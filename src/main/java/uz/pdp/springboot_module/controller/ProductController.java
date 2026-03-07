package uz.pdp.springboot_module.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_module.payload.BaseResponse;
import uz.pdp.springboot_module.payload.ProductCreator;
import uz.pdp.springboot_module.payload.ProductResponse;
import uz.pdp.springboot_module.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@Tag(
        name = "Product API - ProductController",
        description = "productlarni boshqarish uchun API endpointlari"
)
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(
            summary = "Yangi product yaratish",
            description = "Bu endpoint yangi product yaratish uchun ishlatiladi"
    )
    @PostMapping("/create")
    public BaseResponse<ProductResponse> create(@RequestBody @Valid ProductCreator creator){
        ProductResponse response = productService.create(creator);
        return new BaseResponse<>(response);
    }

    @Operation(
            summary = "Barcha productlarni olish",
            description = "Bu endpoint barcha productlarni olish uchun ishlatiladi"
    )
    @GetMapping("/findAll")
    public BaseResponse<List<ProductResponse>> findAll(){
        List<ProductResponse> response = productService.findAll();
        return new BaseResponse<>(response);
    }

    @GetMapping("/findById/{id}")
    public BaseResponse<ProductResponse> findById(@PathVariable Integer id){
        ProductResponse response = productService.findById(id);
        return new BaseResponse<>(response);
    }

}
