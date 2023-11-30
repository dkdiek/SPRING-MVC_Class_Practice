package city.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import city.model.CityModel;

public class CityController {

	public static void main(String[] args) throws IOException {
		//MyBatis 설정 파일 경로 지정:
		String resource = "mybatis/mybatis-config.xml";
		//MyBatis 설정 파일 로딩:
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//SqlSessionFactory 생성:
		//SqlSessionFactory는 SqlSession을 생성하고 관리합니다. SqlSession은 데이터베이스와의 실제 세션을 나타냅니다.
		//세션은 데이터베이스 트랜잭션을 시작하고 완료하며, SQL 문을 실행하는 데 사용됩니다.
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);
		//도시 정보 조회를 위한 매개변수 설정:
		HashMap map = new HashMap();
		map.put("countrycode", "USA");
		//도시 정보 조회 및 출력:
		//CityModel 클래스의 selectCity 메서드를 사용하여 도시 정보를 조회하고, 조회된 결과를 반복문을 통해 출력합니다.
		List<HashMap> cityList = CityModel.selectCity(sqlSessionFactory, map);
		for ( HashMap cityMap : cityList ) {
			System.out.println((String)cityMap.get("name"));
		}
		
		
		
		
		
		
		
	}

}
