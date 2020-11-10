package implementacoes;

import java.util.Scanner;

public class Fila {
	
	private int tail = -1;
	
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		Fila fila = new Fila();
		
		String[]array = new String[size];
		
		
		String acao = sc.nextLine();
		
		while(!(acao.equals("end"))) {
			
			
			if(acao.contains("print")){
				fila.print(array);
			}
			else if(acao.contains("element")){
				fila.element(array);
			}			
			else if(acao.contains("remove")) {
				fila.remove(array);
			}
			
			else if(acao.contains("add")){
				String[] separador = acao.split(" ");
				fila.add(array, separador[1]);
				
			}
			
			acao = sc.nextLine();
			
		}
				
	}
	
	
	
	public void element(String[] array){
			
		if(isEmpty()) {
			System.out.println("empty");
		}
		else {
			System.out.println(array[0]);
		}
		
		
	}

	
	public boolean isEmpty() {
		return this.tail == -1;
	}

	
	public boolean isFull(String[] array) {
		
		return this.tail == (array.length -1);
		
	}

	private void shiftLeft(String[] array) {
		for(int i = 0; i < this.tail; i++){
			array[i] = array[i+1];
		}
	}


	public void add(String[] array, String element) {
		if(isFull(array)) {
			System.out.println("full");
		}else {
			this.tail ++;
			array[this.tail] = element;
		}
			
	}

	
	public void remove(String[] array) {
		
		if(isEmpty()) {
			System.out.println("empty");
		} 		
		else {		
			shiftLeft(array);
			this.tail --;
		}
	}
	
	public void print(String[] array) {
			
			if(isEmpty()) {
				System.out.println("empty");
				return;
			} else {
				for(int i = 0; i <= this.tail; i++) {
					if(i != this.tail) {
						System.out.print(array[i] + " ");
					} else {
						System.out.println(array[i]);
					}
				}
				
			}
		}

}
