package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.SearchDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SearchDAO {
	
	final SqlSession sqlSession;
	
	//조건에 맞는 방 검색
	public List<SearchDTO> selectList(SearchDTO dto){
		
		return sqlSession.selectList("s.accommdation_list", dto);
	}
	
	//숙소 카테고리별 검색
	public List<SearchDTO> selectList(int bu_id) {
		return sqlSession.selectList("s.category",bu_id);
	}
	
}
