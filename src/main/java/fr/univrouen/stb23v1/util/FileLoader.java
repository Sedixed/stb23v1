package fr.univrouen.stb23v1.util;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Handles XML and HTML file loading.
 */
public class FileLoader {

    /**
     * Loads and returns an XML content from a filename.
     * @param filename The XML filename.
     * @return The XML content.
     */
    public static String loadXMLFile(String filename) {
        if (filename == null) {
            throw new IllegalArgumentException();
        }
        FileLoader fl = new FileLoader();
        return fl.loadFile("xml", filename);

    }

    /**
     * Loads and returns an HTML content from a filename.
     * @param filename The HTML filename.
     * @return The HTML content.
     */
    public static String loadHTMLFile(String filename) {
        if (filename == null) {
            throw new IllegalArgumentException();
        }
        FileLoader fl = new FileLoader();
        return fl.loadFile("templates", filename);
    }

    /**
     * Loads an returns a text content from a filename.
     * @param directory The file directory.
     * @param filename The file name.
     * @return The file content.
     */
    private String loadFile(String directory, String filename) {
        Resource resource = new DefaultResourceLoader().getResource("classpath:" + directory + "/" + filename);
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String content = br.readLine();
            while (content != null) {
                sb.append(content);
                content = br.readLine();
            }
            br.close();
            return new String(sb);
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
