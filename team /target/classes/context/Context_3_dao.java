package context;


import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.MemberDAO;
import dao.RoomDAO;


@Configuration
public class Context_3_dao {

		
	@Bean
	public RoomDAO roomDAO(SqlSession sqlSession) {
		return new RoomDAO(sqlSession);
	}
	
	@Bean
	public MemberDAO memberDAO(SqlSession sqlSession) {
		return new MemberDAO(sqlSession);
	}
}
