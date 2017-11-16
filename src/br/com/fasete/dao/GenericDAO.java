package br.com.fasete.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fasete.util.EntityManagerUtil;

public class GenericDAO<Entidade> {
	
	private Class<Entidade> classe;
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		em = EntityManagerUtil.getEntityManager();
		this.classe = (Class<Entidade>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(String campo_ordenacao){
		if(campo_ordenacao != null)
			return em.createQuery("FROM " + classe.getName() + " ORDER BY " + campo_ordenacao).getResultList();
		else
			return em.createQuery("FROM " + classe.getName()).getResultList();
	}

}
