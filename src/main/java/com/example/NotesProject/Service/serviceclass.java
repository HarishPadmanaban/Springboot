package com.example.NotesProject.Service;

import com.example.NotesProject.Model.modelclass;
import com.example.NotesProject.Reopsitory.repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceclass {

    @Autowired
    private repo repoobj;

    public List<modelclass> show(){
        return repoobj.findAll();
    }

    public modelclass save(modelclass data)
    {
        return repoobj.save(data);
    }

    public modelclass getNoteId(Long id)
    {
        return repoobj.findById(id).orElse(null);
    }

    public void delete(Long id)
    {
        repoobj.deleteById(id);
    }

    public modelclass updatenote(Long id,modelclass obj)
    {
        return repoobj.findById(id).map(modelclass ->{

            modelclass.setNote(obj.getNote());
            return repoobj.save(modelclass);
        }).orElse(null);
    }
}
