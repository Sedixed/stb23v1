package fr.univrouen.stb23v1.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Features")
@XmlAccessorType(XmlAccessType.FIELD)
public class Features {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id = 1;

    // The features list
    @XmlElement
    @OneToMany(targetEntity=Feature.class, cascade=CascadeType.ALL)
    private List<Feature> feature = new ArrayList<>();

    public Features() {
    }

    public Integer getId() {
        return id;
    }

    public List<Feature> getFeature() {
        return feature;
    }

}
