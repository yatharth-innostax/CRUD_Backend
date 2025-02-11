package com.example.crud.crud.repository;

import com.example.crud.crud.entity.CrudEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CrudEntryRepository extends JpaRepository<CrudEntry, Long> {

    //@Query("SELECT * FROM CrudEntry")
//    List<CrudEntry> findAll();

//    CrudEntry save(CrudEntry myEntry);

    Optional<CrudEntry> findById(long id);

    boolean existsById(long myId);

    void deleteById(long myId);
}
