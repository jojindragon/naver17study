package bit.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bit.react.data.ShopEntity;
import jakarta.transaction.Transactional;

public interface ShopRepository extends JpaRepository<ShopEntity, Integer>{
	// 사진을 제외하고 수정 - entity를 param으로 받으면 바인딩이 복잡해짐
	@Query(value = """
			update jpashop set sangpum=:#{#entity.sangpum}, price=:#{#entity.price},
				color=:#{#entity.color}, sangguip=:#{#entity.sangguip}
				where num=:#{#entity.num}
			""", nativeQuery = true)
	@Modifying // @Modifying - insert/update/delete 뿐만 아닌 DDL 구문을 사용할 때도 표기
	@Transactional // @Transactional - update/delete를 할 때 ㅍ기를 해줘야 정상 실행
	public void updateShopNoPhoto(@Param("entity") ShopEntity entity);
}
