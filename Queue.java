@SuppressWarnings("unchecked")
public class Queue<T> {
    T[] q;	int front=0;int back=0; //regular line
	F[] l;  int front=0; int back=0; //fast pass line

	public Queue(int length) {
	        q = (T[]) new Object[length]; //regular line
		l= (F[]) new Object[length]; //fast pass
	}

	public void put(T t) { //sizes regular line
		if((back+1)%q.length==front%q.length) resize();
		q[back++%q.length]=t;
	}

	public T peek(int depth) {
		return q[(front+depth)%q.length];
	}

	
	public T get() {
		return q[front++%q.length];
	}

	public int size() {
		if(back>=front) return back - front;
		return q.length - front + back;
	}
	
	public void putfast(F f){  //sizes fast pass line
	    if((back+1)%l.length==front%l.length) resize();
		l[back++%l.length]=f;
	}

	public F peekfast(int depth){
	    return l[front+depth)%l.length]; 
	}

        public F getfast() {
		return l[front++%l.length];
	}

        public int sizefast() {
		if(back>=front) return back - front;
		return l.length - front + back;
	}





	public void resize() {
		System.out.println("resize");
		Queue<T> q2 = new Queue<T>(q.length*10);
		while(this.size()>0) { q2.put(this.get());}
		this.q = q2.q;
		this.front = q2.front;
		this.back = q2.back;

		//Fast pass code now:

		System.out.println("resize fastpass");
		Queue<F> l2 = new Queue<F>(l.length*10);
		while(this.sizefast()>0) { l2.put(this.getfast());}
		this.l = l2.l;
		this.front = l2.front;
		this.back = l2.back;
	}
	
	//test for queue:
	public static void main(String[] args) {
		Queue<Integer> gordon = new Queue<Integer>(10);
		for (int i = 0; i < 15; i++) {
			System.out.println("size: " + gordon.size());
			gordon.put(i);
		}
		Queue<Integer> fast = new Queue<Integer>(10);
		for (int i=0; i<15; i++){
		    System.out.println("size: " + fast.size()):
		    fast.put(i);
		} 	
	} //ends main
} 
