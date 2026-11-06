package listas;

public class ListaEstatica {
	int capacidade;
	int elementoD;
	int[] vetor;
public ListaEstatica(int capacidade){
	this.capacidade = capacidade;
	this.elementoD = 0;
	this.vetor = new int[capacidade];
}

public void inserirFinal(int valor){
	if(estaCheia()){
	System.err.println("esta cheia!");
	return;
	}
	vetor[elementoD]=valor;
	elementoD++;
}

public void inserirInicio(int valor){
	if(estaCheia()){
		System.err.println("esta cheia!");
		return;
	}
	for(int i = elementoD;i>0;i--) {
		vetor[i]= vetor[i-1];
	} 
	vetor[0]=valor;
	elementoD++;
}

public void inserirPosicao(int posicao,int valor){
	if(posicao<0 || posicao>elementoD){
		System.err.println("posição invalida!");
	}
	if(estaCheia()){
		System.err.println("esta cheia!");
		return;
	}
	for(int i = elementoD;i>posicao;i--){
		vetor[i]=vetor[i-1];
	}
	vetor[posicao]=valor;
	elementoD++;
}

public int removerFim(){
	if(estaVazia()){
		System.err.println("esta vazia!");
		return -1;
	}
	return vetor[--elementoD];
}

public int removerInicio(){
	if(estaVazia()){
		System.err.println("esta vazia!");
		return -1;
	}
	int elementRem = vetor[0];
	for(int i = 0; i<elementoD-1;i++){
		vetor [i] = vetor[i+1];
	}
	elementoD--;
	return elementRem;
}

public int removerPosicao(int posicao){
	if(posicao<0 || posicao>elementoD){
		System.err.println("posição invalida!");
		return -1;
	}
	if(estaVazia()){
		System.err.println("esta vazia!");
		return -1;
	}
	int elementRem = vetor[posicao];
	for(int i = posicao;i<elementoD-1;i++){
		vetor[i]=vetor[i+1];    
	}
	elementoD--;
	return elementRem;
}

public void imprimir(){
	if(estaVazia()){
		System.err.println("esta vazia,insira algo na lista parra impessão!");
		return;
	}
	for(int i =0 ; i<elementoD;i++){System.out.println("o valor inserido no espaço "+i+" da lista estatica é: "+vetor[i]);}
}

public boolean estaCheia(){return elementoD == capacidade;}
public boolean estaVazia(){return elementoD == 0;}
public void limpar(){elementoD = 0;}
public static void main(String[] args) {
	ListaEstatica a1 = new ListaEstatica(5);
	
	a1.inserirInicio(1);
	a1.inserirFinal(3);
	a1.inserirPosicao(1, 2);
	a1.removerInicio();
	a1.removerFim();
	a1.removerPosicao(0);
	a1.imprimir();
}

}
