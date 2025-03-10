package com.desafio3.dscommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio3.dscommerce.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
