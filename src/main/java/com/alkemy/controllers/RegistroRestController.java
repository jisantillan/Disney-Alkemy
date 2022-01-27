package com.alkemy.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.models.RegistroRequest;
import com.alkemy.service.RegistroService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "auth/register")
@AllArgsConstructor
public class RegistroRestController {

	 private final RegistroService registroService;

	    @PostMapping
	    public String registrar(@RequestBody RegistroRequest request) {
	        return registroService.registrar(request);
	    }

	    @GetMapping(path = "confirm")
	    public String confirmar(@RequestParam("token") String token) {
	        return registroService.confirmToken(token);
	    }
}	    



   