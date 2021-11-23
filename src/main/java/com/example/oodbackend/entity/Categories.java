package com.example.oodbackend.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name="categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;


    @NotBlank(message = "Please Add Category name ")
    @Length(max =100 ,min =2)
    private String categoryName ;


    @Length(max=500,min=2)
    private String categoryDescription;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

    public Categories() {

    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Categories(Long categoryId, String categoryName, String categoryDescription) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                '}';
    }
}
