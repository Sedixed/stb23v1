package fr.univrouen.stb23v1.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = {"entity", "person", "mail", "tel"})
public class Client {

    // Client entity name
    @XmlElement
    private String entity;

    // Client person
    @XmlElement
    private Person person;

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
