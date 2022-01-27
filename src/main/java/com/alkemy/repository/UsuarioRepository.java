package com.alkemy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.models.Usuario;

@Transactional(readOnly = true)
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{
	Optional<Usuario> findByEmail(String email);
    @Transactional
    @Modifying
    @Query("UPDATE Usuario a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUser(String email);
}
