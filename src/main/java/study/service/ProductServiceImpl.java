package study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import study.model.Product;
import study.repository.ProductRepository;
import study.specification.ProductSpecification;

@Service
public class ProductServiceImpl {
    
	@Autowired
    private ProductRepository productRepository;
  
    public Product saveProduct(Product product) {
    	return productRepository.save(product);
    }

	public List<Product> findAll() {
		
		return productRepository.findAll();
	}
	
	public List<Product> getProductsByNameAndPrice(String name, Double price) {
        Specification<Product> spec = 
        	Specification.where(ProductSpecification.containsName(name))
          .and(ProductSpecification.hasPriceLessthan(price));
        return productRepository.findAll(spec);
    }
	
	public List<Product> orderedByPriceLessThan(Double price){
		Specification<Product> spec =
			Specification.where(ProductSpecification.orderedByPriceLessThan(price));
		
		return productRepository.findAll(spec);
	}
	
}
