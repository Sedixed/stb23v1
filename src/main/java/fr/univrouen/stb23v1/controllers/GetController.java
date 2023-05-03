package fr.univrouen.stb23v1.controllers;

import fr.univrouen.stb23v1.model.STB;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GetController {

    @GetMapping(value = "/stb23/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String getXmlResume(Model model) {
        // temporaire
        List<String> stbs = null;
        model.addAttribute("stbs", stbs);

        // voir comment choisir le xml
        return "resume";
    }

    @GetMapping("/stb23/resume")
    public String getResume(Model model) {
        // temporaire
        List<String> stbs = null;
        model.addAttribute("stbs", stbs);
        return "resume";
    }

    @GetMapping(value = "/stb23/xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public String getXMLSpecification(@PathVariable("id") int id) {
        return "";
    }

    @GetMapping("/stb23/html/{id}")
    public String getHTMLSpecification(@PathVariable("id") int id) {
        return "";
    }

    @GetMapping("/stbid")
    public String getRSSinXML(
            @RequestParam(value = "id") String texte
    ) {
        return ("Détail de la STB n°" + texte);
    }



    /*@GetMapping("/test")
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
