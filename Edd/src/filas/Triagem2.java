package filas;

public class Triagem2{
	Paciente2 inicio;
	Paciente2 fim;
	int tamanho;
	static final Paciente2 pacienteVazio = new Paciente2(-1,"fila vazia");
public Triagem2(){
	this.tamanho = 0;
}
public void pacienteChegou2(int senha,String nome){
	Paciente2 novo = new Paciente2(senha,nome);
	if(estaVazia()) {
		inicio=novo;
	}
	else{
		fim.proximo = novo;
	}
	fim = novo;
	tamanho++;
}

public Paciente2 chamarProximo2(){
	if(estaVazia()){
		System.err.println("err0!");
		return pacienteVazio;
	}
	Paciente2 elementRem = inicio;
	if(inicio.proximo == null){
		inicio=fim=null;
		
	}else {
		inicio = inicio.proximo;
	}
	tamanho--;
	return elementRem;
}

public boolean estaVazia(){return inicio == null && fim == null && tamanho ==0;}

public void imprimir(){
	if(estaVazia()){
		System.err.println("a triagem esta vazia!");
		return;
	}
	
	Paciente2 atual= inicio;
	while(atual.proximo != null){
		System.out.println("paciente: "+atual.nome+" senha: "+atual.senha);
		atual = atual.proximo;
	}
	System.out.println("paciente: "+fim.nome+" senha: "+fim.senha);
}
public Paciente2 proximo(){
	return inicio;
}
public int tamanho(){
	return tamanho;
}
public void limpar() {
	inicio=fim=null;
	tamanho=0;

}
public static void main(String[] args){
	Triagem2 a2 = new Triagem2();
	a2.pacienteChegou2(501,"ana");
	a2.pacienteChegou2(502,"bruno");
	a2.pacienteChegou2(503,"carla");
	a2.pacienteChegou2(504,"diego");
	a2.imprimir();
	
}

}
