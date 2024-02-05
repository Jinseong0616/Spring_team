package dao;

import org.apache.ibatis.session.SqlSession;

import dto.MemberDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberDAO {
	
	final SqlSession sqlSession;
	
	// 로그인 체크
	public MemberDTO selectOne(String m_email) {
		return sqlSession.selectOne("m.loginCheck",m_email);
	}
	
	// 추가
	public int insert(MemberDTO dto) {
		return sqlSession.insert("m.insert",dto);
	}
}
