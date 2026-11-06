package listas;

public class ListaDe {
	No inicio;
	No fim;
public void inserirInicio(int valor){
	No novoNo = new No(valor);
	if(estaVazia()){
		inicio=fim=novoNo;
		return;
	}
	novoNo.proximo=inicio;
	inicio.anterior=novoNo;
	inicio=novoNo;
}

public void inserirFinal(int valor){
	No novoNo = new No(valor);
	if(estaVazia()){
		inicio=fim=novoNo;
		return;
	}
	novoNo.proximo = fim;
	fim.anterior = novoNo;
	fim = novoNo;
}

public void imprimir(){
	if(estaVazia()){
		System.err.println("esta Vazia!");
		return;
	}
	No noAtual = inicio;
	while(noAtual!=null){
		System.out.println(noAtual.valor);
		noAtual = noAtual.proximo;
	}
}
public int removerInicio(){
	if(estaVazia()){
		System.err.println("esta Vazia!");
		return -1;
	}
	int elementRem = inicio.valor;
	if(inicio == fim){
		inicio=fim=null;
		return elementRem;
		
	}
	
	inicio.proximo.anterior = null;
	inicio = inicio.proximo;
	return elementRem;
}

public int removerFinal(){
 if(estaVazia()){
	 System.err.println("esta vazia!");
	 return -1;
 }
 int elementRem = fim.valor;
 if(inicio == fim){
	 inicio=fim=null;
	 return elementRem;
 }
 fim.anterior.proximo= null;
 fim=fim.anterior;
 return elementRem;
}


public boolean estaVazia() {return inicio == null && fim == null;}
public void limpar(){inicio=fim=null;}
public static void main(String[] args){
	
	ListaDe e1 = new ListaDe();
	e1.inserirFinal(3);
	e1.inserirInicio(2);
	e1.inserirInicio(1);
	e1.removerFinal();
	e1.removerInicio();
	e1.removerInicio();
	e1.imprimir();
}

}
