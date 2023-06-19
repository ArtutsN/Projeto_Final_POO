package br.ucb.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.ucb.poo.bean.*;
import br.ucb.poo.factory.ConexaoFactory;

public class CarrinhoDAO {
	ConexaoFactory conexao = new ConexaoFactory();	
	Connection connection = conexao.conectar();
	
	public void insereCarrinho(Carrinho carrinho) {
		String sql = "INSERT INTO carrinho(idUsuario, idProduto) VALUE(?, ?)";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, carrinho.getCodigo_usuario());
			pstmt.setInt(2, carrinho.getCodigo_produto());
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Carrinho> listaCarrinho(){
		String sql = "SELECT idUsuario, idProduto from carrinho";
		
		ArrayList<Carrinho> carrinho = new ArrayList<Carrinho>();
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Carrinho produto = new Carrinho(rs.getInt("idUsuario"),  rs.getInt("idProduto"));
				carrinho.add(produto);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return carrinho;
		
	}
}
