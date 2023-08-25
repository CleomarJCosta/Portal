package com.store.car.controller;

import com.store.car.dto.CarPostDTO;
import com.store.car.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sales")
public class CarPostController {
    @Autowired
    private CarPostService carPostService;
    @GetMapping("/car")
    public ResponseEntity<List<CarPostDTO>> getCarSales(){
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostService.getCarSales());
    }
    @PutMapping("car/{id}")
    public ResponseEntity changeCarSale(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") Long id){
        carPostService.changeCarSales(carPostDTO, Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("car/{id}")
    public ResponseEntity deleteCarForSale(@PathVariable("id") Long id){
        carPostService.removeCarSale(Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
