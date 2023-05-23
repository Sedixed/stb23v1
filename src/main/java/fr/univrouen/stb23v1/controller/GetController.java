package fr.univrouen.stb23v1.controller;

import fr.univrouen.stb23v1.model.STB;
import fr.univrouen.stb23v1.service.STBService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
public class GetController {

    @Autowired
    private STBService stbService;

    @GetMapping(value = "/stb23/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String getXmlResume() {
        return stbService.getXMLResume();
    }

    @GetMapping(value = "/stb23/resume", produces =  MediaType.TEXT_HTML_VALUE)
    public String getResume() {
        return "aled";
    }

    @GetMapping(value = "/stb23/xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public String getXMLSpecification(@PathVariable("id") int id) throws JAXBException {
        return stbService.getXMLFromStbId(id);
    }

    @GetMapping(value = "/stb23/html/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String getHTMLSpecification(@PathVariable("id") int id) {
        return stbService.getHTMLFromStbId(id);
    }


    /*

    @GetMapping("/stbid")
    public String getRSSinXML(
            @RequestParam(value = "id") String texte
    ) {
        return ("Détail de la STB n°" + texte);
    }

    @GetMapping("/test")
    public String getRSSinXML(
            @RequestParam(value = "id") String id,
            @RequestParam(value = "titre") String titre
    ) {
        return ("Test :<br>id = " + id + "<br>titre = " + titre);
    }
    */

    /*@RequestMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody STB getXML() {
        STB stb = new STB(123,"Test STB","2023-04-01T14:22:33");
        return stb;
    }*/
}
