package fr.univrouen.stb23v1.model;


import jakarta.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.List;

public class Team {

    // Team members
    @XmlElement
    private List<Member> member = new ArrayList<>();

    public Team(List<Member> member) {
        this.member = member;
    }

    public Team() {
    }

    public List<Member> getMember() {
        return member;
    }

    public void setMember(List<Member> member) {
        this.member = member;
    }
}
