import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("Olá, Seja Bem Vindo");
		int moedas[]= {1,5,10,25,50,100, 200,500, 1000, 2000,5000,10000}; // Valores em centavos

		System.out.println("\nEntre com o valor a calcula o mapa de troco: ");
		Scanner leitor= new java.util.Scanner(System.in);
		int valor =0;
		try {
			valor=(int)(leitor.nextDouble()*100); // Converte o valor para centavos

		}catch(Exception erro){
			System.out.println("Valor invalido. Digite numero inteiro.");	
		}
		List<TrocoMoeda> troco = troco(moedas, valor);
        for (int i = 0; i < troco.size(); i++) {
            TrocoMoeda trocoMoeda = troco.get(i);
            if(trocoMoeda.moeda >= 200) {
                System.out.println("Nota: " + trocoMoeda.moeda/100.0 + ", Quantidade: " + trocoMoeda.quantidade);
            } else {
                System.out.println("Moeda: " + trocoMoeda.moeda/100.0 + ", Quantidade: " + trocoMoeda.quantidade);
            }
        }


	}
	 public static List<TrocoMoeda> troco(int[] moedas, int valor) {
	        List<TrocoMoeda> troco = new ArrayList<>();
	        List<Integer> moedasList = new ArrayList<>();// converte o vetor moedas para list para podemos utlizar o método de  ordena e reverter
	        for (int i = 0; i < moedas.length; i++) {
	            moedasList.add(moedas[i]);
	        }
	        Collections.sort(moedasList);
	        Collections.reverse(moedasList);
	        for (int i = 0; i < moedasList.size(); i++) {
	            int moeda = moedasList.get(i);
	            int quantidade = valor / moeda;
	            if (quantidade > 0) {
	                troco.add(new TrocoMoeda(moeda, quantidade));
	                valor -= moeda * quantidade;
	            }
	        }
	        return troco;
	 }
}
