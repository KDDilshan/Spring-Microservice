package com.kavindu.product.respositories;

import com.kavindu.product.entities.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepo extends JpaRepository<product, Integer> {

    product findByProductId(int productId);
}
