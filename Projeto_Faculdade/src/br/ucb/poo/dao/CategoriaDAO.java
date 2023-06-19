package br.ucb.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.ucb.poo.bean.*;
import br.ucb.poo.factory.ConexaoFactory;

public class CategoriaDAO {
	ConexaoFactory conexao = new ConexaoFactory();	
	Connection connection = conexao.conectar();
	
	public void insereCategoria(Categorias categoria) {
		String sql = "INSERT INTO categorias (nome) VALUE(?)";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, categoria.getNome());
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Categorias> listaCategorias(){
		String sql = "SELECT idCategorias, nome from categorias";
		
		ArrayList<Categorias> categorias = new ArrayList<Categorias>();
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Categorias categoria = new Categorias(rs.getInt("idCategorias"),  rs.getString("nome"));
				categorias.add(categoria);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return categorias;
		
	}
}
