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
		
		//Iniciando parâmetros de banco de dados
		public EntityManager getEntityManager() {
			entityManagerFactory = Persistence.createEntityManagerFactory("jogosgenericos");
			if (entityManager == null) {
				entityManager = entityManagerFactory.createEntityManager();
			}
			return entityManager;
		}
		
		//Salvar no banco de dados
		public void salvar(Jogos jogo) {	
				entityManager.getTransaction().begin();
				entityManager.merge(jogo);
				entityManager.getTransaction().commit();
				entityManagerFactory.close();
		}
		
	
		//Remover do banco de dados
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
		
		
		//Buscar no banco de dados
		@SuppressWarnings("unchecked")
		public List<Jogos> listar(){
			
			entityManager.getTransaction().begin();
			Query consulta = entityManager.createQuery("select jogo from Jogos jogo");
			List<Jogos> lista = consulta.getResultList();
			entityManager.getTransaction().commit();
			
			return lista;
		}
		
		
		//Atualizar no banco de dados
		public void atualizar(final int id, String inputnJogo, String inputrID, String inputvSistema) {
			
			Jogos jogo = entityManager.find(Jogos.class, id);
			entityManager.getTransaction().begin();
			jogo.setNomeJogo(inputnJogo);
			jogo.setRegistroID(inputrID);
			jogo.setVersao(inputvSistema);
			entityManager.getTransaction().commit();
			
			
		}
	

}
