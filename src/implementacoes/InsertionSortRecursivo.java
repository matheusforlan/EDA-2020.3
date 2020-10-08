package implementacoes;

import java.util.Arrays;
import java.util.Scanner;


public class InsertionSortRecursivo {
	
public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] sequencia = sc.nextLine().split(" ");
		
		int[] sequenciaInteiros = converteEmInteiros(sequencia);
		
		insertionSortRecursivo( sequenciaInteiros, 0,  sequenciaInteiros.length - 1);
		
}
			

	private static void insertionSortRecursivo(int[] array, int indiceInicial, int indiceFinal) {
		
		if( indiceInicial == indiceFinal || array.length == 0) {
			return;
			
		} else {
			
		int j = indiceInicial + 1;
		
		while( (j > 0) && (array[j] < array[j-1]) ){
			
			trocaElementos(array, j, j-1);
			j--;
			
		}
		
		System.out.println(Arrays.toString(array));
		insertionSortRecursivo(array, indiceInicial + 1, indiceFinal);
		
		}
	
}


	private static void trocaElementos(int[] array, int i, int j) {
		if (array == null) {
			throw new IllegalArgumentException();
		}
	
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}




		private static int[] converteEmInteiros(String[] sequencia) {
		
		int[] sequenciaInteiros = new int[sequencia.length];
			
		for (int i = 0; i < sequenciaInteiros.length; i++) {
			
			sequenciaInteiros[i] = Integer.parseInt(sequencia[i]);
		}
			
		return sequenciaInteiros;
			
		}
}
