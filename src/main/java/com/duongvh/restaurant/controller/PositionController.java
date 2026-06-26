package com.duongvh.restaurant.controller;

import com.duongvh.restaurant.model.Position;
import com.duongvh.restaurant.service.position.IPositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private IPositionService positionService;

    @GetMapping("/listPosition")
    public ResponseEntity<Iterable<Position>> getAllPosition(){
        return new ResponseEntity<>(positionService.findAll(), HttpStatus.OK);
    }

}
