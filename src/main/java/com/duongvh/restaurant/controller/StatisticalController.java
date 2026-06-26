package com.duongvh.restaurant.controller;

import com.duongvh.restaurant.model.Bill;
import com.duongvh.restaurant.service.bill.IBillService;
import com.duongvh.restaurant.service.desk.IDeskService;
import com.duongvh.restaurant.service.employee.IEmpService;
import com.duongvh.restaurant.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@RestController
public class StatisticalController {

    @Autowired
    public IBillService billService;

    @Autowired
    public IProductService productService;

    @Autowired
    public IDeskService deskService;

    @Autowired
    public IEmpService empService;

    @GetMapping("/statistical")
    public ModelAndView statisticalPage() {
        Date date = new Date(System.currentTimeMillis());
        Iterable<Bill> bills = billService.findByBillTime(date);
        double sum = 0;
        for (Bill b : bills) {
            sum += b.getBillTotal();
        }
        ModelAndView modelAndView = new ModelAndView("/dashboard/index");
        modelAndView.addObject("countEmployee", empService.countByStatusFalse());
        modelAndView.addObject("countBillToday", billService.countByBillTime(date));
        modelAndView.addObject("totalBillToday", sum);
        modelAndView.addObject("countProduct", productService.countByStatusTrue());
        return modelAndView;
    }

}

