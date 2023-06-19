package br.ucb.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.ucb.poo.bean.*;
import br.ucb.poo.factory.ConexaoFactory;

public class PagamentosDAO {
	ConexaoFactory conexao = new ConexaoFactory();	
	Connection connection = conexao.conectar();
	
	public void inserePagamento(Pagamentos pagamento) {
		String sql = "INSERT INTO pagamentos(idUsuario, valor, metodoPagamento) VALUE(?, ?, ?)";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, pagamento.getCodigo_usuario());
			pstmt.setDouble(2, pagamento.getValor());
			pstmt.setString(3, pagamento.getMetodo_pagamento());
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Pagamentos> listaPagamentos(){
		String sql = "SELECT idpagamentos, idUsuario, valor, metodoPagamento from pagamentos";
		
		ArrayList<Pagamentos> pagamentos = new ArrayList<Pagamentos>();
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Pagamentos pagamento = new Pagamentos(rs.getInt("idpagamentos"),  rs.getInt("idUsuario"), rs.getDouble("valor"), rs.getString("metodoPagamento"));
				pagamentos.add(pagamento);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pagamentos;
		
	}
}
