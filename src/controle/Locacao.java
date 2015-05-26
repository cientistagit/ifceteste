package controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Limpar;
import modelo.LocacaoHistorico;
import modelo.Tarifas;
import modelo.Tecle;

public class Locacao {

	// ESTA LISTA IRÁ ARMAZENAR O HISTORICO DE ALUGUEIS
	static List<LocacaoHistorico> listaMidiaLocadasHistorico = new ArrayList<LocacaoHistorico>();

	@SuppressWarnings({ "resource" })
	public static void iniciarLocacaoMidias() {

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);// exclusivo para String

		String opecaoI = null;
		System.out.println("LOCAÇÃO\n");
		System.out.println("Dejesa iniciar a locação?");
		System.out.print(" S para Sim ou outra tecla + ENTER para Não: ");
		opecaoI = digitar.next();

		/* VERIFICAR SE AS TARIFAS FORAM CADASTRADAS - INICIO */
		if (Tarifas.getValorTarifas() == 0) {
			System.out
					.println("Tarifas ainda não cadastradas.\nCadastre antes de continuar o aluguel\n");
			Tecle.continuar();
			Limpar.Tela();

			Tarifas.CalculaTarifa();
			Tarifas.totalDiasMidiaAlugadaCliente();
			Tecle.continuar();

			Limpar.Tela();
			System.out.println("Continuar locação.");
			Tecle.continuar();

		}	/* VERIFICAR SE AS TARIFAS FORAM CADASTRADAS - FIM */
		
		
		while (opecaoI.equalsIgnoreCase("s")) {

			LocacaoHistorico locar = new LocacaoHistorico();

			// localiza e seta o funcionario e seta no atributo funcionarioLocar
			// do tipo Atendente
			System.out.println("");
			locar.setFuncionarioLocar(CadastroAtendente
					.pesquisarFuncionarioID());

			// localiza e seta o cliente pelo nome
			System.out.println("");
			locar.setClienteLocar(CadastroCliente.pesquisarClientePorNome1());

			/* ESTA PARTE FAZ A LOCAÇÃO DA MIDIA */
			String opecaoMidia = null;
			do {
				System.out.println("Inserir Midia");

				// localiza a midia e seta o objeto na Arraylist.

				locar.MidiaAlugada.add(CadastroMidia.pesquisarMidiaPorNome1());

				System.out.println("Dejesa incluir outra mídia?");
				System.out
						.print(" S para Sim ou outra tecla + ENTER para Não: ");
				opecaoMidia = null;
				opecaoMidia = digitar.next();
				if (opecaoMidia != "s" || opecaoMidia != "S")
					opecaoI = "n";

			} while (opecaoMidia.equalsIgnoreCase("s"));
			
			
			/*== INICIO -  CALCULOS AUTOMÁTICOS DO SISTEMA ==*/

			/* Faz o calculo de cada item do Aluguel */
			locar.calcularTotalItemAluguel();

			// soma todas as midias (atributo valorVenda) do objeto em foco
			locar.somarTotalAluguel();
			
				
			/*== FIM -  CALCULOS ALTOMATICOS DO SISTEMA ==*/
			
			

			/* FINALIZAÇÃO DO ALUGUEL - INCIO */

			System.out.println("\n\nFINALIZANDO ALUGUEL");
			System.out
					.println("Total Aluguel: " + locar.getValorTotalAluguel());
			System.out.print("Valor recebido: ");
			locar.setRecebido(digitar.nextDouble());
			/*FAZ O CALCULO DO TROCO*/
			locar.somarTroco();
			System.out.println("Troco: " + locar.getTroco());

			/* FINALIZAÇÃO DO ALUGUEL - FIM */

			/*
			 * AQUI ADICIONA O OJETO "LOCAR" NA ARRAYLIST GERAL, QUE SERÁ O
			 * HISTÓRICO DOS ALUGUEIS
			 */
			listaMidiaLocadasHistorico.add(locar);

			/* =====PARTE DE RECIBO DE ALUGUEL */
			System.out.println("VISUALIZAR RECIBO?\n");
			String oprecibo = null;
			System.out.print("S para Sim ou outra tecla + ENTER para Não: ");
			oprecibo = digitars.nextLine();
			if (oprecibo.equalsIgnoreCase("s")) {
				System.out.println("\n\nRECIBO DE LOCAÇÃO\n\n");
				System.out.println("Loja: "
						+ CadastroLojaDados.loja1.getNomeFantasia());
				System.out
						.println("CNPF: " + CadastroLojaDados.loja1.getCnpj());
				System.out.println("Telefone: "
						+ CadastroLojaDados.loja1.getTelefoneLoja());
				System.out.println("Endereço: "
						+ CadastroLojaDados.loja1.getEnderecoLoja());

				System.out.println(locar);
				System.out.println("\nFIM DE RECIBO\n");
			}
			/* FIM PARTE DE RECIBO DE ALUGUEL */

		}

		return;

	}

	public static void mostrarListaAluguel() {

		System.out
				.println("==============================================================");
		System.out.println("                  RESUMO DE ALUGUÉIS ");
		System.out
				.println("==============================================================\n");
		System.out
				.println("Loja: " + CadastroLojaDados.loja1.getNomeFantasia());
		System.out.println("CNPJ: " + CadastroLojaDados.loja1.getCnpj());
		System.out.println("Telefone: "
				+ CadastroLojaDados.loja1.getTelefoneLoja());
		System.out.println("Endereço: "
				+ CadastroLojaDados.loja1.getEnderecoLoja());
		for (int i = 0; i < listaMidiaLocadasHistorico.size(); i++) {
			System.out.println(listaMidiaLocadasHistorico.get(i));

		}
		System.out.println("\n\nTotal de aluguéis realizados: "
				+ listaMidiaLocadasHistorico.size() + "\n");

		System.out
				.println("==============================================================");
		System.out
				.println("                                               FIM DA LISTA");
		System.out
				.println("==============================================================");
		return;
	}

}
