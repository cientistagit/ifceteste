package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class LocacaoHistorico {
	// ATRIBUTOS
	private Date data;
	private int idLocacao;
	protected static int idLocacaoGeral;
	private Cliente clienteLocar;
	private Atendente funcionarioLocar;
	private double valorTotalAluguel;
	private double recebido;
	private double troco;

	// USADO PARA ARMAZENAR AS VARIAS MIDIAS QUE SERÃO ALUGADAS POR ALUGEL
	public List<Midia> MidiaAlugada = new ArrayList<Midia>();

	/* serve para exibir a data no formato legal, do BRASIL */
	SimpleDateFormat formatoBrasileiro = new SimpleDateFormat(
			"dd/MM/yyyy hh:mm:ss");

	public LocacaoHistorico() {

		idLocacaoGeral += +1;
		this.idLocacao = idLocacaoGeral;
		this.data = getData(); // DATA DO EVENTO ALUGUEL/VENDA
	}

	// GETTER E SETTERS

	// METODO PARA PEGAR A DATA PARA O ALUGUEL, NA HORA DO EVENTO
	public Date getData() {
		Calendar calendar = new GregorianCalendar();
		Date date = new Date();
		calendar.setTime(date);
		this.data = calendar.getTime();
		return this.data;
	}

	public static int getIdLocacaoGeral() {
		return idLocacaoGeral;
	}

	public static void setIdLocacaoGeral(int idLocacaoGeral) {
		LocacaoHistorico.idLocacaoGeral = idLocacaoGeral;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getIdLocacao() {
		return idLocacao;
	}

	public void setIdLocacao(int idLocacao) {
		this.idLocacao = idLocacao;
	}

	public Cliente getClienteLocar() {
		return clienteLocar;
	}

	public void setClienteLocar(Cliente clienteLocar) {
		this.clienteLocar = clienteLocar;
	}

	public Atendente getFuncionarioLocar() {
		return funcionarioLocar;
	}

	public void setFuncionarioLocar(Atendente funcionarioLocar) {
		this.funcionarioLocar = funcionarioLocar;
	}

	public double getValorTotalAluguel() {
		return valorTotalAluguel;
	}

	public void setValorTotalAluguel(double valorTotalAluguel) {
		this.valorTotalAluguel = valorTotalAluguel;
	}

	public List<Midia> getMidiaAlugada() {
		return MidiaAlugada;
	}

	public void setMidiaAlugada(List<Midia> MidiaAlugada) {
		this.MidiaAlugada = MidiaAlugada;
	}

	public double getRecebido() {
		return recebido;
	}

	public void setRecebido(double recebido) {
		this.recebido = recebido;
	}

	public double getTroco() {
		return troco;
	}

	public void setTroco(double troco) {
		this.troco = troco;
	}

	/*
	 * METODO QUE SOMA O TOTAL DO ALUGUEL DAS MIDIAS
	 */
	public void somarTotalAluguel() {
		for (int i = 0; i < MidiaAlugada.size(); i++) {
			setValorTotalAluguel(getValorTotalAluguel()
					+ MidiaAlugada.get(i).getValorUniMidiaVenda());
		}
	}

	@SuppressWarnings("resource")
	public void somarTroco() {

		Scanner digitar = new Scanner(System.in);

		if (getRecebido() >= getValorTotalAluguel()) {
			setTroco(getValorTotalAluguel() - getRecebido());
			return;
		} else {
			System.out.println("Troco errado.\nRepita a Operação.");
			System.out.print("Valor recebido: ");
			setRecebido(digitar.nextDouble());
			somarTroco();
		}

	}

	/*
	 * ESTE MOTODO FOI FEITO PARA TRATAR UM "PROBLEMA" QUE TINHA NO STRING, da
	 * MidiaAlugada, QUE COLOCAVA UM COLCHETE "[]" NO COMEÇO "[" E NO FIM "]"
	 * ficava estranho
	 */
	public String mostrarItensLocacao() {
		StringBuffer locacao = new StringBuffer();
		for (int i = 0; i < MidiaAlugada.size(); i++) {
			locacao.append(MidiaAlugada.get(i));
		}
		return locacao.toString();
	}

	@Override
	public String toString() {
		return "\nNº Locação: "
				+ idLocacao
				+ "\nData: "
				+ formatoBrasileiro.format(data)
				+ "\n__________________________________________________________\n"
				+ "\nResumo Aluguel\nMídia     >     Valor"
				+ mostrarItensLocacao()// MidiaAlugada
				+ "\n\nTotal Aluguel: R$ "
				+ this.valorTotalAluguel
				+ "\nValor Recebido: R$ "
				+ this.recebido
				+ "\nValor Troco: R$ "
				+ this.troco
				+ "\n__________________________________________________________\n"
				+ "\nCliente: " + clienteLocar + "\nFun.: " + funcionarioLocar
				+ "Total dias de aluguel: " + Tarifas.getTotalDiasAlugueis();

	}

	/*
	 * METODO PARA FAZER O CALCULO DO TOTAL DO ITEM NO ALUGUEL ALUGUEL FUNCIONA
	 * ASSIM: UMA TARFIFA(PORCENTAGEM) FICA SOBRE O PREÇO DE VENDA (VEZES) O
	 * TOTAL DE DIAS VALORMIDIAALUGUEL = TARIFA (VEZES) PREÇO VENDA (VEZES)
	 * TOTAL DIAS ALUGUEL
	 */
	public void calcularTotalItemAluguel() {
		for (int i = 0; i < MidiaAlugada.size(); i++) {
			MidiaAlugada.get(i).setTotalItemVenda(
					Tarifas.getValorTarifas()
							* MidiaAlugada.get(i).getValorUniMidiaVenda()
							* Tarifas.getTotalDiasAlugueis());
		}

	}
}
