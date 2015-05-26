package controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import menus.MenuCadastrosCadastrar;
import menus.MenuMovimentos;
import menus.MenuPrincipal;
import modelo.Limpar;
import modelo.Midia;
import modelo.Tecle;

public class CadastroMidia {

	public static List<Midia> listaMidia = new ArrayList<Midia>();

	@SuppressWarnings("resource")
	public static void cadastrarMidia() {

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);

		Midia midia = new Midia();

		/*
		 * SERVE PARA RECEBER A MARGEM DE LUCRO
		 */
		if (Midia.getIdMidiaGeral() <= 1) {
			System.out
					.println("Obs.: quando for cadastrar as mídias, informe\na margem de lucro.");
			System.out.print("\n\nDigite a margem de lucro em porcentagem: ");
			int porcentagem = digitar.nextInt();
			Midia.setPorcentagemMargem(porcentagem);

		}

		System.out.println("\nCADASTRAR MÍDIA\n");
		System.out.println("Id Mídia: " + midia.getIdMidia());

		System.out.print("Título: ");
		midia.setTitulo(digitars.nextLine());

		System.out.print("Gênero: ");
		midia.setGenero(digitars.nextLine());

		System.out.print("Descrição: ");
		midia.setDescricao(digitars.nextLine());

		System.out.print("Valor de compra da mídia: ");
		midia.setValorUniMidia(digitar.nextDouble());

		midia.CalcularValorMidiaVenda(Midia.getPorcentagemMargem());

		System.out.print("Valor de Venda: ");
		System.out.println(midia.getValorUniMidiaVenda());

		System.out.print("Quantidade de mídia compradas: ");
		midia.setTotalMidias(digitar.nextDouble());

		// adicona o objeto Midia, já preenchido na ArrayList listaMidia
		listaMidia.add(midia);
		return;

	}

	public static void mostraTodasMidiasCadastradas() {

		System.out
				.println("==============================================================");
		System.out.println("                  LISTA DE MIDIAS CADASTRADAS");
		System.out
				.println("==============================================================\n");

		for (Midia midia : listaMidia) {
			System.out.println("            ID Mídia: " + midia.getIdMidia());
			System.out.println("              Título: " + midia.getTitulo());
			System.out.println("              Gênero: " + midia.getGenero());
			System.out.println("           Descrição: " + midia.getDescricao());
			System.out.println("      Valor de Venda: "
					+ midia.getValorUniMidiaVenda());
			System.out.println("Quantidade de mídias: "
					+ midia.getTotalMidias());

			System.out.println();
		}
		System.out.println("Total de Mídias Cadastradas: " + listaMidia.size());
		System.out
				.println("==============================================================");
		System.out
				.println("                                                FIM DA LISTA");
		System.out
				.println("==============================================================");

		return;
	}

	// //////+++++++++++++++++++++++++++////////////////////

	// METODO QUE FAZ A LOCALIZAÇÃO DO OJETO
	@SuppressWarnings("resource")
	public static void pesquisarMidiaPorNome() {

		// verifica sem já tem midia cadastrada
		verificarMidiaCadastrada();

		// MOSTRA LISTA DE MIDIAS CADASTRADAS PARA RAPIDA CONSULTA
		mostrarListaMidiaPorNome();

		Scanner digitar = new Scanner(System.in);

		String midiaNome = null;

		System.out.println("\nLOCALIZAR MÍDIA");
		System.out.print("Digite o título do filme: ");
		midiaNome = digitar.nextLine();

		for (Midia midia : listaMidia) {
			if (midia.getTitulo().equalsIgnoreCase(midiaNome)) {
				System.out.println("Mídia: " + midia.getTitulo()
						+ " localizada.");

			} else {
				System.out.println("Mídia " + midiaNome
						+ " não localizada.\nTentar novamente?");

			}
		}

		return;
	}

	/*USADO NO ALUGUEL DA MIDIA*/
	@SuppressWarnings("resource")
	public static Midia pesquisarMidiaPorNome1() {

		// verifica sem já tem midia cadastrada
		verificarMidiaCadastrada();

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);

		String midiaNome = null;

		/*
		 * usado para quando o titulo do filme for digitado errado, ou quando
		 * ainda não estiver cadastrado - parte1
		 */
		boolean verificarMidia = false;

		System.out.println("\nLOCALIZAR MÍDIA");
		System.out.print("Digite o título do filme: ");
		midiaNome = digitar.nextLine();

		for (int i = 0; i < listaMidia.size(); i++) {
			if (listaMidia.get(i).getTitulo().equalsIgnoreCase(midiaNome)) {
				System.out.println("Midia: " + listaMidia.get(i).getTitulo()
						+ " adicionada.");
				/*
				 * esta linha tira uma midia, do objeto, toda vez que ela for
				 * alocada/vendida, caso não tenha mais em "estoque" pede para
				 * adicionar
				 */
				if (listaMidia.get(i).getTotalMidias() > 0) {
					listaMidia.get(i).setTotalMidias(listaMidia.get(i).getTotalMidias() - 1);
				} else {
					System.out.println("Esta mídia está zerada");
					System.out.print("Adicione uma quantidade (comprada): ");
					listaMidia.get(i).setTotalMidias(digitars.nextDouble());
					listaMidia.get(i).setTotalMidias(listaMidia.get(i).getTotalMidias() - 1);
				}

				/*
				 * se o cliente for encontrado muda para verdadeiro, anulando a
				 * opção de localizar novamente - parte
				 */
				verificarMidia = true;

				return listaMidia.get(i);

			}

		}
		/*
		 * se por acaso o clinete não for localizado aparece esta opção
		 * informando e permitindo localizar novamente
		 */
		if (verificarMidia == false) {
			System.out.println("Mídia " + midiaNome + " não localizada.");
			System.out.println("Pesquise novamente.");
			Tecle.continuar();
			pesquisarMidiaPorNome1();
		}
		return pesquisarMidiaPorNome1();

	}

	/*USADO NA VENDA DA MIDIA, LOCALIZA, TRATA OS ERROS E ENTREGA A MIDIA PRONTA PARA A VENDA*/
	@SuppressWarnings("resource")
	public static Midia pesquisarMidiaPorNomeVenda() {

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);

		String midiaNome = null;

		/*
		 * usado para quando o titulo do filme for digitado errado, ou quando
		 * ainda não estiver cadastrado - parte1
		 */
		boolean verificarMidia = false; // parte 1

		System.out.println("\nLOCALIZAR MÍDIA");
		System.out.print("Digite o título do filme: ");
		midiaNome = digitar.nextLine();

		for (int i = 0; i < listaMidia.size(); i++) {
			if (listaMidia.get(i).getTitulo().equalsIgnoreCase(midiaNome)) {
				System.out.println("Mídia: " + listaMidia.get(i).getTitulo()
						+ " localizada.");

				/*
				 * esta linha tira uma midia, do objeto, toda vez que ela for
				 * alocada/vendida, caso não tenha mais em "estoque" pede para
				 * adicionar
				 */
				if (listaMidia.get(i).getTotalMidias() > 0) {

					/*
					 * VERIFICAÇÃO QTD VENDA MAIOR QUE DISPONIVEL EM ESTOQUE -
					 * INICIO deve ficar repetindo até a quantidade vendida for
					 * menor/igual a em estoque
					 */
					int verificaQTD = 0;
					do {

						
						if (verificaQTD > 0) {
							System.out.println("Repita a Operação.");
							System.out.println("Quantidade maior que a disponivel em estoque.");
							System.out.println("Estoque: "	+ listaMidia.get(i).getTotalMidias());
						}

						System.out.print("Digite a quantidade vendida: ");
						listaMidia.get(i).setQtd(digitar.nextDouble());

						verificaQTD++;
					} while (listaMidia.get(i).getTotalMidias() < listaMidia.get(i).getQtd());
					/*
					 * VERIFICAÇÃO QTD VENDA MAIOR QUE DISPONIVEL EM ESTOQUE -
					 * FIM
					 */

					/*
					 * só deve setar, se quantidade for menor/igual a disponivel
					 * em estoque
					 */
					listaMidia.get(i).setTotalMidias(listaMidia.get(i).getTotalMidias()	- listaMidia.get(i).getQtd());
					

				} else {
					System.out.println("Esta mídia está zerada/negativa");
					System.out.println("Estoque: "	+ listaMidia.get(i).getTotalMidias());
					System.out.print("Adicione uma quantidade (comprada): ");
					listaMidia.get(i).setTotalMidias(digitars.nextDouble());

					/*
					 * VERIFICAÇÃO QTD VENDA MAIOR QUE DISPONIVEL EM ESTOQUE -
					 * INICIO
					 */
					int verificaQTD = 0;
					do {

						
						if (verificaQTD > 0) {
							System.out.println("Repita a Operação.");
							System.out.println("Quantidade maior que a disponivel em estoque.");
							System.out.println("Estoque: "+ listaMidia.get(i).getTotalMidias());
						}

						System.out.print("Digite a quantidade vendida: ");
						listaMidia.get(i).setQtd(digitar.nextDouble());

						verificaQTD++;
					} while (listaMidia.get(i).getTotalMidias() < listaMidia.get(i).getQtd());
					/*
					 * VERIFICAÇÃO QTD VENDA MAIOR QUE DISPONIVEL EM ESTOQUE -
					 * FIM
					 */

					/*
					 * só deve setar, se quantidade for menor/igual a disponivel
					 * em estoque
					 */
					listaMidia.get(i).setTotalMidias(listaMidia.get(i).getTotalMidias()- listaMidia.get(i).getQtd());
				}

				/*
				 * se o cliente for encontrado muda para verdadeiro, anulando a
				 * opção de localizar novamente - parte 2
				 */
				verificarMidia = true; // parte 2

				return listaMidia.get(i);
			}

		}
		/*
		 * se por acaso o cliente não for localizado aparece esta opção
		 * informando e permitindo localizar novamente - parte 3
		 */
		if (verificarMidia == false)/* parte 3 */{
			System.out.println("Mídia " + midiaNome + " não localizada.");
			System.out.println("Pesquise novamente.");
			Tecle.continuar();
			pesquisarMidiaPorNomeVenda();
		}
		return pesquisarMidiaPorNomeVenda();

	}

	/*
	 * METODO QUE FAZ A EDIÇÃO DO OBJETO
	 */
	@SuppressWarnings({ "resource" })
	public static void editarMidiaPorNome() {

		// verifica se já tem midia cadastrada
		verificarMidiaCadastrada();

		// MOSTRA LISTA DE MIDIAS CADASTRADAS PARA RAPIDA CONSULTA
		mostrarListaMidiaPorNome();

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);

		String nomeMidia = null;

		System.out.println("ALTERAR DADOS DE MÍDIA");
		System.out.print("Digite um nome: ");

		nomeMidia = digitars.nextLine();

		boolean teste = false; // serve para exibir a mensagem não localizado
								// somente uma vez.

		for (int i = 0; i < listaMidia.size(); i++) {
			if (listaMidia.get(i).getTitulo().equalsIgnoreCase(nomeMidia)) {
				System.out.println("Localizado:");
				System.out.println("Midia: " + listaMidia.get(i).getTitulo()
						+ "\n");

				teste = true; // se o objeto for localizado mudar para
								// verdadeiro

				String opcao = null;
				System.out.println("\nDeseja alterar os dados?");
				System.out.println("Digite somente S para Sim ou N para Não");
				opcao = digitar.next();

				switch (opcao) {
				case "S":
				case "s":

					System.out.println("Título atual: "
							+ listaMidia.get(i).getTitulo());
					System.out.print("Novo título: ");
					listaMidia.get(i).setDescricao(digitars.nextLine());

					System.out.println("Gênero atual: "
							+ listaMidia.get(i).getGenero());
					System.out.print("Novo Gênero: ");
					listaMidia.get(i).setGenero(digitars.nextLine());

					System.out.println("Descrição Atual: "
							+ listaMidia.get(i).getDescricao());
					System.out.print("Nova descrição: ");
					listaMidia.get(i).setDescricao(digitars.nextLine());

					System.out.println("Valor atual de compra da mídia : "
							+ listaMidia.get(i).getValorUniMidia());
					System.out
							.print("Novo valor unitário de compra da mídia: ");
					listaMidia.get(i).setValorUniMidia(digitar.nextDouble());

					double porcentagem = 0;
					System.out
							.print("Digite a porcentagem da margem de lucro:");
					porcentagem = digitar.nextDouble();

					listaMidia.get(i).CalcularValorMidiaVenda(porcentagem);

					System.out.println("Valor de venda da mídia: "
							+ listaMidia.get(i).getValorUniMidiaVenda());

					System.out.println("Total de mídias: "
							+ listaMidia.get(i).getTotalMidias());
					System.out.print("Novo total de mídias: ");
					listaMidia.get(i).setTotalMidias(digitar.nextDouble());

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
		// mostra esta mensagem somente se não for localizado, deve mostrar
		// somente uma vez
		if (teste == false) {
			System.out.println("Não foi possível localizar....");
		}
		Tecle.continuar();

		return;
	}

	@SuppressWarnings("resource")
	public static void excluirMidiaPorNome() {

		// verifica se já tem midia cadastrada
		verificarMidiaCadastrada();

		// MOSTRA LISTA DE MIDIAS CADASTRADAS PARA RAPIDA CONSULTA
		mostrarListaMidiaPorNome();

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);

		String nomeMidiaTemp2 = null;

		System.out.println("\nEXCLUIR MÍDIA\n");
		System.out.print("Digite o nome: ");
		nomeMidiaTemp2 = digitars.nextLine();

		/* serve para exibir a mensagem não localizado somente uma vez. */
		boolean teste = false;

		for (int i = 0; i < listaMidia.size(); i++) {
			if (listaMidia.get(i).getTitulo().equalsIgnoreCase(nomeMidiaTemp2)) {
				System.out.println("Mídia localizada:");
				System.out.println("Nome: " + listaMidia.get(i).getTitulo());
				System.out.println("Gênero: " + listaMidia.get(i).getGenero()
						+ "\n");
				System.out.println("Descrição: "
						+ listaMidia.get(i).getDescricao());

				/* se o objeto for localizado mudar para verdadeiro */
				teste = true;

				String opcao2 = null;

				System.out.println("\nDeseja realmente excluir a mídia?");
				System.out
						.print(" S para Sim ou outra tecla + ENTER para Não: ");

				opcao2 = digitar.next();

				if (opcao2.equalsIgnoreCase("S")) {
					System.out.println("Mídia: "
							+ listaMidia.get(i).getTitulo() + " excluída.");
					listaMidia.remove(listaMidia.get(i));

				} else {
					System.out.println("Mídia: "
							+ listaMidia.get(i).getTitulo()
							+ " não foi excluída.");
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

		MenuPrincipal.menurPrincipal();
		return;

	}

	@SuppressWarnings("resource")
	public static void verificarMidiaCadastrada() {

		// verifica se já tem cliente cadastrado
		if (listaMidia.isEmpty()) {
			Scanner digitar = new Scanner(System.in);
			System.out.println("Ainda não há mídias cadastradas.");
			System.out.println("Digite qualquer tecla + ENTER para continuar.");
			digitar.next();

			// ir para o menu Cadastro/Cadastrar
			Limpar.Tela();
			MenuCadastrosCadastrar.menuCadastrosCadastrar();
			return;
		}
	}

	/*
	 * este metodo serve para dar baixa nas midias alugadas, ou seja, a midia
	 * entra novamente no estoque da loja
	 */
	@SuppressWarnings({ "resource", "unused" })
	public static void darBaixaMidiaPorNome() {

		// verifica se já tem midia cadastrada
		verificarMidiaCadastrada();

		// MOSTRA LISTA DE MIDIAS CADASTRADAS PARA RAPIDA CONSULTA
		mostrarListaMidiaPorNome();

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);

		String midiaNome = null;

		System.out.println("\nBAIXA MÍDIA");
		System.out.print("Digite o título do filme: ");
		midiaNome = digitar.nextLine();

		/*
		 * usado para quando a midia for digitada errada, ou quando ainda não
		 * estiver cadastrada - parte1
		 */
		boolean verificarMidia = false;

		for (int i = 0; i < listaMidia.size(); i++) {
			if (listaMidia.get(i).getTitulo().equalsIgnoreCase(midiaNome)) {
				System.out.println("Mídia: " + listaMidia.get(i).getTitulo()
						+ " localizada.");

				/*
				 * se a midia for encontrada muda para verdadeiro, anulando a
				 * opção de localizar novamente - parte
				 */
				verificarMidia = true;

				String opmidia = null;
				System.out.println("Deseja dar baixa na mídia?");
				System.out
						.print("S para Sim ou outra tecla + ENTER para Não: ");
				opmidia = digitar.nextLine();
				if (opmidia.equalsIgnoreCase("s")) {
					listaMidia.get(i).setTotalMidias(
							listaMidia.get(i).getTotalMidias() + 1);

					System.out
							.println("Dado baixa(adicionado + 1 à lista no estoque): "
									+ listaMidia.get(i).getTitulo());
				}

			}

		}

		/*
		 * se por acaso a midia não for localizada aparece esta opção informando
		 * e permitindo localizar novamente
		 */
		if (verificarMidia == false) {
			System.out.println("Não foi dado baixa na mídia: " + midiaNome);
			System.out.println("Pesquise novamente.");
			Tecle.continuar();
			darBaixaMidiaPorNome();
		}
		Tecle.continuar();
		Limpar.Tela();
		MenuMovimentos.menuMovimentos();
		return;

	}

	@SuppressWarnings({ "resource", "unused" })
	public static void EntradaEstoqueMidiaPorNome() {
		// verifica se já tem midia cadastrada
		verificarMidiaCadastrada();

		// verifica se já tem midia cadastrada
		verificarMidiaCadastrada();

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);

		String midiaNome = null;

		System.out.println("\nENTRADA MÍDIA ESTOQUE");
		System.out.print("Digite o título do filme: ");
		midiaNome = digitar.nextLine();

		/*
		 * usado para quando a midia for digitada errada, ou quando ainda não
		 * estiver cadastrada - parte1
		 */
		boolean verificarMidia = false;

		for (int i = 0; i < listaMidia.size(); i++) {
			if (listaMidia.get(i).getTitulo().equalsIgnoreCase(midiaNome)) {
				System.out.println("Mídia: " + listaMidia.get(i).getTitulo()
						+ " localizada.\n");
				System.out.println("Total em Estoque: "
						+ listaMidia.get(i).getTotalMidias() + "\n");

				/*
				 * se a midia for encontrada muda para verdadeiro, anulando a
				 * opção de localizar novamente - parte
				 */
				verificarMidia = true;

				String opmidia = null;
				System.out.println("Deseja dar ENTRADA na mídia?");
				System.out
						.print("S para Sim ou outra tecla + ENTER para Não: ");
				opmidia = digitar.nextLine();
				if (opmidia.equalsIgnoreCase("s")) {
					int qtdEntradaMiida = 0;
					System.out.print("Digite a quantidade comprada: ");
					qtdEntradaMiida = digitar.nextInt();
					listaMidia.get(i).setTotalMidias(
							listaMidia.get(i).getTotalMidias()
									+ qtdEntradaMiida);

					System.out.println("\nDado entrada na mídia: "
							+ listaMidia.get(i).getTitulo());
					System.out.println("\nTotal em estoque atual: "
							+ listaMidia.get(i).getTotalMidias());
				}

			}

		}

		/*
		 * se por acaso a midia não for localizada aparece esta opção informando
		 * e permitindo localizar novamente
		 */
		if (verificarMidia == false) {
			System.out.println("Não foi localizada a mídia: " + midiaNome);
			System.out.println("Pesquise novamente.");
			Tecle.continuar();
			EntradaEstoqueMidiaPorNome();
		}
		Tecle.continuar();
		Limpar.Tela();
		MenuMovimentos.menuMovimentos();
		return;

	}

	@SuppressWarnings({ "resource" })
	public static void mostrarListaMidiaPorNome() {

		// verificar se tem midia cadastrada
		verificarMidiaCadastrada();

		Scanner digitars = new Scanner(System.in);

		String verClientes = null;

		System.out.println("Deseja ver lista de mídias cadastradas?");
		System.out.print("Digite S para Sim ou outra tecla + ENTER para não: ");

		verClientes = digitars.nextLine();
		if (verClientes.equalsIgnoreCase("s")) {
			for (int i = 0; i < listaMidia.size(); i++) {
				System.out.println("Cliente: " + listaMidia.get(i).getIdMidia()
						+ " " + listaMidia.get(i).getTitulo());

			}
			Tecle.continuar();
		}

		return;

	}

}
