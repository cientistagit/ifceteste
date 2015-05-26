package modelo;

import java.util.Scanner;

public class Tarifas {

	// ATRIBUTOS
	private int idTarifas;
	private static double valorTarifas;
	private static int totalDiasAlugueis;

	// CONTRUTOR PADRÃO
	public Tarifas() {

	}

	// GETTERS e SETTERS
	public int getIdTarifas() {
		return idTarifas;
	}

	public void setIdTarifas(int idTarifas) {
		this.idTarifas = idTarifas;
	}

	public static double getValorTarifas() {
		return valorTarifas;
	}

	public static void setValorTarifas(double valorTarifas) {
		Tarifas.valorTarifas = valorTarifas;
	}

	public static int getTotalDiasAlugueis() {
		return totalDiasAlugueis;
	}

	public static void setTotalDiasAlugueis(int totalDiasAlugueis) {
		Tarifas.totalDiasAlugueis = totalDiasAlugueis;
	}

	// TOSTRING
	public String toString() {
		return "\nID Tarifas :" + getIdTarifas() + "\nValor Mídia: "
				+ getValorTarifas();
	}

	/*
	 * METODO QUE FAZ O CALCULO DA TARIFA PARA O ALUGUEL CADA MIDIA TEM SEU
	 * VALOR DE VENDA, E O ALUGUEL FUNCIONA ASSIM: UMA TARFIFA(PORCENTAGEM) FICA
	 * SOBRE O PREÇO DE VENDA (VEZES) O TOTAL DE DIAS VALORMIDIAALUGUEL = TARIFA
	 * (VEZES) PREÇO VENDA (VEZES) TOTAL DIAS ALUGUEL
	 */
	@SuppressWarnings("resource")
	public static double CalculaTarifa() {
		Scanner s = new Scanner(System.in);
		System.out.println("\n\nCADASTRO DE TARIFA ALUGUEL");
		System.out.println("Informe/altere a tarifa(porcentagem) a ser cobrada sobre a mídia no aluguel.");
		System.out.print("Valor Tarifa: ");
		valorTarifas = s.nextDouble();
		valorTarifas = valorTarifas / 100;

		System.out.println("\n");
		return valorTarifas;
	}

	@SuppressWarnings("resource")
	public static int totalDiasMidiaAlugadaCliente() {
		Scanner di = new Scanner(System.in);
		System.out.println("\n\nCADASTRO DE TOTAL DE DIAS DO ALUGUEL");

		System.out
				.println("Digite/altere o total de dias padrão para os aluguéis.");
		System.out.print("Dia(s): ");
		setTotalDiasAlugueis(di.nextInt());

		return getTotalDiasAlugueis();

	}

}
