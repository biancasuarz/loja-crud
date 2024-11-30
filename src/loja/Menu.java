package loja;

import java.util.InputMismatchException;
import java.util.Scanner;

import loja.controller.LojaController;
import loja.model.Videogame;

public class Menu {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		LojaController loja = new LojaController();

		int codigo, quantidade, voltagem, opcao;
		String nome, descricao;
		double preco;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                        AKATSUKI                     ");
			System.out.println("            		Desce pro Play!	   		         ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Produto	                   	 ");
			System.out.println("            2 - Listar Todos os Produtos             ");
			System.out.println("            3 - Buscar por Código		             ");
			System.out.println("            4 - Atualizar Produto                    ");
			System.out.println("            5 - Apagar Produto                       ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			try {
				opcao = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				opcao = 0;
			}

			switch (opcao) {

			case 1:
				System.out.println("Digite o nome do produto: ");
				sc.skip("\\R?");
				nome = sc.nextLine();
				System.out.println("Digite a descrição do produto: ");
				descricao = sc.nextLine();
				System.out.println("Digite o preço do produto: R$");
				preco = sc.nextDouble();
				System.out.println("Digite a quantidade: ");
				quantidade = sc.nextInt();
				System.out.println("Digite a voltagem do produto: ");
				voltagem = sc.nextInt();
				loja.cadastrar(new Videogame(loja.gerarCodigo(), nome, descricao, preco, quantidade, voltagem));

				break;
			case 2:
				System.out.println("Listar todos os produtos");
				loja.listarTodos();

				break;
			case 3:
				System.out.println("Digite código do produto desejado para buscar: ");
				codigo = sc.nextInt();
				loja.procurarPorCodigo(codigo);

				break;
			case 4:
				System.out.println("Digite o código do produto: ");
				codigo = sc.nextInt();
				var buscarProduto = loja.buscarNaCollection(codigo);
				if (buscarProduto != null) {
					System.out.println("Digite o nome do produto: ");
					sc.skip("\\R?");
					nome = sc.nextLine();
					System.out.println("Digite a descrição do produto: ");
					descricao = sc.nextLine();
					System.out.println("Digite o preço do produto: R$");
					preco = sc.nextDouble();
					System.out.println("Digite a quantidade: ");
					quantidade = sc.nextInt();
					System.out.println("Digite a voltagem do produto: ");
					voltagem = sc.nextInt();
					loja.atualizar(new Videogame(codigo, nome, descricao, preco, quantidade, voltagem));
				} else {
					System.out.println("Produto não encontrado!");
				}

				break;
			case 5:
				System.out.println("Digite o código do produto que deseja deletar: ");
				codigo = sc.nextInt();
				loja.excluir(codigo);

				break;
			case 6:
				System.out.println("Programa encerrado com sucesso!");
				sobre();
				sc.close();
				System.exit(0);

				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("https://github.com/biancasuarz");
		System.out.println("https://github.com/Schuab3000s");
		System.out.println("https://github.com/marcoslopesdev");
		System.out.println("https://github.com/IJnavi");
		System.out.println("*********************************************************");
	}
}
