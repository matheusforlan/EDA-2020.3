package implementacoes;

import java.util.Arrays;
import java.util.Scanner;

public class BuildHeap {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] sequencia = sc.nextLine().split(" ");
		
		int[] sequenciaInteiros = converteEmInteiros(sequencia);
		
		Heap heap = new Heap(sequenciaInteiros.length);
		
		heap.buildHeap(sequenciaInteiros);
		
        System.out.println(heap.toString());

	}
	
	private static int[] converteEmInteiros(String[] sequencia) {
		
		int[] sequenciaInteiros = new int[sequencia.length];
			
		for (int i = 0; i < sequenciaInteiros.length; i++) {			
			sequenciaInteiros[i] = Integer.parseInt(sequencia[i]);
		}		
		return sequenciaInteiros;
	}
	
	 static class Heap {

	        private int[] heap;
	        private int tail;

	        public Heap(int capacity) {
	            this.heap = new int[capacity];
	            this.tail = -1;
	        }

	        private int left(int index) {
	            return 2*index+1;
	        }

	        private int right(int index) {
	            return 2*index+2;
	        }

	        private int parent(int index) {
	            return (index-1)/2;
	        }

	        private void swap(int indexA, int indexB) {
	        	
	            int aux = this.heap[indexA];
	            this.heap[indexA] = this.heap[indexB];
	            this.heap[indexB] = aux;
	            
	        }
	        
	        public void buildHeap(int[] heap) {
	            this.heap =heap;
	            this.tail = heap.length-1;

	            for (int i = parent(this.tail); i>=0; i--) {
	                this.heapify(i);
	            }
	        }
	        
	        private void heapify(int position) {
	            int left = left(position);
	            int right = right(position);
	            int largest;

	            if (left < this.tail+1 && this.heap[left] > this.heap[position]) {
	                largest = left;
	            } else {
	                largest = position;
	            }

	            if (right < this.tail+1 && this.heap[right] > this.heap[largest]) {
	                largest = right;
	            }

	            if (largest != position) {
	                swap(position, largest);
	                this.heapify(largest);
	            }
	        }
	        
	        public String toString() {
	            return Arrays.toString(this.heap);
	        }        
	 }

}
