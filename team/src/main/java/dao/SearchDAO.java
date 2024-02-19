package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.SearchDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SearchDAO {
	
	final SqlSession sqlSession;
	
	//���ǿ� �´� �� �˻� - üũ��, üũ�ƿ�, �ο���, ���Ҹ� OR ������
	public List<SearchDTO> selectList(HashMap<String,String> map){
		System.out.println(map.get("checkin"));
		System.out.println(map.get("checkout"));
		System.out.println(map.get("count"));
		System.out.println(map.get("txt"));
		
		return sqlSession.selectList("s.accommdation_list", map);
	}
	
	
}
