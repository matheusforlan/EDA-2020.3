package implementacoes;

import java.util.Arrays;
import java.util.Scanner;

public class InsereElementoEmListaOrdenada {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] sequencia = sc.nextLine().split(" ");
		
		int[] sequenciaInteiros = converteEmInteiros(sequencia);
		
		insereUltimo(sequenciaInteiros);
		
		System.out.println(Arrays.toString(sequenciaInteiros));
		
		
	}
	
		
		private static void insereUltimo(int [] array) {
			
			for(int i = array.length - 1; i > 0; i --) {
				if(array[i] < array[i-1]) {
					trocaElementos(array, i, i-1);
				}
				
				else {
					return;
				}
				
			}
			
		}
		
		

		private static int[] converteEmInteiros(String[] sequencia) {
		
		int[] sequenciaInteiros = new int[sequencia.length];
			
		for (int i = 0; i < sequenciaInteiros.length; i++) {
			
			sequenciaInteiros[i] = Integer.parseInt(sequencia[i]);
		}
			
		return sequenciaInteiros;
			
	}
		
		

		private static void trocaElementos(int[] array, int i, int j) {
			if (array == null) {
				throw new IllegalArgumentException();
			}

			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}


}
