package fr.univrouen.stb23v1.controller;

import fr.univrouen.stb23v1.service.STBService;
import fr.univrouen.stb23v1.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller used for DELETE HTTP requests.
 */
@CrossOrigin
@RestController
public class DeleteController {

    /**
     * The STB service.
     */
    @Autowired
    private STBService stbService;

    /**
     * Method used for /stb23/delete/{id} route.
     * @param id The STB id.
     * @return The XML operation result.
     */
    @DeleteMapping("/stb23/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        boolean status = stbService.deleteSTB(id);
        return status
                ? "<result><id>" + id + "</id><status>" + ResponseStatus.DELETED + "</status></result>"
                : "<result><status>" + ResponseStatus.ERROR + "</status></result>";
    }
}
