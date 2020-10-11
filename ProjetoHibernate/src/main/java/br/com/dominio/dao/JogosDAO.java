package br.com.dominio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.dominio.entidade.Jogos;
import br.com.dominio.modelcontrol.JogoBean;

public class JogosDAO {
	
		protected EntityManagerFactory entityManagerFactory;
		EntityManager entityManager;

		public JogosDAO(){
			
			entityManager = getEntityManager();
		} 
		
		public EntityManager getEntityManager() {
			entityManagerFactory = Persistence.createEntityManagerFactory("jogosgenericos");
			if (entityManager == null) {
				entityManager = entityManagerFactory.createEntityManager();
			}
			return entityManager;
		}
		
		public void salvar(Jogos j) {	
				entityManager.getTransaction().begin();
				entityManager.merge(j);
				entityManager.getTransaction().commit();
				entityManagerFactory.close();
		}
		
		
		public void remover(Jogos j) {
				
				
				entityManager.getTransaction().begin();
				
				
				//Query q = entityManager.createNativeQuery("delete jogos from Jogos where id ="+j.getId());
				//q.executeUpdate();
				j = entityManager.find(Jogos.class, j.getId());
				entityManager.remove(j);
				entityManager.getTransaction().commit();
				entityManagerFactory.close();
		}
		
		@SuppressWarnings("unchecked")
		public List<Jogos> listar(){
			
			entityManager.getTransaction().begin();
			Query consulta = entityManager.createQuery("select jogo from Jogos jogo");
			List<Jogos> lista = consulta.getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();
			
			return lista;
		}
	

}
