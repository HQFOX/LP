public class Exp extends Instrucao_aritmetica{


	public void executa(CIMS maquina){
		
		int valor1 = maquina.pilhaAval.pop();
		int valor2 = maquina.pilhaAval.pop();
		
		double exp = Math.pow(valor1 , valor2);
		int resultado = (int) exp;
		maquina.pilhaAval.push(resultado);
		maquina.pc++;
		
	}

	public String toString(){
		return "exp";
	}
}
