package filas;

public class FilaDePrioridade2 {
	Tarefas[] heap;
	int capacidade;
	int tamanho;
	final static Tarefas tarefaVazia = new Tarefas(0,"tarefa vazia!");
public FilaDePrioridade2(int capacidade){
	this.capacidade = capacidade;
	this.tamanho = 0;
}
public void enqueue(int prioridade,String tarefa){
	if(estaCheia()){
		redimensionar();
	}
	
	Tarefas novo = new Tarefas(prioridade,tarefa);
	heap[tamanho]=novo;
	subir(tamanho);
	tamanho++;
}

public Tarefas dequeue(){
	if(estaVazia()){
		System.err.println("fila esta vazia!");
		return tarefaVazia;
	}
	Tarefas elementRem = heap[0];
	tamanho--;
	heap[0]=heap[tamanho];
	if(tamanho>0){
		descer(0);
	}
	return elementRem;	
}

public boolean estaVazia(){
	return tamanho == 0;
}

public boolean estaCheia(){
	return tamanho == capacidade;
}

public int tamanho(){
	return tamanho;
}

public Tarefas proximo(){
	if(estaVazia()){
		return tarefaVazia;
	}
	return heap[0];
}

public void subir(int i){
	while(i>0){
		int pai = (i-1)/2;
		if(!maisUrgente(i,pai)){
			break;
		}
		trocar(i,pai);
		i = pai;
	}
}
public void descer(int i){
	while(true){
		 int maior = i;
		 int esq = (2*i)+1;
		 int dir = (2*i)+2;
		 if(esq< tamanho && maisUrgente(esq,maior)){
			maior = esq;
		 }
		 if(dir<tamanho && maisUrgente(dir,maior)){
			 maior = dir;
		 }
		 if(maior==i){
			 break;
		 }
		 trocar(i,maior);
		 i=maior;
	}
}

public void redimensionar(){
	Tarefas[] novo = new Tarefas[capacidade*2];
	for(int i = 0 ; i < capacidade ; i++){
		novo[i]=heap[i];
	}
	heap = novo;
	}

public boolean maisUrgente(int i,int j){
	return heap[i].prioridade < heap[j].prioridade;
	
}

public void trocar(int i ,int j){
	Tarefas temp = heap[i];
	heap[i]=heap[j];
	heap[j]=temp;
}
}
