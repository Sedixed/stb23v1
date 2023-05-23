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

    // DEPENDENCIES

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    @XmlTransient
    private STB stb;

    // Client person
    @XmlElement
    @OneToOne(mappedBy = "client", cascade=CascadeType.ALL)
    private Person person;

    // ATTRIBUTES

    // Client entity name
    @XmlElement
    private String entity;

    // Client mail
    @XmlElement
    private List<String> mail = new ArrayList<>();

    // Client tel
    @XmlElement
    private List<String> tel = new ArrayList<>();

    public Client(String entity, Person person, List<String> mail, List<String> tel) {
        this.entity = entity;
        this.person = person;
        this.mail = mail;
        this.tel = tel;
    }

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public STB getStb() {
        return stb;
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
