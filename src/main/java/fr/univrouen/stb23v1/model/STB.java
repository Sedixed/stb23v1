package fr.univrouen.stb23v1.model;

import jakarta.xml.bind.annotation.*;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "STB")
@XmlRootElement(name = "stb")
public class STB implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Autogenerated id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    /**
     * STB title.
     */
    @XmlElement
    private String title;

    /**
     * STB version.
     */
    @XmlElement
    private Double version;

    /**
     * STB validation date.
     */
    @XmlElement
    private String date;

    /**
     * STB description.
     */
    @XmlElement
    private String description;

    /**
     * STB client.
     */
    @XmlElement
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "clientId")
    private Client client;

    /**
     * STB team.
     */
    @XmlElement
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "teamId")
    private Team team;

    /**
     * STB features.
     */
    @XmlElement
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "featuresId")
    private Features features;

    public STB() {
    }

    /**
     * @return The STB id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return The STB client.
     */
    public Client getClient() {
        return client;
    }

    /**
     * @return The STB team.
     */
    public Team getTeam() {
        return team;
    }

    /**
     * @return The STB features.
     */
    public Features getFeatures() {
        return features;
    }

    /**
     * @return The STB title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The STB version.
     */
    public Double getVersion() {
        return version;
    }

    /**
     * @return The STB date.
     */
    public String getDate() {
        return date;
    }

    /**
     * @return The STB description.
     */
    public String getDescription() {
        return description;
    }

}
