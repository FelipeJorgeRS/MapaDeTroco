import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class Principal {
	
	public static void main(String[] args) {
		
		System.out.println("Olá, Seja Bem Vindo");
		int moedas[]= {1, 2, 5, 10, 20, 50, 100, 200};
		
		System.out.println("\nEntre com o valor a calcula o mapa de troco: ");
		Scanner leitor= new java.util.Scanner(System.in);
		int valor =0;
		try {
			valor=leitor.nextInt();
		
		}catch(Exception erro){
			System.out.println("Valor invalido. Digite numero inteiro.");	
		}
		List<TrocoMoeda> troco = troco(moedas, valor);
        for (TrocoMoeda trocoMoeda : troco) {
            System.out.println("Moeda: " + trocoMoeda.moeda + ", Quantidade: " + trocoMoeda.quantidade);
        }
        
	
	}
	 public static List<TrocoMoeda> troco(int[] moedas, int valor) {
	        List<TrocoMoeda> troco = new ArrayList<>();
	        List<Integer> moedasList = new ArrayList<>();// convberte o vetor moedas para list para podemos utlizar o método de  ordena e reverter
	        for (int moeda : moedas) {
	            moedasList.add(moeda);
	        }
	        Collections.sort(moedasList);
	        Collections.reverse(moedasList);
	        for (int moeda : moedasList) {
	            int quantidade = valor / moeda;
	            if (quantidade > 0) {
	                troco.add(new TrocoMoeda(moeda, quantidade));
	                valor -= moeda * quantidade;
	            }
	        }
	        return troco;
	 }
}








