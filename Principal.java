package desafioM1Lab2;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int jogarNovamente = 1;
		
		do {
			//Instanciando o jogador1:
			System.out.println("Digite o nome do jogador 1: ");
			Jogador j1 = new Jogador(teclado.nextLine());
			//Instanciando o jogador2:
			System.out.println("Digite o nome do jogador 2: ");
			Jogador j2 = new Jogador(teclado.nextLine());
			
			//Instanciando o tabuleiro:
			System.out.println("Digite as dimensões do tabuleiro: ");
			System.out.println("[3] - 3x3 e [7] - 7x7");
			JogoDaVelha jV = new JogoDaVelha(teclado.nextInt());
			System.out.println("Tabuleiro iniciado!");		
			int jogadasTotais = jV.getQtdJogadas();
			
			for(int i = 1; i <= jogadasTotais; i++) {
				if(i%2 != 0) {
					System.out.println("Rodada do "+j1.getNome());
				}
				else {
					System.out.println("Rodada do "+j2.getNome());
				}
				System.out.println("Faça a "+i+"ª jogada!");
				jV.realizaJogada(teclado.nextInt(), teclado.nextInt(), teclado.next().charAt(0));
				jV.verificaGanhador();
				if(jV.getVencedor() == true) {
					System.out.println("Fim de jogo!");
					System.out.println("Quer jogar novamente? [1] - SIM [0] - NÃO");
					jogarNovamente = teclado.nextInt();
					while(jogarNovamente != 1 && jogarNovamente != 0) {
						System.out.println("Opção inválida, digite novamente: ");
						System.out.println("[1] - SIM [0] - NÃO");
						jogarNovamente = teclado.nextInt();
					}
					if(jogarNovamente == 0) {
						break;
					}
					else {
						i = jogadasTotais;
					}
				}
				if(i == jogadasTotais){
					if(jV.getVencedor() != true) {
						System.out.println("Fim de Jogo! EMPATE!");
						System.out.println("Quer jogar novamente? [1] - SIM [0] - NÃO");
						jogarNovamente = teclado.nextInt();
					}
				}			
			}//Fim for			
		}while(jogarNovamente==1);
		
		}//Fim main		
}//Fim classe
