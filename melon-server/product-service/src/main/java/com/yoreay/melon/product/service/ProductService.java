package com.yoreay.melon.product.service;

import com.yoreay.melon.product.domain.Product;

public interface ProductService {

    Product getProductInfo(Long id);

    boolean addProduct(String barcode);
}
