package com.sonu.order.beans.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OrderTable")
public class Order {

    @Id
    @GeneratedValue(generator = "gen_uuid")
    @GenericGenerator(name = "gen_uuid", strategy = "uuid2")
    @Column(name = "ORDER_ID")
    private String orderId;
    @Column(name = "ORDER_DATE")
    private LocalDateTime OrderTime;
    @Column(name = "CUSTOMER_ID")
    private String customerID;
    private List<Integer> productId;
}
