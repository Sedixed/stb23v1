package fr.univrouen.stb23v1.controllers;

import fr.univrouen.stb23v1.model.STB;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetController {

    @GetMapping("/resume")
    public String getListRSSinXML() {
        return "Envoi de la liste des STB";
    }


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

    @RequestMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody STB getXML() {
        STB stb = new STB(123,"Test STB","2023-04-01T14:22:33");
        return stb;
    }
}
