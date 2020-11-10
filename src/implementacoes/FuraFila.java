package implementacoes;

import java.util.Arrays;
import java.util.Scanner;

class FuraFila {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
			
		String[] sequencia = sc.nextLine().split(" ");
		
		int i = Integer.parseInt(sc.nextLine());
		
		int[] sequenciaInteiros = converteEmInteiros(sequencia);
			
		furaFila(sequenciaInteiros, i);
		
		sc.close();
		
	}
	
	private static int[] converteEmInteiros(String[] sequencia) {
		
		int[] sequenciaInteiros = new int[sequencia.length];
			
		for (int i = 0; i < sequenciaInteiros.length; i++) {
			
			sequenciaInteiros[i] = Integer.parseInt(sequencia[i]);
		}
			
		return sequenciaInteiros;
			
	}

	private static void furaFila(int[] array, int indexPrimeiroIdoso) {

		int index = 0;
		
		for (int i = indexPrimeiroIdoso; i < array.length; i++) {
			int aux = array[i];

			for (int k = i; k > index; k--) {
				array[k] = array[k - 1];
			}
			array[index] = aux;
			
			index++;

			System.out.println(Arrays.toString(array));
		}

	}

}
