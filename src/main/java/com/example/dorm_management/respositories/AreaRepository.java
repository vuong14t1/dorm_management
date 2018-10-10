package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<AreaEntity, Integer> {
}
