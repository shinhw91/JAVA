package todo.p20231206;

import java.util.ArrayList;
import java.util.List;

public class InOutExe {
	List<InOut> inouts = new ArrayList<>();
	int stock = 0;
	
	// 판매
	boolean productOut(String productCode, String date, int count) {
		for(int i = 0; i < inouts.size(); i++) {
			if(inouts.get(i).getProductCode().equals(productCode)) {
				stock = inouts.get(i).getStock();
				inouts.get(i).setStock(stock - count);
				return true;
			} 
		}
		return false;
	}
	
	// 구매
	boolean productIn(String productCode, String date, int count) {
		for(int i = 0; i < inouts.size(); i++) {
			if(inouts.indexOf(productCode) == -1) {
				
			}
			
			if(inouts.get(i).getProductCode().equals(productCode)) {
				stock = inouts.get(i).getStock();
				inouts.get(i).setStock(stock + count);
				return true;
			} else {
				inouts.add(new InOut(productCode, date, count, "구매"));
				return true;
			}
		}
		return false;
	}
	
	// 재고
	List<InOut> stockList() {
		return inouts;
	}
	


	
	
}
