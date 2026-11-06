package filas;

public class Cozinha {
	int capacidade;
	int tamanho;
	int inicio;
	int fim;
	static final Pedido pedidoVazio = new Pedido(-1,"fila vazia");
	Pedido[] vetor;
public Cozinha(int capacidade){
	this.capacidade = capacidade;
	this.inicio = 0;
	this.fim  = -1;
	this.vetor = new Pedido[capacidade];	
}
public void fazerPedido(int numero,String pedido){
	Pedido novo = new Pedido(numero,pedido);
	if(estaCheia()){
		System.err.println("err0!");
		return;
	}
	fim = (fim+1)%capacidade;
	vetor[fim]=novo;
	tamanho++;
}

public Pedido entregarProximo(){
	if(estaVazia()){
		System.err.println("err0!");
		return pedidoVazio;
	}
	Pedido elementRem = vetor[inicio];
	inicio = (inicio+1)%capacidade;
	tamanho--;
	return elementRem;
	
}
public void imprimir() {
	if(estaVazia()){
		System.err.println("lista vazia!");
		return;
	}
	for(int i = inicio;i !=fim;i = (i+1)%capacidade){
		System.out.println("o pedido "+i+" da cozinha é: "+vetor[i].numero+" ("+vetor[i].pedido+")");
	}
	System.out.println("o pedido "+fim+" da cozinha é: "+vetor[fim].numero+" ("+vetor[fim].pedido+")");

}
public boolean estaVazia() {
	return tamanho == 0;
}
public boolean estaCheia(){
	return tamanho == capacidade;
}
public Pedido proximo(){
	if(estaVazia()){
		return pedidoVazio;
	}
	return vetor[inicio];
}
public void limpar(){
	inicio = 0;
	fim = -1;
	tamanho = 0;
}
public static void main(String[] args) {
	Cozinha a1 = new Cozinha(8);
	a1.fazerPedido(101, "x-Burguer");
	a1.fazerPedido(102, "x-salada");
	a1.fazerPedido(103, "Refrigerante");
	a1.fazerPedido(104, "batata frita");
	a1.fazerPedido(105, "Sorvete");
	a1.fazerPedido(101, "x-Burguer");
	a1.fazerPedido(102, "x-salada");
	a1.fazerPedido(103, "Refrigerante");
	a1.limpar();
	a1.entregarProximo();

	
	
} 
}
