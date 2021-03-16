package desafioM1Lab2;

import java.util.Scanner;
import java.util.Arrays;

public class JogoDaVelha {
	private char tabuleiro[][];
	private int dimensao;
	private int qtdJogadas;
	int seqX = 0;
	int seqO = 0;

	Scanner teclado = new Scanner(System.in);

	// Construtor da classe e inicializando o tabuleiro
	public JogoDaVelha(int dimensao) {
		while (dimensao != 3 && dimensao != 7) {
			System.out.println("Dimensão inválida, digite novamente.");
			dimensao = teclado.nextInt();
		}
		this.dimensao = dimensao;
		this.qtdJogadas = dimensao * dimensao;
		tabuleiro = new char[dimensao][dimensao];
	}

	public boolean realizaJogada(int l, int c, char z) {
		/* Verifica se a Linha ou Coluna é existente */
		while (l < 0 || l >= dimensao) {
			System.out.println("Linha inexistente. Digite novamente: ");
			l = teclado.nextInt();
			if(l > 0 && l < dimensao) {
				System.out.println("Linha corrigida.");
			}
		}
		while (c < 0 || c >= dimensao) {
			System.out.println("Coluna inexistente. Digite novamente: ");
			c = teclado.nextInt();
			if(c > 0 && c < dimensao) {
				System.out.println("Coluna corrigida.");
			}
		}
		/* Verifica se o caracter jogado é valido */
		String simbolosValidos = "XxoO";
		while (simbolosValidos.indexOf(z) == -1) {
			System.out.println("Simbolo inválido. Digite novamente: ");
			z = teclado.next().charAt(0);
		}
		/* Varre o array pra saber se a posição ja foi preenchida */
		for (int lin = l; lin < dimensao; lin++) {
			for (int col = c; col < dimensao;) {
				if (tabuleiro[lin][col] != 0) {
					System.out.println("Posição preenchida");
					return false;
				} else {
					tabuleiro[lin][col] = z;
					return true;
				}
			}
		}
		return true;
	}
	
	public boolean verificaGanhador() {
		/* Verificando se ganhador na diagonal principal esq/dir */
		for (int lin = 0; lin < tabuleiro.length; lin++) {
			for (int col = 0; col < tabuleiro.length; col++) {
				if (tabuleiro[lin][col] == 'x' || tabuleiro[lin][col] == 'X') {
					System.out.println("Posição " + lin + "x" + col + " preenchida com X");
					seqX++;
				} else if (tabuleiro[lin][col] == 'o' || tabuleiro[lin][col] == 'O') {
					System.out.println("Posição " + lin + "x" + col + " preenchida com O");
					seqO++;
				}
			}
		}
		// Se todas as posições tiverem preenchidas, define o vencedor.
		if (seqX == tabuleiro.length) {
			System.out.println("Jogador X ganhou!");
			return true;
		} else if (seqO == tabuleiro.length) {
			System.out.println("Jogador O ganhou!");
			return true;
		}

		/* Verificando se há ganhador na diagonal dir/esq */
		for (int lin = 0; lin < tabuleiro.length; lin++) {
			for (int col = tabuleiro.length - 1; col > 0; col--) {
				if (tabuleiro[lin][col] == 'x' || tabuleiro[lin][col] == 'X') {
					System.out.println("Posição " + lin + "x" + col + " preenchida com X");
					seqX++;
				} else if (tabuleiro[lin][col] == 'o' || tabuleiro[lin][col] == 'O') {
					System.out.println("Posição " + lin + "x" + col + " preenchida com O");
					seqO++;
				}
			}
		}

		/* Verificando se há vencedor nas linhas */
		int lin = 0;
		while (lin < tabuleiro.length) {
			for (int col = 0; col < tabuleiro.length; col++) {
				if (tabuleiro[lin][col] == 'x' || tabuleiro[lin][col] == 'X') {
					System.out.println("Posição " + lin + "x" + col + " preenchida com X");
					seqX++;
				} else if (tabuleiro[lin][col] == 'o' || tabuleiro[lin][col] == 'O') {
					System.out.println("Posição " + lin + "x" + col + " preenchida com O");
					seqO++;
				}
			}
			lin++;
		}

		/* Verifica se há vencedor nas colunas */
		int col = 0;
		while (col < tabuleiro.length) {
			for (; lin < tabuleiro.length; lin++) {
				if (tabuleiro[lin][col] == 'x' || tabuleiro[lin][col] == 'X') {
					System.out.println("Posição " + lin + "x" + col + " preenchida com X");
					seqX++;
				} else if (tabuleiro[lin][col] == 'o' || tabuleiro[lin][col] == 'O') {
					System.out.println("Posição " + lin + "x" + col + " preenchida com O");
					seqO++;
				}
			}
			col++;
		}

		// Se todas as posições tiverem preenchidas, define o vencedor.
		if (seqX == tabuleiro.length) {
			System.out.println("Jogador X ganhou!");
			return true;
		} else if (seqO == tabuleiro.length) {
			System.out.println("Jogador O ganhou!");
			return true;
		}
		return false;
	}
	
	// Métodos getters e setters
	public void setDimensao(char dimensao) {
		// System.out.println("Digite seu novo caracter de jogo: ");
		this.dimensao = dimensao;
	}

	public int getDimensao() {
		System.out.println(dimensao);
		return dimensao;
	}

	public int getQtdJogadas() {
		System.out.println(qtdJogadas);
		return qtdJogadas;
	}

	@Override
	public String toString() {
		return "JogoDaVelha [tabuleiro=" + Arrays.toString(tabuleiro) + ", dimensao=" + dimensao + ", qtdJogadas="
				+ qtdJogadas + ", seqX=" + seqX + ", seqO=" + seqO + ", teclado=" + teclado + ", verificaGanhador()="
				+ verificaGanhador() + ", getDimensao()=" + getDimensao() + ", getQtdJogadas()=" + getQtdJogadas()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
