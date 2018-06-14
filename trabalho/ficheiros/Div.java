public class Div extends Instrucao_aritmetica{

	public void executa(CIMS maquina){
		
		int valor1 = maquina.pilhaAval.pop();
		int valor2 = maquina.pilhaAval.pop();
		
		int div = valor2 / valor1;
		maquina.pilhaAval.push(div);
		maquina.pc++;
		
	}


	public String toString(){
		return "div";
	}
}
