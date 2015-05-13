package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.entities.TLogintegracao;
import br.com.entities.TStatusIntegracao;
import br.com.entities.TTipoArqIntegracao;
import br.com.util.HibernateUtil;
/**
 * Classe responsável por acessar o banco de dados (tabela usu_tlogintegracao).
 * @author diego.vogel
 */
public class TLogintegracaoDAO {

	/**
	 * Faz a listagem de todos os logs cadastrados.
	 */
	@SuppressWarnings("unchecked")
	public static List<TLogintegracao> listar() {
		List<TLogintegracao> tLogList = new ArrayList<TLogintegracao>();
		try {
			EntityManager em = HibernateUtil.create();
			Query query = em.createQuery("from TLogintegracao");
			tLogList = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tLogList;
	}
	
	/**
	 * Faz o cadastro um novo log.
	 */
	public static void salvar(TLogintegracao tLogintegracao, TStatusIntegracao status, TTipoArqIntegracao tipo) throws Exception {
		tLogintegracao.setStatusintegracao(status);
		tLogintegracao.setIdtipoarqintegracao(tipo);
		EntityManager em = HibernateUtil.create();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(tLogintegracao);
		tx.commit();
		em.close();
	}
	
	/**
	 * Faz a edição de um log.
	 */
	public static void editar(TLogintegracao tLogintegracao) throws Exception {
		EntityManager em = HibernateUtil.create();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(tLogintegracao);
		tx.commit();
		em.close();
	}
	
	/**
	 * Faz a exclusão de um log.
	 */
	public static void excluir(TLogintegracao tLogintegracao) throws Exception {
		EntityManager em = HibernateUtil.create();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.createQuery("delete from TLogintegracao where logintegracao = :idlog").setParameter("idlog", tLogintegracao.getLogintegracao()).executeUpdate();
		tx.commit();
		em.close();
	}
}
