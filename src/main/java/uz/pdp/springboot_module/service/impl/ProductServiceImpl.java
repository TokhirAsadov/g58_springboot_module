package uz.pdp.springboot_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.springboot_module.entity.Product;
import uz.pdp.springboot_module.payload.ProductCreator;
import uz.pdp.springboot_module.payload.ProductResponse;
import uz.pdp.springboot_module.repository.ProductRepository;
import uz.pdp.springboot_module.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductResponse create(ProductCreator creator) {
        Product build = Product.builder()
                .name(creator.name())
                .price(creator.price())
                .build();
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
