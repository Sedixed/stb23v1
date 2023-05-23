package fr.univrouen.stb23v1.controller;

import fr.univrouen.stb23v1.model.STB;
import fr.univrouen.stb23v1.service.STBService;
import fr.univrouen.stb23v1.util.ResponseDetail;
import fr.univrouen.stb23v1.util.ResponseStatus;
import fr.univrouen.stb23v1.util.STBValidator;
import jakarta.xml.bind.JAXB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.StringReader;


@RestController
public class PostController {

    @Autowired
    private STBService stbService;

    @PostMapping(value = "/stb23/insert", consumes = "application/xml")
    public String insert(@RequestBody String xmlStream) {
        STBValidator stbv = new STBValidator();
        if (stbv.validateXMLSchema(xmlStream)) {
            STB stb = JAXB.unmarshal(new StringReader(xmlStream), STB.class);
            if (stbService.isDuplicate(stb)) {
                return "<result><status>" + ResponseStatus.ERROR + "</status><detail>" + ResponseDetail.DUPLICATED + "</detail></result>";
            }
            stbService.addSTB(stb);
            return "<result><id>" + stb.getId() + "</id><status>" + ResponseStatus.INSERTED + "</status></result>";
        } else {
            return "<result><status>" + ResponseStatus.ERROR + "</status><detail>" + ResponseDetail.INVALID + "</detail></result>";
        }
    }

}
