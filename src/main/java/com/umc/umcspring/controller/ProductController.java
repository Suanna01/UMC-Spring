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

    // 전체 상품 조회
    @GetMapping("/list")
    public ResponseEntity<Product> findAll() {
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.READ_PROD, productService.selectAllProd()), HttpStatus.OK);
    }

    // 상품 수정
    @PutMapping("/prod-modify/{id}")
    public ResponseEntity<Product> prodModify(@PathVariable Long id, @RequestBody ProdReqDTO prodReqDTO) {
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.PUT_PROD, productService.updateProd(id, prodReqDTO)), HttpStatus.OK);
    }

    // 상품 가격 수정 (할인 적용)
    @PatchMapping("/prod-discount/{id}/{rate}")
    public ResponseEntity<Product> prodNameModify(@PathVariable int rate, @PathVariable Long id) {
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.PATCH_PROD_PRICE, productService.updateProd(id, rate)), HttpStatus.OK);
    }

    // 상품 삭제
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Product> prodRemove(@PathVariable Long id) {
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.DELETE_PROD, productService.deleteProd(id)), HttpStatus.OK);
    }

    // 특정 상품 조회
    @GetMapping("/item")
    public ResponseEntity<Product> getProd(@RequestParam Long id) {
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.READ_PROD_BY_ID, productService.selectProdById(id)), HttpStatus.OK);
    }
}
