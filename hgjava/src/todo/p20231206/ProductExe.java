package todo.p20231206;

import java.util.ArrayList;
import java.util.List;

public class ProductExe {
	List<Product> products = new ArrayList<>();
	
	// 등록
	boolean addProduct(Product product) {
		return products.add(product);
	}
	
	// 수정
	boolean modifyProduct(String productCode, int price) {
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getProductCode().equals(productCode)) {
				products.get(i).setPrice(price);
				return true;
			}
		}
		return false;
	}
	
	// 목록
	List<Product> productList() {
		return products;
	}
	
}	// end class
