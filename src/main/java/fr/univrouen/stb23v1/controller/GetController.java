package fr.univrouen.stb23v1.controller;

import fr.univrouen.stb23v1.service.STBService;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller used for GET HTTP requests.
 */
@CrossOrigin
@RestController
public class GetController {

    /**
     * The STB service.
     */
    @Autowired
    private STBService stbService;

    /**
     * Method used for /stb23/resume/xml route.
     * @return The XML result.
     */
    @GetMapping(value = "/stb23/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String getXmlResume() {
        return stbService.getXMLResume();
    }

    /**
     * Method used for /stb23/resume route.
     * @return The HTML result.
     */
    @GetMapping(value = "/stb23/resume", produces = MediaType.TEXT_HTML_VALUE)
    public String getResume(Model model) {
        return stbService.getHTMLResume();
    }

    /**
     * Method used for /stb23/xml/{id} route.
     * @param id The STB id.
     * @return The XML result.
     */
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/stb23/xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public String getXMLSpecification(@PathVariable("id") int id) {
        return stbService.getXMLFromStbId(id);
    }

    /**
     * Method used for /stb23/html/{id} route.
     * @param id The STB id.
     * @return The HTML result.
     */
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/stb23/html/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String getHTMLSpecification(@PathVariable("id") int id) {
        return stbService.getHTMLFromStbId(id);
    }

}
