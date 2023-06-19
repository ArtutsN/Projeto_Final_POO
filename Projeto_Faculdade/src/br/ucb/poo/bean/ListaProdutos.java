package br.ucb.poo.bean;

import java.util.ArrayList;
import java.util.Scanner;

import br.ucb.poo.dao.*;

public class ListaProdutos {
	private ArrayList<Produto> listaProdutos;
	
	public ListaProdutos(){
		this.listaProdutos = new ArrayList<>();
	}
	
	public void novoProduto(int cod_vendedor, ListaCategorias listaCategoria) {
		
		ProdutoDAO dao = new ProdutoDAO();
		
		Scanner scanner = new Scanner(System.in);
		
		String name;
		int vendas, codigo, option_categoria, vendedor;
		double estrelas;
		
		System.out.println("Nome Produto: ");
		name = scanner.nextLine();
		
		System.out.println(listaCategoria.getListaCategorias());
        
        option_categoria = scanner.nextInt();
        scanner.nextLine();

		vendedor = cod_vendedor;
		
		System.out.println("vendas: ");
		vendas = scanner.nextInt();		
		
		System.out.println("valor: ");
		double valor = scanner.nextDouble();
		
		System.out.println("Estrelas: ");
		estrelas = scanner.nextDouble();
		
		codigo = (this.listaProdutos.size() + 1);
		
		Produto produto = new Produto(name, option_categoria, valor, 0, vendedor, 0, codigo);
		
		listaProdutos.add(produto);
		dao.insereProduto(produto);
		
		
	}
	
	public void todosProdutos() {
		for (Produto produto : listaProdutos) {
			System.out.println(produto);
		}
	}
	
	public void teste() {
		this.listaProdutos.add(new Produto("Celular", 3, 5000, 0, 1, 0, 10));
		this.listaProdutos.add(new Produto("Placa de video", 2, 6000, 0, 1, 0, 20));
		this.listaProdutos.add(new Produto("Geladeira", 4, 7000, 0, 1, 0, 30));
		this.listaProdutos.add(new Produto("BMW", 1, 9000, 0, 1, 0, 40));
		this.listaProdutos.add(new Produto("Guitarra", 5, 3000, 0, 1, 0, 50));
	}

	public ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(ArrayList<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
}
