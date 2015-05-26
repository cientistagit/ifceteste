package modelo;

import java.util.Scanner;

public class Tecle {
	
	@SuppressWarnings("resource")
	public static void continuar(){
		Scanner di = new Scanner(System.in);
		
		System.out.println("\nTecle qualquer tecla + ENTER para continuar.\n");
		di.next();
	}

}
