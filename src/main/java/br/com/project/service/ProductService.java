package br.com.project.service;

import java.util.List;

import br.com.project.entity.Product;

public interface ProductService {
	
	public List<Product> list();

    public Product findById(Long id);

    public void save(Product produto);

    public void remove(Long id);

}
