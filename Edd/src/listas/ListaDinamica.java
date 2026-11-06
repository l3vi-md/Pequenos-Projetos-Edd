package listas;

public class ListaDinamica{
	 No inicio;
public void inserirInicio(int valor){
	No novoNo = new No(valor);
	novoNo.proximo = inicio;
	inicio = novoNo;
}

public void inserirFinal(int valor){
	No novoNo = new No(valor);
	if(estaVazia()){
		inicio = novoNo;
		return;
	}
	No noAtual = inicio;
	while(noAtual.proximo != null){
		noAtual= noAtual.proximo;
	}
	noAtual.proximo = novoNo;
}

public int removerInicio(){
	if(estaVazia()){
		System.err.println("esta vazia!");
		return -1;
	}
	int elementRem = inicio.valor;
	inicio = inicio.proximo;
	return elementRem;
}

public int removerFinal(){
	if(estaVazia()){
		System.err.println("esta vazia!");
		return -1;
	}
	if(inicio.proximo == null){
		int elementRem = inicio.proximo.valor;
		inicio.proximo = null;
		return elementRem;
	}
	No noAtual = inicio;
	int valorRem = noAtual.proximo.valor;
	while(noAtual.proximo.proximo != null){
		noAtual = noAtual.proximo;
	}
	noAtual.proximo=null;
	return valorRem;
}

public void imprimir(){
	if(estaVazia()){
		System.err.println("esta vaziaaaaaaaaaa!");
		return;
	}
	No noAtual = inicio;
	while(noAtual.proximo != null){
		System.out.println(noAtual.valor);
		noAtual = noAtual.proximo;
	}
	System.out.println(noAtual.valor);
}

public void limpar() {inicio = null;}
public boolean estaVazia(){return inicio == null; }

public static void main(String[] args){
	
	ListaDinamica a1 = new ListaDinamica();
	
	a1.inserirFinal(4);
	a1.inserirInicio(3);
	a1.inserirInicio(2);
	a1.inserirInicio(1);
	a1.removerInicio();
	a1.imprimir();
}
}

