package fr.univrouen.stb23v1.util;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * XML to HTML stream converter.
 */
public class HtmlConverter {

    /**
     * The stb23 xslt file (html production).
     */
    public static final String STB23_XSLT = "stb23.xslt";

    /**
     * The stb23 resume xslt file (html production).
     */
    public static final String STB23_XSLT_RESUME = "stb23resume.xslt";

    /**
     * The stb23 error xslt file (html production).
     */
    public static final String STB23_XSLT_ERROR = "stb23error.xslt";

    /**
     * Converts an XML stream to the HTML stream according to the XSLT file given from its name.
     * @param xml The XML stream as a string
     * @param xsltFilename The XSLT filename.
     * @return The HTML stream.
     */
    public static String xmlToHtmlStream(String xml, String xsltFilename) {
        TransformerFactory tf = TransformerFactory.newInstance();
        StreamSource xslt = new StreamSource("src/main/resources/xslt/" + xsltFilename);
        StringWriter sw = new StringWriter();
        StreamSource xmlSource = new StreamSource(new StringReader(xml));
        try {
            Transformer transformer = tf.newTransformer(xslt);
            // Result
            StreamResult result = new StreamResult(sw);
            // Transform
            transformer.transform(xmlSource, result);
        } catch (TransformerException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return sw.toString();
    }
}
