package menus;

import java.util.Scanner;

import controle.CadastroAtendente;
import controle.CadastroCliente;
import controle.CadastroLojaDados;
import controle.CadastroMidia;
import controle.Locacao;
import controle.Venda;
import modelo.Limpar;

public class MenuRelatorios {
	private static int opcao;

	@SuppressWarnings("resource")
	public static void menuRelatorios() {

		MenuOpcoes.mensagemMenuRel�toriosLocal();
		MenuOpcoes.mensagemOpcoes();
		MenuOpcoes.mensagemMenuRelariosOpcoes();
		Scanner digitar = new Scanner(System.in);

		MenuOpcoes.mensagemDigiteOpcao();
		opcao = digitar.nextInt();

		switch (opcao) {
		case 1:// mostrar todos os clientes cadastrados
				// INICIO DO CASE 1
			Limpar.Tela();

			int opr = 0;

			CadastroCliente.mostrarTodosClientesCadastrados();

			System.out.println("\n\nOp��es");
			System.out
					.println("1 Menu Principal\n2 Relat�rios\n3 Alterar\n4 Excluir");
			System.out.print("Digite a op��o: ");
			opr = digitar.nextInt();
			switch (opr) {
			case 1:
				Limpar.Tela();
				MenuPrincipal.menurPrincipal();
				break;

			case 2:
				Limpar.Tela();
				MenuRelatorios.menuRelatorios();
				break;

			case 3:
				Limpar.Tela();
				CadastroCliente.editarClientePorNome();
				break;

			case 4:
				Limpar.Tela();
				CadastroCliente.excluirClientePorNome();
				break;

			default:
				MenuOpcoes.mensagemDeOpcaoErrada();
				MenuRelatorios.menuRelatorios();
				break;
			}

			break;
		// FIM DO CASE 1
		case 2:// mostrar todas as m�dias cadastradas
				// IN�CIO DO CASE 1
			Limpar.Tela();

			int opm = 0;

			CadastroMidia.mostraTodasMidiasCadastradas();

			System.out.println("\n\nOp��es");
			System.out
					.println("1 Menu Principal\n2 Relat�rios\n3 Alterar\n4 Excluir");
			System.out.print("Digite a op��o: ");
			opm = digitar.nextInt();
			switch (opm) {
			case 1:
				Limpar.Tela();
				MenuPrincipal.menurPrincipal();
				break;

			case 2:
				Limpar.Tela();
				MenuRelatorios.menuRelatorios();
				break;

			case 3:
				Limpar.Tela();
				CadastroMidia.editarMidiaPorNome();
				break;

			case 4:
				Limpar.Tela();
				CadastroMidia.excluirMidiaPorNome();
				break;

			default:
				MenuOpcoes.mensagemDeOpcaoErrada();
				MenuRelatorios.menuRelatorios();
				break;
			}

			break;
		// FIM DO CASE 2
		case 3:// mostrar todos os funcion�rios cadastrados

			// INICIO DO CASE 3
			Limpar.Tela();

			int oprf = 0;

			CadastroAtendente.mostrarTodosFuncionariosCadastrados();

			System.out.println("\n\nOp��es");
			System.out
					.println("1 Menu Principal\n2 Relat�rios\n3 Alterar\n4 Excluir");
			System.out.print("Digite a op��o: ");
			oprf = digitar.nextInt();
			switch (oprf) {
			case 1:
				Limpar.Tela();
				MenuPrincipal.menurPrincipal();
				break;

			case 2:
				Limpar.Tela();
				MenuRelatorios.menuRelatorios();
				break;

			case 3:
				Limpar.Tela();
				CadastroAtendente.editarFuncionarioPorNome();
				break;

			case 4:
				Limpar.Tela();
				CadastroAtendente.excluirFuncionarioPorNome();
				break;

			default:
				MenuOpcoes.mensagemDeOpcaoErrada();
				MenuRelatorios.menuRelatorios();

				break;
			}

			break;
		// FIM DO CASE 3

		case 4: // mostrar os dados da Loja

			// INCIO DO CASE 4
			Limpar.Tela();

			int opdl = 0;

			CadastroLojaDados.mostrarDadosLoja();

			System.out.println("\n\nOp��es");
			System.out
					.println("1 Menu Principal\n2 Relat�rios\n3 Alterar Dados");
			System.out.print("Digite a op��o: ");
			opdl = digitar.nextInt();
			switch (opdl) {
			case 1:
				Limpar.Tela();
				MenuPrincipal.menurPrincipal();
				break;

			case 2:
				Limpar.Tela();
				MenuRelatorios.menuRelatorios();
				break;

			case 3:
				Limpar.Tela();
				CadastroLojaDados.alterarDadosLoja();
				break;

			default:
				MenuOpcoes.mensagemDeOpcaoErrada();
				MenuRelatorios.menuRelatorios();

				break;
			}

			break;
		// FIM DO CASE 4

		case 5: // mostrar resumo de todos os alugueis
			// INICIO CASE 5
			Limpar.Tela();

			int opRA = 0;// Op��o Resumo alugueis

			Locacao.mostrarListaAluguel();

			System.out.println("\n\nOp��es");
			System.out.println("1 Menu Principal\n2 Relat�rios");
			System.out.print("Digite a op��o: ");
			opRA = digitar.nextInt();

			switch (opRA) {
			case 1:
				Limpar.Tela();
				MenuPrincipal.menurPrincipal();
				break;

			case 2:
				Limpar.Tela();
				MenuRelatorios.menuRelatorios();
				break;

			default:
				MenuOpcoes.mensagemDeOpcaoErrada();
				MenuRelatorios.menuRelatorios();

				break;
			}

			break;

		// FIM CASE 5

		case 6: // mostrar resumo de todas as vendas
			// INICIO CASE 6 - VENDAS
			Limpar.Tela();

			int opRV = 0;// Op��o Resumo Vendas

			Venda.mostrarListaVendas();

			System.out.println("\n\nOp��es");
			System.out.println("1 Menu Principal\n2 Relat�rios");
			System.out.print("Digite a op��o: ");
			opRV = digitar.nextInt();

			switch (opRV) {
			case 1:
				Limpar.Tela();
				MenuPrincipal.menurPrincipal();
				break;

			case 2:
				Limpar.Tela();
				MenuRelatorios.menuRelatorios();
				break;

			default:
				MenuOpcoes.mensagemDeOpcaoErrada();
				MenuRelatorios.menuRelatorios();

				break;
			}

			break;

		// FIM CASE 6 - VENDAS

		case 7: // voltar > Menu Principal
			Limpar.Tela();
			MenuPrincipal.menurPrincipal();
			break;
		case 0: // sair
			MenuOpcoes.OpcaoSairDoSistema();
			break;

		default:
			MenuOpcoes.mensagemDeOpcaoErrada();
			MenuCadastros.menurCadastros();
			break;
		}

	}
}
