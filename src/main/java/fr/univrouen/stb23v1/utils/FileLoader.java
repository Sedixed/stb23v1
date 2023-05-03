package fr.univrouen.stb23v1.utils;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileLoader {

    public static String loadXMLFile(String filename) {
        if (filename == null) {
            throw new IllegalArgumentException();
        }
        FileLoader fl = new FileLoader();
        return fl.loadFile("xml", filename);

    }

    public static String loadHTMLFile(String filename) {
        if (filename == null) {
            throw new IllegalArgumentException();
        }
        FileLoader fl = new FileLoader();
        return fl.loadFile("templates", filename);
    }

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
