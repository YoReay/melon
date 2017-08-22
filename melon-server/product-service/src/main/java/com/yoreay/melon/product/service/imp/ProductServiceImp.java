package com.yoreay.melon.product.service.imp;

import com.yoreay.melon.product.domain.Product;
import com.yoreay.melon.product.domain.ProductRepository;
import com.yoreay.melon.product.service.ProductService;
import com.yoreay.melon.product.util.ProductUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductInfo(Long id) {
        Product p = productRepository.findById(id);
        if (p == null) {
            log.error("[id=" + id + "]的Product不存在！");
        }
        return p;
    }

    @Override
    public boolean addProduct(String barcode) {
        String json = ProductUtil.newInstance().getProductFromApi(barcode);
        System.out.println(json);
        Product p = new Product();
        p.setName("C1710心相印茶语经典系列12包装四层纸手帕");
        p.setBarcode("6922868289158");
        p.setCostPrice(new BigDecimal(0.35));
        p.setPrice(new BigDecimal(0.5));
        productRepository.save(p);
        return false;
    }
}
