package br.ucb.poo.bean;

import java.util.ArrayList;
import java.util.Scanner;

import br.ucb.poo.dao.*;

public class ListaUsuario {
	private ArrayList<Usuario> listaUsuario;
	
	public ListaUsuario(){
		this.listaUsuario = new ArrayList<>();
	}
	
	public void Registro() {
		
		UsuarioDAO dao = new UsuarioDAO();
		
		Scanner scanner = new Scanner(System.in);
		
		String nome, cpf, cep, telefone, email, senha, login;
		int tipoUsuario, codigo;
		
		System.out.println("==============================================");
        System.out.println("                   REGISTRO                   ");
        System.out.println("Escolha o perfil de registro:                 ");
        System.out.println("1 - Cliente                                   ");
        System.out.println("2 - vendedor                                  ");
        System.out.println("==============================================");

		tipoUsuario = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Seu nome: ");
		nome = scanner.nextLine();
		
		System.out.println("Seu CPF: ");
		cpf = scanner.nextLine();
		
		System.out.println("Seu cep: ");
		cep = scanner.nextLine();
		
		System.out.println("Seu telefone: ");
		telefone = scanner.nextLine();
		
		System.out.println("Seu email: ");
		email = scanner.nextLine();
		
		System.out.println("Digite seu login: ");
		login = scanner.nextLine();
		
		System.out.println("Sua senha: ");
		senha = scanner.nextLine();
		
		if (tipoUsuario == 1 || tipoUsuario == 2) {
			codigo = this.listaUsuario.size() + 1;
			Usuario usuario = new Usuario(nome, cpf, tipoUsuario, codigo, login, senha, cep, telefone, email);
			listaUsuario.add(usuario);
			dao.insereUsuario(usuario);
		}
		
		else {
			System.out.println("Invalido\n");
		}
		
	}
	
	public Usuario Login() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("==============================================");
        System.out.println("                    LOGIN                     ");
        System.out.println("==============================================");
        System.out.println("Escolha o perfil de acesso:                   ");
        System.out.println("1 - Cliente                                   ");
        System.out.println("2 - vendedor                                  ");
        System.out.println("3 - Admin                                     ");
        System.out.println("==============================================");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        if(opcao < 1 || opcao > 3) {
        	System.out.println("Opcao invalida");
        	return null;
        }
        
		System.out.println("Usuario: ");
		String usuario = scanner.nextLine();
		
		System.out.println("Senha: ");
		String senha = scanner.nextLine();
		int codigo;
		
		boolean encontrou=false;
		int i=0;
		
		while (!encontrou && i < listaUsuario.size()) {
			if(usuario.equals(listaUsuario.get(i).getLogin()) && senha.equals(listaUsuario.get(i).getSenha())) {
				if(opcao == listaUsuario.get(i).getTipoUsuario()) {
					return listaUsuario.get(i);
				}
				else {
					System.out.println("Usuario nao cadastrado com a sua opcao");
					return null;
				}
			}
			else{
				i++;
			}
		}

		System.out.println("Usuario nao existe");
		return null;
	}

	public ArrayList<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

}
