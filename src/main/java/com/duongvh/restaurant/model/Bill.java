package com.duongvh.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;
    
    @Column
    private String customerName;

    @Column(nullable = false)
    private Date billTime;

    @Column(nullable = false)
    private Double billTotal;
    
    @Column
    private String billNote;
    
    @OneToMany(targetEntity = BillDetail.class, fetch = FetchType.EAGER)
    private Set<BillDetail> billDetailList;
    
    @OneToOne
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;
}
