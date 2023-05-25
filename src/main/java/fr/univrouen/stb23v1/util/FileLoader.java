package fr.univrouen.stb23v1.util;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Handles XML and HTML file loading.
 */
public class FileLoader {

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
        System.out.println(fl.loadFile("html", filename));
        return fl.loadFile("html", filename);
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
                byte[] ptext = content.getBytes(StandardCharsets.ISO_8859_1);
                content = new String(ptext, StandardCharsets.UTF_8);
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
