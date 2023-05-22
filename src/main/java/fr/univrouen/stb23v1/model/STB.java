package fr.univrouen.stb23v1.model;

import jakarta.xml.bind.annotation.*;

import java.io.Serializable;

@XmlRootElement(name = "stb")
@XmlAccessorType(XmlAccessType.FIELD)
public class STB implements Serializable {
    private static final long serialVersionUID = 1L;

    // STB ID in db
    private Integer id;

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

    // STB client
    @XmlElement
    private Client client;

    // STB team
    @XmlElement
    private Team team;

    // STB features
    @XmlElement
    private Features features;

    // STB constructor
    public STB(Integer id, String title, String date) {
        super();
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public STB() {
    }

    @Override
    public String toString() {
        return ("STB (" + id.toString() + ") du " + date + "\n" + title + "\n");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }
}
