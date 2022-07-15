package com.raissasantos.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raissasantos.dsmeta.entities.Sale;


//Repository é como se fosse o DAO
//É o responsável por efetuar ações diretamente no banco
//inserções, alterações, exclusões e consultas
public interface SaleRepository extends JpaRepository<Sale, Long>{

	//Essa consulta não tem, então farei manualmente
	
	@Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
	Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
	
}
