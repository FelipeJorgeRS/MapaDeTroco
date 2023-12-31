import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("Ol�, Seja Bem Vindo");
		int moedas[]= {1,5,10,25,50,100, 200,500, 1000, 2000,5000,10000}; // Valores em centavos

		Scanner leitor= new java.util.Scanner(System.in);
		System.out.println("Digite a quantidade de funcion�rios a calcular o sal�rio");
		int quantidaeFuncionarios=0;
		quantidaeFuncionarios= leitor.nextInt();

		for(int i = 0; i < quantidaeFuncionarios; i++) {
			System.out.print("Entre com o valor do sal�rio do funcion�rio " + (i+1) + ": ");
			int valor =0;
			try {
				valor=(int)(leitor.nextDouble()*100); // Converte o valor para centavos

			}catch(Exception erro){
				System.out.println("Valor invalido. Digite numero inteiro.");	
			}
			List<TrocoMoeda> troco = troco(moedas, valor);
			for (int j = 0; j < troco.size(); j++) {
				TrocoMoeda trocoMoeda = troco.get(j);
				if(trocoMoeda.moeda >= 200) {  // imprime as notas.
					//A l�gia � que se o valor em centavos � mmaior ou igual a 200, ent�o j� tenho uma nota de 2 reais.
					System.out.println("Funcion�rio " + (i+1) + " - Nota: " + trocoMoeda.moeda/100.0 + ", Quantidade: " + trocoMoeda.quantidade);
				} else {
					System.out.println("Funcion�rio " + (i+1) + " - Moeda: " + trocoMoeda.moeda/100.0 + ", Quantidade: " + trocoMoeda.quantidade);
				}
				
			} System.out.println("");// linha vazia que separa os funcion�rios
		}			

	}

	public static List<TrocoMoeda> troco(int[] moedas, int valor) {
		List<TrocoMoeda> troco = new ArrayList<>();
		List<Integer> moedasList = new ArrayList<>();// converte o vetor moedas para list para podemos utlizar o m�todo de  ordena e reverter
		for (int i = 0; i < moedas.length; i++) {
			moedasList.add(moedas[i]);
		}
		Collections.sort(moedasList); // ordena a lista de moedae e notas
		Collections.reverse(moedasList); // reverte a ordem. isto � nesses�rio para que o algoritmo guloso possa pegar sempre a maior nota primeirro
		for (int i = 0; i < moedasList.size(); i++) {
			int moeda = moedasList.get(i);
			int quantidade = valor / moeda; // este comando calcula a quantidade de moedas com base no valor
			if (quantidade > 0) { // 
				troco.add(new TrocoMoeda(moeda, quantidade));// adciona a moeda ja on=btida a lista de resultados
				valor -= moeda * quantidade; // calcula o valor do salario que ainda sobra para fazer o troco
			}
		}
		return troco;
	}
}
