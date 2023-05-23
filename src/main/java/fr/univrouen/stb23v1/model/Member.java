package fr.univrouen.stb23v1.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Member")
@XmlType(propOrder = {"person", "mail", "function"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    // Member person element
    @XmlElement
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "personId")
    private Person person;

    // The member mail
    @XmlElement
    private String mail;

    // The functions handled by this member
    @XmlElement
    private List<String> function = new ArrayList<>();

    public Member() {
    }

    public Integer getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }


    public String getMail() {
        return mail;
    }

    public List<String> getFunction() {
        return function;
    }

}
