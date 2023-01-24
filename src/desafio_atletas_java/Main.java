package desafio_atletas_java;

import java.util.Scanner;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		String nome;
		String maisAlto = "";
		char sexo;
		int qtdAtletas, i;
		int contagemHomens = 0;
		int contagemMulheres = 0;
		double altura, peso;
		double alturaAnterior = 0;
		double pesoMedio = 0;
		double pctHomens = 0;
		double alturaMulheres = 0;
		double altMediaMulheres = 0;
		
		System.out.print("Qual a quantidade de atletas? ");
		qtdAtletas = sc.nextInt();
		
		
		for(i = 0; i < qtdAtletas; i++) {
			sc.nextLine();
			System.out.println("Digite os dados do atleta número " + (i+1) + ":");
			System.out.print("Nome: ");
			nome = sc.nextLine();
			
			System.out.print("Sexo: ");
			sexo = sc.next().charAt(0);
			if(sexo != 'F' && sexo != 'M') {
				while(sexo != 'F' && sexo != 'M') {
					System.out.print("Valor inválido! Favor digitar F ou M: ");
					sexo = sc.next().charAt(0);
				}
			}
			if(sexo == 'F') {
				contagemMulheres += 1;
			}
			else {
				if(sexo == 'M') {
					contagemHomens += 1;
				}
			}
		
			System.out.print("Altura: ");
			altura = sc.nextDouble();
			if(altura <= 0) {
				while(altura <= 0) {
					System.out.print("Valor inválido! Favor digitar um valor positivo: ");
					altura = sc.nextDouble();
				}
			}
			
			if(altura > alturaAnterior) {
				alturaAnterior = altura;
				maisAlto = nome;
			}
			
			if(sexo == 'F') {
				alturaMulheres = alturaMulheres + altura;
			}
			
			System.out.print("Peso: ");
			peso = sc.nextDouble();
			if(peso <= 0) {
				while(peso <= 0) {
					System.out.print("Valor inválido! Favor digitar um valor positivo: ");
					peso = sc.nextDouble();
				}
			}
			pesoMedio = pesoMedio + peso;
			
		}
		
		pesoMedio = pesoMedio / qtdAtletas;
		pctHomens = (double)(contagemHomens * 100) / qtdAtletas;
		
		System.out.println();
		System.out.println("RELATÓRIO: ");
		System.out.println();
		System.out.printf("Peso médio dos atletas: %.2f%n", pesoMedio);
		System.out.printf("Atleta mais alto: %s%n", maisAlto);
		System.out.printf("Porcentagem de homens: %.1f %%%n", pctHomens);
		if(contagemMulheres == 0) {
			System.out.println("Não há mulheres cadastradas");
		}
		else {
			altMediaMulheres = alturaMulheres / contagemMulheres;
			System.out.printf("Altura média das mulheres: %.2f%n", altMediaMulheres);
		}
		
		sc.close();
	}

}
