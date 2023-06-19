package br.ucb.poo.bean;

public class Usuario {
	private String nome;
	private String cpf;
	private int tipoUsuario; 
	private int codigo;
	private String login;
	private String senha;
	private String cep;
	private String telefone;
	private String email;
	
	public Usuario(String nome, String cpf, int tipoUsuario, int codigo, String login, String senha, String cep, String telefone, String email){
		this.nome = nome;
		this.cpf = cpf;
		this.tipoUsuario = tipoUsuario;
		this.codigo = codigo;
		this.login = login;
		this.senha = senha;
		this.cep = cep;
		this.telefone = telefone;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "nome=" + nome + "  cpf=" + cpf + "  tipoUsuario=" + tipoUsuario + "  codigo=" + codigo + "\n";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
