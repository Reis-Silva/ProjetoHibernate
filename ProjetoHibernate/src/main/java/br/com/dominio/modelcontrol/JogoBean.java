package br.com.dominio.modelcontrol;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.dominio.dao.JogosDAO;
import br.com.dominio.entidade.Jogos;

@ApplicationScoped
@ManagedBean
public class JogoBean {
	
	@Inject
	private Jogos jogo = new Jogos();
	
	private List<Jogos> jogos = new ArrayList<Jogos>();
	
	private JogosDAO gerenciar = new JogosDAO();
	
	

	public Jogos getJogo() {
		return jogo;
	}

	public void setJogo(Jogos jogo) {
		this.jogo = jogo;
	}

	public List<Jogos> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogos> jogos) {
		this.jogos = jogos;
	}

	public JogosDAO getGerenciar() {
		return gerenciar;
	}

	public void setGerenciar(JogosDAO gerenciar) {
		this.gerenciar = gerenciar;
	}
	

	public void save() {
		
		gerenciar.salvar(jogo);
		
	}
	
	public void remove() {
		gerenciar.remover(jogo);
	}
	

}
