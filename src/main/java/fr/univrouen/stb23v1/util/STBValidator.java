package fr.univrouen.stb23v1.util;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * STB validator helper.
 */
public class STBValidator {

    /**
     * Path to XSD file.
     */
    public static final String STB23_XSD_PATH = "xsd/stb23.xsd";

    /**
     * Exceptions list.
     */
    private List<SAXParseException> exceptions = new ArrayList<>();

    /**
     * @param xmlStream The XML stream to validate against a XSD.
     * @return True if the XMl stream is valid, false otherwise.
     */
    public boolean validateXMLSchema(String xmlStream) {

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        URL src = STBValidator.class.getClassLoader().getResource(STB23_XSD_PATH);
        if (src == null) {
            return false;
        }
        XmlErrorHandler xsdErrorHandler = new XmlErrorHandler();
        try {
            Schema schema = factory.newSchema(new File(src.getFile()));
            Validator validator = schema.newValidator();
            validator.setErrorHandler(xsdErrorHandler);
            validator.validate(new StreamSource(new StringReader(xmlStream)));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }

        this.exceptions = xsdErrorHandler.getExceptions();
        return this.exceptions.isEmpty();
    }

    /**
     * @return The exceptions list.
     */
    public List<SAXParseException> getExceptions() {
        return exceptions;
    }
}
