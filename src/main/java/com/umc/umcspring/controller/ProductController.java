package com.umc.umcspring.controller;

import com.umc.umcspring.ResponseMessage;
import com.umc.umcspring.StatusCode;
import com.umc.umcspring.domain.Product;
import com.umc.umcspring.dto.DefaultRes;
import com.umc.umcspring.dto.ProdReqDTO;
import com.umc.umcspring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    // 상품 등록
    @PostMapping("/registration")
    public ResponseEntity<ProdReqDTO> postProd(@RequestBody ProdReqDTO prodReqDTO) {
        productService.insertProd(prodReqDTO);
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.CREATE_PROD, prodReqDTO), HttpStatus.OK);
    }
}
