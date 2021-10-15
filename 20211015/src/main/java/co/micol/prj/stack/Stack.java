package co.micol.prj.stack;

public class Stack {
	private char[] stack = new char[10]; //문자 스택...
	private int top = -1;
	
	public void push (char c) {				//스택에서 데이터 집어넣는 함수.
		 if (top > stack.length) {
			 System.out.println("스택이 더이상 데이터를 입력할 수 없습니다.");
		}else {
			stack[++top] = c;
		}	 
	}
	
	public char pop() {
		char data = ' ';
		if (top<0) {
			System.out.println("스택에 더이상 데이터가 없습니다.");
		}else {
			data = stack[top--]; 
		}
		return data;
	}
	
}
