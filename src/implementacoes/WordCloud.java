package implementacoes;

import java.util.ArrayList;
import java.util.Scanner;


public class WordCloud {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                
        String[] textSplit = sc.nextLine().split(" ");
        
        HashTable hashTable = new HashTable(textSplit.length);
        
        for(String string: textSplit) {
        	hashTable.put(string);
        }
        
        String word = sc.nextLine();
        
        while(!(word.equals("fim"))) {
						
			hashTable.frequencyWord(word);						
			word = sc.nextLine();			
		}
        
        sc.close();
    }
	
	
	static class HashTable{
		
		Object[] table;
		
		public HashTable(int size) {
		
			this.table = new ArrayList[size];
		}
		
		public void frequencyWord(String word) {
			
			int frequency = 0;
			
			if(word != null) {
				
				int hash = this.hash(word);
				
				if(this.table[hash] != null) {
					
					ArrayList<String> list = (ArrayList<String>) this.table[hash];
					
					for(String string: list) {
						if(string.equals(word)) {
							frequency ++;
						}
					}
					
				}
				
			}
			
			
			System.out.println(frequency);
		}

		private int hash(String element) {
			
			int hashKey;
			int key = element.hashCode();
			hashKey = Math.abs(key) % this.table.length; // prercisa do módulo da chave, pq o hashCode pode ser negativo
			
			return hashKey;			
		}
		
		public void put(String element) {
			
			if(element != null) {
				
				int hash = this.hash(element);
				
				ArrayList<String> list = (ArrayList<String>) this.table[hash];
				
				if(this.table[hash] == null) {
					list = new ArrayList<String>();
					list.add(element);
					this.table[hash] = list;
					
				} else {
					list.add(element);
					
				}		
			}			
		}
	}

}
