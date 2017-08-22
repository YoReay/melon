package com.yoreay.melon.product.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String barcode;

    private BigDecimal costPrice;

    private BigDecimal price;

    private Date productionDate;

    private Date expirationDate;
}
