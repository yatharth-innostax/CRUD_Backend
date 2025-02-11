package com.example.crud.crud.controller;

import com.example.crud.crud.entity.CrudEntry;
import com.example.crud.crud.repository.CrudEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//Final Test For Push Request

@RestController
@RequestMapping("/crud")
public class crudEntryController {

    @Autowired
    public CrudEntryRepository crudEntryRepository;

    @GetMapping
    public List<CrudEntry> getAll() {
        return crudEntryRepository.findAll();
    }

    @PostMapping
    public CrudEntry createEntry(@RequestBody CrudEntry myEntry) {
        return crudEntryRepository.save(myEntry);
    }

    @GetMapping("id/{myId}")
    public CrudEntry getCrudEntryById(@PathVariable long myId) {
        Optional<CrudEntry> entry = crudEntryRepository.findById(myId);
        return entry.orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteCrudEntryById(@PathVariable long myId) {
        if (crudEntryRepository.existsById(myId)) {
            crudEntryRepository.deleteById(myId);
            return true;
        }
        return false;
    }

    @PutMapping("id/{id}")
    public CrudEntry updateCrudEntryById(@PathVariable long id, @RequestBody CrudEntry myEntry) {
        if (crudEntryRepository.existsById(id)) {
            myEntry.setId(id);
            return crudEntryRepository.save(myEntry);
        }
        return null;
    }
}
