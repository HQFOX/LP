public class AtribuiArg extends Instrucao_acesso{

int a;
int b;
	public AtribuiArg(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	
		public void executa(CIMS maquina){
		
		RegistoAtivacao temp = maquina.AA;
		while(a>0)
		{
			temp = temp.ControlLink;
		}
		//se A for zero	
		//~ temp.args.set(b,maquina.pilhaAval.pop());
		temp.args[b-1] = maquina.pilhaAval.pop();
		
		maquina.pc++;
	}

	public String toString(){
		return "coloca arg" + a + " " + b ;
	}
}
