package com.eshop.demo.repository;

import com.eshop.demo.model.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ani Poghosyan on 14/02/2022
 */
public interface ProductRepository extends JpaRepository<Product,Long> {

}
