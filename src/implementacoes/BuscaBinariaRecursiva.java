package implementacoes;
import java.util.Scanner;

class BuscaBinariaRecursiva {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
			
		String[] sequencia = sc.nextLine().split(" ");
			
		int n = sc.nextInt();
					
		int[] sequenciaInteiros = converteEmInteiros(sequencia);
			
		if (buscaBinariaRecursiva(sequenciaInteiros, n, 0, sequenciaInteiros.length-1) == -1){
			
				System.out.println(-1);
		}
			
	}
				
	private static int[] converteEmInteiros(String[] sequencia) {
			
		int[] sequenciaInteiros = new int[sequencia.length];
			
		for (int i = 0; i < sequenciaInteiros.length; i++) {
			
			sequenciaInteiros[i] = Integer.parseInt(sequencia[i]);
		}
			
		return sequenciaInteiros;
			
	}


	private static int buscaBinariaRecursiva(int sequenciaInteiros[], int n, int inicio, int fim) {
			
		int meio = (inicio + fim) / 2;
			
		if (inicio <= fim) {
				
			System.out.println(meio);
				
			if (n == sequenciaInteiros[meio]) {
				
				return meio;
					
			} else if (n < sequenciaInteiros[meio]) {
				
				return buscaBinariaRecursiva(sequenciaInteiros, n,  inicio, meio - 1);
					
			} else {
				
				return buscaBinariaRecursiva(sequenciaInteiros, n,  meio + 1, fim);
			}
				
		} else {
			
			return -1;
			
			}
	}
		
}

		


