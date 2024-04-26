package JogoDaVelha;

public class JogoDaVelha_Mapa {

	private char[][] mapa = new char[3][3];
	
	public int sortear(int inicio, int fim) {

		//Gera um número aleatório baseando-se nos milisegundos atuais
		
		return (int)((1231231* System.currentTimeMillis() + 1912312)%fim);
	}
	
	public void limpaMapa() {
		//Limpa todo o mapa
		for(int linha = 0; linha < 3;linha++) {
			for(int coluna = 0; coluna < 3; coluna++) {
				mapa[linha][coluna] = ' ';
			}
		}
	}
	
	public void desenha(int jogada) {
		
					
		System.out.print("------------- .. jogada: " + jogada);
	
		for(char[] linha:mapa) {
			System.out.print("\n| ");
			for(char coluna:linha) {
				System.out.print(coluna + " | ");
		
			}
			
			System.out.print("\n-------------");
		}
		System.out.println("----------------");
	}
	
	public boolean jogar(int l, int c, char jogador) {
		
		//Verifica se a casa está vazia para jogar, se não estiver não permite a jogada
		if(mapa[l][c] == ' ') {
			mapa[l][c] = jogador;
			if(jogador == 'O') {
				System.out.printf("PC[%d,%d]\n",l,c);
			}
			
			if(ganhou(jogador) && jogador == 'X') {
				System.out.println("... Jogador GANHOU!");
			}
			else if(ganhou(jogador) && jogador == 'O') System.out.println("... PC GANHOU!");
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean ganhou(char jogador) {
		
		//Loop para verificar as linhas e colunas 
		for(int i = 0; i < 3; i++) {
			if(mapa[i][0] == jogador && mapa[i][1] == jogador && mapa[i][2] == jogador) {
				return true;
			}
			if(mapa[0][i] == jogador && mapa[1][i] == jogador && mapa[2][i] == jogador) {
				return true;
			}
		}
		
		// Verifica as diagonais
		if((mapa[0][0] == jogador && mapa[1][1] == jogador && mapa[2][2] == jogador) ||
				(mapa[2][0] == jogador && mapa[1][1] == jogador && mapa[0][2] == jogador)) {
			return true;
		}
			
		return false;
		
		
	}
}
