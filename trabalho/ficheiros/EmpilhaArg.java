public class EmpilhaArg extends Instrucao_acesso{

int a;

int b;

	public EmpilhaArg(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	
	public void executa(CIMS maquina){
		RegistoAtivacao temp = maquina.AA;
		while(a>0)
		{
			if(temp.ControlLink!=null)
			{
				temp = temp.ControlLink;
				a--;
			}
		}
		//se A for zero	
		maquina.pilhaAval.push(temp.args[b-1]);
		
		maquina.pc++;
	}
		
	public String toString()
	{
		return "empilha arg " + a + " " + b ;
	}
}
