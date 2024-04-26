package JogoDaVelha;

import java.util.Scanner;

public class JogoDaVelha_Jogador {

	private JogoDaVelha_Mapa mapa;
	private char letra;
	
	//Construtor de classe
	public JogoDaVelha_Jogador(JogoDaVelha_Mapa mapa) {
		this.mapa = mapa;
		this.letra = 'X';
	}
	
	//Se o jogador ganhar, retorna true.
	public boolean joga(Scanner teclado) {
		System.out.print("Jogador . .");
		
		//While está ai para permitir que só execute a jogada se for válido
		while(true){
			//try para executar execções personalizadas e trabalhar com as exceções padrões
			try {
						
			
			System.out.println("\n linha: ");
			int linha = Integer.parseInt(teclado.next());
			if(linha > 2 || linha < 0) throw new Exception("Insira uma linha de 0 a 2");
			
			System.out.println(" coluna: ");
			int coluna = Integer.parseInt(teclado.next());
			if(coluna > 2 || coluna < 0) throw new Exception("Insira uma coluna de 0 a 2");
			
			 if(!mapa.jogar(linha, coluna, letra)) {
				 throw new Exception("Erro ao jogar");
			 }
			
			 
			 if(mapa.ganhou(letra)) {
				 
				 return true;
			 }
			 
			
			break;
		}catch(Exception ex) {
			System.out.print(ex.getMessage());
		}
		
	}
		return false;

	}
}
