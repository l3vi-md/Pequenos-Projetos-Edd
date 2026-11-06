package filas;

public class FilaDePrioridade {
	int tamanho;
	int capacidade;
	Tarefas[] heap;
	final static Tarefas tarefaVazia = new Tarefas(0,"vazio");
public FilaDePrioridade(int capacidade){
	this.tamanho = 0;
	this.capacidade = capacidade;
	this.heap = new Tarefas[capacidade];
	
}

public void enqueue(int prioridade,String nome) {
	if(estaCheia()) {
		redimensionar();
	}
	Tarefas novo = new Tarefas(prioridade,nome);
	heap[tamanho]=novo;
	subir(tamanho);
	tamanho++;
	
}

public Tarefas dequeue(){
	if(estaVazia()){
		System.err.println("err0!");
		return tarefaVazia;
	}
	Tarefas elementRem = heap[0];
	tamanho--;
	heap[0]=heap[tamanho];
	if(tamanho>0) {
	descer(0);
	}
	return elementRem;
	
}
	
public boolean estaCheia() {
	return tamanho == capacidade;
	
}
	
public boolean estaVazia() {
	return tamanho == 0;
	
}
	
public int tamanho() {
	return tamanho;

}
	
public Tarefas proximo() {
	if(estaVazia()){
		System.err.println("err0!");
		return tarefaVazia;
	}
	return heap[0];
}
	
public boolean maisUrgente(int i , int pai) {
	return heap[i].prioridade<heap[pai].prioridade;

}
	
public void subir(int i){
	while(i>0) {
		int pai = (i-1)/2;
		if(!maisUrgente(i,pai)){
			break;
		}
		trocar(i,pai);
		i=pai;
	}
}
	
public void descer(int i){
	while(true){
	 int maior = i;
	 int esq = (i*2)+1;
	 int dir = (i*2)+2;
	 if(esq < tamanho && maisUrgente(esq,maior)){
		 maior = esq;
		 
	 }
	 if(dir < tamanho && maisUrgente(dir,maior)){
		 maior = dir;
		 
	 }
	 if(maior == i){
		 break;
		 
	 }
	 trocar(i,maior);
	 i=maior;
	}
}
	
public void redimensionar() {
	Tarefas[] novo = new Tarefas[capacidade*2];
	for(int i =0; i<capacidade;i++){
		novo[i]=heap[i];
	}
	heap=novo;
	
	}
public void trocar(int i ,int j){
	Tarefas temp = heap[i];
	heap[i]=heap[j];
	heap[j]=temp;
	
}
public static void main(String[] args) {
	FilaDePrioridade a1 = new FilaDePrioridade(7);
	a1.enqueue(3, "varrer a casa");
	a1.enqueue(2, "lavar a louça");
	a1.enqueue(1, "tirar o lixo");
	a1.enqueue(4,"fazer tarefa de casa");
	a1.enqueue(1,"passear com o cachorro");
	a1.enqueue(6,"ver tv");
	a1.enqueue(5,"tomar banho");
	a1.dequeue();
	a1.dequeue();
}

}
