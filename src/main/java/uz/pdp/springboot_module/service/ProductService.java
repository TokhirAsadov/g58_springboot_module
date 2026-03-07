package uz.pdp.springboot_module.service;

import uz.pdp.springboot_module.payload.ProductCreator;
import uz.pdp.springboot_module.payload.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse create(ProductCreator creator);

    List<ProductResponse> findAll();

    ProductResponse findById(Integer id);
}
