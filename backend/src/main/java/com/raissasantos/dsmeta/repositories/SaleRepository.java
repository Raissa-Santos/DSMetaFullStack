package com.raissasantos.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raissasantos.dsmeta.entities.Sale;


//Repository é como se fosse o DAO
//É o responsável por efetuar ações diretamente no banco
//inserções, alterações, exclusões e consultas
public interface SaleRepository extends JpaRepository<Sale, Long>{

}
