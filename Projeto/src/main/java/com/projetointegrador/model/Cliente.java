package com.projetointegrador.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //Indicando ao SPRING a classe é uma entidade
@Table(name = "tb_cliente") //Nome que vai ser dado a tabela no banco de dados
public class Cliente {
	
	@Id //Indicando que é a chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Para fazer o auto-incremendo do ID na tabela no banco de dados
	private long id_cliente;
	
	@NotNull //Obrigando o campo a não ser nulo
	@Size(min = 5, max = 100) //Dando um tamanho minimo e maximo obrigade caracteres ao campo
	private String email;
	
	@NotNull
	@Size(min = 5, max = 15)
	private String senha;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String nome;
	
	@Size(min = 5, max = 15)
	private String telefone;
	
	@NotNull
	private Date dataNascimento;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE) //Indicando que é uma relação "um para muitos"
	@JsonIgnoreProperties("cliente") //Indicando que deve ignorar campos desconhecidos
	private List<Endereco> endereco;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("cliente")
	private Pedido pedido;
	
	//CRIANDO OS GETTERS E SETTERS

	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}