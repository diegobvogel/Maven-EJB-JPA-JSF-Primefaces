package br.com.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.com.dao.TLogintegracaoDAO;
import br.com.dao.TStatusIntegracaoDAO;
import br.com.dao.TTipoArqIntegracaoDAO;
import br.com.entities.TLogintegracao;
import br.com.entities.TStatusIntegracao;
import br.com.entities.TTipoArqIntegracao;

/**
 * ManageBean responsável por gerenciar o comportamento da tela de cadastro de LOGS.
 * A tela possui somente as funções de CRUD.
 * @author diego.vogel
 */
@ManagedBean(name = "tLogintegracaoBEAN")
@SessionScoped
public class TLogintegracaoBEAN {

	public TLogintegracao tLogintegracao;
	public TLogintegracao tLogintegracaoConsultar;
	public List<TLogintegracao> listLogs;
	public List<TLogintegracao> listLogsFiltrados;
	
    private List<TStatusIntegracao> statusList;
    private TStatusIntegracao status;
    
    private List<TTipoArqIntegracao> tipoList;
    private TTipoArqIntegracao tipo;
	
	
	@PostConstruct
    public void init() {
		tLogintegracao = new TLogintegracao();
		tLogintegracaoConsultar = new TLogintegracao();
		
		statusList = TStatusIntegracaoDAO.listAll();
		tipoList = TTipoArqIntegracaoDAO.listAll();
		
		listLogs = TLogintegracaoDAO.listar();
    }

	public void listarLogs(){
		try {
			System.out.println("Listar");
			listLogs = TLogintegracaoDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(){
		try {
			System.out.println("salvar");
			TLogintegracaoDAO.salvar(tLogintegracao, status, tipo);
			tLogintegracao = new TLogintegracao();
			listarLogs();
			addMessageInfo("Registro cadastrado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("Ocorreu um erro ao salvar o registro.\n\n" + e.getMessage());
		}
	}
	
	public void editar(){
		try {
			System.out.println("Editar");
			TLogintegracaoDAO.editar(tLogintegracao);
			tLogintegracao = new TLogintegracao();
			listarLogs();
			addMessageInfo("Registro editado com sucesso.");
			RequestContext.getCurrentInstance().execute("PF('dlgLogEditar').hide();");
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("Ocorreu um erro ao editar o registro.\n\n" + e.getMessage());
		}
	}
	
	public void excluir(TLogintegracao tLogintegracao){
		try {
			System.out.println("Excluir");
			TLogintegracaoDAO.excluir(tLogintegracao);
			listarLogs();
			addMessageInfo("Registro excluido com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("Ocorreu um erro ao excluir o registro.\n\n" + e.getMessage());
		}
	}
	
	public void limparObjeto(){
		tLogintegracao = new TLogintegracao();
	}
	
	public void addMessageInfo(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public void addMessageError(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	// getters and setters
	public List<TLogintegracao> getListLogs() {
		return listLogs;
	}
	public void setListLogs(List<TLogintegracao> listLogs) {
		this.listLogs = listLogs;
	}

	public TLogintegracao gettLogintegracao() {
		return tLogintegracao;
	}

	public void settLogintegracao(TLogintegracao tLogintegracao) {
		this.tLogintegracao = tLogintegracao;
	}

	public TLogintegracao gettLogintegracaoConsultar() {
		return tLogintegracaoConsultar;
	}

	public void settLogintegracaoConsultar(TLogintegracao tLogintegracaoConsultar) {
		this.tLogintegracaoConsultar = tLogintegracaoConsultar;
	}

	public List<TLogintegracao> getListLogsFiltrados() {
		return listLogsFiltrados;
	}
	
	public void setListLogsFiltrados(List<TLogintegracao> listLogsFiltrados) {
		this.listLogsFiltrados = listLogsFiltrados;
	}

	public List<TStatusIntegracao> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<TStatusIntegracao> statusList) {
		this.statusList = statusList;
	}

	public TStatusIntegracao getStatus() {
		return status;
	}

	public void setStatus(TStatusIntegracao status) {
		this.status = status;
	}

	public List<TTipoArqIntegracao> getTipoList() {
		return tipoList;
	}

	public void setTipoList(List<TTipoArqIntegracao> tipoList) {
		this.tipoList = tipoList;
	}

	public TTipoArqIntegracao getTipo() {
		return tipo;
	}

	public void setTipo(TTipoArqIntegracao tipo) {
		this.tipo = tipo;
	}
}
