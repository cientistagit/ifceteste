package menus;

import java.util.Scanner;

import controle.CadastroAtendente;
import controle.CadastroCliente;
import controle.CadastroMidia;
import modelo.Limpar;

public class MenuCadastrosExcluir {
	private static int opcao;

	public static void menuCadastrosExcluir() {

		MenuOpcoes.mensagemCadastrosExcluirLocal();
		MenuOpcoes.mensagemOpcoes();
		MenuOpcoes.mensagemMenuCadastrosExcluirOpcoes();

		@SuppressWarnings("resource")
		Scanner digitar = new Scanner(System.in);

		MenuOpcoes.mensagemDigiteOpcao();
		opcao = digitar.nextInt();

		switch (opcao) {
		case 1: // clientes
			//incio case 1
			Limpar.Tela();

			String opce = null;
			Scanner df = new Scanner(System.in);
			do {
				CadastroCliente.excluirClientePorNome();

				System.out.println("\nDeseja excluir/localizar outro cliente?");
				System.out
						.print(" S para Sim ou outra tecla + ENTER para N�o: ");
				opce = df.next();

			} while (opce.equalsIgnoreCase("S"));

			Limpar.Tela();

			MenuCadastrosExcluir.menuCadastrosExcluir();

			break;
			//fim case 1
		case 2: // tarifas
			//INCIO CASE 2
			System.out
					.println("Tarifas\nSer� incrementado numa classe � parte");
			break;
		case 3: // midias

			Limpar.Tela();

			String opem = null;
			Scanner dem = new Scanner(System.in);
			do {
				CadastroMidia.excluirMidiaPorNome();

				System.out.println("\nDeseja excluir/localizar outra m�dia?");
				System.out
						.print(" S para Sim ou outra tecla + ENTER para N�o: ");
				opem = dem.nextLine();

			} while (opem.equalsIgnoreCase("s"));

			Limpar.Tela();

			MenuCadastrosExcluir.menuCadastrosExcluir();
			
			break;
			
			//FIM CASE 2

		case 4: // funcionarios
			//INICIO CASE 4

			Limpar.Tela();

			String opa = null;
			Scanner df1 = new Scanner(System.in);
			do {
				CadastroAtendente.excluirFuncionarioPorNome();

				System.out
						.println("\nDeseja excluir/localizar outro funcion�rio?");
				System.out
						.print("S para Sim ou outra tecla + ENTER para N�o: ");
				opa = df1.next();

			} while (opa.equalsIgnoreCase("S"));

			Limpar.Tela();

			MenuCadastrosExcluir.menuCadastrosExcluir();
			;

			break;
			
			//FIM CASE 4

		case 6: // voltar
			
			// INICIO CASE 6
			
			Limpar.Tela();
			MenuCadastros.menurCadastros();
			break;
			
			//FIM CASE 6

		case 7: // menu principal
			//INCIO CASE 7
			MenuOpcoes.voltarMenuPrincipal();

			//FIM CASE 7
		case 0: // sair
			//INICIO CASE 0
			MenuOpcoes.OpcaoSairDoSistema();
			break;
			//FIM CASE 00
			

		default:
			MenuOpcoes.mensagemDeOpcaoErrada();
			MenuCadastrosExcluir.menuCadastrosExcluir();
			break;
		}

	}

}