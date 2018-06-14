public class AtribuiVar extends Instrucao_acesso{

int a; //profundidade

int b; //index da variavel
	//mete o valor da pilha de avaliacao na variavel com esse index

	public AtribuiVar(int a, int b)
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
		temp.print();
		temp.vars[b-1] = maquina.pilhaAval.pop();
		
		maquina.pc++;
	}
	public String toString(){
		return "atribui var" + a + " " + b ;
	}
}
