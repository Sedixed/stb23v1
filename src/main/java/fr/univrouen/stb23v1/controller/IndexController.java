package fr.univrouen.stb23v1.controller;

import fr.univrouen.stb23v1.util.FileLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller used for the base (/ and /help) HTTP requests.
 */
@CrossOrigin
@RestController
public class IndexController {

    /**
     * Method used for / route.
     * @return The HTML home page.
     */
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String index() {
        return FileLoader.loadHTMLFile("index.html");
    }

    /**
     * Method used for /help route.
     * @return The HTML help page.
     */
    @GetMapping(value = "/help", produces = MediaType.TEXT_HTML_VALUE)
    public String help() { return FileLoader.loadHTMLFile("help.html"); }
}