package co.micol.prj.En;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionSha {
	 public String sha512(String password, String encKey) { // 단방향 암호화 모듈 == sha512; sha 함수를 쓸때는 256이상 쓰세요.
	      String encStr = null;
	      String hash = password +encKey;
	      try {
	         MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
	         messageDigest.update(hash.getBytes());
	         encStr = String.format("%128x", new BigInteger(1,messageDigest.digest()));
	      
	      }catch(NoSuchAlgorithmException e) {
	         e.printStackTrace();
	      }
	      return encStr;
 }
}
