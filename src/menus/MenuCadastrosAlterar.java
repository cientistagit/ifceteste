package menus;

import java.util.Scanner;

import controle.CadastroAtendente;
import controle.CadastroCliente;
import controle.CadastroLojaDados;
import controle.CadastroMidia;
import modelo.Limpar;
import modelo.Tarifas;

public class MenuCadastrosAlterar {
	private static int opcao;

	public static void menuCadastrosAlterar() {

		MenuOpcoes.mensagemCadastrosAlterarLocal();
		MenuOpcoes.mensagemOpcoes();
		MenuOpcoes.mensagemMenuCadastrosAlterarOpcoes();

		@SuppressWarnings("resource")
		Scanner digitar = new Scanner(System.in);

		MenuOpcoes.mensagemDigiteOpcao();
		opcao = digitar.nextInt();

		switch (opcao) {
		case 1: // clientes

			Limpar.Tela();
			String opcc = null;
			Scanner dcc = new Scanner(System.in);
			do {
				CadastroCliente.editarClientePorNome();

				System.out
						.println("\nDeseja alterar/localizar os dados de outro cliente?");
				System.out.print(" S para Sim e outra tecla para Não: ");
				opcc = dcc.next();

			} while (opcc.equalsIgnoreCase("S"));
			Limpar.Tela();
			MenuCadastrosAlterar.menuCadastrosAlterar();
			Limpar.Tela();

			break;
		case 2: // Tarifas
			Limpar.Tela();

			Tarifas.CalculaTarifa();
			Tarifas.totalDiasMidiaAlugadaCliente();

			Limpar.Tela();

			MenuCadastrosCadastrar.menuCadastrosCadastrar();
			break;
		case 3:// midias

			Limpar.Tela();
			String opam = null;
			Scanner am = new Scanner(System.in);
			do {
				CadastroMidia.editarMidiaPorNome();

				System.out
						.println("\nDeseja alterar/localizar os dados de outra mídia?");
				System.out.print(" S para Sim e outra tecla para Não: ");
				opam = am.nextLine();

			} while (opam.equalsIgnoreCase("s"));
			Limpar.Tela();
			MenuCadastrosAlterar.menuCadastrosAlterar();
			Limpar.Tela();

			
			break;

		case 4: // funcionarios

			Limpar.Tela();
			String op = null;
			Scanner dfa = new Scanner(System.in);
			do {
				CadastroAtendente.editarFuncionarioPorNome();

				System.out
						.println("\nDeseja alterar/localizar os dados de outro funcionário?");
				System.out.print(" S para Sim e outra tecla para Não: ");
				op = dfa.next();

			} while (op.equalsIgnoreCase("S"));
			Limpar.Tela();
			MenuCadastrosAlterar.menuCadastrosAlterar();
			Limpar.Tela();

			break;

		case 5: // Dados da Loja

			Limpar.Tela();
			String opdl = null;
			Scanner ddl = new Scanner(System.in);

			System.out.println("\nDeseja realmente alterar os dados da loja?");
			System.out.print(" S para Sim e outra tecla para Não: ");
			opdl = ddl.next();

			if (opdl.equalsIgnoreCase("S")) {
				CadastroLojaDados.alterarDadosLoja();

			} else {
				Limpar.Tela();
				MenuCadastrosAlterar.menuCadastrosAlterar();
				Limpar.Tela();
			}

			break;

		case 6: // voltar
			Limpar.Tela();
			MenuCadastros.menurCadastros();
			break;
		case 7: // menu principal
			MenuOpcoes.voltarMenuPrincipal();
		case 0:
			MenuOpcoes.OpcaoSairDoSistema();
			break;

		default:
			MenuOpcoes.mensagemDeOpcaoErrada();
			MenuCadastrosAlterar.menuCadastrosAlterar();
			break;
		}

	}

}
