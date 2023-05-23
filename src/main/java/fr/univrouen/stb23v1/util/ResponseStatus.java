package fr.univrouen.stb23v1.util;

public enum ResponseStatus {
    ERROR("ERROR"),
    INSERTED("INSERTED"),
    DELETED("DELETED");

    private final String verbose;

    private ResponseStatus(String verbose) {
        this.verbose = verbose;
    }

    public String getStatus() {
        return this.verbose;
    }
}
