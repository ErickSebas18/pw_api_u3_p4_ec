package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Horario;

@Repository
@Transactional
public class HorarioRepositoryImpl implements IHorarioRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarHorario(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(horario);
	}

	@Override
	public Horario seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Horario.class, id);
	}

	@Override
	public void actualizar(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(horario);
	}

	@Override
	public void actualizarParcial(String codigoAntiguo, String codigoNuevo) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("Update horario h set h.codigo=:codigoNuevo where h.codigo=:codigoAntiguo");
		myQuery.setParameter("codigoNuevo", codigoNuevo);
		myQuery.setParameter("codigoAntiguo", codigoAntiguo);
		myQuery.executeUpdate();
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionarPorId(id));
	}

}
