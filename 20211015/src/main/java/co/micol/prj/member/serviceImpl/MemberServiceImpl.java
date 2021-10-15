package co.micol.prj.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.micol.prj.En.DataSource;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;


public class MemberServiceImpl implements MemberService {
	private DataSource dao = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public MemberVO memberLogin(MemberVO vo) {
		String sql = "select * from member where id = ? and password = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareCall(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs= psmt.executeQuery();
			if (rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setAddress(rs.getNString("address"));
				vo.setAuthor(rs.getNString("author"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public String encKey() {	//암호화 key 가져오기.
		String sql = "select * from encrytion";
		String val = null;
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				val = rs.getString("enckey");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return val;
	}

}
