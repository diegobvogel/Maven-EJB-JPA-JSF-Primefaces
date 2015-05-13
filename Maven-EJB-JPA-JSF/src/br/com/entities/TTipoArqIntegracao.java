package br.com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representa a tabela usu_ttipoarqIntegracao do banco de dados.
 * @author diego.vogel
 */
@Entity
@Table(name="usu_ttipoarqIntegracao")
public class TTipoArqIntegracao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer Idtipoarqintegracao;
	private String desctipoarqintegracao;
	private String extensaoarqintegracao;
	
	@Id
	@Column(name="Idtipoarqintegracao")
	@GeneratedValue
	public Integer getIdtipoarqintegracao() {
		return Idtipoarqintegracao;
	}
	public void setIdtipoarqintegracao(Integer idtipoarqintegracao) {
		Idtipoarqintegracao = idtipoarqintegracao;
	}
	public String getDesctipoarqintegracao() {
		return desctipoarqintegracao;
	}
	public void setDesctipoarqintegracao(String desctipoarqintegracao) {
		this.desctipoarqintegracao = desctipoarqintegracao;
	}
	public String getExtensaoarqintegracao() {
		return extensaoarqintegracao;
	}
	public void setExtensaoarqintegracao(String extensaoarqintegracao) {
		this.extensaoarqintegracao = extensaoarqintegracao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((Idtipoarqintegracao == null) ? 0 : Idtipoarqintegracao
						.hashCode());
		result = prime
				* result
				+ ((desctipoarqintegracao == null) ? 0 : desctipoarqintegracao
						.hashCode());
		result = prime
				* result
				+ ((extensaoarqintegracao == null) ? 0 : extensaoarqintegracao
						.hashCode());
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
		TTipoArqIntegracao other = (TTipoArqIntegracao) obj;
		if (Idtipoarqintegracao == null) {
			if (other.Idtipoarqintegracao != null)
				return false;
		} else if (!Idtipoarqintegracao.equals(other.Idtipoarqintegracao))
			return false;
		if (desctipoarqintegracao == null) {
			if (other.desctipoarqintegracao != null)
				return false;
		} else if (!desctipoarqintegracao.equals(other.desctipoarqintegracao))
			return false;
		if (extensaoarqintegracao == null) {
			if (other.extensaoarqintegracao != null)
				return false;
		} else if (!extensaoarqintegracao.equals(other.extensaoarqintegracao))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "TTipoArqIntegracao [Idtipoarqintegracao=" + Idtipoarqintegracao
				+ ", desctipoarqintegracao=" + desctipoarqintegracao
				+ ", extensaoarqintegracao=" + extensaoarqintegracao + "]";
	}
}
