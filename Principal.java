package desafioM1Lab2;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);	
		//Instanciando o jogador1:
		System.out.println("Digite o nome do jogador 1: ");
		Jogador j1 = new Jogador(teclado.nextLine());
		System.out.println("Digite o nome do jogador 2: ");
		Jogador j2 = new Jogador(teclado.nextLine());
		
		//Instanciando o tabuleiro:
		System.out.println("Digite as dimensões do tabuleiro: ");
		System.out.println("[3] - 3x3 e [7] - 7x7");
		JogoDaVelha jV = new JogoDaVelha(teclado.nextInt());
		System.out.println("Tabuleiro iniciado!");		
		System.out.println("O jogo tem "+jV.getQtdJogadas()+" jogadas restantes");		
		System.out.println("Faça a primeira jogada: ");		
		jV.realizaJogada(teclado.nextInt(), teclado.nextInt(), teclado.next().charAt(0));
		jV.realizaJogada(teclado.nextInt(), teclado.nextInt(), teclado.next().charAt(0));
		jV.realizaJogada(teclado.nextInt(), teclado.nextInt(), teclado.next().charAt(0));
		jV.verificaGanhador();
		
	}

}
