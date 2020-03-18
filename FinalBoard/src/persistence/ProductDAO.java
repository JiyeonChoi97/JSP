package persistence;

import java.util.List;
// database 관점
public interface ProductDAO {

	void insert(ProductDTO pdto);
	List<ProductDTO> selectList();
	ProductDTO selectOne(int pno);	// 몇번 pno 상품을 볼것인가.
	void update(ProductDTO pdto);
	void delete(int pno);
	void updateCount(int pno);
	
}
