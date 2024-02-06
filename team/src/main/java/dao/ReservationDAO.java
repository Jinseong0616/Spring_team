package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.ReservationDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReservationDAO {
	
	final SqlSession sqlSession;	
	
	public List<ReservationDTO> selectList(){
		return sqlSession.selectList("rv.select");
	}
}
