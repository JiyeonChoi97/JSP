package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import persistence.ProductDAO;
import persistence.ProductDAOImpl;
import persistence.ProductDTO;

public class ProductServiceImpl implements ProductService {

	private static Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	ProductDAO pdao;
	List<ProductDTO> pList;
	ProductDTO pdto;
	
	public ProductServiceImpl() {
		pdao = new ProductDAOImpl();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, String sign) {
		if(sign.equals("pWrite")) {
			String category = request.getParameter("category");
			String pname = request.getParameter("pname");
			String pwriter = request.getParameter("pwriter");
			String pcontent = request.getParameter("pcontent");
			
			ProductDTO pdto = new ProductDTO(category, pname, pcontent, pwriter, null);
			write(pdto);	// dao로 날리기
			
		} else if(sign.equals("pList")) {
			 pList = getList();	
			 request.setAttribute("objList", pList);
		} else if(sign.equals("pDetail")||sign.equals("pModify")) {
			 Integer pno = (Integer) request.getAttribute("pno");
			 if(pno==null) {
				 pno = Integer.parseInt(request.getParameter("pno"));
			 }
			 pdto = getProduct(pno);	
			 request.setAttribute("pdto", pdto);
		} else if(sign.equals("pModifySave")) {
			int pno = Integer.parseInt(request.getParameter("pno"));
			String category = request.getParameter("category");
			String pname = request.getParameter("pname");
			String pcontent = request.getParameter("pcontent");
			pdto = new ProductDTO(pno, category, pname, pcontent);
			modify(pdto);
			request.setAttribute("pno", pno);	// 수정한 pno 객체 다시 보내주기
		}
	}

	@Override
	public void write(ProductDTO pdto) {
		log.info(">>> 검증 로직 ");
		pdao.insert(pdto);
	}

	@Override
	public List<ProductDTO> getList() {
		return pdao.selectList();
	}

	@Override
	public ProductDTO getProduct(int pno) {
		return pdao.selectOne(pno);
	}

	@Override
	public void modify(ProductDTO pdto) {
		pdao.update(pdto);
	}

	@Override
	public void remove(int pno) {

	}

	@Override
	public void readCount(int pno) {

	}

}
