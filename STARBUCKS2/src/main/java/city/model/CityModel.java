package city.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import city.dao.CityMapper;

public class CityModel {

	public static List<HashMap> selectCity(SqlSessionFactory sqlSessionFactory, HashMap map) {
		List<HashMap> cityNames = null;
		//try-with-resources 문법을 사용하여 SqlSession을 생성하고 블록이 끝날 때 자동으로 닫히도록 합니다.
		try (SqlSession session = sqlSessionFactory.openSession()) {
			
			//1번째 방식 xml을 바로 호출하는 방식, 단점 오타(mapper.java없어도됨)
			//cityNames = session.selectList("city.dao.CityMapper.selectCity", map);
			
			//2번째 방식 가장 많이 사용하는 방식(xml에 매핑되는 인터페이스로 호출, 오타나니까 ,java 인터페이스로 만들어서 부름)
			//SqlSession을 통해 MyBatis의 매퍼 인터페이스를 가져오고, 이를 통해 SQL 쿼리를 실행합니다.
			CityMapper mapper = session.getMapper(CityMapper.class);
			cityNames = mapper.selectCity(map);
		}
		return cityNames;
	}
}
