package visao;

import menus.MenuPrincipal;

//Anota��o pra ver a alterea��o pelot GIT
import controle.CadastroLojaDados;

public class PrincipalLocadora {

	public static void main(String[] args) {

		// TESTAR OS MENUS
		CadastroLojaDados.mensagemDeBemvindo();
		CadastroLojaDados.cadastrarDadosLoja();
		MenuPrincipal.menurPrincipal();

	}
}
//Jorge