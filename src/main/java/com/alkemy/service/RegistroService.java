package com.alkemy.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.models.RegistroRequest;
import com.alkemy.models.RolUsuario;
import com.alkemy.models.Usuario;
import com.alkemy.security.token.ConfirmationToken;
import com.alkemy.security.token.TokenService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistroService {
	
	private final UsuarioService usuarioService;
	private final EmailValidator emailValidator;
	private final TokenService confirmationTokenService;
//    private final EmailSender emailSender;
	
	public String registrar(RegistroRequest request) {
		boolean isValidEmail = emailValidator.test(request.getEmail());
		if(!isValidEmail) {
			throw new IllegalStateException("Email Invalido");
		}
		  String token = usuarioService.signUpUser(
	                new Usuario(
	                        request.getNombre(),
	                        request.getApellido(),
	                        request.getEmail(),
	                        request.getPassword(),
	                        RolUsuario.USER)

	                );
	        

	        String link = "http://localhost:8080/auth/register/confirm?token=" + token;
//	        emailSender.send(
//	                request.getEmail(),
//	                buildEmail(request.getNombre(), link));

	        return token;
	    }

	    @Transactional
	    public String confirmToken(String token) {
	        ConfirmationToken confirmationToken = confirmationTokenService
	                .getToken(token)
	                .orElseThrow(() ->
	                        new IllegalStateException("token not found"));

	        if (confirmationToken.getConfirmedAt() != null) {
	            throw new IllegalStateException("email already confirmed");
	        }

	        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

	        if (expiredAt.isBefore(LocalDateTime.now())) {
	            throw new IllegalStateException("token expired");
	        }

	        confirmationTokenService.setConfirmedAt(token);
	        usuarioService.enableUser(
	                confirmationToken.getUsuario().getEmail());
	        return "confirmed";
	    }

	
	
}
