package com.kavindu.order.repositories;

import com.kavindu.order.entities.order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderRepo extends JpaRepository<order, Integer> {
}
