package pilhas;

public class Editor{
	Ação topo;
	int tamanho;
	static final Ação açãoVazia = new Ação("vazio");
public Editor(){
	this.tamanho = 0;
}
public void push(String texto){
	Ação novo = new Ação(texto);
	novo.proximo = topo;
	topo = novo;
	tamanho++;
}

public Ação pop(){
	if(estaVazia()){
		System.err.println("pilha vazia!");
		return açãoVazia;
	}
	Ação elementRem = topo;
	topo = topo.proximo;
	tamanho--;
	return elementRem;
}


public void imprimir(){
	if(estaVazia()){
		System.err.println("pilha esta vazia!");
		return;
	}
	Ação atual = topo;
	while(atual != null){
		System.out.println(atual.texto);
		atual = atual.proximo;
	}
}

public Ação top() {
	if(estaVazia()){
		return açãoVazia;
	}
	return topo;
}
public void limpar() {
	topo = null;
	tamanho = 0;
}
public int tamanho(){
	return tamanho;
}
public boolean estaVazia(){
	return topo == null && tamanho == 0;
}
public static void main(String[] args){
	Editor a1 = new Editor();
	a1.push("levi");
	a1.push("l3vi");
	a1.imprimir();
	a1.pop();
	a1.pop();
	a1.imprimir();
	
}


}
