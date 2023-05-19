package com.edu.iuh.repositories;

import com.edu.iuh.entities.Order_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
//@CrossOrigin(origins = "http://localhost:3000/",methods = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*")
public interface OrderRepository extends JpaRepository<Order_, String> {
    @Query("select o from Order_ o join o.user_ u where u.userEmail = ?1")
    List<Order_> findOrdersByUserEmail(String userEmail);

    @Query(value = "SELECT * FROM order_ ORDER BY order_status  ASC OFFSET ?1 ROWS FETCH NEXT 10 ROWS ONLY",nativeQuery = true)
    List<Order_> find10Order(int offset);

    Order_ findOrder_ByOrderId(String orderId);

    Integer countOrder_By();
}