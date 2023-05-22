package fr.univrouen.stb23v1.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

public class Person {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
