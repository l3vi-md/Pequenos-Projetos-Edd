package filas;

public class Triagem{
	Paciente inicio;
	Paciente fim;
	int tamanho;
	int capacidade;
	Paciente[] vetor;
	static final Paciente pacienteVazio = new Paciente(-1,"vazio");
	
	
public Triagem(){
	this.tamanho = 0;
}

public void enqueue(int numero,String paciente){
	Paciente novo = new Paciente(numero,paciente);
	if(estaVazia()){
		inicio = novo;
	}
	else{
		fim.proximo = novo;
	}
	fim = novo;
	tamanho++;
	
}

public Paciente dequeue(){
	if(estaVazia()){
		System.err.println("err0!");
		return pacienteVazio;
	}
	Paciente elementRem = inicio;
	inicio = inicio.proximo;
	tamanho--;
	return elementRem;
}

public void imprimir(){
	if(estaVazia()){
		System.err.println("err0!");
		return;
	}
	Paciente atual = inicio;
	while(atual != null){
		System.out.println("paciente: "+atual.nome+" - numero: "+atual.numero);
		atual = atual.proximo;
	}
}

public boolean estaVazia(){
	return tamanho == 0|| inicio == null || fim == null;
	
}
public Paciente proximo(){
	if(estaVazia()){
		return pacienteVazio;
	}
	return inicio;
	
}
public int tamanho(){
	return tamanho;
}
public static void main(String[] args){
	Triagem a2 = new Triagem();
	a2.enqueue(501,"ana");
	a2.enqueue(502,"bruno");
	a2.enqueue(503,"carla");
	a2.enqueue(504,"diego");
	a2.dequeue();
	a2.imprimir();
	a2.dequeue();
	a2.imprimir();
	a2.dequeue();
	a2.imprimir();
	a2.dequeue();

}
}