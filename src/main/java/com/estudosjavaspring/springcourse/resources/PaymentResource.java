package com.estudosjavaspring.springcourse.resources;

import com.estudosjavaspring.springcourse.entities.Payment;
import com.estudosjavaspring.springcourse.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @GetMapping
    public ResponseEntity<List<Payment>> findAll(){
        List<Payment> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    public ResponseEntity<Payment> findById(@PathVariable Long id){
        Payment obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
