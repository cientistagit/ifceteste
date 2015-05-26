package controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import menus.MenuCadastrosCadastrar;
import menus.MenuPrincipal;
import modelo.Cliente;
import modelo.Limpar;
import modelo.Tecle;

public class CadastroCliente {

	static List<Cliente> listaCliente = new ArrayList<Cliente>();

	@SuppressWarnings("resource")
	public static void cadastrarCliente() {
		System.out.println("CADASTRAR CLIENTES\n");

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);

		Cliente cliente = new Cliente();

		// para Exibir a Mensagem somente uma vez.
		if (Cliente.getIdClienteGeral() < 1) {
			System.out.println("\nCADASTRO DE CLIENTES");
		}

		System.out.println("Cliente Nº: " + cliente.getIdCliente());

		System.out.print("Nome: ");
		cliente.setNome(digitars.nextLine());

		System.out.print("CPF.: ");
		cliente.setCpf(digitar.nextLong());

		System.out.print("Sexo: ");
		// fazer metodo para escolher entre masculino e feminino.

		cliente.setSexo(digitars.nextLine());

		System.out.print("Telefone: ");
		cliente.setTelefone(digitar.nextLong());

		System.out.print("Endereço: ");
		cliente.setEndereco(digitars.nextLine());

		System.out.print("Tipo de cliente: ");
		// Fazer uma metodo para escolher entre: "Padrão", "Venda", "Risco"
		cliente.setTipoCliente(digitars.nextLine());

		// adicona o objeto cliente, já preenchido na ArrayList listaCliente
		listaCliente.add(cliente);

		return;
	}

	public static void mostrarTodosClientesCadastrados() {

		System.out
				.println("==============================================================");
		System.out.println("                 LISTA DE CLIENTES CADASTRADOS");
		System.out
				.println("==============================================================\n");
		for (Cliente cliente : listaCliente) {
			System.out.println(" ID do Cliente: " + cliente.getIdCliente());
			System.out.println("          Nome: " + cliente.getNome());
			System.out.println("CPF do Cliente: " + cliente.getCpf());
			System.out.println("          Sexo: " + cliente.getSexo());
			System.out.println("      Telefone: " + cliente.getTelefone());
			System.out.println("      Endereço: " + cliente.getEndereco());
			System.out.println();

		}
		System.out.println("Total de Clientes Cadastrados: "
				+ listaCliente.size());
		System.out
				.println("==============================================================");
		System.out
				.println("                                                 FIM DA LISTA");
		System.out
				.println("==============================================================");
		return;
	}

	// METODO QUE FAZ A LOCALIZAÇÃO DO OBJETO - SEM RETORNO
	@SuppressWarnings("resource")
	public static void pesquisarClientePorNome() {

		// verificar se tem cliente cadastrado
		verificarClienteCadastrado();

		// MOSTRAR LISTA DE CLIENTES CADASTRADOS
		mostrarListaClientePorNome();

		Scanner digitar = new Scanner(System.in);

		String locNome;

		System.out.println("LOCALIZAR CLIENTE");
		System.out.print("Digite o nome do cliente:");
		locNome = digitar.nextLine();

		for (Cliente cliente : listaCliente) {

			if (cliente.getNome().equalsIgnoreCase(locNome)) {
				System.out.println("Cliente: " + cliente.getNome()
						+ " localizado.");
			}
		}
		System.out.println("Cliente " + locNome + " não localizado.");

		return;

	}

	@SuppressWarnings("resource")
	public static Cliente pesquisarClientePorNome1() {

		// verificar se tem cliente cadastrado
		verificarClienteCadastrado();

		// MOSTRAR LISTA DE CLIENTES CADASTRADOS
		mostrarListaClientePorNome();

		Scanner digitar = new Scanner(System.in);

		String locNome;
		/*
		 * usado para quando o nome cliente for digitado errado, ou quando ainda
		 * não estiver cadastrado - parte1
		 */
		boolean verificarCliente = false;

		System.out.println("LOCALIZAR CLIENTE");
		System.out.print("Digite o nome do cliente:");
		locNome = digitar.nextLine();

		for (Cliente cliente : listaCliente) {
			if (cliente.getNome().equalsIgnoreCase(locNome)) {
				System.out.println("Cliente: " + cliente.getNome()
						+ " localizado.");

				/*
				 * se o cliente for encontrado muda para verdadeiro, anulando a
				 * opção de localizar novamente - parte
				 */
				verificarCliente = true;

				return cliente;
			}
		}

		/*
		 * se por acaso o clinete não for localizado aparece esta opção
		 * informando e permitindo localizar novamente
		 */
		if (verificarCliente == false) {
			System.out.println("Cliente " + locNome + " não localizado.");
			System.out.println("Pesquise novamente.");
			Tecle.continuar();
			pesquisarClientePorNome1();
		}
		return pesquisarClientePorNome1();

	}

	/*
	 * METODO QUE FAZ A EDIÇÃO DO OBJETO 0. verificar se tem algum funcionario
	 * cadastrado antes // 1. localizar funcionario // 2. mostrar o funcionario
	 * localizado, se cadastrado // 3. perguntar se deseja realmente alterar os
	 * dados // 4. alterar os dados
	 */
	@SuppressWarnings({ "resource" })
	public static void editarClientePorNome() {
		// verificar se tem cliente cadastrado
		verificarClienteCadastrado();

		// MOSTRAR LISTA DE CLIENTES CADASTRADOS
		mostrarListaClientePorNome();

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);

		String nomeCliente = null;

		System.out.println("ALTERAR DADOS DE FUNCIONÁRIO");
		System.out.print("Digite um nome: ");

		nomeCliente = digitars.nextLine();

		/* serve para exibir a mensagem não localizado somente uma vez. */
		boolean teste = false;

		for (Cliente cliente : listaCliente) {
			if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
				System.out.println("Localizado:");
				System.out.println("Cliente: " + cliente.getNome() + "\n");

				/* se o objeto for localizado mudar para verdadeiro */
				teste = true;

				String opcao = null;
				System.out.println("\nDeseja alterar os dados?");
				System.out.println("Digite somente S para Sim ou N para Não");
				opcao = digitar.next();

				switch (opcao) {
				case "S":
				case "s":

					System.out.println("Nome atual: " + cliente.getNome());
					System.out.print("Nome: ");
					cliente.setNome(digitar.next());

					System.out.println("CPF atual: " + cliente.getCpf());
					System.out.print("CPF: ");
					cliente.setCpf(digitar.nextLong());

					System.out.println("Sexo atual: " + cliente.getSexo());
					System.out.print("Sexo: ");
					cliente.setSexo(digitar.next());

					System.out.println("Endereço atual: "
							+ cliente.getEndereco());
					System.out.print("Endereço: ");
					cliente.setEndereco(digitar.next());

					System.out.println("Telefone atual: "
							+ cliente.getTelefone());
					System.out.print("Telefone: ");
					cliente.setTelefone(digitar.nextLong());

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
		 * mostra esta mensagem somente se não for localizado, deve mostrar
		 * somente uma vez
		 */
		if (teste == false) {
			System.out.println("Não foi possível localizar....");
		}
		Tecle.continuar();
		return;

	}

	/*
	 * METODO PARA EXCLUIR CLIENTE // 0. verificar se tem funcionario já
	 * cadastrado // 1. localigar funcionado cadastrado // 2. mostrar o
	 * funcionario localizado, se cadastrado // 3. perguntar se deseja realmente
	 * excluir os dados // 4. excluir os dados
	 */
	@SuppressWarnings("resource")
	public static void excluirClientePorNome() {

		// verificar se tem cliente cadastrado
		verificarClienteCadastrado();

		// MOSTRAR LISTA DE CLIENTES CADASTRADOS
		mostrarListaClientePorNome();

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);

		String nomeClienteTemp2 = null;

		System.out.println("\nEXCLUIR CLIENTE\n");
		System.out.print("Digite o nome: ");
		nomeClienteTemp2 = digitars.nextLine();

		/* serve para exibir a mensagem não localizado somente uma vez. */
		boolean teste = false;

		for (int i = 0; i < listaCliente.size(); i++) {
			if (listaCliente.get(i).getNome()
					.equalsIgnoreCase(nomeClienteTemp2)) {

				System.out.println("Funcionário localizado:");
				System.out.println("Nome: " + listaCliente.get(i).getNome());
				System.out.println("Sexo: " + listaCliente.get(i).getSexo()
						+ "\n");

				/* se o objeto for localizado mudar para verdadeiro */
				teste = true;

				String opcao2 = null;

				System.out.println("\nDeseja realmente excluir o cliente?");
				System.out
						.print(" S para Sim ou outra tecla + ENTER para Não: ");

				opcao2 = digitar.nextLine();

				if (opcao2.equalsIgnoreCase("s")) {
					System.out.println("Cliente: "
							+ listaCliente.get(i).getNome() + " excluído.");
					listaCliente.remove(listaCliente.get(i));
					Tecle.continuar();

				} else {
					System.out.println("Cliente: "
							+ listaCliente.get(i).getNome()
							+ " não foi excluído.");
					Tecle.continuar();
				}

			}

		}
		/*
		 * mostra esta mensagem somente se não for localizado, deve mostrar
		 * somente uma vez
		 */
		if (teste == false) {
			System.out.println("Não foi possível localizar....");
			Tecle.continuar();
		}

		MenuPrincipal.menurPrincipal();
		return;

	}

	@SuppressWarnings("resource")
	public static void verificarClienteCadastrado() {

		// verifica se já tem cliente cadastrado
		if (listaCliente.isEmpty()) {
			Scanner digitar = new Scanner(System.in);
			System.out.println("Ainda não há clientes cadastrados.");
			System.out.println("Digite qualquer tecla + ENTER para continuar.");
			digitar.next();

			// ir para o menu Cadastro/Cadastrar
			Limpar.Tela();
			MenuCadastrosCadastrar.menuCadastrosCadastrar();
			return;
		}
	}

	@SuppressWarnings({ "resource" })
	public static void mostrarListaClientePorNome() {

		// verificar se tem cliente cadastrado
		verificarClienteCadastrado();

		Scanner digitars = new Scanner(System.in);

		String verClientes = null;

		System.out.println("Deseja ver lista de clientes?");
		System.out.print("Digite S para Sim ou outra tecla + ENTER para não: ");

		verClientes = digitars.nextLine();
		if (verClientes.equalsIgnoreCase("s")) {
			for (int i = 0; i < listaCliente.size(); i++) {
				System.out.println("Cliente: "
						+ listaCliente.get(i).getIdCliente() + " "
						+ listaCliente.get(i).getNome());

			}
			Tecle.continuar();
		}

		return;

	}

}