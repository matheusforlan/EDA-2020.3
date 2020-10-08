package implementacoes;

import java.util.Scanner;

class VerificaElementosDuplicados {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		String[] sequencia = sc.nextLine().split(" ");
		
		if(Duplicados(sequencia)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		
		
		
	}


public static boolean Duplicados(String[] sequencia) {
	
	boolean resultado = false;
	
	for(int i=0; i < sequencia.length; i++) {	
		for( int j = i+ 1; j<sequencia.length; j++) {
			if(Integer.parseInt(sequencia[i]) == Integer.parseInt(sequencia[j])){	
				resultado = true;
			}
		}		
	}
	return resultado;
}

}