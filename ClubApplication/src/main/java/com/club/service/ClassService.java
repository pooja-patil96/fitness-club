package com.club.service;

import com.club.model.ClubClass;
import com.club.repo.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClubRepository clubClassRepository;

    public ClubClass createClass(ClubClass newClass) {
        return clubClassRepository.save(newClass);
    }

    public List<ClubClass> getClasses() {
        return clubClassRepository.findAll();
    }

    public ClubClass getClassById(Long id) {
        return clubClassRepository.findById(id).orElse(null);
    }
}
