package com.example.NotesProject.Controller;

import com.example.NotesProject.Model.modelclass;
import com.example.NotesProject.Service.serviceclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
public class controllerclass {

    @Autowired
    private serviceclass servobj;

    @GetMapping("/")
    public String method1(Model mod)
    {
        mod.addAttribute("noteobj",new modelclass());
        mod.addAttribute("list",servobj.show());
        return "Notes";
    }
    @PostMapping("/")
    public String show(@ModelAttribute("noteobj")modelclass model)
    {
        servobj.save(model);
        return "redirect:/notes/";
    }
    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id")Long id)
    {
        servobj.delete(id);
        return "redirect:/notes/";
    }

    @GetMapping("/edit/{id}")
    public String UpdatePage(@PathVariable("id")Long id, Model mod)
    {
        modelclass modobj = servobj.getNoteId(id);
        mod.addAttribute("noteobj",modobj);
        return "Edit";
    }
    @PostMapping("/update/{id}")
    public String UpdateNote(@PathVariable("id")Long id,@ModelAttribute("movieobj")modelclass modelobj,Model mod){
        modelclass up=servobj.updatenote(id,modelobj);
        mod.addAttribute("noteobj",mod);
        if(up==null){
            mod.addAttribute("error","Note not found");
            return "error-page";
        }
        return "redirect:/notes/";
    }

}
