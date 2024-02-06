package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.BusinessDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BusinessDAO {

	final SqlSession sqlSession;
	
	//카테고리별 조회
	public List<BusinessDTO> selectList(int bu_id) {
		return sqlSession.selectList("b.category",bu_id);
	}
}
