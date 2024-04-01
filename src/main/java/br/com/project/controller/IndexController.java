package br.com.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.project.entity.Product;
import br.com.project.service.ProductService;


@Controller
public class IndexController {
	
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	private final ProductService productService;
	
	@Autowired
	public IndexController(ProductService produtoService) {
		this.productService = produtoService;
	}

    @RequestMapping("/index")
    public String indexRouter(Model model){
    	logger.info("Access indexRouter ...");
    	
    	List<Product> products = productService.list();
        model.addAttribute("products", products);
        
        return "index";
    }
    
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
    	productService.remove(productId);

        return ResponseEntity.ok("success deleted.");
    }
    
    @PutMapping("/products/update")
    public ResponseEntity<String> updateProduct(@RequestBody Product updatedProduct) {
        try {
            productService.save(updatedProduct);
            return ResponseEntity.ok("success updated.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to update.");
        }
    }

}
