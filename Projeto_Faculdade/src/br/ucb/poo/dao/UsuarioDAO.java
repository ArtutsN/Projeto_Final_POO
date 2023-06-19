package br.ucb.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.ucb.poo.factory.ConexaoFactory;
import br.ucb.poo.bean.*;

public class UsuarioDAO {
	ConexaoFactory conexao = new ConexaoFactory();	
	Connection connection = conexao.conectar();
	
	public void insereUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuario(nome, email, senha, login, cpf, cep, telefone, tipoUsuario) VALUE(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getEmail());
			pstmt.setString(3, usuario.getSenha());
			pstmt.setString(4, usuario.getLogin());
			pstmt.setString(5, usuario.getCpf());
			pstmt.setString(6, usuario.getCep());
			pstmt.setString(7, usuario.getTelefone());
			pstmt.setInt(8, usuario.getTipoUsuario());
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Usuario> listaUsuarios(){
		String sql = "SELECT idUsuario, nome, email, senha, login, cpf, cep, telefone, tipoUsuario from usuario";
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Usuario usuario = new Usuario(rs.getString("nome"),  rs.getString("cpf"),  rs.getInt("tipoUsuario"), rs.getInt("idUsuario"), rs.getString("login"), rs.getString("senha"), rs.getString("cep"), rs.getString("telefone"), rs.getString("email"));
				usuarios.add(usuario);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuarios;
		
	}
}
