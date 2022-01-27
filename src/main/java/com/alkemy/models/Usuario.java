package com.alkemy.models;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Usuario implements UserDetails {
	
	@SequenceGenerator(
	            name = "user_sequence",
	            sequenceName = "user_sequence",
	            allocationSize = 1
	    )
    @Id
    @GeneratedValue(
	            strategy = GenerationType.SEQUENCE,
	            generator = "user_sequence"
	    )
	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private RolUsuario rolUsuario;
	private Boolean locked = false;
	private Boolean enabled = false;
	
	
	public Usuario(String nombre, String apellido, String email, String password, RolUsuario rolUsuario) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.rolUsuario = rolUsuario;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(rolUsuario.name());
		
		return Collections.singletonList(authority);
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	

}
