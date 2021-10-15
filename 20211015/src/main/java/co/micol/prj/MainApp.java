package co.micol.prj;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Scanner;

import co.micol.prj.Dual.AES256Util;
import co.micol.prj.En.EncryptionSha;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.queue.Queue;
import co.micol.prj.stack.Stack;

public class MainApp {
	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchFieldException, GeneralSecurityException {
//		Stack stack = new Stack();
//		stack.push('a');
//		stack.push('b');
//		stack.push('c');
//		stack.push('d');
//		
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		Queue queue = new Queue();
//		queue.put(1);
//		queue.put(2);
//		queue.put(3);
//		queue.put(4);
//		queue.put(5);
//		
//		System.out.println(queue.get());
//		System.out.println(queue.get());
//		System.out.println(queue.get());
//		System.out.println(queue.get());
//		System.out.println(queue.get());
//		System.out.println(queue.get());
//
//		queue.put(8);
//		queue.put(9);
//		
//		System.out.println(queue.get());
//		System.out.println(queue.get());
		
////		EncryptionSha enc = new EncryptionSha();
////		String password = "1234";
////		String encKey = "@#$123*&++!@#$%D12";
////		
////		System.out.println(enc.sha512(password, encKey));
//		
//		// 단방향 암호화 scanner 버전. ////미리 입력하는 버전.
		EncryptionSha enc = new EncryptionSha();
//		Scanner sc = new Scanner(System.in);
//		MemberService memberdao = new MemberServiceImpl();
//		MemberVO member = new MemberVO();
//		
//		String encKey = memberdao.encKey(); //DB에 저장된 암호화Key값을 가져온다.
//		System.out.println("** 아이디를 입력하세요 ...");
//		
//		member.setId(sc.nextLine());
//		System.out.println("** 패스워드를 입력하세요...");
//		String password  = sc.nextLine();
////		String password  = "1234";
////		String password = enc.sha512("4567", encKey); //입력된 패스워드 암호화. 미리 암호화 해야된다. 미리 쳐보기..
//		member.setPassword(enc.sha512(password, encKey));
//		
//		member = memberdao.memberLogin(member);
//		if (member.getName() != null) {
//			System.out.print(member.getName());
//			System.out.println("님 환영합니다.");
//		}else {
//			System.out.println("아이디 또는 패스워드가 틀립니다.");			
//		}
//		sc.close();
		
		Scanner sc = new Scanner(System.in);
		AES256Util aes = new AES256Util();
		MemberService memberdao = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		
		
//		String encStr = aes.encrypt("USER");
//		System.out.println(encStr);
		
		String encKey = memberdao.encKey(); //DB에 저장된 암호화Key값을 가져온다.
		System.out.println("** 아이디를 입력하세요 ...");
		member.setId(sc.nextLine());
		System.out.println("** 패스워드를 입력하세요...");
		String password  = sc.nextLine();
		member.setPassword(enc.sha512(password, encKey));
		memberdao.memberLogin(member);
		System.out.println(aes.encrypt(member.getAuthor()));
		member = memberdao.memberLogin(member);
		if (member.getName() != null) {
			System.out.print(member.getName());
			System.out.println("님 환영합니다.");
		}else {
			System.out.println("아이디 또는 패스워드가 틀립니다.");			
		}
		sc.close();
		System.out.println(aes.decrypt(member.getAuthor()));
	}
}
