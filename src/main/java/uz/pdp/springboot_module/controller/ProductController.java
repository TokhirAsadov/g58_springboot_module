package uz.pdp.springboot_module.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_module.payload.BaseResponse;
import uz.pdp.springboot_module.payload.ErrorDto;
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

    @Operation(
            summary = "ID bo`yicha productni olish"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Product topildi"
                    ),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorDto.class))
                    }),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Server xatosi"
                    )
            }
    )
    @GetMapping("/findById/{id}")
    public BaseResponse<ProductResponse> findById(@PathVariable Integer id){
        ProductResponse response = productService.findById(id);
        return new BaseResponse<>(response);
    }

    @Hidden
    @DeleteMapping("/deleteById/{id}")
    public BaseResponse<String> deleteById(@PathVariable Integer id){
        productService.deleteById(id);
        return new BaseResponse<>("Product deleted successfully");
    }

}
