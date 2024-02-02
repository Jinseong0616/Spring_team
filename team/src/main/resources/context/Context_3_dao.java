package context;


import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.RoomDAO;


@Configuration
public class Context_3_dao {

		
	@Bean
	public RoomDAO roomDAO(SqlSession sqlSession) {
		return new RoomDAO(sqlSession);
	}
}
