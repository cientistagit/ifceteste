package menus;

import java.util.Scanner;

import modelo.Limpar;

public class MenuPrincipal {
	
	private static int opcao;

	public static void menurPrincipal() {
		Limpar.Tela();

		@SuppressWarnings("resource")
		Scanner digitar = new Scanner(System.in);

		MenuOpcoes.mensagemBemVindo();

		MenuOpcoes.mensagemMenuPrincipal();
		MenuOpcoes.mensagemOpcoes();
		MenuOpcoes.mensagemMenuPrincipalOpcoes();

		MenuOpcoes.mensagemDigiteOpcao();
		opcao = digitar.nextInt();

		switch (opcao) {
		case 1: //cadastros
			Limpar.Tela();
			MenuCadastros.menurCadastros();
			break;
		case 2: //movimentos
			Limpar.Tela();
			MenuMovimentos.menuMovimentos();
			break;
		case 3://relatórios
			Limpar.Tela();
			MenuRelatorios.menuRelatorios();
			break;
		case 0:
			MenuOpcoes.OpcaoSairDoSistema();
		default:
			MenuOpcoes.mensagemDeOpcaoErrada();
			MenuPrincipal.menurPrincipal();
			break;
		}

	}

}
