package com.damiantomczyszyn.bookstore.repository;


import com.damiantomczyszyn.bookstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository  extends CrudRepository<Order,Long> {


}
