package controle;

import java.util.Scanner;

import menus.MenuPrincipal;
import modelo.DadosLoja;
import modelo.Limpar;

public class CadastroLojaDados {

	public CadastroLojaDados() {
		cadastrarDadosLoja();
	}

	static DadosLoja loja1 = new DadosLoja();

	/*
	 * este metodo deve ser executado somente uma vez
	 */
	@SuppressWarnings("resource")
	public static void cadastrarDadosLoja() {

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);

		System.out.print("Nome empresarial da loja: ");
		loja1.setNomeEmpresarial(digitars.nextLine());

		System.out.print("Nome fantasia: ");
		loja1.setNomeFantasia(digitars.nextLine());

		System.out.print("CNPJ da loja (somente números): ");
		loja1.setCnpj(digitar.nextLong());

		System.out.print("Endereço: ");
		loja1.setEnderecoLoja(digitars.nextLine());

		System.out.print("Telefone da loja: ");
		loja1.setTelefoneLoja(digitar.nextLong());

		System.out
				.println("Parabéns!\nTodos os dados necessários sobre a loja foram coletados.");
		System.out.println("Tecle qualquer tecla + ENTER para continuar.");
		digitar.next();
		
		return;
		
	}

	@SuppressWarnings("resource")
	public static void mensagemDeBemvindo() {
		Scanner digitar = new Scanner(System.in);
		Limpar.Tela();
		System.out
				.println("Seja bem-vindo ao SYSMOVIE.\nUm programa para controle de loja de aluguel e venda de mídias.\nPara começar, vamos coletar alguns dados sobre a loja.\nTecle qualquer tecla + ENTER para continuar.");
		digitar.next();
		
		return;

	}

	@SuppressWarnings("resource")
	public static void alterarDadosLoja() {

		Scanner digitar = new Scanner(System.in);
		Scanner digitars = new Scanner(System.in);
		
		System.out.println("ALTERAR DADOS DA LOJA\n\n");
		
		System.out.println("Atual nome empresarial da loja: "
				+ loja1.getNomeEmpresarial());
		System.out.print("Novo nome empresarial da loja: ");
		loja1.setNomeEmpresarial(digitars.nextLine());

		System.out.println("Atual nome fantasia: " + loja1.getNomeFantasia());
		System.out.print("Novo nome fantasia: ");
		loja1.setNomeFantasia(digitars.nextLine());

		System.out.println("Atual CNPJ da loja (somente números): "
				+ loja1.getCnpj());
		System.out.print("Novo CNPJ da loja (somente números): ");
		loja1.setCnpj(digitar.nextLong());

		System.out.println("Atual endereço: " + loja1.getEnderecoLoja());
		System.out.print("Novo endereço: ");
		loja1.setEnderecoLoja(digitars.nextLine());

		System.out
				.println("Atual telefone da loja: " + loja1.getTelefoneLoja());
		System.out.print("Novo telefone da loja: ");
		loja1.setTelefoneLoja(digitar.nextLong());

		System.out.println("Parabéns!\nOS dados da loja foram alterados.");
		System.out.println("Tecle qualquer tecla + ENTER para continuar.");
		digitar.next();
		
		MenuPrincipal.menurPrincipal();

		return;
	}

	public static void mostrarDadosLoja() {
		
		System.out.println("==============================================================");
		System.out.println("                       DADOS DA LOJA");
		System.out.println("==============================================================\n");

		System.out.println("Nome empresarial da loja: "+ loja1.getNomeEmpresarial());
		System.out.println("Nome fantasia: " + loja1.getNomeFantasia());
		System.out.println("CNPJ da loja (somente números): " + loja1.getCnpj());
		System.out.println("Endereço: " + loja1.getEnderecoLoja());
		System.out.println("Telefone da loja: " + loja1.getTelefoneLoja());
		System.out.println("==============================================================");
		System.out.println("                                       SYSMOVIE V0.1 - BETA");
		System.out.println("==============================================================");
		
		return;
	}

}
