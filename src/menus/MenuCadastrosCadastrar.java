package menus;

import java.util.Scanner;

import modelo.Limpar;
import modelo.Tarifas;
import controle.CadastroAtendente;
import controle.CadastroCliente;
import controle.CadastroMidia;

public class MenuCadastrosCadastrar {
	private static int opcao;

	public static void menuCadastrosCadastrar() {

		MenuOpcoes.mensagemCadastrosCadastrarLocal();
		MenuOpcoes.mensagemOpcoes();
		MenuOpcoes.mensagemMenuCadastrosCadastrarOpcoes();

		@SuppressWarnings("resource")
		Scanner digitar = new Scanner(System.in);

		MenuOpcoes.mensagemDigiteOpcao();
		opcao = digitar.nextInt();

		switch (opcao) {
		case 1: // clientes
			Limpar.Tela();

			String opc = null;
			Scanner dc = new Scanner(System.in);

			do {
				CadastroCliente.cadastrarCliente();

				System.out.println("\nDeseja cadastrar outro cliente?");
				System.out
						.print(" S para Sim ou outra tecla + ENTER para Não: ");
				opc = dc.next();

			} while (opc.equalsIgnoreCase("S"));

			Limpar.Tela();

			MenuCadastrosCadastrar.menuCadastrosCadastrar();

			break;
		case 2: // tarifas
			Limpar.Tela();

			Tarifas.CalculaTarifa();
			Tarifas.totalDiasMidiaAlugadaCliente();

			Limpar.Tela();

			MenuCadastrosCadastrar.menuCadastrosCadastrar();

		break;

		case 3: // mididas

			Limpar.Tela();

			String opm = null;
			Scanner cm = new Scanner(System.in);
			do {
				CadastroMidia.cadastrarMidia();

				System.out.println("\nDeseja cadastrar outra mídia?");
				System.out
						.print(" S para Sim ou outra tecla + ENTER para Não: ");
				opm = cm.next();

			} while (opm.equalsIgnoreCase("S"));
			Limpar.Tela();
			MenuCadastrosCadastrar.menuCadastrosCadastrar();
			break;

		case 4:// funcionarios
			Limpar.Tela();

			String opa = null;
			Scanner df = new Scanner(System.in);
			do {
				CadastroAtendente.cadastrarAtendente();

				System.out.println("\nDeseja cadastrar outro funcionário?");
				System.out
						.print(" S para Sim ou outra tecla + ENTER para Não: ");
				opa = df.next();

			} while (opa.equalsIgnoreCase("S"));
			Limpar.Tela();
			MenuCadastrosCadastrar.menuCadastrosCadastrar();
			break;

		case 6:// voltar
			Limpar.Tela();
			MenuCadastros.menurCadastros();
			break;

		case 7:// menur principal
			MenuOpcoes.voltarMenuPrincipal();

		case 0: // sair
			MenuOpcoes.OpcaoSairDoSistema();
			break;

		default:
			MenuOpcoes.mensagemDeOpcaoErrada();
			MenuCadastrosCadastrar.menuCadastrosCadastrar();
			break;
		}

	}

}