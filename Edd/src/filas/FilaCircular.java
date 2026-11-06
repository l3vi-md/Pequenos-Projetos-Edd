package filas;
public class FilaCircular {
	int capacidade;
	int elementoDentro;
	int inicio;
	int fim;
	int[] vetor;
public FilaCircular(int capacidade){
	this.capacidade = capacidade;
	this.elementoDentro = 0;
	this.inicio = 0;
	this.fim = -1;
	this.vetor = new int[capacidade];
}
public void enqueue(int valor){
	if(estaCheia()){
		System.err.println("err0!");
		return;
	}
	fim = (fim+1)%capacidade;
	vetor[fim]=valor;
	elementoDentro++;
}

public int dequeue(){
	if(estaVazia()){
		System.err.println("err0!");
		return -1;
	}
	int elementRem  = vetor[inicio];
	inicio = (inicio+1)%capacidade;
	elementoDentro--;
	return elementRem;
	
}

public void imprimir(){
	if(estaVazia()) {
		System.err.println("err0!");
		return;
	}
	for(int i =inicio;i != fim; i = (i+1)%capacidade){
		System.out.println("o valor inserido na posição "+i+" da filacircular é: "+vetor[i]);
	}
	System.out.println("o valor inserido na posição "+fim+" da filacircular é: "+vetor[fim]);
}

public void limpar(){
	elementoDentro = 0;
	inicio = 0;
	fim = -1;
}

public boolean estaCheia(){return elementoDentro==capacidade;}

public boolean estaVazia(){return elementoDentro == 0;}

public static void main(String[] args){
	FilaCircular a1 = new FilaCircular(3);
	a1.enqueue(1);
	a1.enqueue(2);
	a1.enqueue(3);
	a1.imprimir();
	a1.dequeue();
	a1.imprimir();
	a1.enqueue(4);
	a1.imprimir();
}
}
