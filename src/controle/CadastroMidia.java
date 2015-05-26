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
					.println("Obs.: quando for cadastrar as m�dias, informe\na margem de lucro.");
			System.out.print("\n\nDigite a margem de lucro em porcentagem: ");
			int porcentagem = digitar.nextInt();
			Midia.setPorcentagemMargem(porcentagem);

		}

		System.out.println("\nCADASTRAR M�DIA\n");
		System.out.println("Id M�dia: " + midia.getIdMidia());

		System.out.print("T�tulo: ");
		midia.setTitulo(digitars.nextLine());

		System.out.print("G�nero: ");
		midia.setGenero(digitars.nextLine());

		System.out.print("Descri��o: ");
		midia.setDescricao(digitars.nextLine());

		System.out.print("Valor de compra da m�dia: ");
		midia.setValorUniMidia(digitar.nextDouble());

		midia.CalcularValorMidiaVenda(Midia.getPorcentagemMargem());

		System.out.print("Valor de Venda: ");
		System.out.println(midia.getValorUniMidiaVenda());

		System.out.print("Quantidade de m�dia compradas: ");
		midia.setTotalMidias(digitar.nextDouble());

		// adicona o objeto Midia, j� preenchido na ArrayList listaMidia
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
			System.out.println("            ID M�dia: " + midia.getIdMidia());
			System.out.println("              T�tulo: " + midia.getTitulo());
			System.out.println("              G�nero: " + midia.getGenero());
			System.out.println("           Descri��o: " + midia.getDescricao());
			System.out.println("      Valor de Venda: "
					+ midia.getValorUniMidiaVenda());
			System.out.println("Quantidade de m�dias: "
					+ midia.getTotalMidias());

			System.out.println();
		}
		System.out.println("Total de M�dias Cadastradas: " + listaMidia.size());
		System.out
				.println("==============================================================");
		System.out
				.println("                                                FIM DA LISTA");
		System.out
				.println("==============================================================");

		return;
	}

	// //////+++++++++++++++++++++++++++////////////////////

	// METODO QUE FAZ A LOCALIZA��O DO OJETO
	@SuppressWarnings("resource")
	public static void pesquisarMidiaPorNome() {

		// verifica sem j� tem midia cadastrada
		verificarMidiaCadastrada();

		// MOSTRA LISTA DE MIDIAS CADASTRADAS PARA RAPIDA CONSULTA
		mostrarListaMidiaPorNome();

		Scanner digitar = new Scanner(System.in);

		String midiaNome = null;

		System.out.println("\nLOCALIZAR M�DIA");
		System.out.print("Digite o t�tulo do filme: ");
		midiaNome = digitar.nextLine();

		for (Midia midia : listaMidia) {
			if (midia.getTitulo().equalsIgnoreCase(midiaNome)) {
				System.out.println("M�dia: " + midia.getTitulo()
						+ " localizada.");

			} else {
				System.out.println("M�dia " + midiaNome
						+ " n�o localizada.\nTentar novamente?");

			}
		}

		return;
	}

	/*USADO NO ALUGUEL DA MIDIA*/
	@SuppressWarnings("resource")
	public static Midia pesquisarMidiaPorNome1() {

		// verifica sem j� tem midia cadastrada
		verificarMidiaCadastrada();

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);

		String midiaNome = null;

		/*
		 * usado para quando o titulo do filme for digitado errado, ou quando
		 * ainda n�o estiver cadastrado - parte1
		 */
		boolean verificarMidia = false;

		System.out.println("\nLOCALIZAR M�DIA");
		System.out.print("Digite o t�tulo do filme: ");
		midiaNome = digitar.nextLine();

		for (int i = 0; i < listaMidia.size(); i++) {
			if (listaMidia.get(i).getTitulo().equalsIgnoreCase(midiaNome)) {
				System.out.println("Midia: " + listaMidia.get(i).getTitulo()
						+ " adicionada.");
				/*
				 * esta linha tira uma midia, do objeto, toda vez que ela for
				 * alocada/vendida, caso n�o tenha mais em "estoque" pede para
				 * adicionar
				 */
				if (listaMidia.get(i).getTotalMidias() > 0) {
					listaMidia.get(i).setTotalMidias(listaMidia.get(i).getTotalMidias() - 1);
				} else {
					System.out.println("Esta m�dia est� zerada");
					System.out.print("Adicione uma quantidade (comprada): ");
					listaMidia.get(i).setTotalMidias(digitars.nextDouble());
					listaMidia.get(i).setTotalMidias(listaMidia.get(i).getTotalMidias() - 1);
				}

				/*
				 * se o cliente for encontrado muda para verdadeiro, anulando a
				 * op��o de localizar novamente - parte
				 */
				verificarMidia = true;

				return listaMidia.get(i);

			}

		}
		/*
		 * se por acaso o clinete n�o for localizado aparece esta op��o
		 * informando e permitindo localizar novamente
		 */
		if (verificarMidia == false) {
			System.out.println("M�dia " + midiaNome + " n�o localizada.");
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
		 * ainda n�o estiver cadastrado - parte1
		 */
		boolean verificarMidia = false; // parte 1

		System.out.println("\nLOCALIZAR M�DIA");
		System.out.print("Digite o t�tulo do filme: ");
		midiaNome = digitar.nextLine();

		for (int i = 0; i < listaMidia.size(); i++) {
			if (listaMidia.get(i).getTitulo().equalsIgnoreCase(midiaNome)) {
				System.out.println("M�dia: " + listaMidia.get(i).getTitulo()
						+ " localizada.");

				/*
				 * esta linha tira uma midia, do objeto, toda vez que ela for
				 * alocada/vendida, caso n�o tenha mais em "estoque" pede para
				 * adicionar
				 */
				if (listaMidia.get(i).getTotalMidias() > 0) {

					/*
					 * VERIFICA��O QTD VENDA MAIOR QUE DISPONIVEL EM ESTOQUE -
					 * INICIO deve ficar repetindo at� a quantidade vendida for
					 * menor/igual a em estoque
					 */
					int verificaQTD = 0;
					do {

						
						if (verificaQTD > 0) {
							System.out.println("Repita a Opera��o.");
							System.out.println("Quantidade maior que a disponivel em estoque.");
							System.out.println("Estoque: "	+ listaMidia.get(i).getTotalMidias());
						}

						System.out.print("Digite a quantidade vendida: ");
						listaMidia.get(i).setQtd(digitar.nextDouble());

						verificaQTD++;
					} while (listaMidia.get(i).getTotalMidias() < listaMidia.get(i).getQtd());
					/*
					 * VERIFICA��O QTD VENDA MAIOR QUE DISPONIVEL EM ESTOQUE -
					 * FIM
					 */

					/*
					 * s� deve setar, se quantidade for menor/igual a disponivel
					 * em estoque
					 */
					listaMidia.get(i).setTotalMidias(listaMidia.get(i).getTotalMidias()	- listaMidia.get(i).getQtd());
					

				} else {
					System.out.println("Esta m�dia est� zerada/negativa");
					System.out.println("Estoque: "	+ listaMidia.get(i).getTotalMidias());
					System.out.print("Adicione uma quantidade (comprada): ");
					listaMidia.get(i).setTotalMidias(digitars.nextDouble());

					/*
					 * VERIFICA��O QTD VENDA MAIOR QUE DISPONIVEL EM ESTOQUE -
					 * INICIO
					 */
					int verificaQTD = 0;
					do {

						
						if (verificaQTD > 0) {
							System.out.println("Repita a Opera��o.");
							System.out.println("Quantidade maior que a disponivel em estoque.");
							System.out.println("Estoque: "+ listaMidia.get(i).getTotalMidias());
						}

						System.out.print("Digite a quantidade vendida: ");
						listaMidia.get(i).setQtd(digitar.nextDouble());

						verificaQTD++;
					} while (listaMidia.get(i).getTotalMidias() < listaMidia.get(i).getQtd());
					/*
					 * VERIFICA��O QTD VENDA MAIOR QUE DISPONIVEL EM ESTOQUE -
					 * FIM
					 */

					/*
					 * s� deve setar, se quantidade for menor/igual a disponivel
					 * em estoque
					 */
					listaMidia.get(i).setTotalMidias(listaMidia.get(i).getTotalMidias()- listaMidia.get(i).getQtd());
				}

				/*
				 * se o cliente for encontrado muda para verdadeiro, anulando a
				 * op��o de localizar novamente - parte 2
				 */
				verificarMidia = true; // parte 2

				return listaMidia.get(i);
			}

		}
		/*
		 * se por acaso o cliente n�o for localizado aparece esta op��o
		 * informando e permitindo localizar novamente - parte 3
		 */
		if (verificarMidia == false)/* parte 3 */{
			System.out.println("M�dia " + midiaNome + " n�o localizada.");
			System.out.println("Pesquise novamente.");
			Tecle.continuar();
			pesquisarMidiaPorNomeVenda();
		}
		return pesquisarMidiaPorNomeVenda();

	}

	/*
	 * METODO QUE FAZ A EDI��O DO OBJETO
	 */
	@SuppressWarnings({ "resource" })
	public static void editarMidiaPorNome() {

		// verifica se j� tem midia cadastrada
		verificarMidiaCadastrada();

		// MOSTRA LISTA DE MIDIAS CADASTRADAS PARA RAPIDA CONSULTA
		mostrarListaMidiaPorNome();

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);

		String nomeMidia = null;

		System.out.println("ALTERAR DADOS DE M�DIA");
		System.out.print("Digite um nome: ");

		nomeMidia = digitars.nextLine();

		boolean teste = false; // serve para exibir a mensagem n�o localizado
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
				System.out.println("Digite somente S para Sim ou N para N�o");
				opcao = digitar.next();

				switch (opcao) {
				case "S":
				case "s":

					System.out.println("T�tulo atual: "
							+ listaMidia.get(i).getTitulo());
					System.out.print("Novo t�tulo: ");
					listaMidia.get(i).setDescricao(digitars.nextLine());

					System.out.println("G�nero atual: "
							+ listaMidia.get(i).getGenero());
					System.out.print("Novo G�nero: ");
					listaMidia.get(i).setGenero(digitars.nextLine());

					System.out.println("Descri��o Atual: "
							+ listaMidia.get(i).getDescricao());
					System.out.print("Nova descri��o: ");
					listaMidia.get(i).setDescricao(digitars.nextLine());

					System.out.println("Valor atual de compra da m�dia : "
							+ listaMidia.get(i).getValorUniMidia());
					System.out
							.print("Novo valor unit�rio de compra da m�dia: ");
					listaMidia.get(i).setValorUniMidia(digitar.nextDouble());

					double porcentagem = 0;
					System.out
							.print("Digite a porcentagem da margem de lucro:");
					porcentagem = digitar.nextDouble();

					listaMidia.get(i).CalcularValorMidiaVenda(porcentagem);

					System.out.println("Valor de venda da m�dia: "
							+ listaMidia.get(i).getValorUniMidiaVenda());

					System.out.println("Total de m�dias: "
							+ listaMidia.get(i).getTotalMidias());
					System.out.print("Novo total de m�dias: ");
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
		// mostra esta mensagem somente se n�o for localizado, deve mostrar
		// somente uma vez
		if (teste == false) {
			System.out.println("N�o foi poss�vel localizar....");
		}
		Tecle.continuar();

		return;
	}

	@SuppressWarnings("resource")
	public static void excluirMidiaPorNome() {

		// verifica se j� tem midia cadastrada
		verificarMidiaCadastrada();

		// MOSTRA LISTA DE MIDIAS CADASTRADAS PARA RAPIDA CONSULTA
		mostrarListaMidiaPorNome();

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);

		String nomeMidiaTemp2 = null;

		System.out.println("\nEXCLUIR M�DIA\n");
		System.out.print("Digite o nome: ");
		nomeMidiaTemp2 = digitars.nextLine();

		/* serve para exibir a mensagem n�o localizado somente uma vez. */
		boolean teste = false;

		for (int i = 0; i < listaMidia.size(); i++) {
			if (listaMidia.get(i).getTitulo().equalsIgnoreCase(nomeMidiaTemp2)) {
				System.out.println("M�dia localizada:");
				System.out.println("Nome: " + listaMidia.get(i).getTitulo());
				System.out.println("G�nero: " + listaMidia.get(i).getGenero()
						+ "\n");
				System.out.println("Descri��o: "
						+ listaMidia.get(i).getDescricao());

				/* se o objeto for localizado mudar para verdadeiro */
				teste = true;

				String opcao2 = null;

				System.out.println("\nDeseja realmente excluir a m�dia?");
				System.out
						.print(" S para Sim ou outra tecla + ENTER para N�o: ");

				opcao2 = digitar.next();

				if (opcao2.equalsIgnoreCase("S")) {
					System.out.println("M�dia: "
							+ listaMidia.get(i).getTitulo() + " exclu�da.");
					listaMidia.remove(listaMidia.get(i));

				} else {
					System.out.println("M�dia: "
							+ listaMidia.get(i).getTitulo()
							+ " n�o foi exclu�da.");
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
	public static void verificarMidiaCadastrada() {

		// verifica se j� tem cliente cadastrado
		if (listaMidia.isEmpty()) {
			Scanner digitar = new Scanner(System.in);
			System.out.println("Ainda n�o h� m�dias cadastradas.");
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

		// verifica se j� tem midia cadastrada
		verificarMidiaCadastrada();

		// MOSTRA LISTA DE MIDIAS CADASTRADAS PARA RAPIDA CONSULTA
		mostrarListaMidiaPorNome();

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);

		String midiaNome = null;

		System.out.println("\nBAIXA M�DIA");
		System.out.print("Digite o t�tulo do filme: ");
		midiaNome = digitar.nextLine();

		/*
		 * usado para quando a midia for digitada errada, ou quando ainda n�o
		 * estiver cadastrada - parte1
		 */
		boolean verificarMidia = false;

		for (int i = 0; i < listaMidia.size(); i++) {
			if (listaMidia.get(i).getTitulo().equalsIgnoreCase(midiaNome)) {
				System.out.println("M�dia: " + listaMidia.get(i).getTitulo()
						+ " localizada.");

				/*
				 * se a midia for encontrada muda para verdadeiro, anulando a
				 * op��o de localizar novamente - parte
				 */
				verificarMidia = true;

				String opmidia = null;
				System.out.println("Deseja dar baixa na m�dia?");
				System.out
						.print("S para Sim ou outra tecla + ENTER para N�o: ");
				opmidia = digitar.nextLine();
				if (opmidia.equalsIgnoreCase("s")) {
					listaMidia.get(i).setTotalMidias(
							listaMidia.get(i).getTotalMidias() + 1);

					System.out
							.println("Dado baixa(adicionado + 1 � lista no estoque): "
									+ listaMidia.get(i).getTitulo());
				}

			}

		}

		/*
		 * se por acaso a midia n�o for localizada aparece esta op��o informando
		 * e permitindo localizar novamente
		 */
		if (verificarMidia == false) {
			System.out.println("N�o foi dado baixa na m�dia: " + midiaNome);
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
		// verifica se j� tem midia cadastrada
		verificarMidiaCadastrada();

		// verifica se j� tem midia cadastrada
		verificarMidiaCadastrada();

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);

		String midiaNome = null;

		System.out.println("\nENTRADA M�DIA ESTOQUE");
		System.out.print("Digite o t�tulo do filme: ");
		midiaNome = digitar.nextLine();

		/*
		 * usado para quando a midia for digitada errada, ou quando ainda n�o
		 * estiver cadastrada - parte1
		 */
		boolean verificarMidia = false;

		for (int i = 0; i < listaMidia.size(); i++) {
			if (listaMidia.get(i).getTitulo().equalsIgnoreCase(midiaNome)) {
				System.out.println("M�dia: " + listaMidia.get(i).getTitulo()
						+ " localizada.\n");
				System.out.println("Total em Estoque: "
						+ listaMidia.get(i).getTotalMidias() + "\n");

				/*
				 * se a midia for encontrada muda para verdadeiro, anulando a
				 * op��o de localizar novamente - parte
				 */
				verificarMidia = true;

				String opmidia = null;
				System.out.println("Deseja dar ENTRADA na m�dia?");
				System.out
						.print("S para Sim ou outra tecla + ENTER para N�o: ");
				opmidia = digitar.nextLine();
				if (opmidia.equalsIgnoreCase("s")) {
					int qtdEntradaMiida = 0;
					System.out.print("Digite a quantidade comprada: ");
					qtdEntradaMiida = digitar.nextInt();
					listaMidia.get(i).setTotalMidias(
							listaMidia.get(i).getTotalMidias()
									+ qtdEntradaMiida);

					System.out.println("\nDado entrada na m�dia: "
							+ listaMidia.get(i).getTitulo());
					System.out.println("\nTotal em estoque atual: "
							+ listaMidia.get(i).getTotalMidias());
				}

			}

		}

		/*
		 * se por acaso a midia n�o for localizada aparece esta op��o informando
		 * e permitindo localizar novamente
		 */
		if (verificarMidia == false) {
			System.out.println("N�o foi localizada a m�dia: " + midiaNome);
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

		System.out.println("Deseja ver lista de m�dias cadastradas?");
		System.out.print("Digite S para Sim ou outra tecla + ENTER para n�o: ");

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
