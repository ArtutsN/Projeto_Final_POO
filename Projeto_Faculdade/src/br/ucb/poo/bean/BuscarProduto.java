package br.ucb.poo.bean;

import java.util.ArrayList;
import java.util.Scanner;


public class BuscarProduto {
	
	public void tipoBusca(ListaProdutos listaProdutos, Usuario usuario, ListaCarrinho listaCarrinho, ListaCategorias listaCategorias) {
		Scanner scanner=new Scanner(System.in);
		
		ArrayList<Produto> listaOrdenada = listaProdutos.getListaProdutos();
		
		int option = 0;
		
		
		
		do{
			System.out.println("========== Tela de busca ==========");
			System.out.println("Deseja buscar como? ");
			System.out.println("Categoria [1] ");
			System.out.println("Mais vendido [2] ");
			System.out.println("Estrelas [3] ");
			System.out.println("Mais Caros[4] ");
			System.out.println("Voltar a tela inicial[0]");
			
			
			option = scanner.nextInt();

            switch(option){
                case (1):
                    OrdenarCategorias categoria = new OrdenarCategorias();
                	categoria.categorias(listaProdutos.getListaProdutos(), usuario, listaCarrinho, listaCategorias);
                break;

                case (2):
                	OrdenarVendidos vendidos = new OrdenarVendidos();
                	vendidos.ordenarLista(listaProdutos.getListaProdutos(), listaCarrinho, usuario);
                break;
                
                case (3):
                	OrdenarEstrelas estrelas = new OrdenarEstrelas();
            		estrelas.ordenarLista(listaProdutos.getListaProdutos(), listaCarrinho, usuario);
                break;
                
                case (4):
                	OrdenarValor valor = new OrdenarValor();
            		valor.ordenarLista(listaProdutos.getListaProdutos(), listaCarrinho, usuario);
                break;
                
                case (5):
                	listaProdutos.todosProdutos();
                break;
                
                case (0):

                break;
            }
        }while(option != 0);
	}
	
}
