package com.jun.springcloud.conrroller;

import com.jun.springcloud.entities.CommonResult;
import com.jun.springcloud.entities.Payment;
import com.jun.springcloud.service.PaymentService;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Log4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("************插入结果" + result);
        System.out.println("hooosdfsdsfs");
        if (result > 0) {
            return new CommonResult(200, "插入数据成功", result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("************查询结果" + payment);
        System.out.println("nihoa");
        log.info("hello everyone gsdfgsdfg");
        System.out.println("fsdfsdfsdfsdfsdf");
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID: " + id, null);
        }
    }
}
