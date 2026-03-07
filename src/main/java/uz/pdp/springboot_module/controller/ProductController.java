package uz.pdp.springboot_module.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springboot_module.payload.BaseResponse;
import uz.pdp.springboot_module.payload.ProductCreator;
import uz.pdp.springboot_module.payload.ProductResponse;
import uz.pdp.springboot_module.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public BaseResponse<ProductResponse> create(@RequestBody @Valid ProductCreator creator){
        ProductResponse response = productService.create(creator);
        return new BaseResponse<>(response);
    }

    @PostMapping("/findAll")
    public BaseResponse<List<ProductResponse>> findAll(){
        List<ProductResponse> response = productService.findAll();
        return new BaseResponse<>(response);
    }

}
