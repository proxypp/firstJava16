package co.micol.prj.queue;

public class Queue {
	private int[] queue = new int[10];
	private int rear = -1;
	private int front = -1;
	public void put(int n) {
		if (rear > queue.length) {
			System.out.println("Queue Full");
		}else {
			queue[++rear] = n;
		}
	}
	public int get() {
		if (front == rear||front > queue.length -1) {
			System.out.println("Queue Empty");
			return -1;
		}else {		
			return queue[++front];
		}
	}
}
