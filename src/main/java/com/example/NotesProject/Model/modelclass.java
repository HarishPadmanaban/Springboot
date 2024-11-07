package com.example.NotesProject.Model;


import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name="NotesTable")
public class modelclass {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String note;

    public long getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
