package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Materia;


@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public Materia buscarMateria(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Materia.class, id);
	}

	@Override
	public void insertarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	public void actualizarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(materia);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarMateria(id));
	}

	@Override
	public List<Materia> buscarCedulaEstudiante(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQuery = this.entityManager.createQuery("Select m from Materia m where m.estudiante.cedula =:cedula", Materia.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getResultList();
	}

}
