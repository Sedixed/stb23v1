package fr.univrouen.stb23v1.util;

import fr.univrouen.stb23v1.model.STB;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.util.JAXBSource;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringWriter;

public class HtmlConverter {

    public static String stbToHtmlStream(STB stb) {
        TransformerFactory tf = TransformerFactory.newInstance();
        StreamSource xslt = new StreamSource("src/main/resources/xslt/stb23.xslt");
        StringWriter sw = new StringWriter();
        try {
            Transformer transformer = tf.newTransformer(xslt);
            // Source
            JAXBContext jc = JAXBContext.newInstance(STB.class);
            JAXBSource source = new JAXBSource(jc, stb);
            // Result
            StreamResult result = new StreamResult(sw);
            // Transform
            transformer.transform(source, result);
        } catch (JAXBException | TransformerException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return sw.toString();
    }
}
