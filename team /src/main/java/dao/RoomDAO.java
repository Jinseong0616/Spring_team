package dao;

import org.apache.ibatis.session.SqlSession;

import dto.RoomDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoomDAO {
	
	final SqlSession sqlSession;
	
	
	//�� �߰��ϱ�
	public int add(RoomDTO dto) {
		return sqlSession.insert("r.room_insert",dto);
	}
	
	//�߰��� �� ���� ���ϱ�
	public int count_room() {
		return sqlSession.selectOne("r.room_count");
	}
}
