package br.com.fasete.principal;

import java.util.List;

import br.com.fasete.dao.ProdutoDAO;
import br.com.fasete.entidades.Produtos;

public class Principal {

	public static void main(String[] args) {
		
		ProdutoDAO daoProduto = new ProdutoDAO();
		
		List<Produtos> listaProdutos = daoProduto.listar("descricao");
		
		for (Produtos produtos : listaProdutos) {
			System.out.println("Nome do produto: " + produtos.getDescricao());
		}
	}

}
