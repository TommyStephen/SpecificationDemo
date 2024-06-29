package study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import study.model.Product;
import study.service.ProductServiceImpl;

@RestController
public class ProductController {

	@Autowired 
	private ProductServiceImpl prodcutService;
		
	@PostMapping("product/save")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
	        Product savedProduct = prodcutService.saveProduct(product);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	    }
	
	@GetMapping("product/findAll")
	public ResponseEntity<List<Product>>  findAll(){
		List<Product> list = prodcutService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("products/getProductsByNameAndPrice")
    public List<Product> getProducts(@RequestParam String name, @RequestParam Double price) {
        return prodcutService.getProductsByNameAndPrice(name, price);
    }
	
	@GetMapping("products/orderedByPrice")
    public List<Product> orderedByPrice(@RequestParam Double price) {
        return prodcutService.orderedByPriceLessThan(price);		
	}
	
	
}
