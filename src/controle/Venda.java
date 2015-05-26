package controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.VendaHistorico;

public class Venda {

	// ESTA LISTA IRÁ ARMAZENAR O HISTORICO DE VENDAS
	static List<VendaHistorico> listaMidiaVendidasHistorico = new ArrayList<VendaHistorico>();

	@SuppressWarnings({ "resource" })
	public static void iniciarVendaMidias() {

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);// exclusivo para String

		String opecaoI = null;
		System.out.println("VENDA\n");
		System.out.println("Deseja iniciar a venda?");
		System.out.print(" S para Sim ou outra tecla + ENTER para Não: ");
		opecaoI = digitar.next();

		while (opecaoI.equalsIgnoreCase("s")) {

			VendaHistorico vender = new VendaHistorico();
			
			// localiza e seta o funcionario e seta no atributo funcionarioLocar
			// do tipo Atendente
			System.out.println("");
			vender.setFuncionarioLocar(CadastroAtendente.pesquisarFuncionarioID());

			// localiza e seta o cliente pelo nome
			System.out.println("");
			vender.setClienteLocar(CadastroCliente.pesquisarClientePorNome1());

		

			/* ESTA PARTE FAZ A VENDA DA MIDIA*/
			String opecaoMidia = null;
			do {
				System.out.println("Inserir Midia");

				/*localiza a midia e seta o objeto na Arraylist.
				 * O próprio metodo faz a verificação de erros e outros*/
				/***********************************************/
				vender.MidiaVenda.add(CadastroMidia.pesquisarMidiaPorNomeVenda());
				

				System.out.println("Deseja incluir outra mídia?");
				System.out.print(" S para Sim ou outra tecla + ENTER para Não: ");
				opecaoMidia = null;
				opecaoMidia = digitar.next();
				if (opecaoMidia != "s" || opecaoMidia != "S")
					opecaoI = "n";

			} while (opecaoMidia.equalsIgnoreCase("s"));

			/*== INICIO -  CALCULOS AUTOMATICOS DO SISTEMA ==*/
			
			/*Faz o calculo de cada item da Venda*/
			vender.calcularTotalItemVEnda();
			
			/*Soma o total da venda*/
			vender.somarTotalVenda();
			
			/*informa que a Midia é do tipo VENDA, para exibir o toString para a venda*/
			vender.setTipoVenda();

			/*== FIM -  CALCULOS ALTOMATICOS DO SISTEMA ==*/
			
			
			/* FINALIZAÇÃO DA VENDA - INCIO */

			System.out.println("\n\nFINALIZANDO VENDA");
			System.out.println("Total Venda: " + vender.getValorTotalVenda());
			System.out.print("Valor recebido: ");
			vender.setRecebido(digitar.nextDouble());
			/*FAZ O CALCULO DO TROCO, O METODO ESTÁ NA CLASSE VendaHistorico*/
			vender.somarTrocoVenda();
			System.out.println("Troco: " + vender.getTroco());

			/* FINALIZAÇÃO DA VENDA - FIM */

			/*
			 * AQUI ADICIONA O OJETO "LOCAR" NA ARRAYLIST GERAL, QUE SERÁ O
			 * HISTÓRICO DAS VENDAS
			 */
			listaMidiaVendidasHistorico.add(vender);

			/* =====PARTE DE RECIBO DA VENDA */
			System.out.println("VISUALIZAR RECIBO?\n");
			String oprecibo = null;
			System.out.print("S para Sim ou outra tecla + ENTER para Não: ");
			oprecibo = digitars.nextLine();
			if (oprecibo.equalsIgnoreCase("s")) {
				System.out.println("\n\nRECIBO DE VENDA\n\n");
				System.out.println("Loja: "
						+ CadastroLojaDados.loja1.getNomeFantasia());
				System.out
						.println("CNPF: " + CadastroLojaDados.loja1.getCnpj());
				System.out.println("Telefone: "
						+ CadastroLojaDados.loja1.getTelefoneLoja());
				System.out.println("Endereço: "
						+ CadastroLojaDados.loja1.getEnderecoLoja());

				System.out.println(vender);
				System.out.println("\nFIM DO RECIBO\n");
			}
			/* FIM PARTE DE RECIBO DE ALUGUEL */

		}

		return;

	}

	public static void mostrarListaVendas() {

		System.out
				.println("==============================================================");
		System.out.println("                  RESUMO DE VENDAS ");
		System.out
				.println("==============================================================\n");
		System.out
				.println("Loja: " + CadastroLojaDados.loja1.getNomeFantasia());
		System.out.println("CNPJ: " + CadastroLojaDados.loja1.getCnpj());
		System.out.println("Telefone: "
				+ CadastroLojaDados.loja1.getTelefoneLoja());
		System.out.println("Endereço: "
				+ CadastroLojaDados.loja1.getEnderecoLoja());
		for (int i = 0; i < listaMidiaVendidasHistorico.size(); i++) {
			System.out.println(listaMidiaVendidasHistorico.get(i));

		}
		System.out.println("\n\nTotal venda(s)  realizada(s): "
				+ listaMidiaVendidasHistorico.size() + "\n");

		System.out
				.println("==============================================================");
		System.out.println("                                               FIM DA LISTA");
		System.out.println("==============================================================");
		return;
	}

}
