package modelo;

import java.util.Scanner;

public class Midia {

	protected static int idMidiaGeral;// feito para implementar o contador de
										// midias cadastradas.
	protected int idMidia;
	protected String titulo;
	protected String genero;
	protected String descricao;
	protected double valorUniMidia;
	protected double valorUniMidiaVenda;
	private double qtd; // quantidade vendida, usar na venda
	private double totalItemVenda; // Valor total da venda, usar na venda
	private int tipoEvento = 0; // para marcar quando for aluguel e/ou venda - 0
	// aluguel 1 venda
	private String vendaOuAluguel;

	/*
	 * receber um valor para ser usado em todas as midias que forem sendo
	 * cadastradas
	 */
	protected static double porcentagemMargem;

	protected double totalMidias;

	// CONSTRUTOR PADRÃO
	public Midia() {
		idMidiaGeral += +1;
		idMidia = idMidiaGeral;
	}

	// CONSTRUTOR SOBRECARREGADO
	public Midia(int pIdMidia, String pTitulo, String pGenero,
			String pDescricao, double pValorUniMidia,
			double pValorUniMidiaVenda, double pTotalMidias) {
		this.idMidia = pIdMidia;
		this.titulo = pTitulo;
		this.genero = pGenero;
		this.descricao = pDescricao;
		this.valorUniMidia = pValorUniMidia;
		valorUniMidiaVenda = pValorUniMidiaVenda;
		this.totalMidias = pTotalMidias;

	}

	// GETTERS E SETTERS

	public static int getIdMidiaGeral() {
		return idMidiaGeral;
	}

	public double getQtd() {
		return qtd;
	}

	public void setQtd(double qtd) {
		this.qtd = qtd;
	}

	public double getTotalItemVenda() {
		return totalItemVenda;
	}

	public void setTotalItemVenda(double totalItemVenda) {
		this.totalItemVenda = totalItemVenda;
	}

	public static void setIdMidiaGeral(int idMidiaGeral) {
		Midia.idMidiaGeral = idMidiaGeral;
	}

	public int getIdMidia() {
		return idMidia;
	}

	public void setIdMidia(int idMidia) {
		this.idMidia = idMidia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorUniMidia() {
		return valorUniMidia;
	}

	public void setValorUniMidia(double valorUniMidia) {
		this.valorUniMidia = valorUniMidia;
	}

	public double getValorUniMidiaVenda() {
		return valorUniMidiaVenda;
	}

	public void setValorUniMidiaVenda(double valorUniMidiaVenda) {
		this.valorUniMidiaVenda = valorUniMidiaVenda;
	}

	public double getTotalMidias() {
		return totalMidias;
	}

	public void setTotalMidias(double totalMidias) {
		this.totalMidias = totalMidias;
	}

	public int getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(int tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getVendaOuAluguel() {
		return vendaOuAluguel;
	}

	public void setVendaOuAluguel(String vendaOuAluguel) {
		this.vendaOuAluguel = vendaOuAluguel;
	}

	public static double getPorcentagemMargem() {
		return porcentagemMargem;
	}

	/*
	 * ESTE MÉTODO FOI FEITO PARA PEGAR A MARGEM DE LUCRO E INSERIR NO MÉTODO
	 * 'CalcularValorMidiaVenda'. Ele é um metodo estatico e por isso posso
	 * ficar pegando o mesmo valor/dado para todas as midias a serem
	 * cadastradas.
	 */
	public static void setPorcentagemMargem(double porcentagemMargem) {
		Midia.porcentagemMargem = porcentagemMargem;
	}

	/*
	 * METODO QUE FAZ O CALCULO PARA OBTER A MARGEM DE LUCRO BASEADO EM UMA
	 * MARGEM DE LUCRO NUNCA DEVE TER UMA MARGEM DE LUCRO NEGATIVA
	 */
	public void CalcularValorMidiaVenda(double pPorcentagemGanhoVenda) {

		setValorUniMidiaVenda(0);

		if (pPorcentagemGanhoVenda >= 0) {
			pPorcentagemGanhoVenda = pPorcentagemGanhoVenda / 100;

			setValorUniMidiaVenda((pPorcentagemGanhoVenda * getValorUniMidia())
					+ getValorUniMidia());
		} else {
			do {
				System.out
						.print("Margem de lucro negativa\nDigite outro valor: ");

				@SuppressWarnings("resource")
				Scanner digitar = new Scanner(System.in);
				pPorcentagemGanhoVenda = digitar.nextDouble();

				pPorcentagemGanhoVenda = pPorcentagemGanhoVenda / 100;

				setValorUniMidiaVenda((pPorcentagemGanhoVenda * getValorUniMidia())
						+ getValorUniMidia());

			} while (pPorcentagemGanhoVenda < 0);

		}

	}

	// MÉTODO TOSTRING
	@Override
	public String toString() {

		if (this.tipoEvento == 0) {
			return "\n" + titulo + "    >     " + valorUniMidiaVenda;
		}

		return "\n" + this.titulo + "  >  " + this.qtd + "  >  "
				+ this.valorUniMidiaVenda + " >  " + this.totalItemVenda;

	}

	/*
	 * este metodo foi para no caso de comparação de objeto, o java comparar os
	 * objetos.
	 */
	public boolean equals(Object obj) {
		Midia midia = (Midia) obj;
		if (midia.getTitulo() == this.titulo)
			return true;
		return false;
	}

}