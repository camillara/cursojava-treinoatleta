import java.util.Scanner;

public class TreinosUsain {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		double[][] treinamentos = new double[7][10];
		double[] vetor = new double[7];
		String[] evolucao = new String[7];
		double []media = new double[7];
		double soma = 0.0, melhorTempo = 0.0;

		System.out.println("Informe o tempo do Usain:");
		for (int i = 0; i < treinamentos.length; i++) {
			for (int j = 0; j < treinamentos[i].length; j++) {
				System.out.printf("%dº dia - Treino: %d - Tempo: ", i + 1, j + 1);
				treinamentos[i][j] = entrada.nextDouble();
				if (treinamentos[i][j] <= 0) {
					System.out.println("O valor deve ser positivo!");
					j = j - 1;
				}
			}
			System.out.println();
		}
		
		System.out.println();
		
		//=========letra a) calcular media desempenho diário
		for(int i=0; i<treinamentos.length; i++) {
			for(int j=0; j<treinamentos[i].length; j++) {
				soma+=treinamentos[i][j];
			}
			media[i]=(soma/10);// valor de soma dos tempos dividido pela quantidade de treinos diários
			System.out.printf("Média do %dº dia: %.2f\n", i + 1, media[i]);
			soma=0;
		}
		
		
		System.out.println();
		//=========letra b) calcular melhor treino do dia

		for (int i = 0; i < treinamentos.length; i++) {
			melhorTempo = treinamentos[i][0];
			for (int j = 0; j < treinamentos[i].length; j++) {
				if (treinamentos[i][j] < melhorTempo) {
					melhorTempo = treinamentos[i][j];
				}
				vetor[i] = melhorTempo;
			}
			System.out.printf("Melhor treino do %dº dia: %.2f\n", i + 1, vetor[i]);
		}

		System.out.println();
		
		//=========letra c)comparar evolução dias
		evolucao[0] = ("Início");
		System.out.printf("1º dia - melhor tempo: %.2f -  %s\n", vetor[0], evolucao[0]);
		for (int i = 1; i < vetor.length; i++) {
			if (vetor[i - 1] > vetor[i]) {
				evolucao[i] = ("Houve melhora de desempenho");
			} else if (vetor[i - 1] == vetor[i]) {
				evolucao[i] = ("Manteve o desempenho");
			} else {
				evolucao[i] = ("Piorou o desempenho");
			}
			System.out.printf("%dº dia - melhor tempo: %.2f -  %s \n", i + 1, vetor[i], evolucao[i]);
		}

		entrada.close();
	}
}