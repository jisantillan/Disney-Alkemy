package com.alkemy.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alkemy.entity.Usuario;
import com.alkemy.repository.UsuarioRepository;
import com.alkemy.security.token.ConfirmationToken;
import com.alkemy.security.token.TokenService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService implements UserDetailsService {
		
	private final UsuarioRepository usuarioRepository;
	
	 private final static String USER_NOT_FOUND_MSG =
	            "user with email %s not found";

	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	 private final TokenService tokenService;
	@Override
	 public UserDetails loadUserByUsername(String email)
	            throws UsernameNotFoundException {
	        return usuarioRepository.findByEmail(email).orElseThrow(() ->
	                        new UsernameNotFoundException(
	                                String.format(USER_NOT_FOUND_MSG, email)));
	    }
	
	public String signUpUser(Usuario usuario) {
		
//		Validacion de username/email
		boolean userExists = usuarioRepository.findByEmail(usuario.getEmail()).isPresent();
		if(userExists) {
			throw new IllegalStateException("Ya existe ese email");
		}
		
//		Encriptacion de password
		
		String passwordEncriptada = bCryptPasswordEncoder.encode(usuario.getPassword());
		usuario.setPassword(passwordEncriptada);
		
//		Guardar usuario
		
		usuarioRepository.save(usuario);
		
//		Generacion de token
		String token = UUID.randomUUID().toString();
		ConfirmationToken confirmationToken = new ConfirmationToken(token,LocalDateTime.now(),LocalDateTime.now().plusMinutes(15), usuario);
		tokenService.saveToken(confirmationToken);
		
		
		return token;
	}

	public int enableUser(String email) {
		 return usuarioRepository.enableUser(email);		
	}
}

