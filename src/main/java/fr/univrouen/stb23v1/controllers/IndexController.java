package fr.univrouen.stb23v1.controllers;

import fr.univrouen.stb23v1.utils.FileLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class IndexController {
    @GetMapping("/")
    public String index() {
        return FileLoader.loadHTMLFile("index.html");
    }

    @GetMapping("/help")
    public String help() { return FileLoader.loadHTMLFile("help.html"); }
}