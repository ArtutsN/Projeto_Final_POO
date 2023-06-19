package br.ucb.poo.bean;

import java.util.ArrayList;
import java.util.Scanner;



public class OrdenarCategorias {	
		
		public void listaCategoria(ArrayList<Produto> listaProdutos, int categoria, Usuario usuario, ListaCarrinho listaCarrinho){
			
			ArrayList<Produto> listaCategoria = new ArrayList<Produto>();
			
			for(Produto produto: listaProdutos) {
				if(produto.getCategoria() == categoria) {
					listaCategoria.add(produto);
				}
			}
			
			for (Produto produto : listaCategoria) {
				System.out.println(produto);
			}
			
			
			if(usuario != null) {
				if(usuario.getTipoUsuario() == 1) {
					System.out.println("Deseja adicionar algum produto? [0] nao - [1] sim");
					Scanner scanner = new Scanner(System.in);
					int num = scanner.nextInt();
					if(num == 1) {
						listaCarrinho.adicionarProduto(listaCategoria, usuario);
					}
				}
			}
			
			
		}
		
		public void categorias(ArrayList<Produto> listaProdutos, Usuario usuario, ListaCarrinho listaCarrinho, ListaCategorias listaCategorias) {
			 Scanner scanner=new Scanner(System.in);
			 int option;
			 
			 do{      
		            System.out.println("Digite [999] para sair");
		            for(Categorias categorias: listaCategorias.getListaCategorias()) {
		            	System.out.println(categorias.getIdCategoria() +  " - " + categorias.getNome());
		            }
		            
		            option = scanner.nextInt();
		            if (option > listaCategorias.getListaCategorias().size()) {
						option = 999;
						System.out.println("Sair");
					}
		            else
		            	this.listaCategoria(listaProdutos, option, usuario, listaCarrinho);

		         
		                	
		       }while(option != 999);
		 }
	}

