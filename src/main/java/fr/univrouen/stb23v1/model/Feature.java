package fr.univrouen.stb23v1.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

@Entity
@Table(name = "Feature")
@XmlType(propOrder = {"description", "priority", "delivery", "comment"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    // DATABASE LINKS

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    @XmlTransient
    private Features features;

    // ATTRIBUTES

    // The feature name attribute
    @XmlAttribute
    private String name;

    // The feature section attribute
    @XmlAttribute
    private Integer section;

    // The feature number attribute
    @XmlAttribute
    private Integer number;

    // The feature description
    @XmlElement
    private String description;

    // The feature priority
    @XmlElement
    private Integer priority;

    // The feature delivery date
    @XmlElement
    private String delivery;

    // The feature additional comment
    @XmlElement
    private String comment;

    public Feature(String name, Integer section, Integer number, String description,
                   Integer priority, String delivery, String comment
    ) {
        this.name = name;
        this.section = section;
        this.number = number;
        this.description = description;
        this.priority = priority;
        this.delivery = delivery;
        this.comment = comment;
    }

    public Feature() {
    }

    public Integer getId() {
        return id;
    }

    public Features getFeatures() {
        return features;
    }

    public String getName() {
        return name;
    }

    public Integer getSection() {
        return section;
    }

    public Integer getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPriority() {
        return priority;
    }

    public String getDelivery() {
        return delivery;
    }

    public String getComment() {
        return comment;
    }

}
