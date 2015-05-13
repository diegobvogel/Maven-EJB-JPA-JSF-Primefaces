package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.entities.TStatusIntegracao;
import br.com.util.HibernateUtil;

/**
 * Classe responsável por acessar o banco de dados (tabela usu_tstatusintegracao).
 * @author diego.vogel
 */
public class TStatusIntegracaoDAO {
	
	/**
	 * Faz a busca de um status pelo seu ID.
	 */
	public static TStatusIntegracao select(Integer statusintegracao){
		TStatusIntegracao obj = null;
		try {
			EntityManager em = HibernateUtil.create();
			Query query = em.createQuery("from TStatusIntegracao where statusintegracao = :statusintegracao");
			query.setParameter("statusintegracao", statusintegracao);
			obj = (TStatusIntegracao) query.getSingleResult();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	/**
	 * Faz a listagem de todos os status cadastrados.
	 */
	@SuppressWarnings("unchecked")
	public static List<TStatusIntegracao> listAll(){
		List<TStatusIntegracao> statusList = new ArrayList<TStatusIntegracao>();
		try {
			EntityManager em = HibernateUtil.create();
			Query query = em.createQuery("from TStatusIntegracao");
			statusList = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusList;
	}
}
