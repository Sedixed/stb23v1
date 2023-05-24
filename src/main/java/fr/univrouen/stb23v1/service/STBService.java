package fr.univrouen.stb23v1.service;

import fr.univrouen.stb23v1.model.STB;
import fr.univrouen.stb23v1.repository.STBRepository;
import fr.univrouen.stb23v1.util.HtmlConverter;
import fr.univrouen.stb23v1.util.ResponseStatus;
import jakarta.xml.bind.JAXB;
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

    /**
     * Autowired STB repository.
     */
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

    /**
     *
     * @param id The STB id.
     * @return The XMl stream from the corresponding STB, identified by its id.
     */
    public String getXMLFromStbId(int id)  {
        STB stb = stbRepository.findById("" + id).orElse(null);
        if (stb == null) {
            return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                    "<result>" +
                    "<id>" + id + "</id><status>" + ResponseStatus.ERROR + "</status>" +
                    "</result>";
        }
        StringWriter sw = new StringWriter();
        JAXB.marshal(stb, sw);
        return sw.toString();
    }

    /**
     * @return The resume of the STBs as a XML stream.
     */
    public String getXMLResume() {
        List<STB> stbs = getSTBs();
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("<result>");
        for (STB stb : stbs) {
            sb.append("<stb>");
            sb.append("<id>").append(stb.getId()).append("</id>");
            sb.append("<title>").append(stb.getTitle()).append("</title>");
            sb.append("<description>").append(stb.getDescription()).append("</description>");
            sb.append("<date>").append(stb.getDate()).append("</date>");
            sb.append("<clientEntity>").append(stb.getClient().getEntity()).append("</clientEntity>");
            sb.append("</stb>");
        }
        sb.append("</result>");
        return sb.toString();
    }

    /**
     * @return The resume of the STBs as an HTML stream.
     */
    public String getHTMLResume() {
        return HtmlConverter.xmlToHtmlStream(getXMLResume(), HtmlConverter.STB23_XSLT_RESUME);
    }

    /**
     * @param id The STB id.
     * @return The HTML stream from the corresponding STB, identified by its id.
     */
    public String getHTMLFromStbId(int id) {
        STB stb = stbRepository.findById("" + id).orElse(null);
        String xslt = HtmlConverter.STB23_XSLT;
        if (stb == null) {
            xslt = HtmlConverter.STB23_XSLT_ERROR;
        }
        return HtmlConverter.xmlToHtmlStream(getXMLFromStbId(id), xslt);
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
