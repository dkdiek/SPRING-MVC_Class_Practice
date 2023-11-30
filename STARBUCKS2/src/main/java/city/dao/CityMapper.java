package city.dao;

import java.util.HashMap;
import java.util.List;

public interface CityMapper {
	//MyBatis는 데이터베이스와 Java 객체 간의 매핑을 위한 SQL 매퍼를 사용
	//인터페이스 내에는 도시 정보를 조회하는 selectCity라는 메서드가 선언되어 있습니다. 이 메서드는 매개변수로 HashMap을 받아들이고, 조회 결과를 List<HashMap>으로 반환합니다.
//HashMap map: 매개변수로 전달되는 조건을 담고 있는 HashMap입니다.
//List<HashMap>: 조회 결과를 담는 자료구조로, 각 도시에 대한 정보가 HashMap으로 표현되어 있습니다.
	public List<HashMap> selectCity(HashMap map);

}
