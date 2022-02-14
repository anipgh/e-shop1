package com.eshop.demo.repository;

import com.eshop.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Siranush Karapetyan [a625929] on 14/02/2022
 */
public interface ProductRepository extends JpaRepository<Product,Long> {

}
