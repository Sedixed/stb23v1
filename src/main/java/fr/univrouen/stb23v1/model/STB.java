package fr.univrouen.stb23v1.model;

import jakarta.xml.bind.annotation.*;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "STB")
@XmlRootElement(name = "stb")
public class STB implements Serializable {
    private static final long serialVersionUID = 1L;

    // STB title
    @XmlElement
    private String title;

    // STB version
    @XmlElement
    private Double version;

    // STB validation date
    @XmlElement
    private String date;

    // STB description
    @XmlElement
    private String description;

    // STB ID in db
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    // STB client
    @XmlElement
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "clientId")
    private Client client;

    // STB team
    @XmlElement
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "teamId")
    private Team team;

    // STB features
    @XmlElement
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "featuresId")
    private Features features;

    public STB() {
    }

    public Integer getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Team getTeam() {
        return team;
    }

    public Features getFeatures() {
        return features;
    }

    public String getTitle() {
        return title;
    }

    public Double getVersion() {
        return version;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

}
