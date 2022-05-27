package com.jpa.spring.mysql.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jpa.spring.mysql.api.dao.TicketDao;
import com.jpa.spring.mysql.api.model.Ticket;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	private TicketDao dao;
	
	@PostMapping("/bookTickets")
	public String bookTicket(@RequestBody List<Ticket> tickets) {
		dao.saveAll(tickets);
		return "ticket booked : " + tickets.size();
	}
	
	@GetMapping("/getTickets")
	public List<Ticket> getTicket(){
		return (List<Ticket>) dao.findAll();
	}
	
	@GetMapping("/getTickets/{id}")
	public Optional<Ticket> getBook(@PathVariable int id){
		return dao.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id){
		dao.deleteById(id);
		return "ticket deleted with id : " + id;
	}
}
