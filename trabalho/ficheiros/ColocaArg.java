public class ColocaArg extends Instrucao_chamada{

int a;
	public ColocaArg(int a)
	{
		this.a = a;
	}
	
	
	public void executa(CIMS maquina){
		
		maquina.args.push(maquina.pilhaAval.pop());
		maquina.pc++;
		
	}
	public String toString(){
		return "coloca arg" + a;
	}
}
