public class EscreveInt extends Instrucao_saida{

	public void executa(CIMS maquina){
		
		int valor = maquina.pilhaAval.pop();
		
		System.out.print(" " + valor + " ");
	
		maquina.pc++;
	
	}
		


	public String toString(){
		return "escreve int";
	}
}
