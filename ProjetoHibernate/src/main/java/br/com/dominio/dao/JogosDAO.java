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
		
		
		public void remover(Jogos jogo) {
				entityManager.getTransaction().begin();
				
				
				//Query q = entityManager.createNativeQuery("delete from jogos where id=2");
				//q.executeUpdate();
				jogo = entityManager.find(Jogos.class, jogo.getId());
				entityManager.remove(jogo);
				entityManager.getTransaction().commit();
				entityManagerFactory.close();
		}
		
		public Jogos getById(final int id) {
	         return entityManager.find(Jogos.class, id);
	       }
		
		
		public void removeById(final int id) {
	         try {
	            Jogos cliente = getById(id);
	            remover(cliente);
	         } catch (Exception ex) {
	            ex.printStackTrace();
	         }
	       }
		
		@SuppressWarnings("unchecked")
		public List<Jogos> listar(){
			
			entityManager.getTransaction().begin();
			Query consulta = entityManager.createQuery("select jogo from Jogos jogo");
			List<Jogos> lista = consulta.getResultList();
			entityManager.getTransaction().commit();
			
			
			return lista;
		}
	

}
