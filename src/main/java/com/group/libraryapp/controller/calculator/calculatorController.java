package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.*;

@RestController
//클래스를 api 진입 지점으로 만들어줌
public class calculatorController {
    @GetMapping("/add")
    public int addTwoNumbers(CalculatorAddRequest request){
        return request.getNumber1()+request.getNumber2();
    }
    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request){
        return request.getNumber1()* request.getNumber2();
    }
}
