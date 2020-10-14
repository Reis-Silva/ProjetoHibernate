package br.com.dominio.modelcontrol;

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
	private Jogos jogo;
	
	@Inject
	private String inputnJogo;
	
	@Inject
	private String inputrID;
	
	@Inject
	private String inputvSistema;
	
	@Inject
	private List<Jogos> jogos; 
	
	@Inject
	private JogosDAO gerenciar;


	public Jogos getJogo() {
		return jogo;
	}

	public void setJ(Jogos jogo) {
		this.jogo = jogo;
	}
	

	public String getInputnJogo() {
		return inputnJogo;
	}

	public void setInputnJogo(String inputnJogo) {
		this.inputnJogo = inputnJogo;
	}

	public String getInputrID() {
		return inputrID;
	}

	public void setInputrID(String inputrID) {
		this.inputrID = inputrID;
	}

	public String getInputvSistema() {
		return inputvSistema;
	}

	public void setInputvSistema(String inputvSistema) {
		this.inputvSistema = inputvSistema;
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
		jogo = new Jogos();
		gerenciar = new JogosDAO();
		jogo.setNomeJogo(inputnJogo);
		jogo.setRegistroID(inputrID);
		jogo.setVersao(inputvSistema);
		gerenciar.salvar(jogo);
		
	}
	
	public void remove(int id) {
		gerenciar.removeById(id);
	}
	

	public void buscar() {
		jogo = new Jogos();
		gerenciar = new JogosDAO();
		setJogos(gerenciar.listar());
	}
	
	public void editar(int id) {
		
		gerenciar.atualizar(id, inputnJogo, inputrID, inputvSistema);
		
	}


}
