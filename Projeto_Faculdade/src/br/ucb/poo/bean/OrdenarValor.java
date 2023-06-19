package br.ucb.poo.bean;

import java.util.ArrayList;
import java.util.Scanner;


public class OrdenarValor implements OrdenarLista {

	@Override
	public void ordenarLista(ArrayList<Produto> listaProdutos, ListaCarrinho listaCarrinho, Usuario usuario) {
		
		ArrayList<Produto> listaValor = new ArrayList<>();
		Produto intermediaria;
		
		for(int i = 0; i < listaProdutos.size(); i++) {
			for(int j = 0; j < listaProdutos.size() - i - 1; j++) {
				if(listaProdutos.get(j).getValor() < listaProdutos.get(j + 1).getValor()) {
					intermediaria = listaProdutos.get(j + 1);
					listaProdutos.set(j + 1, listaProdutos.get(j));
					listaProdutos.set(j, intermediaria);
				}
			}
		}
		
		for (Produto produto : listaProdutos) {
			System.out.println(produto);
			listaValor.add(produto);
		}
		
		if(usuario != null) {
			if(usuario.getTipoUsuario() == 1) {
				System.out.println("Deseja adicionar algum produto? [0] nao - [1] sim");
				Scanner scanner = new Scanner(System.in);
				int num = scanner.nextInt();
				if(num == 1) {
					listaCarrinho.adicionarProduto(listaValor, usuario);
				}
			}
		}

	}

}
