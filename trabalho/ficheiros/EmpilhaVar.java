public class EmpilhaVar extends Instrucao_acesso{

int a; //profundidade

int b; //index da variavel
	//mete o valor nessas coordenadas na pilha de avaliacao

	public EmpilhaVar(int a, int b)
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
		maquina.pilhaAval.push(temp.vars[b-1]);
		
		maquina.pc++;
	}
		
	public String toString(){
		return "empilha var " + a + " " + b ;
	}
}
