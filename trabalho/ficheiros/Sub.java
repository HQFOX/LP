public class Sub extends Instrucao_aritmetica{



	public void executa(CIMS maquina){
		
		int valor1 = maquina.pilhaAval.pop();
		int valor2 = maquina.pilhaAval.pop();
		
		int sub = valor2 - valor1;
		maquina.pilhaAval.push(sub);
		maquina.pc++;
		
	}

	public String toString(){
		return "sub";
	}
}
