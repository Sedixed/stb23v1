package fr.univrouen.stb23v1.util;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom XML error handler.
 */
public class XmlErrorHandler implements ErrorHandler {

    /**
     * Exceptions list.
     */
    private List<SAXParseException> exceptions;


    public XmlErrorHandler() {
        this.exceptions = new ArrayList<>();
    }

    /**
     * @return The exceptions list.
     */
    public List<SAXParseException> getExceptions() {
        return exceptions;
    }

    @Override
    public void warning(SAXParseException exception) {
        exceptions.add(exception);
    }

    @Override
    public void error(SAXParseException exception) {
        exceptions.add(exception);
    }

    @Override
    public void fatalError(SAXParseException exception) {
        exceptions.add(exception);
    }
}
