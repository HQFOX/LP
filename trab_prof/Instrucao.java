package Sintaxe;
import lp.TISC;
import java.util.Stack;

public abstract class Instrucao{
	public abstract void exec(TISC t);//{
		//System.out.println(this.toString());
	//}
	
	public abstract String toString();
}
