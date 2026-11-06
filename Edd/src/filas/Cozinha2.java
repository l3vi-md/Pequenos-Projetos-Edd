package filas;

public class Cozinha2{
	int elementoDentro;
	int inicio;
	int fim;
	int capacidade;
	Pedido2[] vetor;
	static final Pedido2 pedidoVazio =  new Pedido2(-1,"cozinha vazia");
public Cozinha2(){
	this.capacidade = 8;
	this.elementoDentro = 0;
	this.inicio = 0;
	this.fim = -1;
	this.vetor = new Pedido2[capacidade];
}

public void fazerPedido2(int codigo,String nome){
	if(estaCheia()){
		System.err.println("cozinha ja esta no limite de pedidos sendo preparados!");
		return;
	}
	Pedido2 novo = new Pedido2(codigo,nome);
	fim = (fim+1)%capacidade;
	vetor[fim]=novo;
	elementoDentro++;
}

public Pedido2 entregarProximo2(){
	if(estaVazia()){
		System.err.println("cozinha não tem mais pedidos sendo feitos!");
		return pedidoVazio;
	}
	Pedido2 elementoRem = vetor[inicio];
	inicio = (inicio+1)%capacidade;
	elementoDentro--;
	return elementoRem;
}

public void imprimir(){
	if(estaVazia()){
		System.err.println("err0!");
		return;
	}
	for(int i = inicio;i!=fim;i = (i+1)%capacidade){
		System.out.println("o pedido "+i+" da cozinha é: "+vetor[i].nome+"("+vetor[i].nome+")");
	}
	System.out.println("o pedido "+fim+" da cozinha é: "+vetor[fim].nome+"("+vetor[fim].nome+")");
}

public boolean estaVazia(){return elementoDentro == 0;}
public boolean estaCheia(){return elementoDentro == capacidade;}
public Pedido2 proximoDaFila(){
return vetor[inicio];
}
public static void main(String[] args) {
	Cozinha2 a1 = new Cozinha2();
	a1.fazerPedido2(101, "x-Burguer");
	a1.fazerPedido2(102, "x-salada");
	a1.fazerPedido2(103, "Refrigerante");
	a1.fazerPedido2(104, "batata frita");
	a1.fazerPedido2(105, "Sorvete");
	a1.fazerPedido2(101, "x-Burguer");
	a1.fazerPedido2(102, "x-salada");
	a1.fazerPedido2(103, "Refrigerante");
	
	
} 

}
