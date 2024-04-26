package JogoDaVelha;

import java.util.Scanner;

public class JogoDaVelha {

	private static JogoDaVelha_Mapa jogoMapa;
	private static JogoDaVelha_Jogador jogoJogador;
	private static JogoDaVelha_PC jogoPc;
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		jogoMapa = new JogoDaVelha_Mapa();
		jogoJogador = new JogoDaVelha_Jogador(jogoMapa);
		jogoPc = new JogoDaVelha_PC(jogoMapa);
		
		
		while(true) {
		jogoMapa.limpaMapa();
		Jogar(teclado);	
		System.out.println("\n\n________________________\n Deseja jogar novamente (s/n)?");
		
		char c;
		
		do {
			c = teclado.next().charAt(0);
			if(c != 's' && c != 'n' ) System.out.println("Informe s ou n");
		}while(c != 's' && c != 'n');
		
		if(c == 'n') break;
		
		
		}

	}
	
	private static void Jogar(Scanner teclado) {
		int jogada = 0;
		
		while(true) {
			//Sorteiro para ver quem começa jogando
			if(jogoMapa.sortear(1, 100) < 50){
				//Caso PC
				while(true){
					jogoMapa.desenha(jogada++);
					if(jogada == 10) break;
					else if(jogoPc.joga()) break;
					jogoMapa.desenha(jogada++);
					if(jogada == 10) break;
					else if(jogoJogador.joga(teclado)) break;
			}
		}
			//Caso o jogador
			else {
				while(true) {
				jogoMapa.desenha(jogada++);
				if(jogada == 10) break;
				else if(jogoJogador.joga(teclado)) break;
				jogoMapa.desenha(jogada++);
				if(jogada == 10) break;
				else if(jogoPc.joga()) break;
				}
			}
		if(jogada == 10) {
			jogada--;
			jogoMapa.desenha(jogada);
			System.out.println("... EMPATOU!");
			break;
		}
		jogoMapa.desenha(jogada);
		break;
	}
	}
}
