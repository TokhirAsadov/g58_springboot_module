package uz.pdp.springboot_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springboot_module.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
