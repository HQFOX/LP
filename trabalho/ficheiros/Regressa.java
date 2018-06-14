public class Regressa extends Instrucao_chamada{


	public void executa(CIMS maquina){
		
		maquina.blocos.pop();
		if(maquina.blocos.empty()==false){
			maquina.pc = maquina.AA.EnderecoRetorno;
			maquina.AA = maquina.AA.ControlLink;
		}
		else{
				maquina.flag =0;
		}
		
	}


	public String toString(){
		return "regressa";
	}
}
