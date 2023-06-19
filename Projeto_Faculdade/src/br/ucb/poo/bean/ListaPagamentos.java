package br.ucb.poo.bean;

import java.util.ArrayList;
import java.util.Scanner;

import br.ucb.poo.dao.*;

public class ListaPagamentos {
	private ArrayList<Pagamentos> listaPagamentos;
	
	public ListaPagamentos() {
		listaPagamentos = new ArrayList<>();
	}
	
	public void adicionarPagamento(int idUsuario, double valor) {
		
		PagamentosDAO dao = new PagamentosDAO();
		
		Scanner scanner = new Scanner(System.in);
		String metodo;
		int idPedido;
		
		System.out.println("==============================================");
        System.out.println("                  PAGAMENTOS                  ");
        System.out.println("==============================================");
        System.out.println("1 - DEBITO                    2 - CREDITO     ");
        System.out.println("3 - BOLETO                    4 - PIX         ");
        System.out.println("==============================================");
		
        int option = scanner.nextInt();
		
		scanner.nextLine();
		
		if(option == 1) {
			metodo = "DEBITO";
		}
		else if(option == 2) {
			metodo = "CREDITO";
		}
		else if(option == 3) {
			metodo = "BOLETO";
		}
		else {
			metodo = "PIX";
		}
		
		idPedido = listaPagamentos.size() + 1;
		
		Pagamentos pagamento = new Pagamentos(idUsuario, idPedido, valor, metodo);
		
		listaPagamentos.add(pagamento);
		dao.inserePagamento(pagamento);
		
	}
	
	public void verPagamentos() {
		int i=0;
		for (Pagamentos pagamentos : listaPagamentos) {
			i++;
			System.out.println(i + " - " + pagamentos);
		}
	}

	public ArrayList<Pagamentos> getListaPagamentos() {
		return listaPagamentos;
	}

	public void setListaPagamentos(ArrayList<Pagamentos> listaPagamentos) {
		this.listaPagamentos = listaPagamentos;
	}
}
