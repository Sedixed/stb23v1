package fr.univrouen.stb23v1.util;

/**
 * Contains the response detail.
 */
public enum ResponseDetail {
    INVALID("INVALID"),
    DUPLICATED("DUPLICATED");

    private final String verbose;

    ResponseDetail(String verbose) {
        this.verbose = verbose;
    }

    public String getDetail() {
        return this.verbose;
    }
}
