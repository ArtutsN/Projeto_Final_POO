package br.ucb.poo.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import br.ucb.poo.dao.*;

public class ListaCarrinho {
	private ArrayList<Carrinho> listaCarrinho;
	
	public ListaCarrinho() {
		listaCarrinho = new ArrayList<>();
	}
	
	public void adicionarProduto(ArrayList<Produto> listaProdutos, Usuario usuario) {
		
		CarrinhoDAO dao = new CarrinhoDAO();
		
		Scanner scanner = new Scanner(System.in);
				
		System.out.println("Qual produto deseja? ");
		int i = scanner.nextInt();
		
		Carrinho carrinho = new Carrinho(usuario.getCodigo(), listaProdutos.get(i-1).getCodigo());
		
		this.listaCarrinho.add(carrinho);
		dao.insereCarrinho(carrinho);
		
		
	}
	
	public void mostrar(ArrayList<Produto> lista, Usuario usuario, ListaPagamentos listaPagamentos) {
		for (Carrinho carrinho : listaCarrinho) {
			if(carrinho.getCodigo_usuario() == usuario.getCodigo()) {
				for (Produto produto : lista) {
					if (carrinho.getCodigo_produto() == produto.getCodigo()) {
						System.out.println(produto);
					}
				}
			}
		}
	}
	
	public void vender(ArrayList<Produto> lista, int usuario, ListaPagamentos listaPagamentos) {
		
		Scanner scanner = new Scanner(System.in);
		double valorGeral = 0;
		
		Iterator<Carrinho> iterator = listaCarrinho.iterator();
		while (iterator.hasNext()) {
		    Carrinho carrinho = iterator.next();
		    if (carrinho.getCodigo_usuario() == usuario) {
		        for (Produto produto : lista) {
		            if (carrinho.getCodigo_produto() == produto.getCodigo()) {
		            	valorGeral += produto.getValor();
		                produto.setVendas(produto.getVendas() + 1);
		                System.out.println("Digite sua nota: ");
		                int option = scanner.nextInt();
		                produto.setEstrelas((produto.getEstrelas() * (produto.getVendas() - 1) + option) / produto.getVendas());
		                iterator.remove(); // Remove o carrinho usando o iterador
		            }
		        }
		    }
		}
		listaPagamentos.adicionarPagamento(usuario, valorGeral);
	}
	
	
	public ArrayList<Carrinho> getListaCarrinho() {
		return listaCarrinho;
	}

	public void setListaCarrinho(ArrayList<Carrinho> listaCarrinho) {
		this.listaCarrinho = listaCarrinho;
	}

	@Override
	public String toString() {
		return "ListaCarrinho [listaCarrinho=" + listaCarrinho + "]";
	}
	
}
