package pilhas;

public class Editor2 {
	Ação topo;
	int tamanho;
	static final Ação açãoVazia = new Ação("vazia");
public Editor2(){
	this.tamanho = 0;
}
public void enter(String texto){
	Ação novo = new Ação(texto);
	novo.proximo =topo;
	topo = novo;
	tamanho++;
}
public Ação ctrlZ(){
	if(estaVazia()){
		System.err.println("err0!");
		return açãoVazia;
	}
	Ação elementRem = topo;
	topo = topo.proximo;
	tamanho--;
	return elementRem;
}
public void imprimir(){
	if(estaVazia()) {
		System.err.println("err0!");
		return;
	}
	Ação atual = topo;
	while(atual != null){
		System.out.println(atual.texto);
		atual = atual.proximo;
	}
}
public void limpar(){
	topo = null;
	tamanho = 0;
}
public Ação top(){
	return topo;
}
public 	boolean estaVazia(){return topo == null && tamanho==0;}
public static void main(String[] args){
	Editor2 a1 = new Editor2();
	a1.enter("levi");
	a1.enter("l3vi");
	a1.ctrlZ();
	a1.imprimir();
	a1.ctrlZ();
	a1.ctrlZ();
	a1.imprimir();
	
}

}
