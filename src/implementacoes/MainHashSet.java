package implementacoes;

import java.util.Arrays;
import java.util.Scanner;


public class MainHashSet {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Integer size = sc.nextInt();

        HashSet hashSet = new HashSet(size);
        
        
        String acao = sc.nextLine();

        
        while(!(acao.equals("end"))) {
			
			
			if(acao.contains("put")){
				String[] separador = acao.split(" ");
				hashSet.put(Integer.parseInt(separador[1]));
				hashSet.print();
			}
			else if(acao.contains("remove")){
				String[] separador = acao.split(" ");
				hashSet.remove(Integer.parseInt(separador[1]));
				hashSet.print();
				
			}			
			else if(acao.contains("contains")) {
				String[] separador = acao.split(" ");
				boolean answer = hashSet.contains(Integer.parseInt(separador[1]));
				System.out.println(answer);
			}			
			acao = sc.nextLine();		
		}
        
        sc.close();
    }
	
		static class HashSet{
		
		Integer[] array;
		
		public HashSet(Integer size) {
			this.array = new Integer[size];
		}

		private int hash(Integer key) {
			
			return key % this.array.length;
		}

		public void put(Integer element) {
			
			if((element != null) && (!this.contains(element))) {
				
				int probe = 0;
				int hash;
				
				while(probe < this.array.length) {
					
					hash = (this.hash(element) + probe) % this.array.length;
					
					if(this.array[hash] == null) {
						this.array[hash] = element;
						break;
					} else {
						
						probe ++;
					}
					
				}
				
			}
			
		}

		public boolean contains(Integer element) {
			
			boolean answer = false;
			
			if(element != null) {
				
				int probe = 0;
				int hash;
				
				while(probe < this.array.length) {
					
					hash = (this.hash(element) + probe) % this.array.length;
					
					if((this.array[hash] != null) && (this.array[hash] == element)) {
						
						answer = true;
						break;
						
					} else {
						probe ++;
					}
				}
				
			}
			
			return answer;
			
		}

		public void remove(Integer element) {
			
			if((element != null) && this.contains(element)) {
				
				int probe = 0;
				int hash;
				
				while(probe < this.array.length) {
					
					hash = (this.hash(element) + probe) % this.array.length;
					
					if((this.array[hash] == element) && (this.array[hash] != null)) {
						this.array[hash] = null;
						break;
					} else {
						probe ++;
					}
					
				}
				
				
			}
			
		}
		
		public void print() {
			 System.out.println(Arrays.toString(this.array));
		}
		
	}

}
