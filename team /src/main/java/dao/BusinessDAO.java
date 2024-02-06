package dao;

import org.apache.ibatis.session.SqlSession;

import dto.BusinessDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BusinessDAO {

	final SqlSession sqlSession;
	
	// 로그인 체크
	public BusinessDTO selectOne(String bu_email) {
		return sqlSession.selectOne("b.loginCheck",bu_email);
	}
	
	// 추가
	public int insert(BusinessDTO dto) {
		return sqlSession.insert("b.insert",dto);
	}
}
