package controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import menus.MenuCadastrosCadastrar;
import menus.MenuPrincipal;
import modelo.Atendente;
import modelo.Limpar;
import modelo.Tecle;

public class CadastroAtendente {

	static List<Atendente> listaFuncionario = new ArrayList<Atendente>();

	@SuppressWarnings("resource")
	public static void cadastrarAtendente() {

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);

		Atendente funcionario = new Atendente();

		System.out.println("CADASTRAR FUNCION�RIO\n");

		System.out.println("Funcioanrio N�.: " + funcionario.getIdAtendente());

		System.out.print("Nome: ");
		funcionario.setNome(digitars.nextLine());

		System.out.print("CPF.: ");
		funcionario.setCpf(digitar.nextLong());

		System.out.print("Sexo: ");
		funcionario.setSexo(digitars.nextLine());

		System.out.print("Telefone: ");
		funcionario.setTelefone(digitar.nextLong());

		System.out.print("Endere�o: ");
		funcionario.setEndereco(digitars.nextLine());

		System.out.print("Fun��o: ");
		funcionario.setFuncao(digitars.nextLine());

		listaFuncionario.add(funcionario);

		return;

	}

	// METODO PARA EXIBIR OS FUNCIONARIOS CADASTRADOS
	public static void mostrarTodosFuncionariosCadastrados() {

		System.out
				.println("==============================================================");
		System.out.println("          LISTA DE FUNCION�RIOS CADASTRADOS");
		System.out
				.println("==============================================================\n");

		for (Atendente atendente : listaFuncionario) {
			System.out
					.println("  ID  Funcion�rio: " + atendente.getIdAtendente());
			System.out.println("           Nome: " + atendente.getNome());
			System.out.println("         Func�o: " + atendente.getFuncao());
			System.out.println("CPF funcion�rio: " + atendente.getCpf());
			System.out.println("           Sexo: " + atendente.getSexo());
			System.out.println("       Telefone: " + atendente.getTelefone());
			System.out.println("       Endere�o: " + atendente.getEndereco());
			System.out.println();
		}
		System.out.println("Total de Funcion�rios Cadastrados: "
				+ listaFuncionario.size());
		System.out
				.println("==============================================================");
		System.out
				.println("                                                 FIM DA LISTA");
		System.out
				.println("==============================================================");
		return;
	}

	// METODO QUE FAZ A LOCALIZA��O DO OJETO
	@SuppressWarnings("resource")
	public static Atendente pesquisarFuncionarioID() {

		// verifica se j� tem funcionario cadastrado
		verificarFuncionarioCadastrado();

		// Exibi lista de funcionarios j� cadastrados.
		mostrarListaFuncionarioPorNome();

		Scanner digitar = new Scanner(System.in);

		int idAtendente;

		System.out.println("Localizar funcion�rio.");
		System.out.print("Digite a ID do funcion�rio: ");

		idAtendente = digitar.nextInt();

		/*
		 * usado para quando a ID do funcionario for digitado errado, ou quando
		 * ainda n�o estiver cadastrado - parte1
		 */
		boolean verificarFuncionario = false;

		for (Atendente funcionario : listaFuncionario) {

			if (funcionario.getIdAtendente() == idAtendente) {

				System.out.println("Funcion�rio: " + funcionario.getNome());

				/*
				 * se a ID do funcionario for encontrada muda para verdadeiro,
				 * anulando a op��o de localizar novamente - parte
				 */
				verificarFuncionario = true;

				return funcionario;
			}
		}
		/*
		 * se por acaso o funcionario n�o for localizado aparece esta op��o
		 * informando e permitindo localizar novamente
		 */
		if (verificarFuncionario == false) {
			System.out.println("N�o foi localizado funcion�rio com a ID: "
					+ idAtendente);
			System.out.println("Pesquise novamente.");
			Tecle.continuar();
			pesquisarFuncionarioID();
		}
		return pesquisarFuncionarioID();

	}

	/*
	 * METODO QUE FAZ A EDI��O DO OBJETO // 0. verificar se tem algum
	 * funcionario cadastrado antes // 1. localizar funcionario // 2. mostrar o
	 * funcionario localizado, se cadastrado // 3. perguntar se deseja realmente
	 * alterar os dados // 4. alterar os dados
	 */
	@SuppressWarnings("resource")
	public static void editarFuncionarioPorNome() {

		// verifica se j� tem funcionario cadastrado
		verificarFuncionarioCadastrado();

		// Exibi lista de funcionarios j� cadastrados.
		mostrarListaFuncionarioPorNome();

		Scanner digitar = new Scanner(System.in);

		String nome = null;

		System.out.println("ALTERAR DADOS DE FUNCION�RIO");
		System.out.print("Digite o nome: ");
		nome = digitar.nextLine();

		/* serve para exibir a mensagem n�o localizado somente uma vez. */
		boolean teste = false;

		for (Atendente funcionario : listaFuncionario) {

			Scanner d1 = new Scanner(System.in);
			Scanner d1s = new Scanner(System.in);

			if (funcionario.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Localizado:");
				System.out
						.print("Funcion�rio: " + funcionario.getNome() + "\n");

				/* se o objeto for localizado mudar para verdadeiro */
				teste = true;

				String opcao = null;
				System.out.println("Deseja alterar os dados?");
				System.out.println("Digite somente S para Sim ou N para N�o");
				opcao = d1.next();

				switch (opcao) {
				case "S":
				case "s":

					System.out.println("Nome atual: " + funcionario.getNome());
					System.out.print("Nome: ");
					funcionario.setNome(d1s.nextLine());

					System.out.println("CPF Atual: " + funcionario.getCpf());
					System.out.print("CPF: ");
					funcionario.setCpf(d1.nextLong());

					System.out.println("Sexo atual: " + funcionario.getSexo());
					System.out.print("Sexo: ");
					funcionario.setSexo(d1s.nextLine());

					System.out.println("Fun��o atual: " + funcionario.getCpf());
					System.out.print("Fun��o: ");
					funcionario.setFuncao(d1s.nextLine());

					System.out.println("Endere�o atual: "
							+ funcionario.getEndereco());
					System.out.print("Endere�o: ");
					funcionario.setEndereco(d1s.nextLine());

					System.out.println("Telefone atual: "
							+ funcionario.getTelefone());
					System.out.print("Telefone: ");
					funcionario.setTelefone(d1.nextLong());

					break;

				case "N":
				case "n":
					MenuPrincipal.menurPrincipal();
					break;

				default:
					MenuPrincipal.menurPrincipal();

					break;
				}

			}

		}

		/*
		 * mostra esta mensagem somente se n�o for localizado, deve mostrar
		 * somente uma vez
		 */
		if (teste == false) {
			System.out.println("N�o foi poss�vel localizar....");
		}
		Tecle.continuar();

		MenuPrincipal.menurPrincipal();
		return;
	}

	/*
	 * METODO PARA EXCLUIR FUNCIONARIO // 0. verificar se tem funcionario j�
	 * cadastrado // 1. localigar funcionado cadastrado // 2. mostrar o
	 * funcionario localizado, se cadastrado // 3. perguntar se deseja realmente
	 * excluir os dados // 4. excluir os dados
	 */
	@SuppressWarnings("resource")
	public static void excluirFuncionarioPorNome() {

		// verifica se j� tem funcionario cadastrado
		verificarFuncionarioCadastrado();

		// Exibi lista de funcionarios j� cadastrados.
		mostrarListaFuncionarioPorNome();

		Scanner dExcluirs = new Scanner(System.in);

		String nome = null;

		System.out.println("\nEXCLUIR FUNCION�RIO\n");
		System.out.print("Digite o nome: ");
		nome = dExcluirs.nextLine();

		/* serve para exibir a mensagem n�o localizado somente uma vez. */
		boolean teste = false;

		for (int i = 0; i < listaFuncionario.size(); i++) {
			if (listaFuncionario.get(i).getNome().equalsIgnoreCase(nome)) {
				System.out.println("Funcion�rio localizado:");
				System.out
						.println("Nome: " + listaFuncionario.get(i).getNome());
				System.out.println("Fun��o: "
						+ listaFuncionario.get(i).getFuncao() + "\n");

				/* se o objeto for localizado mudar para verdadeiro */
				teste = true;

				String opcao = null;

				System.out.println("\nDeseja realmente excluir o funcion�rio?");
				System.out
						.print(" S para Sim ou outra tecla + ENTER para N�o: ");

				opcao = dExcluirs.nextLine();

				if (opcao.equalsIgnoreCase("s")) {
					System.out.println("Funcion�rio(a): "
							+ listaFuncionario.get(i).getNome()
							+ " exclu�do(a).");
					listaFuncionario.remove(listaFuncionario.get(i));

				} else {
					System.out.println("Funcion�rio(a): "
							+ listaFuncionario.get(i).getNome()
							+ " n�o foi exclu�do(a).");
				}

			}

		}

		/*
		 * mostra esta mensagem somente se n�o for localizado, deve mostrar
		 * somente uma vez
		 */
		if (teste == false) {
			System.out.println("N�o foi poss�vel localizar....");
		}
		Tecle.continuar();

		MenuPrincipal.menurPrincipal();
		return;

	}

	@SuppressWarnings("resource")
	public static void verificarFuncionarioCadastrado() {

		// verifica se j� tem funcion�rio cadastrado
		if (listaFuncionario.isEmpty()) {
			Scanner digitar = new Scanner(System.in);
			System.out.println("Ainda n�o h� funcion�rios cadastrados.");
			System.out.println("Digite qualquer tecla + ENTER para continuar.");
			digitar.next();

			// ir para o menu Cadastro/Cadastrar
			Limpar.Tela();
			MenuCadastrosCadastrar.menuCadastrosCadastrar();
			return;
		}
	}

	@SuppressWarnings({ "resource" })
	public static void mostrarListaFuncionarioPorNome() {

		// verificar se tem cliente cadastrado
		verificarFuncionarioCadastrado();

		Scanner digitars = new Scanner(System.in);

		String verClientes = null;

		System.out.println("Deseja ver lista de funcion�rios?");
		System.out.print("Digite S para Sim ou outra tecla + ENTER para n�o: ");

		verClientes = digitars.nextLine();
		if (verClientes.equalsIgnoreCase("s")) {
			for (int i = 0; i < listaFuncionario.size(); i++) {
				System.out.println("Cliente: "
						+ listaFuncionario.get(i).getIdAtendente() + " "
						+ listaFuncionario.get(i).getNome());

			}
			Tecle.continuar();
		}

		return;

	}

}// chave final