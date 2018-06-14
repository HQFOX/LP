public class EmpilhaInt extends Instrucao_manipulacao{

int a;


	public EmpilhaInt(int a)
	{
		this.a = a;
	}
	
	public void executa(CIMS maquina){
	
		maquina.pilhaAval.push(a);
		
		maquina.pc++;
	}
		
	public String toString()
	{
		return "empilha " + a;
	}
}
