public class Mod extends Instrucao_aritmetica{


	public void executa(CIMS maquina){
		
		int valor1 = maquina.pilhaAval.pop();
		int valor2 = maquina.pilhaAval.pop();
		
		int mod = valor1 % valor2;
		maquina.pilhaAval.push(mod);
		maquina.pc++;
		
	}

	public String toString(){
		return "mod";
	}
}
