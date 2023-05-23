package fr.univrouen.stb23v1.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Client")
@XmlType(propOrder = {"entity", "person", "mail", "tel"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    // Client person
    @XmlElement
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "personId")
    private Person person;

    // Client entity name
    @XmlElement
    private String entity;

    // Client mail
    @XmlElement
    private List<String> mail = new ArrayList<>();

    // Client tel
    @XmlElement
    private List<String> tel = new ArrayList<>();

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public String getEntity() {
        return entity;
    }

    public List<String> getMail() {
        return mail;
    }

    public List<String> getTel() {
        return tel;
    }

}
