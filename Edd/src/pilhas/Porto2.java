package pilhas;

public class Porto2{
	int topo;
	int capacidade;
	int tamanho;
	Conteiner2[] vetor;
	final static Conteiner2 conteinerVazio = new Conteiner2("-1","nenhum","vazio");
public Porto2(int capacidade){
	this.topo = -1;
	this.capacidade = capacidade;
	this.tamanho = 0;
	this.vetor = new Conteiner2[capacidade];
	}
public void carregarConteiner(String codigo,String destino,String peso){
	if(estaCheia()){
		System.err.println("limite atigido!");
		return;
	}
	Conteiner2 novo = new Conteiner2(codigo,destino,peso);
	vetor[++topo]= novo;
	tamanho++;
}

public Conteiner2 desembarcarConteiner(){
	if(estaVazia()){
		System.err.println("err0!");
		return conteinerVazio;
	}
	tamanho--;
	return vetor[topo--];
	
}

public void inspecionarCarga(){
	if(estaVazia()){
		System.err.println("err0!");
		return;
	}
	for(int i = topo ; i >= 0 ; i--){
		System.out.println("codigo: "+vetor[i].codigo+" destino: "+vetor[i].destino+" peso: "+vetor[i].peso+" toneladas");
	}
}

public boolean estaVazia(){return topo==-1;}

public boolean estaCheia() {return topo == capacidade-1;}

public int tamanho(){
	return tamanho;
}

public Conteiner2 top(){
	if(estaVazia()){
		return conteinerVazio;
	}
	return vetor[topo];
}

public static void main(String[] args){
	Porto2 a1 = new Porto2(3);
	a1.carregarConteiner("123","coritiba", "100");
	a1.carregarConteiner("124","santa catarina", "10");
	a1.carregarConteiner("125","natal","25 ");
	a1.inspecionarCarga();
	a1.desembarcarConteiner();
	a1.desembarcarConteiner();
	a1.desembarcarConteiner();
}
}
