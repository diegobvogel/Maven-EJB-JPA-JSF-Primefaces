package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.entities.TTipoArqIntegracao;
import br.com.util.HibernateUtil;

/**
 * Classe responsável por acessar o banco de dados (tabela usu_ttipoarqintegracao).
 * @author diego.vogel
 */
public class TTipoArqIntegracaoDAO {
	
	/**
	 * Faz a busca de um tipo pelo seu ID.
	 */
	public static TTipoArqIntegracao select(Integer Idtipoarqintegracao){
		TTipoArqIntegracao obj = null;
		try {
			EntityManager em = HibernateUtil.create();
			Query query = em.createQuery("from TTipoArqIntegracao where Idtipoarqintegracao = :Idtipoarqintegracao");
			query.setParameter("Idtipoarqintegracao", Idtipoarqintegracao);
			obj = (TTipoArqIntegracao) query.getSingleResult();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * Faz listagem de todos os tipos cadastrados.
	 */
	@SuppressWarnings("unchecked")
	public static List<TTipoArqIntegracao> listAll(){
		List<TTipoArqIntegracao> tipoList = new ArrayList<TTipoArqIntegracao>();
		try {
			EntityManager em = HibernateUtil.create();
			Query query = em.createQuery("from TTipoArqIntegracao");
			tipoList = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoList;
	}
}
