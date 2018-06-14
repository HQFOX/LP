public class Smenor extends Instrucao_salto{


String e;

	public Smenor(String e)
	{
		this.e = e;

	}

	public void executa(CIMS maquina){
		
		int valor1 = maquina.pilhaAval.pop();
		int valor2 = maquina.pilhaAval.pop();
		
		if(valor1 > valor2)
		{
			maquina.pc = maquina.etiquetas.get(e).posicao;	
			maquina.pc++;
		}
		else{
			maquina.pc++;
		}
		
	}
	public String toString(){
		return "smenor";
	}
}
