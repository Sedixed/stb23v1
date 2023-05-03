package fr.univrouen.stb23v1.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @PostMapping(value = "/stb23/insert", consumes = "application/xml")
    public String insert(@RequestBody String stream) {
        return "";
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
