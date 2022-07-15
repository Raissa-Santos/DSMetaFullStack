package com.raissasantos.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raissasantos.dsmeta.entities.Sale;
import com.raissasantos.dsmeta.services.SaleService;
import com.raissasantos.dsmeta.services.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired //injeta uma instancia do SaleService
	private SaleService service;
	
	@Autowired 
	private SmsService smsService;
	
	//http://localhost:8080/sales?minDate=2022-01-01&maxDate=2022-03-31
	
	//Datas em String porque na WEB elas estarão dessa forma, depois que serão formatadas para Date
	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value = "minDate", defaultValue = "") String minDate, 
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate, 
			Pageable pageable){//dados paginados, retorna o JSON com os elementos agrupados de 20 em 20.
		return service.findSales(minDate, maxDate, pageable);
	}
	
//  ../sales/id/notification
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
}
