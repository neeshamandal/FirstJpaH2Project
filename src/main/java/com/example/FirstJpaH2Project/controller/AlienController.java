package com.example.FirstJpaH2Project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.FirstJpaH2Project.demo.dao.AlienRepo;
import com.example.FirstJpaH2Project.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@PostMapping("/Alien")
	public Alien addAlien(@RequestBody Alien alien) {
		
		repo.save(alien);
		return alien;
	}
	
	@GetMapping(path = "/Aliens")
	public List<Alien> getAliens() {
		
		return repo.findAll();
	}
	
	@DeleteMapping("/Alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		@SuppressWarnings("deprecation")
		Alien a = repo.getOne(aid);
		repo.delete(a);
		return "deleted" ;
		
	}
	
	@PutMapping("/Alien")
	public Alien saveOrUpdate(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@RequestMapping("/Alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		
		return repo.findById(aid);
	}
	
	

}
