package desafioM1Lab2;

public class Jogador{
	private String nome = "";
	private int pontos;		
	
	public Jogador(String nome) {		
		this.nome = nome;
		this.pontos = 0;
	}
	
	public String getNome() {
		return nome;
	}	
	public int getPontos() {
		System.out.println(pontos);
		return pontos;
	}
	
	public void setNome(String nome) {
		System.out.println("Digite seu nome: ");
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", pontos=" + pontos + "]";
	}	
	
	
}
