package com.dailycode.Spring.Data.Jpa.repository;

import com.dailycode.Spring.Data.Jpa.entities.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {
}
