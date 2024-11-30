package loja.controller;

import loja.model.Produto;
import loja.repository.LojaRepository;

import java.util.ArrayList;

public class LojaController implements LojaRepository {

	private ArrayList<Produto> listaProdutos = new ArrayList<>();

	int codigo = 0;

	public Produto buscarNaCollection(int codigo) {
		for (var produto : listaProdutos) {
			if (produto.getCodigo() == codigo) {
				return produto;
			}
		}
		return null;
	}

	@Override
	public void procurarPorCodigo(int codigo) {
		var produto = buscarNaCollection(codigo);
		if (produto != null) {
			produto.visualizar();
		} else {
			System.out.println("O produto " + codigo + " não foi encontrado!");
		}
	}

	@Override
	public void listarTodos() {
		for (var produto : listaProdutos) {
			produto.visualizar();
		}
	}

	@Override
	public void excluir(int codigo) {
		var produto = buscarNaCollection(codigo);
		if (produto != null) {
			if (listaProdutos.remove(produto) == true) {
				System.out.println("Produto " + codigo + " excluido com sucesso!");
			}
		} else {
			System.out.println("Produto " + codigo + " não foi encontrado!");
		}
	}

	@Override
	public void atualizar(Produto produto) {
		var buscaProduto = buscarNaCollection(produto.getCodigo());
		if (buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
			System.out.println("Produto " + produto.getCodigo() + " atualizado com sucesso!");
		} else {
			System.out.println("Prdouto " + produto.getCodigo() + " não foi encontrado!");
		}
	}

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("Produto " + produto.getCodigo() + " cadastrado com sucesso!");
	}

	public int gerarCodigo() {
		return ++codigo;
	}

}
