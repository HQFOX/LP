
// Conjunto de Instrucoes Maquina Simplimport java.util.ArrayList;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Stack;


public class CIMS {
  /** Executa o programa CIMS carregado na maquina. */

	Hashtable<String,Etiquetas> etiquetas; //hash table com 
	ArrayList<Instrucao> mem;
	Stack<Integer> pilhaAval;
	int pc;
	Stack<RegistoAtivacao> blocos;
	ArrayList<RegistoAtivacao> memexec; //a meḿoria  de  execucao,  onde  se  encontram  os  registos  de  ativaçao  dos  blocos  do programa cuja execucao ainda nao terminou.
	RegistoAtivacao AA; //apontador ambiente , aponta para o regisot de ativacao corrente
	Stack<Integer> args; 	//sitio para colocar os valores de coloca args
	int flag;
	int pcTemp;
	

	public CIMS ()
	{
		etiquetas = new Hashtable<String,Etiquetas>();
		mem = new ArrayList<Instrucao>();
		pilhaAval = new Stack<Integer>();
		memexec = new ArrayList<RegistoAtivacao>();
		blocos = new Stack<RegistoAtivacao>();
		args = new Stack<Integer>();
		pc = 0;
		pcTemp = 0;
		flag = 1;
		AA = new RegistoAtivacao(0,0,0,null);
		
	}

	public ArrayList<Instrucao> getMemoria()
	{
		return mem;
	}
	
	public void add_instrucao(Instrucao inst)
	{
		mem.add(inst);
	}
	
	public void add_etiqueta(String ID, int posicao)
	{
		Etiquetas etiqueta = new Etiquetas(ID, posicao);
		System.out.println("label: "+ ID );
		etiquetas.put(ID,etiqueta);
	
	}
	
	public void executa()
	{
		Etiquetas etiqueta = findMain();
		//~ etiqueta.print();
		pc = etiqueta.posicao;
		pc++;
		while(flag == 1){
			//~ System.out.println("       " + mem.get(pc).toString());
			mem.get(pc).executa(this);
			//~ AA.print();
			//~ System.out.println("Pilha avaliacao " + pilhaAval.toString());
			//~ System.out.println("Pilha args " + args.toString());
			//~ System.out.println("----------------------");
		}
		
		
		
	}
	
	
	public Etiquetas findMain(){
		Etiquetas main = etiquetas.get("main");
		return main;
	}
	
	public Etiquetas getEtiqueta(String ID)
	{
		return etiquetas.get(ID);
	}
	
	public ArrayList<Instrucao> getInstrucoes(int index)
	{
			return mem;
	}
	
	public void print()
	{
		for(int i = 0; i< mem.size() ; i++)
		{
			System.out.println("       " + mem.get(i).toString());
		}
	}
}
