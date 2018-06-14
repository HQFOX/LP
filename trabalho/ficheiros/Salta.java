public class Salta extends Instrucao_salto{

	String e;

	public Salta(String e)
	{
	   this.e = e;
	}
		
	public void executa(CIMS maquina){
		maquina.pc = maquina.etiquetas.get(e).posicao;	
		maquina.pc++;	
	}

	public String toString(){
		return "salta " + e;
	}
}
