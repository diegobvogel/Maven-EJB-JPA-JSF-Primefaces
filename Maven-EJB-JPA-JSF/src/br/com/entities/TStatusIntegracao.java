package br.com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representa a tabela usu_tstatusintegracao do banco de dados.
 * @author diego.vogel
 */
@Entity
@Table(name="usu_tstatusintegracao")
public class TStatusIntegracao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer statusintegracao;
	private String descstatusinteg;
	
	@Id
	@Column(name="statusintegracao")
	@GeneratedValue
	public Integer getStatusintegracao() {
		return statusintegracao;
	}
	public void setStatusintegracao(Integer statusintegracao) {
		this.statusintegracao = statusintegracao;
	}
	public String getDescstatusinteg() {
		return descstatusinteg;
	}
	public void setDescstatusinteg(String descstatusinteg) {
		this.descstatusinteg = descstatusinteg;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descstatusinteg == null) ? 0 : descstatusinteg.hashCode());
		result = prime
				* result
				+ ((statusintegracao == null) ? 0 : statusintegracao.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TStatusIntegracao other = (TStatusIntegracao) obj;
		if (descstatusinteg == null) {
			if (other.descstatusinteg != null)
				return false;
		} else if (!descstatusinteg.equals(other.descstatusinteg))
			return false;
		if (statusintegracao == null) {
			if (other.statusintegracao != null)
				return false;
		} else if (!statusintegracao.equals(other.statusintegracao))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TStatusIntegracao [statusintegracao=" + statusintegracao
				+ ", descstatusinteg=" + descstatusinteg + "]";
	}
}
