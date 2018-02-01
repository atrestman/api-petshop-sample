package com.trestman.api.petshop.mapper;

import com.trestman.api.petshop.entity.CategoryEntity;
import com.trestman.swagger.api.petshop.model.Category;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CategoryMapper {
    private static Function<CategoryEntity, Category> mapCategoryEntityIntoCategory =
            new Function<CategoryEntity, Category>() {
                @Override
                public Category apply(CategoryEntity categoryEntity) {
                    Category category = new Category();
                    category.categoryid(categoryEntity.getCategoryid())
                            .name(categoryEntity.getName())
                            .description(categoryEntity.getDescription())
                            .imageurl(categoryEntity.getImageurl());
                    return category;
                }
            };

    private static Function<Category, CategoryEntity> mapCategoryIntoCategoryEtntity =
            new Function<Category, CategoryEntity>() {
                @Override
                public CategoryEntity apply(Category category) {
                    CategoryEntity categoryEntity = CategoryEntity.builder()
                            .categoryid(category.getCategoryid())
                            .description(category.getDescription())
                            .imageurl(category.getImageurl())
                            .build();
                    return categoryEntity;
                }
            };


    public static CategoryEntity map(Category category) {
        if (category == null) {
            return null;
        }
        return mapCategoryIntoCategoryEtntity.apply(category);
    }

    public static Category map(CategoryEntity categoryEntity) {
        if (categoryEntity == null) {
            return null;
        }
        return mapCategoryEntityIntoCategory.apply(categoryEntity);
    }

    public static List<Category> map(List<CategoryEntity> categoryEntities) {
        List<Category> categorys = categoryEntities.stream().map(mapCategoryEntityIntoCategory)
                .collect(Collectors.toList());
        return categorys;
    }
}
