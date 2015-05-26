package visao;

import menus.MenuPrincipal;

//Anotação pra ver a altereação pelot GIT
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