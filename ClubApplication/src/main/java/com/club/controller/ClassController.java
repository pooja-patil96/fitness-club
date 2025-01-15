package com.club.controller;

import com.club.model.ClubClass;
import com.club.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping
    public ClubClass createClass(@RequestBody ClubClass newClass) {
        return classService.createClass(newClass);
    }

    @GetMapping
    public List<ClubClass> getClasses() {
        return classService.getClasses();
    }

    @GetMapping("/{id}")
    public ClubClass getClassById(@PathVariable Long id) {
        return classService.getClassById(id);
    }
}
