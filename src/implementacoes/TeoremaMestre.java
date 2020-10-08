package implementacoes;
import java.util.Scanner;

	
public class TeoremaMestre {

		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			int a = sc.nextInt();
			
			int b = sc.nextInt();
			
			int ord = sc.nextInt();
			
			String theta = teoremaMestre(a, b, ord);
			
			System.out.println(theta);
		
		}

		private static String teoremaMestre(int a, int b, int ord) {
			
			String theta = "T(n) = theta(";

			double log = Math.log(a) / Math.log(b);
			
			int logInt = (int) log;
			
			
			if(ord < log) {
				
				theta += "n**" + logInt;
			}
			
			else if(ord == log) {
				theta += "n**" + ord  + " * log n";
			}
			
			else { // (ord > log)
				theta += "n**" + ord;
			}


			theta += ")";
			
			return theta;
			
	
		}

	}



