package fr.univrouen.stb23v1.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@Entity
@Table(name = "Feature")
@XmlType(propOrder = {"description", "priority", "delivery", "comment"})
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // DATABASE LINKS

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
