package Sintaxe.Instrucoes.Aritmetica;
import Sintaxe.Instrucoes.Inst_Aritmetica;
import lp.*;
import java.util.Stack;

public class add extends Inst_Aritmetica{
	public String toString(){
		return "ADD";
	}
	
	public void exec(TISC t){
		Integer t2=t.getEvalStack().pop();
		Integer t1=t.getEvalStack().pop();
		t.getEvalStack().push(t1+t2);
                t.getExecMemory().incPC();
	}
	
}
