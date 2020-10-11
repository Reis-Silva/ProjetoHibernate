package br.com.dominio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.dominio.entidade.Jogos;

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
				Query q = entityManager.createNativeQuery("delete cliente from cliente where cpf ="+j.getId());
				q.executeUpdate();
				//cliente = entityManager.find(Cliente.class, cliente.getId());
				//entityManager.remove(cliente);
				entityManager.getTransaction().commit();
				entityManagerFactory.close();
		}
		
		public List<Jogos> listar(){
			
			entityManager.getTransaction().begin();
			Query consulta = entityManager.createQuery("select cliente from Cliente cliente");
			List<Jogos> lista = consulta.getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();
			
			return lista;
		}
	

}
