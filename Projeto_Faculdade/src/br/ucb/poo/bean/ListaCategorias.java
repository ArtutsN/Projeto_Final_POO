package br.ucb.poo.bean;

import java.util.ArrayList;
import java.util.Scanner;

import br.ucb.poo.dao.*;

public class ListaCategorias {
	private ArrayList<Categorias> listaCategorias;
	
	public ListaCategorias() {
		listaCategorias = new ArrayList<>();
	}
	
	public void adicionarCategorias() {
		
		CategoriaDAO dao = new CategoriaDAO();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nome Categoria: ");
		String nome = scanner.nextLine();
		
		int idCategoria = listaCategorias.size() + 1;
		
		
		Categorias categoria = new Categorias(idCategoria, nome);
		listaCategorias.add(categoria);
		dao.insereCategoria(categoria);
		
	}
	
	public void teste() {
		listaCategorias.add(new Categorias(1, "CARRO"));
		listaCategorias.add(new Categorias(2, "COMPUTADOR"));
		listaCategorias.add(new Categorias(3, "CELULAR"));
		listaCategorias.add(new Categorias(4, "ELETRODOMESTICOS"));
		listaCategorias.add(new Categorias(5, "MUSICA"));
	}

	public ArrayList<Categorias> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(ArrayList<Categorias> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}
}
