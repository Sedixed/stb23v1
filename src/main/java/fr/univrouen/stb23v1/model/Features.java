package fr.univrouen.stb23v1.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Features")
@XmlAccessorType(XmlAccessType.FIELD)
public class Features {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    // DEPENDENCIES

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    @XmlTransient
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

    public Integer getId() {
        return id;
    }

    public STB getStb() {
        return stb;
    }

    public List<Feature> getFeature() {
        return feature;
    }

}
