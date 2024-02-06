package dao;

import org.apache.ibatis.session.SqlSession;

import dto.RoomDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoomDAO {
	
	final SqlSession sqlSession;
	
	
	//방 추가하기
	public int add(RoomDTO dto) {
		return sqlSession.insert("r.room_insert",dto);
	}
	
	//추가된 방 개수 구하기
	public int count_room() {
		return sqlSession.selectOne("r.room_count");
	}
}
