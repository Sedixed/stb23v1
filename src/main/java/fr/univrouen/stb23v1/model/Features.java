package fr.univrouen.stb23v1.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Features")
public class Features {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // DEPENDENCIES

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private STB stb;

    // The features list
    @XmlElement
    @OneToMany(mappedBy = "features", cascade=CascadeType.ALL)
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
