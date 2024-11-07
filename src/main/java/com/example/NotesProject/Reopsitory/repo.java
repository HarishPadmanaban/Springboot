package com.example.NotesProject.Reopsitory;

import com.example.NotesProject.Model.modelclass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repo extends JpaRepository<modelclass,Long> {
}
