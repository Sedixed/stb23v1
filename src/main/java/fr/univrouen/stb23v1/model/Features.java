package fr.univrouen.stb23v1.model;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.List;

public class Features {

    // The features list
    @XmlElement
    private List<Feature> feature = new ArrayList<>();

    public Features(List<Feature> feature) {
        this.feature = feature;
    }

    public Features() {
    }

    public List<Feature> getFeature() {
        return feature;
    }

    public void setFeature(List<Feature> feature) {
        this.feature = feature;
    }
}
