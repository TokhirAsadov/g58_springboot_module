package uz.pdp.springboot_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springboot_module.entity.Product;

import java.util.Arrays;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByPriceBetween(Integer minPrice, Integer maxPrice);
}
