package com.example.APIRest.repositories;
import com.example.APIRest.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Un repositorio es una clase que permite hacer peticiones a una bbdd
@Repository
public interface ITaskRepository extends JpaRepository<TaskModel, Long> {
    
}
