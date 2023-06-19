package br.ucb.poo.bean;

public class Categorias {
	private int idCategoria;
	private String nome;
	
	public Categorias(int idCategoria, String nome) {
		this.idCategoria = idCategoria;
		this.nome = nome;
	}
	
	

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	@Override
	public String toString() {
		return "idCategoria=" + idCategoria + ", nome=" + nome + "\n";
	}

}
