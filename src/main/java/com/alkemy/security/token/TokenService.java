package com.alkemy.security.token;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TokenService {
	private final TokenRepository tokenRepository;

	public void saveToken(ConfirmationToken token) {
		tokenRepository.save(token);
	}

	public Optional<ConfirmationToken> getToken(String token) {
		return tokenRepository.findByToken(token);
	}

	public int setConfirmedAt(String token) {
		return tokenRepository.updateConfirmedAt(
				token, LocalDateTime.now());
	}
}

