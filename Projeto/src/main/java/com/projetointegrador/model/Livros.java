package com.projetointegrador.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_livros", uniqueConstraints={@UniqueConstraint(columnNames={"isbn"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Livros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_livros;
	
	@NotNull
	private String capa;

	@NotNull
	private String titulo;
	
	private String descricao;
	
	private String autor;
	
	@NotNull
	private Integer qtdeEstoque;
	
	private Integer qtdePedido = 1;
	
	private boolean temEstoque = true;
	
	@NotNull
	private int isbn;
	
	@NotNull
	private Double valorUnitario;
	
	@ManyToMany(mappedBy = "tag")
	@JsonIgnoreProperties("livros")
	private List<Tag> tag;
	
	@ManyToMany
	@JsonIgnoreProperties("livros")
	@JoinTable(
			name = "pedido_livros", 
			uniqueConstraints = @UniqueConstraint(columnNames = {"livros_fk", "pedido_fk"}),
			joinColumns = {@JoinColumn(name = "livros_fk")}, 
			inverseJoinColumns = {@JoinColumn(name = "pedido_fk")})
	private List<Pedido> pedido;
	
	@ManyToOne
	@JsonIgnoreProperties("livros")
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;

	public Long getId_livros() {
		return id_livros;
	}

	public void setId_livros(Long id_livros) {
		this.id_livros = id_livros;
	}

	public String getCapa() {
		return capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getQtdeEstoque() {
		return qtdeEstoque;
	}

	public void setQtdeEstoque(Integer qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}

	public Integer getQtdePedido() {
		return qtdePedido;
	}

	public void setQtdePedido(Integer qtdePedido) {
		this.qtdePedido = qtdePedido;
	}

	public boolean isTemEstoque() {
		return temEstoque;
	}

	public void setTemEstoque(boolean temEstoque) {
		this.temEstoque = temEstoque;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public List<Tag> getTag() {
		return tag;
	}

	public void setTag(List<Tag> tag) {
		this.tag = tag;
	}

}
