package br.com.dominio.modelcontrol;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import br.com.dominio.dao.JogosDAO;
import br.com.dominio.entidade.Jogos;

@ViewScoped
@ManagedBean
public class JogoBean {
	
	@Inject
	private Jogos jogo;
	
	@Inject
	private List<Jogos> jogos;
	
	@Inject
	private JogosDAO gerenciar;
	
	@Inject
	private String inputnJogo;
	
	@Inject
	private String inputrID;
	
	@Inject
	private String inputvSistema;
	
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
	
	public String fecharSessao(){
 
	      return "index.xhtml";

	}
	
	//Função para salvar no banco de dados
	public void save(String inputnJogo,String inputrID, String inputvSistema) {
		jogo = new Jogos();
		gerenciar = new JogosDAO();
		jogo.setNomeJogo(inputnJogo);
		jogo.setRegistroID(inputrID);
		jogo.setVersao(inputvSistema);
		gerenciar.salvar(jogo);
		buscar();
		
	}
	
	public void remove(int id) {
		gerenciar.removeById(id);
		buscar();
	}
	
	//Busca no banco de dados
	public void buscar() {
		jogo = new Jogos();
		gerenciar = new JogosDAO();
		setJogos(gerenciar.listar());
	}
	
	//Função para editar no banco de dados
	public void inicioEditar(int id ,String inputnJogo, String inputrID, String inputvSistema) {
		
		jogo = new Jogos();
		jogo.setId(id);
		jogo.setNomeJogo(inputnJogo);
		jogo.setRegistroID(inputrID);
		jogo.setVersao(inputvSistema);
		
	}
	
	
	public void editar(int id, String inputnJogo, String inputrID, String inputvSistema) {
		
		gerenciar.atualizar(id, inputnJogo, inputrID, inputvSistema);
		buscar();
		
	}
	
	//Iniciando o sistema
	@PostConstruct
	public void init() {
		
		buscar();
		
	}
	

}
