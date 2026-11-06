package pilhas;

public class Porto {
	int topo;
	int tamanho;
	int capacidade;
	Conteiner[] vetor;
	static final Conteiner conteinerVazio = new Conteiner("-1","nenhum","0");
public Porto(int capacidade){
	this.capacidade = capacidade;
	this.topo = -1;
	this.tamanho=0;
	this.vetor = new Conteiner[capacidade];	
}
public void push(String a,String b,String c){
	if(estaCheia()){
		System.err.println("limite atingido!");
		return;
	}
	Conteiner novo = new Conteiner(a,b,c);
	vetor[++topo]=novo;
	tamanho++;
	
}

public Conteiner pop(){
	if(estaVazia()){
		System.err.println("o porto esta vazio!");
		return conteinerVazio;
	}
	tamanho--;
	return vetor[topo--];
}

public void imprimir(){
	if(estaVazia()){
		System.err.println("o porto esta vazio!");
		return;
	}
	for(int i = topo ; i > -1;i--){
		System.out.println("conteiner - codigo: "+vetor[i].codigo+" destino: "+vetor[i].destino+" peso: "+vetor[i].peso);
	}
}

public boolean estaVazia(){
	return tamanho == 0;
}
public boolean estaCheia() {
	return tamanho==capacidade;
}

public void esvaziar() {
	topo = -1;
	tamanho = 0;
}
public Conteiner proximo(){
	if(estaVazia()){
		return conteinerVazio;
	}
	return vetor[topo];
}
public int tamanho(){
	return tamanho;
}
public static void main(String[] args){
	Porto a1 = new Porto(3);
	a1.push("123","coritiba", "100");
	a1.push("124","santa catarina", "10");
	a1.push("125","natal","25 ");
	a1.imprimir();
	a1.pop();
	a1.pop();
	a1.pop();
	a1.imprimir();
}
}
