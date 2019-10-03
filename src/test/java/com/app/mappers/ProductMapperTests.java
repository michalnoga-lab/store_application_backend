package com.app.mappers;

import com.app.dto.ProductDTO;
import com.app.model.Cart;
import com.app.model.Company;
import com.app.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class ProductMapperTests {

    @Test
    @DisplayName("toDto")
    void test1() {

        Product product = Product.builder()
                .id(1L)
                .quantity(1)
                .nettPrice(BigDecimal.ONE)
                .name("Example name")
                .carts(new HashSet<>(List.of(Cart.builder().id(2L).build())))
                .company(Company.builder().id(3L).build())
                .description("Description")
                .build();

        ProductDTO expectedProduct = ProductDTO.builder()
                .id(1L)
                .quantity(1)
                .nettPrice(BigDecimal.ONE)
                .name("Example name")
                .company(Company.builder().id(3L).build())
                .description("Description")
                .build();

        ProductDTO actualProduct = ProductMapper.toDto(product);

        Assertions.assertEquals(expectedProduct, actualProduct);
    }

    @Test
    @DisplayName("fromDto")
    void test2() {

        ProductDTO productDTO = ProductDTO.builder()
                .id(1L)
                .quantity(1)
                .nettPrice(BigDecimal.ONE)
                .name("Example name")
                .company(Company.builder().id(3L).build())
                .description("Description")
                .build();

        Product expectedProduct = Product.builder()
                .id(1L)
                .quantity(1)
                .nettPrice(BigDecimal.ONE)
                .name("Example name")
                .carts(new HashSet<>(List.of(Cart.builder().id(2L).build())))
                .company(Company.builder().id(3L).build())
                .description("Description")
                .build();

        Product actualProduct = ProductMapper.fromDto(productDTO);

        Assertions.assertEquals(expectedProduct, actualProduct);
    }
}