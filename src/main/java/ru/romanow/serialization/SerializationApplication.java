package ru.romanow.serialization;

import com.jayway.jsonpath.JsonPath;
import lombok.SneakyThrows;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.JsonEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import ru.romanow.serialization.generated.ProtobufObjectProto;
import ru.romanow.serialization.model.*;
import ru.romanow.serialization.services.BsonSerializer;
import ru.romanow.serialization.services.JsonSerializer;
import ru.romanow.serialization.services.MsgpackSerializer;
import ru.romanow.serialization.services.XmlSerializer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.springframework.util.Base64Utils.encodeToString;

@SuppressWarnings("unused")
@SpringBootApplication
public class SerializationApplication
        implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(SerializationApplication.class);
    private static final String XML_DATA_FILE = "/data/xml-data.xml";
    private static final String JSON_DATA_FILE = "/data/json-data.json";
    private static final String XPATH = "//key[text()='KEY1']";
    private static final String JSON_PATH = "$..[?(@.key == 'KEY1')].key";

    public static void main(String[] args) {
        SpringApplication.run(SerializationApplication.class, args);
    }

    @Override
    public void run(String... args) {
//        testJson();
//        testXml();
//        validateXml();
//        testXPath();
//        testJsonPath();
//        testBson();
//        testMsgPack();
//        testProtobuf();
        testAvro();
    }

    private void testAvro() {
        logger.info("\n==================== Start testAvro ====================");

//        final Schema testObjectSchema = ReflectData.get().getSchema(TestObject.class);

        final Schema status = SchemaBuilder
                .enumeration("status")
                .namespace("ru.romanow.serialization")
                .symbols("DONE", "FAIL", "PAUSED");
        final Schema innerData = SchemaBuilder
                .record("InnerData")
                .namespace("ru.romanow.serialization")
                .fields()
                .optionalString("code")
                .optionalInt("priority")
                .endRecord();
        final Schema testObjectSchema = SchemaBuilder
                .record("TestObject")
                .namespace("ru.romanow.serialization")
                .fields()
                .optionalString("message")
                .optionalInt("code")
                .name("status").type(status).noDefault()
                .name("innerData").type(innerData).noDefault()
                .endRecord();

        logger.info("Generated scheme:\n'{}'", testObjectSchema.toString(true));

        final TestObject testObject = createTestObject();

        DatumWriter<TestObject> writer = new GenericDatumWriter<>(testObjectSchema);
        byte[] data = new byte[0];
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
            JsonEncoder jsonEncoder = EncoderFactory.get().jsonEncoder(testObjectSchema, stream);
            writer.write(testObject, jsonEncoder);
            jsonEncoder.flush();
            data = stream.toByteArray();
        } catch (IOException exception) {
            logger.error("", exception);
        }

        logger.info("Serialized object", encodeToString(data));

        logger.info("\n==================== Finish testAvro ====================");
    }

    private void testJsonPath() {
        logger.info("\n==================== Start testJsonPath ====================");

        final String json = readFromFile(JSON_DATA_FILE);
        logger.info("Read JSON from file:\n{}", json);
        final List<String> result = JsonPath.read(json, JSON_PATH);
        logger.info("JsonPath '{}' evaluates {}", JSON_PATH, result);

        logger.info("\n==================== Finish testJsonPath ====================");
    }

    @SneakyThrows
    private void testXPath() {
        logger.info("\n==================== Start testXPath ====================");

        final String xml = readFromFile(XML_DATA_FILE);
        logger.info("Read XML from file:\n{}", xml);

        try (InputStream stream = new ClassPathResource(XML_DATA_FILE).getInputStream()) {
            final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder builder = factory.newDocumentBuilder();
            final Document document = builder.parse(stream);
            final XPathFactory xPathfactory = XPathFactory.newInstance();
            final XPath xpath = xPathfactory.newXPath();
            final XPathExpression expr = xpath.compile(XPATH);

            final Object result = expr.evaluate(document, XPathConstants.STRING);
            logger.info("XPath '{}' evaluates {}", XPATH, result);
        }

        logger.info("\n==================== Finish testXPath ====================");
    }

    @SneakyThrows
    private void testProtobuf() {
        logger.info("\n==================== Start testProtobuf ====================");

        ProtobufObjectProto.TestObject testObject = ProtobufObjectProto
                .TestObject
                .newBuilder()
                .setCode(nextInt(0, 100))
                .setMessage(randomAlphabetic(10))
                .setStatus(ProtobufObjectProto.Status.FAIL)
                .build();

        logger.info("Serialize object '{}' to Protobuf", testObject);

        try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
            testObject.writeTo(stream);
            byte[] object = stream.toByteArray();

            logger.info("{}", encodeToString(object));

            ProtobufObjectProto.TestObject parsedObject =
                    ProtobufObjectProto.TestObject.parseFrom(object);

            logger.info("\n{}", parsedObject);
        }

        logger.info("\n==================== Finish testProtobuf ====================");
    }

    private void testJson() {
        logger.info("\n==================== Start testJson ====================");

        TestObject testObject = createTestObject();

        logger.info("Serialize object '{}' to JSON", testObject);

        String json = JsonSerializer.toJson(testObject);
        logger.info("\n{}", json);

        NewTestObject newObject = JsonSerializer.fromJson(json, NewTestObject.class);
        logger.info("{}", newObject);

        logger.info("\n==================== Finish testJson ====================");
    }

    private void testXml() {
        logger.info("\n==================== Start testXml ====================");

        TestObject testObject = createXmlTestObject();
        logger.info("Serialize object '{}' to XML", testObject);

        String xml = XmlSerializer.toXml(testObject);
        logger.info("\n{}", xml);

        XmlTestObject newObject = XmlSerializer.fromXml(xml);
        logger.info("{}", newObject);

        logger.info("\n==================== Finish testXml ====================");
    }

    private void validateXml() {
        logger.info("\n==================== Start validateXml ====================");

        final String xml = readFromFile(XML_DATA_FILE);
        logger.info("Read XML from file:\n{}", xml);
        logger.info("XML valid: {}", XmlSerializer.validate(xml));

        logger.info("\n==================== Finish validateXml ====================");
    }

    private void testBson() {
        logger.info("\n==================== Start testBson ====================");

        TestObject testObject = createTestObject();

        logger.info("Serialize object '{}' to BSON", testObject);

        byte[] bson = BsonSerializer.toBson(testObject);
        logger.info("\n{}", encodeToString(bson));

        TestObject newObject = BsonSerializer.fromBson(bson, TestObject.class);
        logger.info("{}", newObject);

        logger.info("\n==================== Finish testBson ====================");
    }

    private void testMsgPack() {
        logger.info("\n==================== Start testMsgPack ====================");

        TestObject testObject = createTestObject();

        logger.info("Serialize object '{}' to MsgPack", testObject);

        byte[] bson = MsgpackSerializer.toMsgpack(testObject);
        logger.info("\n{}", encodeToString(bson));

        TestObject newObject = MsgpackSerializer.fromMsgpack(bson, TestObject.class);
        logger.info("{}", newObject);

        logger.info("\n==================== Finish testMsgPack ====================");
    }

    private TestObject createTestObject() {
        return new TestObject()
                .setMessage(randomAlphanumeric(10))
                .setCode(nextInt(0, 100))
                .setStatus(Status.DONE)
                .setInnerData(buildInnerData())
                .setPublicData(newArrayList(buildPublicData(), buildPublicData()));
    }

    @SneakyThrows
    private String readFromFile(String fileName) {
        try (InputStream stream = new ClassPathResource(fileName).getInputStream()) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
                return reader.lines().collect(Collectors.joining("\n"));
            }
        }
    }

    private XmlTestObject createXmlTestObject() {
        return new XmlTestObject()
                .setMessage(randomAlphanumeric(10))
                .setCode(nextInt(0, 100))
                .setStatus(Status.DONE)
                .setInnerData(buildInnerData())
                .setPublicData(newArrayList(buildPublicData(), buildPublicData()));
    }

    private PublicData buildPublicData() {
        return new PublicData(randomAlphabetic(8), randomAlphanumeric(15));
    }

    private InnerData buildInnerData() {
        return new InnerData(randomAlphanumeric(15), nextInt(10, 15));
    }
}