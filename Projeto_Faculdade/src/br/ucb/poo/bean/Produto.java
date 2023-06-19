package br.ucb.poo.bean;

public class Produto {
	private String name;
	private int categoria;
	private int vendedor;
	private double valor;
	private double estrelas;
	private int vendas;
	private int codigo;
		
	
	public Produto(String name, int categoria, double valor, double estrelas, int vendedor, int vendas , int codigo){
		this.name = name;
		this.categoria = categoria;
		this.valor = valor;
		this.estrelas = estrelas;
		this.vendedor = vendedor;
		this.vendas = vendas;
		this.codigo = codigo;
	}
	
	

	@Override
	public String toString() {
		return name + " - valor=" + valor + " - vendas=" + vendas + " - estrelas=" + estrelas
		+ " - categoria=" + categoria  + " - vendedor=" + vendedor + " - codigo=" + codigo + "\n";
	}



	//GET E SET NAME
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//GET E SET VALOR
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	//GET E SET VENDAS
	public int getVendas() {
		return vendas;
	}

	public void setVendas(int vendas) {
		this.vendas = vendas;
	}
	
	//GET E SET ESTRELAS
	public double getEstrelas() {
		return estrelas;
	}

	public void setEstrelas(double estrelas) {
		this.estrelas = estrelas;
	}

	//GET E SET VENDEDOR
	public int getVendedor() {
		return vendedor;
	}

	public void setVendedor(int vendedor) {
		this.vendedor = vendedor;
	}

	//GET E SET CATEGORIA
	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	//GET E SET CODIGO
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
