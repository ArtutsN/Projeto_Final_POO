package br.ucb.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.ucb.poo.bean.*;
import br.ucb.poo.factory.ConexaoFactory;

public class ProdutoDAO {
	ConexaoFactory conexao = new ConexaoFactory();	
	Connection connection = conexao.conectar();
	
	public void insereProduto(Produto produto) {
		String sql = "INSERT INTO produto(nome, estrelas, categoria, vendedor, valor, vendas) VALUE(?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, produto.getName());
			pstmt.setDouble(2, produto.getEstrelas());
			pstmt.setInt(3, produto.getCategoria());
			pstmt.setInt(4, produto.getVendedor());
			pstmt.setDouble(5, produto.getValor());
			pstmt.setInt(6, produto.getVendas());
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Produto> listaProdutos(){
		String sql = "SELECT idProduto, nome, estrelas, categoria, vendedor, valor, vendas from produto";
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Produto produto = new Produto(rs.getString("nome"),  rs.getInt("categoria"),  rs.getDouble("valor"), rs.getDouble("estrelas"), rs.getInt("vendedor"), rs.getInt("vendas"), rs.getInt("idProduto"));
				produtos.add(produto);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return produtos;
		
	}
}
