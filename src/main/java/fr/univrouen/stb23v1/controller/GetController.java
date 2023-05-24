package fr.univrouen.stb23v1.controller;

import fr.univrouen.stb23v1.service.STBService;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
public class GetController {

    @Autowired
    private STBService stbService;

    @GetMapping(value = "/stb23/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String getXmlResume() {
        return stbService.getXMLResume();
    }

    @GetMapping(value = "/stb23/resume", produces = MediaType.TEXT_HTML_VALUE)
    public String getResume(Model model) {
        return stbService.getHTMLResume();
    }

    @GetMapping(value = "/stb23/xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public String getXMLSpecification(@PathVariable("id") int id) {
        return stbService.getXMLFromStbId(id);
    }

    @GetMapping(value = "/stb23/html/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String getHTMLSpecification(@PathVariable("id") int id) {
        return stbService.getHTMLFromStbId(id);
    }

}
