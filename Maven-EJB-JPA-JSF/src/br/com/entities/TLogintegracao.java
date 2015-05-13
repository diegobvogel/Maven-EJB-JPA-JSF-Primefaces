package br.com.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Representa a tabela usu_tlogintegracao do banco de dados.
 * @author diego.vogel
 */
@Entity
@Table(name="usu_tlogintegracao")
public class TLogintegracao {
	private Integer logintegracao;
	private TStatusIntegracao statusintegracao;
	private String desclogintegracao;
	private Date dataintegracao;
	private String nmarquivointegracao;
	private Integer numregistrointegracao;
	private TTipoArqIntegracao Idtipoarqintegracao;
	private Date dtgeracaoarquivo;
	private String identregistro;
	private String desclogerrotecnico;
	
	@Id
	@GeneratedValue
	public Integer getLogintegracao() {
		return logintegracao;
	}
	public void setLogintegracao(Integer logintegracao) {
		this.logintegracao = logintegracao;
	}
	public String getDesclogintegracao() {
		return desclogintegracao;
	}
	public void setDesclogintegracao(String desclogintegracao) {
		this.desclogintegracao = desclogintegracao;
	}
	public Date getDataintegracao() {
		return dataintegracao;
	}
	public void setDataintegracao(Date dataintegracao) {
		this.dataintegracao = dataintegracao;
	}
	public String getNmarquivointegracao() {
		return nmarquivointegracao;
	}
	public void setNmarquivointegracao(String nmarquivointegracao) {
		this.nmarquivointegracao = nmarquivointegracao;
	}
	public Integer getNumregistrointegracao() {
		return numregistrointegracao;
	}
	public void setNumregistrointegracao(Integer numregistrointegracao) {
		this.numregistrointegracao = numregistrointegracao;
	}
	public Date getDtgeracaoarquivo() {
		return dtgeracaoarquivo;
	}
	public void setDtgeracaoarquivo(Date dtgeracaoarquivo) {
		this.dtgeracaoarquivo = dtgeracaoarquivo;
	}
	public String getIdentregistro() {
		return identregistro;
	}
	public void setIdentregistro(String identregistro) {
		this.identregistro = identregistro;
	}
	public String getDesclogerrotecnico() {
		return desclogerrotecnico;
	}
	public void setDesclogerrotecnico(String desclogerrotecnico) {
		this.desclogerrotecnico = desclogerrotecnico;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Idtipoarqintegracao")
	public TTipoArqIntegracao getIdtipoarqintegracao() {
		return Idtipoarqintegracao;
	}
	public void setIdtipoarqintegracao(TTipoArqIntegracao idtipoarqintegracao) {
		Idtipoarqintegracao = idtipoarqintegracao;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statusintegracao")
	public TStatusIntegracao getStatusintegracao() {
		return statusintegracao;
	}
	public void setStatusintegracao(TStatusIntegracao statusintegracao) {
		this.statusintegracao = statusintegracao;
	}
}
