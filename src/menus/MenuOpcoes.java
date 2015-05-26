package menus;

import modelo.Limpar;

public class MenuOpcoes {

	// MENSAGEM DE BEM-VINDO AO SYSMOVIE
	public static void mensagemBemVindo() {
		System.out.println("\n\nBem-vindo ao SysMovie\n");
	}

	// MENSAGEM INFORMANDO O MENU PRINCIPAL
	public static void mensagemMenuPrincipal() {
		System.out.println("Menu Principal");
	}

	// MENSAGEM QUE MOSTA MENSAGEM "Opções" , INDICAR AS OPÇÕES DISPONIVEL
	public static void mensagemOpcoes() {
		System.out.println("Opções");
	}

	// OPÇÕES NO MENU PRINCIPAL
	public static void mensagemMenuPrincipalOpcoes() {
		System.out.println("1 Cadastros" + "\n2 Movimentos" + "\n3 Relatórios"
				+ "\n0 Sair\n");
	}

	// MENSAGEM "Digite a Opção:"
	public static void mensagemDigiteOpcao() {
		System.out.print("\nDigite a Opção: ");
	}

	// MENSAGEM INDICADO A LOCALIDADE DE MENU CADASTROS
	public static void mensagemMenuCadastrosLocal() {
		System.out.println("\n\nTela Principal  > Cadastros\n");
	}

	// MENSAEM COM AS OPÇÕES DO MENU CADASTASTOS
	public static void mensagemMenuCadastrosOpcoes() {
		System.out.println("1 Cadastrar\n" + "2 Alterar\n" + "3 Excluir\n"
				+ "4 Voltar\n" + "0 Sair\n");
	}

	// MENSAGEM INDICANDO LOCAL DE MENU CADASTRAR
	public static void mensagemCadastrosCadastrarLocal() {
		System.out.println("Tela Principal  > Cadastros > Cadastrar\n");
	}

	// MENSAGEM INDICANDO LOCAL DE MENU ALTERAR
	public static void mensagemCadastrosAlterarLocal() {
		System.out.println("Tela Principal  > Cadastros > Alterar\n");
	}

	// MENSAGEM INDICANDO LOCAL DE MENU EXCLUIR
	public static void mensagemCadastrosExcluirLocal() {
		System.out.println("Tela Principal  > Cadastros > Excluir\n");
	}

	// MENSAGEM INDICANDO LOCAL DE MENU RELAÓRIOS
	public static void mensagemMenuRelátoriosLocal() {
		System.out.println("Tela Principal  > Relatórios\n  ");
	}
	
	
	// MENSAGEM INDICANDO LOCAL DE MENU MOVIMENTO ALUGAR
	public static void mensagemMenuMovimentosLocal() {
			System.out.println("Tela Principal  > Movimento");
		}
	
	//MENSAGEM COM AS OPÇÕES DO MEU RELATÓRIO
	public static void mensagemMenuRelariosOpcoes(){
		System.out.println("1 Clientes cadastrados\n" +  "2 Mídias cadastradas\n"
				+ "3 Funcionários cadastrados\n" +"4 Dados Loja\n"+"5 Resumo de aluguéis\n"+"6 Resumo de Vendas\n"+ "7 Menu Principal\n"
				+ "0 Sair");
	}
	
	
	//MENSAGEM COM AS OPÇÕES DO MEU MOVIMENTO
		public static void mensagemMenuMovimentosOpcoes(){
			System.out.println("1 Aluguel\n2 Baixa Mídias\n3 Vender\n4 Entrada Estoque Mídias\n7 Menu Principal\n"+ "0 Sair");
		}

	
	
	
	

	// MENSAGEM COM AS OPÇÕES DO MENU CADASTRAR
	public static void mensagemMenuCadastrosCadastrarOpcoes() {
		System.out.println("1 Clientes\n" + "2 Tarifa\n" + "3 Mídias\n"
				+ "4 Funcionários\n" + "6 Voltar\n" + "7 Menu Principal\n"
				+ "0 Sair");
	}

	// MENSAGEM COM AS OPÇÕES DO MENU ALTERAR
	public static void mensagemMenuCadastrosAlterarOpcoes() {
		System.out.println("1 Clientes\n" + "2 Tarifa\n" + "3 Mídias\n"
				+ "4 Funcionários\n" + "5 Dados Loja\n" + "6 Voltar\n"
				+ "7 Menu Principal\n" + "0 Sair");
	}

	// MENSAGEM COM AS OPÇÕES DO MENU EXCLUIR
	public static void mensagemMenuCadastrosExcluirOpcoes() {
		System.out.println("1 Clientes\n" + "2 Tarifa\n" + "3 Mídias\n"
				+ "4 Funcionários\n" + "6 Voltar\n" + "7 Menu Principal\n"
				+ "0 Sair");
	}
	
	// COMANDO PARA SAIR DO SISTEMA
	public static void OpcaoSairDoSistema() {
		Limpar.Tela();
		System.out.println("Tichau");
		System.exit(0);
	}

	// COMANDO PARA VOLTAR DIRETO PARA O MENU PRINCIPAL
	public static void voltarMenuPrincipal() {
		Limpar.Tela();
		MenuPrincipal.menurPrincipal();
	}

	public static void mensagemDeOpcaoErrada() {
		Limpar.Tela();
		System.out.println("MENSAGEM:");
		System.out.println("Opção errada!\nRepita a operação.\n");
	}

}
