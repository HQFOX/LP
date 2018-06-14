public class Soma extends Instrucao_aritmetica{



	public void executa(CIMS maquina){
		
		int valor1 = maquina.pilhaAval.pop();
		int valor2 = maquina.pilhaAval.pop();
		
		int soma = valor1 + valor2;
		maquina.pilhaAval.push(soma);
		maquina.pc++;
		
	}

	public String toString(){
		return "soma";
	}
}
