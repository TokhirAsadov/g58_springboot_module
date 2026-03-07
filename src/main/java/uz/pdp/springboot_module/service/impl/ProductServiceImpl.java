package uz.pdp.springboot_module.service.impl;

import org.springframework.stereotype.Service;
import uz.pdp.springboot_module.entity.Product;
import uz.pdp.springboot_module.payload.ProductCreator;
import uz.pdp.springboot_module.payload.ProductResponse;
import uz.pdp.springboot_module.repository.ProductRepository;
import uz.pdp.springboot_module.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse create(ProductCreator creator) {
        Product build = new Product(creator.name(), creator.price());
        Product save = productRepository.save(build);
        return new ProductResponse(save.getId(), save.getName(), save.getPrice());
    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(product ->
                        new ProductResponse(
                                product.getId(),
                                product.getName(),
                                product.getPrice()
                        )
                )
                .toList();
    }
}
