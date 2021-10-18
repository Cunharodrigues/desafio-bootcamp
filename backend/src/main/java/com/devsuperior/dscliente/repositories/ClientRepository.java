package com.devsuperior.dscliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dscliente.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
