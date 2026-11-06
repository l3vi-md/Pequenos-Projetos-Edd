package filas;

public class Cozinha3 {
	int tamanho;
	int capacidade;
	int inicio;
	int fim;
	Pedido3[] vetor;
	static final Pedido3 pedidoVazio = new Pedido3(-1,"vazio");
public Cozinha3(int capacidade){
	this.capacidade = capacidade;
	this.tamanho = 0;
	this.inicio = 0;
	this.fim = -1;
	this.vetor = new Pedido3[capacidade];
}	
public void enqueue(int numero,String nome){
	if(estaCheia()){
		System.err.println("err0!");
		return;
	}
	Pedido3 novo = new Pedido3(numero,nome);
	fim = (fim+1)%capacidade;
	vetor[fim]=novo;
	tamanho++;
}

public Pedido3 dequeue(){
	if(estaVazia()){
		System.err.println("err0!");
		return pedidoVazio;
	}
	Pedido3 elementRem = vetor[inicio];
	inicio= (inicio+1)%capacidade;
	tamanho--;
	return elementRem;
}

public Pedido3 Proximo() {
	if(estaVazia()){
		return pedidoVazio;
	}
	return vetor[inicio];
}
public boolean estaVazia() {
	return  tamanho == 0;
}
public boolean estaCheia() {
	return tamanho == capacidade;
}
public void imprimir() {
	if(estaVazia()){
		System.err.println("lista vazia!");
		return;
	}
	for(int i = inicio ; i != fim; i = (i+1)%capacidade){
		System.out.println("o pedido "+i+" da cozinha é: "+vetor[i].numero+"("+vetor[i].nome+")");
	}
	System.out.println("o pedido "+fim+" da cozinha é: "+vetor[fim].numero+"("+vetor[fim].nome+")");
}
public void limpar(){
	tamanho = 0;
	inicio = 0;
	fim = -1;
}
public int tamanho() {
	return tamanho;
}
public static void main(String[] args) {
	Cozinha3 a1 = new Cozinha3(8);
	
	a1.enqueue(101, "x-Burguer");
	a1.enqueue(102, "x-salada");
	a1.enqueue(103, "Refrigerante");
	a1.enqueue(104, "batata frita");
	a1.enqueue(105, "Sorvete");
	a1.enqueue(101, "x-Burguer");
	a1.enqueue(102, "x-salada");
	a1.enqueue(103, "Refrigerante");
	a1.imprimir();
	
	
} 
}
