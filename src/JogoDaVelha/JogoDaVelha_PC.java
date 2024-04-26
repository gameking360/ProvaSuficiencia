package JogoDaVelha;


public class JogoDaVelha_PC {

	private JogoDaVelha_Mapa mapa;
	private char letra;
	
	//Construtor de classe
	public JogoDaVelha_PC(JogoDaVelha_Mapa mapa) {
		this.mapa = mapa;
		this.letra = 'O';
	}
	
	public boolean joga() {
		
		//Ficar executando até o computador realizar uma ação válida
		do {	
			
			int linha = mapa.sortear(0, 3);
			int coluna = mapa.sortear(0, 3);
			
			
			if(linha >2 || coluna > 2 || !mapa.jogar(linha, coluna, letra)) {
				
			
			while(!mapa.jogar(linha, coluna, letra)) {
				linha = mapa.sortear(0, 3);
				coluna = mapa.sortear(0, 3);
			}
			
			}
				
				mapa.jogar(linha, coluna, letra);
								
				//Caso a jogada dê a vitória, retorna verdadeiro
				if(mapa.ganhou(letra)) {
					
					return true;
				}
				
			
				break;
			
		}while(true);
		return false;
	}
	
}
