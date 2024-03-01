package com.juan.backend.userapp.backenduserapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juan.backend.userapp.backenduserapp.models.entities.User;
import com.juan.backend.userapp.backenduserapp.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	public List<User> list() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Optional<User> userOptional = service.findById(id);

		if (userOptional.isPresent()) {
			return ResponseEntity.ok(userOptional.orElseThrow());
		}

		return ResponseEntity.notFound().build();

	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable Long id) {
		Optional<User> userOptional = service.update(user, id);

		if (userOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(userOptional.orElseThrow());
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<User> userOptional = service.findById(id);

		if (userOptional.isPresent()) {
			service.remove(id);
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

}
