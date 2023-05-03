package fr.univrouen.stb23v1.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    @DeleteMapping("/stb23/delete/{id}")
    public String getHTMLSpecification(@PathVariable("id") int id) {
        return "";
    }
}
