package fr.univrouen.stb23v1.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlValue;

@Entity
@Table(name = "Person")

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    // DEPENDENCIES

    @OneToOne
    @JoinColumn(referencedColumnName = "id",  nullable = true)
    @XmlTransient
    private Client client;

    @OneToOne
    @JoinColumn(referencedColumnName = "id",  nullable = true)
    @XmlTransient
    private Member member;

    // ATTRIBUTES

    // Person name
    @XmlValue
    private String name;

    // Person gender attribute
    @XmlAttribute
    private String gender;

    // Person lastname attribute
    @XmlAttribute
    private String lastname;

    public Person(String name, String gender, String lastname) {
        this.name = name;
        this.gender = gender;
        this.lastname = lastname;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Member getMember() {
        return member;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getLastname() {
        return lastname;
    }

}
