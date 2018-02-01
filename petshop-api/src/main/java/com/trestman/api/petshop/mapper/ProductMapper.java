package com.trestman.api.petshop.mapper;

import com.trestman.api.petshop.entity.CategoryEntity;
import com.trestman.api.petshop.entity.ProductEntity;
import com.trestman.swagger.api.petshop.model.Category;
import com.trestman.swagger.api.petshop.model.Product;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductMapper {
    private static Function<ProductEntity, Product> mapProductEntityIntoProduct =
            new Function<ProductEntity, Product>() {
                @Override
                public Product apply(ProductEntity productEntity) {
                    Product product = new Product();
                    product.productid(productEntity.getProductid())
                            .name(productEntity.getName())
                            .description(productEntity.getDescription())
                            .imageurl(productEntity.getImageurl())
                            .category(CategoryMapper.map(productEntity.getCategoryEntity()));
                    return product;
                }
            };

    private static Function<Product, ProductEntity> mapProductIntoProductEtntity =
            new Function<Product, ProductEntity>() {
                @Override
                public ProductEntity apply(Product product) {
                    ProductEntity productEntity = ProductEntity.builder()
                            .productid(product.getProductid())
                            .name(product.getName())
                            .description(product.getDescription())
                            .imageurl(product.getImageurl())
                            .build();
                    productEntity.setCategoryEntity(CategoryMapper.map(product.getCategory()));
                    return productEntity;
                }
            };


    public static ProductEntity map(Product product) {
        if (product == null) {
            return null;
        }
        return mapProductIntoProductEtntity.apply(product);
    }

    public static Product map(ProductEntity productEntity) {
        if (productEntity == null) {
            return null;
        }
        return mapProductEntityIntoProduct.apply(productEntity);
    }

    public static List<Product> map(List<ProductEntity> productEntities) {
        List<Product> products = productEntities.stream().map(mapProductEntityIntoProduct)
                .collect(Collectors.toList());
        return products;
    }
}
