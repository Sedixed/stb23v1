package fr.univrouen.stb23v1.controllers;

import fr.univrouen.stb23v1.model.STB;
import fr.univrouen.stb23v1.service.STBService;
import fr.univrouen.stb23v1.utils.ResponseDetail;
import fr.univrouen.stb23v1.utils.ResponseStatus;
import fr.univrouen.stb23v1.utils.STBValidator;
import jakarta.xml.bind.JAXB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXParseException;

import java.io.StringReader;

@RestController
public class PostController {

    @Autowired
    private STBService stbService;

    @PostMapping(value = "/stb23/insert", consumes = "application/xml")
    public String insert(@RequestBody String xmlStream) {
        STBValidator stbv = new STBValidator();
        if (stbv.validateXMLSchema(xmlStream)) {
            STB stb = stbService.addSTB(xmlStream);
            return "<result><id>" + stb.getId() + "</id><status>" + ResponseStatus.INSERTED + "</status></result>";
        } else {
            return "<result><status>" + ResponseStatus.ERROR + "</status><detail>" + ResponseDetail.INVALID + "</detail></result>";
        }
    }

    /*@RequestMapping(value = "/testpost", method = RequestMethod.POST, consumes = "application/xml")
    public String postTest(@RequestBody String flux) {
        return ("<result><response>Message reçu : </response>" + flux + "</result>");
    }

     */

    /*@PostMapping(value = "/poststb", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String postSTB() {
        TestSTB stb = new TestSTB();
        return stb.loadFileXML();
    }*/
}
