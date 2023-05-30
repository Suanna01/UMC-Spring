package com.umc.umcspring.service;

import com.umc.umcspring.domain.Product;
import com.umc.umcspring.dto.ProdReqDTO;
import com.umc.umcspring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    // 상품 등록
    public String insertProd(ProdReqDTO prodReqDTO) {
        Product product = new Product();

        product.setName(prodReqDTO.getName());
        product.setPrice(prodReqDTO.getPrice());

        // DB에 저장
        productRepository.save(product);

        return "상품 등록 성공";
    }

}
