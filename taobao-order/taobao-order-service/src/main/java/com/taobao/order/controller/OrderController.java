package com.taobao.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Lawrence Li
 * @date 2020/8/7 2:01 PM
 */
@Slf4j
@RestController
public class OrderController {

    @GetMapping(value = "hello")
    public ResponseEntity<String> greeting(){
        return ResponseEntity.status(HttpStatus.OK).body("how are you doing");
    }
}
