package br.ucb.poo;

import java.util.Scanner;

import br.ucb.poo.bean.*;
import br.ucb.poo.dao.*;

public class Executora{
	
	public static void limpeza() {
		for (int i = 0; i < 100; ++i)  
		       System.out.println(); 
	}
	
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        ListaProdutos listaProdutos = new ListaProdutos();
        ListaUsuario listaUsuario = new ListaUsuario();
        ListaCarrinho listaCarrinho = new ListaCarrinho();
        ListaPagamentos listaPagamentos = new ListaPagamentos();
        ListaCategorias listaCategorias = new ListaCategorias();
        
        UsuarioDAO daoUsuario = new UsuarioDAO();
        listaUsuario.setListaUsuario(daoUsuario.listaUsuarios());
        
        
        CategoriaDAO daoCategoria = new CategoriaDAO();
        listaCategorias.setListaCategorias(daoCategoria.listaCategorias());
        
        
        ProdutoDAO daoProduto = new ProdutoDAO();
        listaProdutos.setListaProdutos(daoProduto.listaProdutos());
        
        
        CarrinhoDAO daoCarrinho = new CarrinhoDAO();
        listaCarrinho.setListaCarrinho(daoCarrinho.listaCarrinho());
        
        
        PagamentosDAO daoPagamento = new PagamentosDAO();
        listaPagamentos.setListaPagamentos(daoPagamento.listaPagamentos());
           
        
        
        
        Usuario usuarioAtual = null;
        
        int option = 0;

        do{
            System.out.println("=============================================");
            System.out.println("             MARKETPLACE - HOME              ");
            if (usuarioAtual != null)
            	System.out.println("                 " + usuarioAtual.getNome() +"        ");
            System.out.println("=============================================");
            System.out.println("1 - LOGIN/LOGOUT  2 - REGISTRO  0 - ENCERRAR ");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("   3 - BUSCAR PRODUTO   4 - LISTA CARRINHO   ");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("         5 - ADICIONAR NOVO PRODUTO          ");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("            6 - FINALIZAR COMPRAS            ");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("           7 - ADICIONAR CATEGORIA           ");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("           8 - VER TODAS AS LISTAS           ");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
            
            option = scanner.nextInt();
            

            switch(option){
                case (1):
                	if(usuarioAtual == null && listaUsuario.getListaUsuario().size() > 0)
                		usuarioAtual = listaUsuario.Login();
                	else {
                		System.out.println("Deseja fazer logout? [1] sim - [0] nao");
                		option = scanner.nextInt();
                		if(option == 1)
                			usuarioAtual = null;
                	}
                break;

                case (2):
                	if(usuarioAtual == null)
                		listaUsuario.Registro();
                	else
                		System.out.println("Não permitido");
                break;
                
                case (3):
                	BuscarProduto buscar = new BuscarProduto();
                	buscar.tipoBusca(listaProdutos, usuarioAtual, listaCarrinho, listaCategorias);
                break;
                
                case (4):
                	if(usuarioAtual != null) {
                		if(usuarioAtual.getTipoUsuario() == 1) {
                			listaCarrinho.mostrar(listaProdutos.getListaProdutos(), usuarioAtual, listaPagamentos);
                		}
                		else {
                			System.out.println("Sem permissao voce nao e CLIENTE");
                		}
                	}
                	else {
                		System.out.println("Sem permissao, voce nao esta logado");
                	}
                break;
                
                case (5):
                	if(usuarioAtual != null) {
                		if(usuarioAtual.getTipoUsuario() == 2) {
                			listaProdutos.novoProduto(usuarioAtual.getCodigo(), listaCategorias);
                			System.out.println(listaProdutos.getListaProdutos());
                		}
                		else {
                			System.out.println("Sem permissao voce nao e vendedor");
                		}
                	}
                	else
                		System.out.println("Sem permissao, voce nao esta logado");
                break;
                
                case (6):
                	if(usuarioAtual != null) {
                		if(usuarioAtual.getTipoUsuario() == 1) {
                			listaCarrinho.vender(listaProdutos.getListaProdutos(), usuarioAtual.getCodigo(), listaPagamentos);
                		}
                		else {
                			System.out.println("Sem permissao voce nao e CLIENTE");
                		}
                	}
                break;
                
                case(7):
                	listaCategorias.adicionarCategorias();
                break;
                
                case(8):
                	System.out.println("==========================Usuarios==========================");
                	for (Usuario usuario : listaUsuario.getListaUsuario()) {
						System.out.println(usuario);
					}
                	
                	System.out.println("==========================Categorias==========================");
                	for (Categorias categoria : listaCategorias.getListaCategorias()) {
						System.out.println(categoria);
					}
                	
                	System.out.println("==========================Produtos==========================");
                	for (Produto produto : listaProdutos.getListaProdutos()) {
						System.out.println(produto);
					}
                	
                	System.out.println("==========================Carrinho==========================");
                	for (Carrinho carrinho : listaCarrinho.getListaCarrinho()) {
						System.out.println(carrinho);
					}
                	
                	System.out.println("==========================Pagamentos==========================");
                	for (Pagamentos pagamento : listaPagamentos.getListaPagamentos()) {
						System.out.println(pagamento);
					}
                break;
                
                }
            
        }while(option != 0);
        
        scanner.close();
        
    }
}
