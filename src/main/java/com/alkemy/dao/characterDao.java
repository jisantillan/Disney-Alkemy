package com.alkemy.dao;

import java.util.List;
import com.alkemy.models.Personaje;

public interface characterDao {
	public List<Personaje> getUsuarios();

	public void delete(Integer id);
	
}
