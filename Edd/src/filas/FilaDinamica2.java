package filas;

public class FilaDinamica2 {
	No2 inicio;
	No2 fim;
	
	
	public void enqueue(int valor){
		No2 novoNo = new No2(valor);
		if(estaVazia()){
			inicio = novoNo;
		}
		else {
			fim.proximo = novoNo;
		}
		fim =novoNo;
	}
	
	public int dequeue() {
		if(estaVazia()){
			System.err.println("err0!");
			return -1;
		}
		int elementRem = inicio.valor;
		inicio = inicio.proximo;
		return elementRem;
	}
	
	public void imprimir(){
		if(estaVazia()){
			System.err.println("err0!");
			return;
		}
		No2 noAtual = inicio;
		while(noAtual.proximo != null){
			System.out.println("o valor inserido na fila dinamica é:"+noAtual.valor);
			noAtual = noAtual.proximo;
		}
		System.out.println("o valor inserido na fila dinamica é:"+fim.valor);
	
	}
	public int proximo() {
		if (estaVazia()){
	
		System.err.println("err0!");
		return -1;
		}
		return inicio.valor;
	}
	
	public boolean estaVazia() {return inicio == null && fim == null;}
	public void limpar() {inicio=fim=null;}
	
	public static void main(String[] args){
		FilaCircular2 a1 = new FilaCircular2(3);
		a1.enqueue(1);
		a1.enqueue(2);
		a1.enqueue(3);
		a1.imprimir();
		a1.dequeue();
		a1.dequeue();
		a1.dequeue();
		a1.dequeue();
		a1.imprimir();
		
	
		
	}
}
