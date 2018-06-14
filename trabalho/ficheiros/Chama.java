public class Chama extends Instrucao_chamada{

int a;
String e;

	public Chama(int a, String e)
	{
		this.a = a;
		this.e = e;
	}
	
	public void executa(CIMS maquina)
	{
		maquina.pc++;
		
		maquina.pcTemp = maquina.pc++;
		
		Etiquetas proxEtiqueta = maquina.etiquetas.get(e);	
		
		maquina.pc = proxEtiqueta.posicao;
		
		maquina.pc++;
		
	}

	public String toString(){
		return "chama " + a + " "+ e;
	}
}
