package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Manager;

public interface ManagerRepo extends JpaRepository<Manager, String>
{

}
