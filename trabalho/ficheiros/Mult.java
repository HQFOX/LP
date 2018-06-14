public class Mult extends Instrucao_aritmetica{

	public void executa(CIMS maquina){
		
		int valor1 = maquina.pilhaAval.pop();
		int valor2 = maquina.pilhaAval.pop();
		
		int mult = valor1 * valor2;
		maquina.pilhaAval.push(mult);
		maquina.pc++;
		
	}


	public String toString(){
		return "mult";
	}
}
