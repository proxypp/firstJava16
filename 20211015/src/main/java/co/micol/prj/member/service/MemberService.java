package co.micol.prj.member.service;

public interface MemberService {
	MemberVO memberLogin(MemberVO vo); //로그인 체크.
	String encKey(); ///암호화 키를 가져오는 메소드.
}
