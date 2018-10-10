package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRespository extends JpaRepository<AreaEntity, Integer> {
}
