import java.util.ArrayList;

public class RegistoAtivacao {
	
	RegistoAtivacao ControlLink;
	int EnderecoRetorno;
	
	int[] vars;
	int[] args;
	int nargs; 
	int nvars;
	
	
	public RegistoAtivacao(int nargs,int nvars, int EnderecoRetorno, RegistoAtivacao c){
		this.nargs = nargs;
		this.nvars = nvars;
		vars = new int[nvars];
		args = new int[nargs];
		ControlLink = c;
		this.EnderecoRetorno = EnderecoRetorno;
		
	}
	
	//~ public void RegistoAtivacaoLocais( int nargs,int nvars)
	//~ {		
		//~ vars = new ArrayList<Integer>(nvars+11);
		//~ args = new ArrayList<Integer>(nargs+11);
	
	//~ }
	public void setControlLink(RegistoAtivacao c){
		ControlLink = c;
	}
		
	public RegistoAtivacao getControlLink(){
		return ControlLink;
	}
	
	public void setEnderecoRetorno(int r){
		EnderecoRetorno =r;
	}
	
	public int getEnderecoRetorno(){
		return EnderecoRetorno;
	}
	
	public void print(){
		//System.out.println("args" + vars.toString()  + " vars" + vars.toString());
		for(int i = 0; i< nargs ; i++)
		{
			System.out.println(" arg[ " + args[i] + " ] ");
			i++;
		}
		for(int j = 0; j< nvars ; j++)
		{
			System.out.println(" vars[ " + vars[j] + " ] ");
			j++;
		}
	}
}
