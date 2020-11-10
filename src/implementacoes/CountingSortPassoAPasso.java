package implementacoes;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSortPassoAPasso {
	
	public static void main(String [] args) {
			
			Scanner sc = new Scanner(System.in);
			
			String[] sequencia = sc.nextLine().split(" ");
			
			int[] sequenciaInteiros = converteEmInteiros(sequencia);
			
			int k = sc.nextInt();
			
			countingSort(sequenciaInteiros, k);
			
		}
	

		private static int[] converteEmInteiros(String[] sequencia) {
			
			int[] sequenciaInteiros = new int[sequencia.length];
				
			for (int i = 0; i < sequenciaInteiros.length; i++) {
				
				sequenciaInteiros[i] = Integer.parseInt(sequencia[i]);
			}
				
			return sequenciaInteiros;
				
		}
		
		private static String printArray(int[] array) {
			String result = "";
			
			for(int i = 0; i < array.length; i++) {
				if( result.length() == 0) {
					result += array[i];
				} else {
					result += " " + array[i];
				}
			}
			
			return result;
		}
	
		private static void countingSort(int[] initialArray, int k) {
			
		int leftIndex = 0;
		int rightIndex = initialArray.length -1;
		
		int[] countingArray = new int[k + 1];
		
		
		// frequencia
		for(int i = leftIndex; i <= rightIndex; i++) {
			countingArray[initialArray[i]] += 1;
			System.out.println(printArray(countingArray));
		}
		
		// cumulativa
		
		for(int i = 0; i < countingArray.length - 1; i++) {
			
			countingArray[i+1] += countingArray[i];
			
		}
		
		System.out.println("Cumulativa do vetor de contagem - " + printArray(countingArray));
		
		int[] orderedArray = new int[rightIndex - leftIndex + 1];
		
		for(int i = rightIndex; i >= leftIndex; i--){
			
			countingArray[initialArray[i]] -= 1;
			
			orderedArray[countingArray[initialArray[i]]] = initialArray[i];
			
		}
		
		System.out.println(printArray(countingArray));
		
		for(int i = leftIndex; i <= rightIndex; i++){
			initialArray[i] = orderedArray[i-leftIndex];
			
		}
		
		System.out.println(printArray(initialArray));
		
	}


		
}
