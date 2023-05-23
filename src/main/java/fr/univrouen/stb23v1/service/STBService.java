package fr.univrouen.stb23v1.service;

import fr.univrouen.stb23v1.model.STB;
import fr.univrouen.stb23v1.repository.STBRepository;
import fr.univrouen.stb23v1.util.ResponseStatus;
import jakarta.xml.bind.JAXB;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * STB service.
 */
@Service
public class STBService {

    @Autowired
    private STBRepository stbRepository;

    /**
     * @return All the STBs found in db.
     */
    public List<STB> getSTBs() {
        List<STB> stbs = new ArrayList<>();
        stbRepository.findAll().forEach(stbs::add);
        return stbs;
    }

    /**
     * @param id The STB id.
     * @return The STB from the db which has the given id, null if not found.
     */
    public STB getStbFromId(int id) {
        return stbRepository.findById("" + id).orElse(null);
    }

    public String getXMLFromStbId(int id)  {
        STB stb = stbRepository.findById("" + id).orElse(null);
        if (stb == null) {
            return "<result><id>" + id + "</id><status>" + ResponseStatus.ERROR + "</status></result>";
        }
        StringWriter sw = new StringWriter();
        JAXB.marshal(stb, sw);
        return sw.toString();
    }

    /**
     * Adds an STB to the db.
     * @param stb The STB to add.
     */
    public void addSTB(STB stb) {
        stbRepository.save(stb);
    }

    /**
     * @param stb The STB to compare to the stored ones.
     * @return True if the STB is a duplicate of one in the database, false otherwise.
     */
    public boolean isDuplicate(STB stb) {
        List<STB> stbs = getSTBs();
        for (STB comparedSTB : stbs) {
            if (
                    comparedSTB.getTitle().equals(stb.getTitle())
                    && comparedSTB.getVersion().equals(stb.getVersion())
                    && comparedSTB.getDate().equals(stb.getDate())
            ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes the STB of given id from db.
     * @param id The STB id.
     * @return True if the operation is successful, false otherwise.
     */
    public boolean deleteSTB(int id) {
        STB stb = getStbFromId(id);
        if (stb == null) {
            return false;
        }
        stbRepository.delete(stb);
        return true;
    }
}
