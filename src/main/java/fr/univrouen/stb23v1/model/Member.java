package fr.univrouen.stb23v1.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Member")
@XmlType(propOrder = {"person", "mail", "function"})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // DEPENDENCIES

    // Member person element
    @XmlElement
    @OneToOne(mappedBy = "member", cascade=CascadeType.ALL)
    private Person person;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Team team;

    // ATTRIBUTES

    // The member mail
    @XmlElement
    private String mail;

    // The functions handled by this member
    @XmlElement
    private List<String> function = new ArrayList<>();

    public Member(Person person, String mail, List<String> function) {
        this.person = person;
        this.mail = mail;
        this.function = function;
    }

    public Member() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<String> getFunction() {
        return function;
    }

    public void setFunction(List<String> function) {
        this.function = function;
    }
}
