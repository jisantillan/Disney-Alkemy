package com.alkemy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import com.alkemy.models.Personaje;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class characterDaoImp implements characterDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<Personaje> getUsuarios() {
		return entityManager.createQuery( "FROM Personaje").getResultList();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Personaje personaje = entityManager.find(Personaje.class, id);
		entityManager.remove(personaje);
		
	}
	
	

}
