package menus;

import java.util.Scanner;

import modelo.Limpar;

public class MenuCadastros {
	private static int opcao;

	@SuppressWarnings("resource")
	public static void menurCadastros() {
		MenuOpcoes.mensagemMenuCadastrosLocal();
		MenuOpcoes.mensagemOpcoes();
		MenuOpcoes.mensagemMenuCadastrosOpcoes();
		
		
		Scanner digitar = new Scanner(System.in);

		MenuOpcoes.mensagemDigiteOpcao();
		opcao = digitar.nextInt();

		switch (opcao) {
		case 1: //cadastrar
			Limpar.Tela();
			MenuCadastrosCadastrar.menuCadastrosCadastrar();
			break;
		case 2: //alterar
			Limpar.Tela();
			MenuCadastrosAlterar.menuCadastrosAlterar();
			break;
		case 3: //excluir
			Limpar.Tela();
			MenuCadastrosExcluir.menuCadastrosExcluir();
			break;
		case 4: //voltar > Menu Principal
			Limpar.Tela();
			MenuPrincipal.menurPrincipal();
			break;
		case 0:
			MenuOpcoes.OpcaoSairDoSistema();
			break;

		default:
			MenuOpcoes.mensagemDeOpcaoErrada();
			MenuCadastros.menurCadastros();
			break;
		}

	}

}