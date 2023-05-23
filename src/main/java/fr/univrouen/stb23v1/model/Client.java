package fr.univrouen.stb23v1.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Client")
@XmlType(propOrder = {"entity", "person", "mail", "tel"})
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // DEPENDENCIES

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
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

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<String> getMail() {
        return mail;
    }

    public void setMail(List<String> mail) {
        this.mail = mail;
    }

    public List<String> getTel() {
        return tel;
    }

    public void setTel(List<String> tel) {
        this.tel = tel;
    }

}
