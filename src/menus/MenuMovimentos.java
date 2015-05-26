package menus;

import java.util.Scanner;

import modelo.Limpar;
import controle.CadastroMidia;
import controle.Locacao;
import controle.Venda;

public class MenuMovimentos {
	private static int opcao;

	public static void menuMovimentos() {

		MenuOpcoes.mensagemMenuMovimentosLocal();
		MenuOpcoes.mensagemOpcoes();
		MenuOpcoes.mensagemMenuMovimentosOpcoes();

		@SuppressWarnings("resource")
		Scanner digitar = new Scanner(System.in);

		MenuOpcoes.mensagemDigiteOpcao();
		opcao = digitar.nextInt();

		switch (opcao) {
		case 1: // Alugar
			// INICIO DO CASE 1 - ALUGAR
			Limpar.Tela();

			int opr = 0;
			Locacao.iniciarLocacaoMidias();

			System.out.println("\n\nOpções");
			System.out.println("1 Menu Principal\n2 Nova Locação");
			System.out.print("Digite a opção: ");
			opr = digitar.nextInt();
			switch (opr) {
			case 1:
				Limpar.Tela();
				MenuPrincipal.menurPrincipal();
				break;

			case 2:
				Limpar.Tela();
				Locacao.iniciarLocacaoMidias();
				MenuMovimentos.menuMovimentos();
				break;

			default:
				MenuOpcoes.mensagemDeOpcaoErrada();
				MenuRelatorios.menuRelatorios();
				break;
			}
			break;
		// FIM DO CASE 1 - ALUGAR

		case 2: // Baixa mídias
			// INICIO DO CASE 2 - BAIXA MIDIA
			Limpar.Tela();

			int oprbm = 0;
			CadastroMidia.darBaixaMidiaPorNome();

			System.out.println("\n\nOpções");
			System.out.println("1 Menu Principal\n2 Nova Baixa");
			System.out.print("Digite a opção: ");
			opr = digitar.nextInt();
			switch (oprbm) {
			case 1:
				Limpar.Tela();
				MenuPrincipal.menurPrincipal();
				break;

			case 2:
				Limpar.Tela();
				CadastroMidia.darBaixaMidiaPorNome();
				MenuMovimentos.menuMovimentos();
				;
				break;

			default:
				MenuOpcoes.mensagemDeOpcaoErrada();
				MenuRelatorios.menuRelatorios();
				break;
			}
			break;
		// FIM DO CASE 2 - BAIXA MIDIA

		case 3:

			// INICIO DO CASE 3 - VENDER
			Limpar.Tela();

			int opv = 0;
			Venda.iniciarVendaMidias();

			System.out.println("\n\nOpções");
			System.out.println("1 Menu Principal\n2 Nova Venda");
			System.out.print("Digite a opção: ");
			opv = digitar.nextInt();
			switch (opv) {
			case 1:
				Limpar.Tela();
				MenuPrincipal.menurPrincipal();
				break;

			case 2:
				Limpar.Tela();
				Venda.iniciarVendaMidias();
				MenuMovimentos.menuMovimentos();
				break;

			default:
				MenuOpcoes.mensagemDeOpcaoErrada();
				MenuRelatorios.menuRelatorios();
				break;
			}
			break;
		// FIM DO CASE 3 - VENDER

		case 4:// Entrada Midias Estoque
				// INICIO DO CASE 4 - ENTRADA ESTOQUE MIDIAS
			Limpar.Tela();

			int oprem = 0;
			CadastroMidia.EntradaEstoqueMidiaPorNome();

			System.out.println("\n\nOpções");
			System.out.println("1 Menu Principal\n2 Nova Entrada Mídia");
			System.out.print("Digite a opção: ");
			opr = digitar.nextInt();
			switch (oprem) {
			case 1:
				Limpar.Tela();
				MenuPrincipal.menurPrincipal();
				break;

			case 2:
				Limpar.Tela();
				CadastroMidia.EntradaEstoqueMidiaPorNome();
				MenuMovimentos.menuMovimentos();
				break;

			default:
				MenuOpcoes.mensagemDeOpcaoErrada();
				MenuRelatorios.menuRelatorios();
				break;
			}
			break;
		// FIM DO CASE 2 - BAIXA MIDIA

		case 7: // menu principal
			MenuOpcoes.voltarMenuPrincipal();
			break;
		case 0: // sair do sistema
			MenuOpcoes.OpcaoSairDoSistema();
			break;

		default:
			MenuOpcoes.mensagemDeOpcaoErrada();
			MenuCadastrosAlterar.menuCadastrosAlterar();
			break;
		}

	}

}
