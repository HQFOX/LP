public class EscreveStr extends Instrucao_saida{

	String str;

	public EscreveStr(String str)
	{
		this.str = str;
	}

	public void executa(CIMS maquina){
		
		System.out.print(" " + str + " ");
		maquina.pc++;
		
	}

	public String toString(){
		return "escreve str" + str;
	}
}
