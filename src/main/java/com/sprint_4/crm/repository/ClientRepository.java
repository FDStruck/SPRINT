package com.sprint_4.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint_4.crm.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long>{

//    @Query("SELECT c FROM Client c WHERE c.clientName = :clientName")
//    Client findByNome(@Param("clientName") String clientName);
//
//    Client findByNomee(String nome);


}
