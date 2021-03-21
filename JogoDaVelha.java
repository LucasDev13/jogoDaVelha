package desafioM1Lab2;

import java.util.Scanner;
import java.util.Arrays;

public class JogoDaVelha {
	private char tabuleiro[][];
	private int dimensao;
	private int qtdJogadas;
	private int jogadasTotais = qtdJogadas;
	private boolean vencedor = false;
	int seqX = 0;
	int seqO = 0;
	int lin = 0;
	int col = 0;

	Scanner teclado = new Scanner(System.in);
	Jogador j1 = new Jogador("");
	Jogador j2 = new Jogador("");

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
			System.out.println("Digite a nova linha: ");
			l = teclado.nextInt();
			if(l > 0 && l < dimensao) {
				System.out.println("Linha corrigida.");
			}
		}
		while (c < 0 || c >= dimensao) {
			System.out.println("Coluna inexistente. Digite novamente: ");
			System.out.println("Digite a nova coluna: ");
			c = teclado.nextInt();
			if(c > 0 && c < dimensao) {
				System.out.println("Coluna corrigida.");
			}
		}
		/* Verifica se o caracter jogado é valido */
		String simbolosValidos = "XxoO";
		while (simbolosValidos.indexOf(z) == -1) {
			System.out.println("Simbolo inválido. Digite novamente: ");
			System.out.println("Digite o simbolo correto: ");
			z = teclado.next().charAt(0);
		}
		/* Varre o array pra saber se a posição ja foi preenchida */
		for (int lin = l; lin < dimensao; lin++) {
			for (int col = c; col < dimensao;) {
				while (tabuleiro[lin][col] != 0) {
					System.out.println("Posição preenchida");
					System.out.println("Jogue em outra posição. Digite a nova linha: ");
					l = teclado.nextInt();
					System.out.println("Digite a nova coluna: ");
					c = teclado.nextInt();
					System.out.println("Digite o simbolo correto: ");
					z = teclado.next().charAt(0);
					tabuleiro[l][c] = z;
					qtdJogadas--;
					return false;
				}
				tabuleiro[lin][col] = z;
				qtdJogadas--;
				return true;
			}
		}
		return true;
	}
	
	public boolean verificaGanhador() {
		/* Verificando se ganhador na diagonal principal esq/dir */
		seqX = 0;
		seqO = 0;
		for (int lin = 0, col = 0; col < tabuleiro.length; col++, lin++) {
			if (tabuleiro[lin][col] == 'x' || tabuleiro[lin][col] == 'X') {
				seqX++;// conta quantos 'x' foram encontrados.
			} else if (tabuleiro[lin][col] == 'o' || tabuleiro[lin][col] == 'O') {
				seqO++;// conta quantos 'o' foram encontrados.
			}
		}

		// Se todas as posições tiverem preenchidas, define o vencedor.
		if (seqX == tabuleiro.length) {
			System.out.println("Jogador X ganhou!");
			qtdJogadas = 0;
			vencedor = true;
			j1.setPontos(1);
			return true;
		} else if (seqO == tabuleiro.length) {
			System.out.println("Jogador O ganhou!");
			vencedor = true;
			qtdJogadas = 0;
			j2.setPontos(1);
			return true;
		}

		/* Verificando se há ganhador na diagonal dir/esq */
		seqX = 0;
		seqO = 0;
		for (int lin = 0, col = tabuleiro.length - 1; col >= 0; lin++, col--) {
			if (tabuleiro[lin][col] == 'x' || tabuleiro[lin][col] == 'X') {
				seqX++;
			} else if (tabuleiro[lin][col] == 'o' || tabuleiro[lin][col] == 'O') {
				seqO++;
			}
		}

		// Se todas as posições tiverem preenchidas, define o vencedor.
		if (seqX == tabuleiro.length) {
			System.out.println("Jogador X ganhou!");
			qtdJogadas = 0;
			vencedor = true;
			j1.setPontos(1);
			return true;
		} else if (seqO == tabuleiro.length) {
			System.out.println("Jogador O ganhou!");
			qtdJogadas = 0;
			vencedor = true;
			j2.setPontos(1);
			return true;
		}

		/* Verificando se há vencedor nas linhas */
		seqX = 0;
		seqO = 0;
		lin = 0;
		while (lin < tabuleiro.length) {
			seqX = 0;
			seqO = 0;
			col = 0;
			for (col = 0; col < tabuleiro.length; col++) {
				if (tabuleiro[lin][col] == 'x' || tabuleiro[lin][col] == 'X') {
					seqX++;
					if (seqX == tabuleiro.length) {
						System.out.println("Jogador X ganhou!");
						qtdJogadas = 0;
						vencedor = true;
						j1.setPontos(1);
						return true;
					} 
				} else if (tabuleiro[lin][col] == 'o' || tabuleiro[lin][col] == 'O') {
					seqO++;
					if (seqO == tabuleiro.length) {
						System.out.println("Jogador O ganhou!");
						qtdJogadas = 0;
						vencedor = true;
						j2.setPontos(1);
						return true;
					}
				}
			}
			lin++;
		}
		
		/* Verifica se há vencedor nas colunas */
		seqX = 0;
		seqO = 0;
		col = 0;
		while (col < tabuleiro.length) {
			seqX = 0;
			seqO = 0;
			lin = 0;
			for (lin = 0; lin < tabuleiro.length; lin++) {
				if (tabuleiro[lin][col] == 'x' || tabuleiro[lin][col] == 'X') {
					seqX++;
					if (seqX == tabuleiro.length) {
						System.out.println("Jogador X ganhou!");
						qtdJogadas = 0;
						vencedor = true;
						j1.setPontos(1);
						return true;
					} 
				} else if (tabuleiro[lin][col] == 'o' || tabuleiro[lin][col] == 'O') {
					seqO++;
					if (seqO == tabuleiro.length) {
						System.out.println("Jogador O ganhou!");
						qtdJogadas = 0;
						vencedor = true;
						j2.setPontos(1);
						return true;
					}
				}
			}
			col++;
		}
		
		return false;
	}
	
	// Métodos getters e setters
	public void setDimensao(char dimensao) {
		// System.out.println("Digite seu novo caracter de jogo: ");
		this.dimensao = dimensao;
	}
	
	public int getDimensao() {
		return dimensao;
	}

	public int getQtdJogadas() {
		return qtdJogadas;
	}	
	public boolean getVencedor() {
		return vencedor;
	}

	@Override
	public String toString() {
		return "JogoDaVelha [tabuleiro=" + Arrays.toString(tabuleiro) + ", dimensao=" + dimensao + ", qtdJogadas="
				+ qtdJogadas + ", jogadasTotais=" + jogadasTotais + ", vencedor=" + vencedor + ", seqX=" + seqX
				+ ", seqO=" + seqO + ", lin=" + lin + ", col=" + col + ", teclado=" + teclado + ", verificaGanhador()="
				+ verificaGanhador() + ", getDimensao()=" + getDimensao() + ", getQtdJogadas()=" + getQtdJogadas()
				+ ", getVencedor()=" + getVencedor() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
}