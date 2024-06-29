package study.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import study.model.Product;

@Component
public class ProductSpecification {


	public static Specification<Product> containsName(String name){
		return (a,b,c)->c.like(a.get("name"), "%"+name+"%");
	}
	public static Specification<Product> hasPriceLessthan(Double price){
		return (a,b,c)->c.lessThanOrEqualTo(a.get("price"), price);
	}
	//using the query (b) argument
	public static Specification<Product> orderedByPriceLessThan(Double price){
		return (a,b,c)->{
			b.orderBy(c.asc(a.get("price")));
			return c.lessThanOrEqualTo(a.get("price"), price);		
		};
	}
}
