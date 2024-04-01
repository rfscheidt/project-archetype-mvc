package br.com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.entity.Product;
import br.com.project.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository produtoRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
    public List<Product> list() {
        return produtoRepository.findAll();
    }

    public Product findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public void save(Product produto) {
        produtoRepository.save(produto);
    }

    public void remove(Long id) {
        produtoRepository.deleteById(id);
    }

}
