public class MudaLinha extends Instrucao_saida{


	public void executa(CIMS maquina){
		
		System.out.println();
		
		maquina.pc++;
	}
		

	public String toString(){
		return "muda linha";
	}
}
