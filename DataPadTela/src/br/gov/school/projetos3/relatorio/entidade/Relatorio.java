package br.gov.school.projetos3.relatorio.entidade;

import java.time.LocalDateTime;
import java.util.List;

import br.gov.school.projetos3.usuario.entidade.Identificavel;

public class Relatorio extends Identificavel {
	private int idRelatorio;
	private LocalDateTime dataCriacao;
	private List<String> tags;
	private String descricao;
	
	public Relatorio(int idRelatorio, LocalDateTime dataCriacao, List<String> tags,  String descricao) {
		this.idRelatorio = idRelatorio;
		this.dataCriacao = dataCriacao;
		this.tags = tags;
		this.descricao = descricao;
	}
	public int getIdRelatorio() {
		return idRelatorio;
	}
	public List<String> getTags() {
		return tags;
	}
	public String getDescricao() {
		return descricao;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	@Override
	public String obterChave() {
		return (idRelatorio+"");
	}
}
