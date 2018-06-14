
import java.lang.*;

public class Sigual extends Instrucao_salto{

String e;

	public Sigual(String e)
	{
		this.e = e;
	}

	public void executa(CIMS maquina){
		
		int valor1 = maquina.pilhaAval.pop();
		int valor2 = maquina.pilhaAval.pop();
		
		if(valor2==valor1)
		{
			maquina.pc = maquina.etiquetas.get(e).posicao;
			maquina.pc++;
		}
		else if(valor1!=valor2){
			maquina.pc++;
		}
		
	}

	public String toString(){
		return "sigual" + e;
	}
}
