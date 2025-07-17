package com.example.Library.Management.System.repository;

import com.example.Library.Management.System.model.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library,Long> {

}
