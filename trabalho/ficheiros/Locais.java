public class Locais extends Instrucao_chamada{

int argumentos;	//argumentos
int variaveis;	//variaveis

	public Locais(int argumentos, int variaveis)
	{
		this.argumentos = argumentos;
		this.variaveis = variaveis;
	}

	public void executa(CIMS maquina){
		

		RegistoAtivacao reg = new RegistoAtivacao(argumentos , variaveis , maquina.pcTemp , maquina.AA);
		
		maquina.blocos.push(reg);
		maquina.AA = reg;
		int j = argumentos;
		int i = 0;
		while(j>0){
			//~ maquina.AA.args.add(i,maquina.args.pop());
			maquina.AA.args[i] = maquina.args.pop();
			i++;
			j--;
		}
			
		//~ reg.print();	
		maquina.pc++;
		
	}

	public String toString(){
		return "locais " + argumentos +" "+ variaveis;
	}
}
