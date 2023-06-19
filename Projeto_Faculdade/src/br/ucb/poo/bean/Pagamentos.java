package br.ucb.poo.bean;

public class Pagamentos {
	private int codigo_usuario;
	private int codigo_pedido;
	private double valor;
	private String metodo_pagamento;
	
	public Pagamentos(int codigo_usuario, int codigo_pedido, double valor, String metodo_pagamento) {
		this.codigo_usuario = codigo_usuario;
		this.codigo_pedido = codigo_pedido;
		this.valor = valor;
		this.metodo_pagamento = metodo_pagamento;

	}
	
	@Override
	public String toString() {
		return "codigo_usuario=" + codigo_usuario + ", codigo_pedido=" + codigo_pedido + ", valor=" + valor
				+ ", metodo_pagamento=" + metodo_pagamento + "\n";
	}

	public int getCodigo_usuario() {
		return codigo_usuario;
	}

	public void setCodigo_usuario(int codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}

	public int getCodigo_pedido() {
		return codigo_pedido;
	}

	public void setCodigo_pedido(int codigo_pedido) {
		this.codigo_pedido = codigo_pedido;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getMetodo_pagamento() {
		return metodo_pagamento;
	}

	public void setMetodo_pagamento(String metodo_pagamento) {
		this.metodo_pagamento = metodo_pagamento;
	}


}
