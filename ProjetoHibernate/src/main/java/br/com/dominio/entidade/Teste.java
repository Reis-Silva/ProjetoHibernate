package br.com.dominio.entidade;

import java.util.List;

import br.com.dominio.dao.JogosDAO;

public class Teste {
	
	public static void main(String[] args) {
		
		Jogos j1 = new Jogos();
		j1.setNomeJogo("teste");
		j1.setRegistroID("xbox");
		j1.setVersao("1");
		
		
		
		JogosDAO j= new JogosDAO();
		j.salvar(j1);
		

		/*
		List<jogo> clientes = cj.listar();
		
		
		
		
		for(int i = 0; i< clientes.size(); i++) {
			
			System.out.println("\nNome: "+clientes.get(i).getNome()+"\nCPF: "+clientes.get(i).getCpf()
					+"\nRG: "+clientes.get(i).getRg());
		
		
		}*/

	}
	
}
