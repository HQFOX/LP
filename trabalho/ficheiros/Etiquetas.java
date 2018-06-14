
import java.util.ArrayList;

public class Etiquetas 
{

	ArrayList<Instrucao> instrucoes;
	String ID;
	int posicao;

	public Etiquetas (String ID,int posicao)
	{
		instrucoes = new ArrayList<Instrucao>();
		this.ID = ID;
		this.posicao = posicao;
	}
	
	public void add_instrucao(Instrucao inst)
	{
		instrucoes.add(inst);
	}
	
	public Integer getPosicao(){
		return posicao;
	}
	
	public void print()
	{
		System.out.print(ID + "  ");
		for(int i=0; i < instrucoes.size() ; i++)
		{
			System.out.println("       " + instrucoes.get(i).toString());
		}
	}
}
