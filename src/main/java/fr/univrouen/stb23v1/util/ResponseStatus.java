package fr.univrouen.stb23v1.util;

/**
 * Contains the response status.
 */
public enum ResponseStatus {
    ERROR("ERROR"),
    INSERTED("INSERTED"),
    DELETED("DELETED");

    private final String verbose;

    ResponseStatus(String verbose) {
        this.verbose = verbose;
    }

    public String getStatus() {
        return this.verbose;
    }
}
