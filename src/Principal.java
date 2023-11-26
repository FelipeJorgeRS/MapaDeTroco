import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		System.out.println("Olá, Seja Bem Vindo");
		int notas[]= {1,5, 10, 20, 50, 100, 200};
		double moedas[]= {0.01, 0.10, 0.25, 0.50};
		
		System.out.println("\nEntre com o valor a calcula o mapa de troco: ");
		Scanner leitor= new java.util.Scanner(System.in);
		double valor =0.0;
		try {
			valor=leitor.nextDouble();
		
		}catch(Exception erro){
			System.out.println("Valor invalido. Digite numero inteiro.");	
		}
		List<TrocoNota> trocoNotas = trocoNotas(notas, valor);
        for (int i = 0; i < trocoNotas.size(); i++) {
            TrocoNota trocoNota = trocoNotas.get(i);
            System.out.println("Nota: " + trocoNota.nota + ", Quantidade: " + trocoNota.quantidade);
        }
        List<TrocoMoeda> trocoMoedas = trocoMoedas(moedas, valor%100);
        for (int i = 0; i < trocoMoedas.size(); i++) {
            TrocoMoeda trocoMoeda = trocoMoedas.get(i);
            System.out.println("Moeda: " + trocoMoeda.moeda + ", Quantidade: " + trocoMoeda.quantidade);
        }
	
	}
	 private static List<TrocoMoeda> trocoMoedas(double[] moedas, double valor) {
		 List<TrocoMoeda> troco = new ArrayList<>();
	        List<Double> moedasList = new ArrayList<>();
	        for (int i = 0; i < moedas.length; i++) {
	        	moedasList.add(moedas[i]);
	        }
	        Collections.sort(moedasList);
	        Collections.reverse(moedasList);
	        for (int i = 0; i < moedasList.size(); i++) {
	            double moeda = moedasList.get(i);
	            double quantidade = valor / moeda;
	            if (quantidade > 0) {
	                troco.add(new TrocoMoeda(moeda, quantidade));
	                valor -= moeda * quantidade;
	            }
	        }
	        return troco;
	 }		
	
	public static List<TrocoNota> trocoNotas(int[] notas, double valor) {
	        List<TrocoNota> troco = new ArrayList<>();
	        List<Integer> notasList = new ArrayList<>();
	        for (int i = 0; i < notas.length; i++) {
	            notasList.add(notas[i]);
	        }
	        Collections.sort(notasList);
	        Collections.reverse(notasList);
	        for (int i = 0; i < notasList.size(); i++) {
	            int nota = notasList.get(i);
	            int quantidade = (int) (valor / nota);
	            if (quantidade > 0) {
	                troco.add(new TrocoNota(nota, quantidade));
	                valor -= nota * quantidade;
	            }
	        }
	        return troco;
	 }
}