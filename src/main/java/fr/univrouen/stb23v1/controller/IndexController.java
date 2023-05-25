package fr.univrouen.stb23v1.controller;

import fr.univrouen.stb23v1.util.FileLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class IndexController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String index() {
        return FileLoader.loadHTMLFile("index.html");
    }


    @GetMapping(value = "/help", produces = MediaType.TEXT_HTML_VALUE)
    public String help() { return FileLoader.loadHTMLFile("help.html"); }
}