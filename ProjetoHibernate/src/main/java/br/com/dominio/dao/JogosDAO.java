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
		
			
		public Jogos getById(final int id) {
	         return entityManager.find(Jogos.class, id);
	       }
		
		
		public void removeById(final int id) {
	         try {
	        	 Jogos j = new Jogos();
	             j = getById(id);
	            remover(j);
	         } catch (Exception ex) {
	            ex.printStackTrace();
	         }
	       }
		
		
		public void remover(Jogos j) {
			entityManager.getTransaction().begin();
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
			
			
			return lista;
		}
		
		
		public List<Jogos> direcaoAtualizar(int id) {
			
			entityManager.getTransaction().begin();
			Query consulta = entityManager.createQuery("select * from Jogos jogo where id="+id);
			List<Jogos> listaAtualizar = consulta.getResultList();
			entityManager.getTransaction().commit();
			
			return listaAtualizar;
			
		}
		
		public void atualizar(final int id, String inputnJogo, String inputrID, String inputvSistema) {
			
			Jogos jogo = entityManager.find(Jogos.class, id);
			entityManager.getTransaction().begin();
			jogo.setNomeJogo(inputnJogo);
			jogo.setRegistroID(inputrID);
			jogo.setVersao(inputvSistema);
			entityManager.getTransaction().commit();
			
			
		}
	

}
