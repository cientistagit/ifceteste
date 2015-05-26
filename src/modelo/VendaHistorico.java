package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class VendaHistorico {
	// ATRIBUTOS
	private Date data; // Calendar
	private int idVenda;
	protected static int idVendaGeral;
	private Cliente clienteLocar;
	private Atendente funcionarioLocar;
	private double valorTotalVenda;
	private double recebido;
	private double troco;
	private int tipoVenda = 1;

	// USADO PARA ARMAZENAR AS VARIAS MIDIAS QUE SERÃO VENDIDAS
	public List<Midia> MidiaVenda = new ArrayList<Midia>();

	/* serve para exibir a data no formato legal, do BRASIL */
	SimpleDateFormat formatoBrasileiro = new SimpleDateFormat(
			"dd/MM/yyyy hh:mm:ss");

	public VendaHistorico() {
		idVendaGeral += +1;
		this.idVenda = idVendaGeral;
		this.data = getData();
	}

	// GETTER E SETTERS

	// METODO PARA PEGAR A DATA PARA O ALUGUEL
	public Date getData() {

		Calendar calendar = new GregorianCalendar();
		Date date = new Date();
		calendar.setTime(date);
		this.data = calendar.getTime();
		return this.data;
	}

	public static int getIdVendaGeral() {
		return idVendaGeral;
	}

	public static void setIdLocacaoGeral(int idVendaGeral) {
		VendaHistorico.idVendaGeral = idVendaGeral;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdLocacao(int idVenda) {
		this.idVenda = idVenda;
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

	public double getValorTotalVenda() {
		return valorTotalVenda;
	}

	public void setValorTotalVenda(double valorTotalVenda) {
		this.valorTotalVenda = valorTotalVenda;
	}

	public List<Midia> getMidiaVenda() {
		return MidiaVenda;
	}

	public void setMidiaAlugada(List<Midia> MidiaVenda) {
		this.MidiaVenda = MidiaVenda;
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
	 * METODO QUE SOMA O TOTAL DA VENDA DAS MIDIAS
	 */
	public void somarTotalVenda() {
		for (int i = 0; i < MidiaVenda.size(); i++) {
			setValorTotalVenda(getValorTotalVenda()
					+ MidiaVenda.get(i).getTotalItemVenda());
		}
	}

	public void setTipoVenda() {
		for (int i = 0; i < MidiaVenda.size(); i++) {
			MidiaVenda.get(i).setTipoEvento(this.tipoVenda);
		}

	}

	@SuppressWarnings("resource")
	public void somarTrocoVenda() {
		Scanner digitar = new Scanner(System.in);

		if (getRecebido() >= getValorTotalVenda()) {
			setTroco(getValorTotalVenda() - getRecebido());
			return;
		} else {
			System.out.println("Troco errado.\nRepita a operação.");
			System.out.print("Valor recebido: ");
			setRecebido(digitar.nextDouble());
			somarTrocoVenda();
		}

	}

	// METODO PARA FAZER O CALCULO DO TOTAL DO ITEM NA VENDA
	public void calcularTotalItemVEnda() {
		for (int i = 0; i < MidiaVenda.size(); i++) {
			MidiaVenda.get(i).setTotalItemVenda(
					MidiaVenda.get(i).getQtd()
							* MidiaVenda.get(i).getValorUniMidiaVenda());
		}

	}

	/*
	 * ESTE MOTODO FOI FEITO PARA TRATAR UM "PROBLEMA" QUE TINHA NO STRING, da
	 * MidiaVenda, QUE COLOCAVA UM COLCHETE "[]" NO COMEÇO "[" E NO FIM "]"
	 * ficava os itens entre os colchetes, ficam estranho.
	 */
	public String mostrarItensVenda() {
		StringBuffer vendaString = new StringBuffer();
		for (int i = 0; i < MidiaVenda.size(); i++) {
			vendaString.append(MidiaVenda.get(i));
		}
		return vendaString.toString();
	}

	@Override
	public String toString() {
		return "\nNº Venda: "
				+ idVenda
				+ "\nData: "
				+ formatoBrasileiro.format(data)
				+ "\n__________________________________________________________\n"
				+ "\nResumo Venda \nMídia     >     QTD.     >   ValorUni.   >   Total"
				+ mostrarItensVenda()// MidiaVenda.toString()
				+ "\n\nTotal: R$ "
				+ this.valorTotalVenda
				+ "\nValor Recebido: R$ "
				+ this.recebido
				+ "\nValor Troco: R$ "
				+ this.troco
				+ "\n__________________________________________________________\n"
				+ "\nCliente: " + clienteLocar + "\nFun.: " + funcionarioLocar;
	}
}
