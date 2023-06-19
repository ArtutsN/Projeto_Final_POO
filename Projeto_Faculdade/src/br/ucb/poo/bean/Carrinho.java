package br.ucb.poo.bean;

public class Carrinho {
	private int codigo_usuario;
	private int codigo_produto;
	
	public Carrinho(int codigo_usuario, int codigo_produto) {
		this.codigo_usuario = codigo_usuario;
		this.codigo_produto = codigo_produto;
	}

	public int getCodigo_usuario() {
		return codigo_usuario;
	}

	public void setCodigo_usuario(int codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}

	public int getCodigo_produto() {
		return codigo_produto;
	}

	public void setCodigo_produto(int codigo_produto) {
		this.codigo_produto = codigo_produto;
	}

	@Override
	public String toString() {
		return "codigo_usuario=" + codigo_usuario + ", codigo_produto=" + codigo_produto + "\n";
	}
}
