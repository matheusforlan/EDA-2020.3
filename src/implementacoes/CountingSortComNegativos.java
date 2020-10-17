package implementacoes;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSortComNegativos {
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] sequencia = sc.nextLine().split(" ");
		
		int[] sequenciaInteiros = converteEmInteiros(sequencia);
		
		int max= sc.nextInt();
		
		int min = sc.nextInt();
		
		
		extendCountingSort(sequenciaInteiros, max, min );
		
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
		
		if(array.length == 1) {
			result = "[" + array[0] + "]";
			
		} else {
					
			for(int i = 0; i < array.length; i++) {
				
				if( result.length() == 0) {
					result += "[" +  array[i];
				} else {
				 	
					if(result.length() == 0) {					
						result += " " + array[i];
					}
				 
					else if(i+1 == array.length) {
						result += ", " + array[i] + "]";
					}
					else {
						result += ", " + array[i];
					}	
				}		
			}
		}
		
		return result;
	}
	
	
	private static void extendCountingSort(int[] initialArray, int max, int min) {
		
			int leftIndex = 0;
			int rightIndex = initialArray.length -1;
			
			int[] countingArray = new int[max - min + 1];
				
			
			// frequencia
			for(int i = leftIndex; i <= rightIndex; i++) {
				countingArray[initialArray[i] - min] += 1;
				System.out.println(printArray(countingArray));
			}
			
			// cumulativa
	
			for(int i = 0; i < countingArray.length - 1; i++) {
						
				countingArray[i+1] += countingArray[i];
						
			}
			
			System.out.println("Cumulativa do vetor de contagem - " + printArray(countingArray));
			
			int[] orderedArray = new int[rightIndex - leftIndex + 1];
			
			for(int i = rightIndex; i >= leftIndex; i--){
				
				countingArray[initialArray[i] - min] -= 1;
				
				orderedArray[ countingArray[initialArray[i] - min]] = initialArray[i];
				
			}
			
			System.out.println(printArray(countingArray));
			
			for(int i = leftIndex; i <= rightIndex; i++){
				initialArray[i] = orderedArray[i-leftIndex];
				
			}
			
			System.out.println(printArray(initialArray));			
		}
}
