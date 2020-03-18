package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.ProductDTO;
// 서비스 관점
public interface ProductService {
	
	void execute(HttpServletRequest request, HttpServletResponse response, String sign);
	void write(ProductDTO pdto);
	List<ProductDTO> getList();
	ProductDTO getProduct(int pno);
	void modify(ProductDTO pdto);
	void remove(int pno);
	void readCount(int pno);
	
}
