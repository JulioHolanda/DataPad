package br.gov.school.projetos3.gerenciamento.entidades;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UProjetoSocial extends Usuario {
	private Localizacao cep;
	private String nomeFantasia;
	private String cadastroFisJur;
	private Categoria categoria;
	private String descricao;
	private PostList posts;
	private Contato contato;
	public UProjetoSocial(long id, String nome, Localizacao cep, String nomeFantasia, String cadastroFisJur, Categoria categoria, Contato contato) {
		super(nome);
		this.id = gerarId(cadastroFisJur);
		this.cep = cep;
		this.nomeFantasia = nomeFantasia;
		this.cadastroFisJur = cadastroFisJur;
		this.categoria = categoria;
		this.contato = contato;
	}
	public UProjetoSocial(long id, String nome, Localizacao cep, String nomeFantasia, String cadastroFisJur, Categoria categoria, Contato contato, String descricao) {
		this(id, nome, cep, nomeFantasia, cadastroFisJur, categoria, contato);
		this.descricao = descricao;
	}
	public Localizacao getCep() {
		return cep;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public String getCadastroFisJur() {
		return cadastroFisJur;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public PostList getPosts() {
		return posts;
	}
	public Contato getContato() {
		return contato;
	}
	public void setCep(Localizacao cep) {
		this.cep = cep;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setPosts(PostList posts) {
		this.posts = posts;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public abstract long gerarId(String cadastroFisJur) {
        try {
            // Remova quaisquer caracteres não numéricos do CPF/CNPJ
            String numericString = cpfCnpj.replaceAll("[^\\d]", "");

            // Obtenha a data atual como uma string no formato "yyyyMMdd"
            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

            // Combine o CPF/CNPJ e a data atual
            String combinedString = numericString + currentDate;

            // Calcule o hash MD5 da string combinada
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(combinedString.getBytes());
            BigInteger hashInt = new BigInteger(1, hashBytes);

            // Converta o hash em um valor long
            return hashInt.longValue();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return 0;
        }
	}

}
