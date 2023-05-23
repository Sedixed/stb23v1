package fr.univrouen.stb23v1.util;

public enum ResponseDetail {
    INVALID("INVALID"),
    DUPLICATED("DUPLICATED");

    private final String verbose;

    private ResponseDetail(String verbose) {
        this.verbose = verbose;
    }

    public String getDetail() {
        return this.verbose;
    }
}
