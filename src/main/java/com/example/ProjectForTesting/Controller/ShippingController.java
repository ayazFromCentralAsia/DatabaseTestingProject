package com.example.ProjectForTesting.Controller;

import com.example.ProjectForTesting.Dto.ShippingDto;
import com.example.ProjectForTesting.Dto.UserDto;
import com.example.ProjectForTesting.Entity.Shipping;
import com.example.ProjectForTesting.Mapper.ShippingMapper;
import com.example.ProjectForTesting.Service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    ShippingMapper shippingMapper;

    @Autowired
    ShippingService shippingService;


    @GetMapping
    public List<Shipping> allShip(){
        return shippingService.getAllShipping();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createShipping(@RequestBody ShippingDto shippingDto){
        Shipping shipping = shippingMapper.toEntity(shippingDto);
        shippingService.createShipping(shipping);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/byId")
    public ResponseEntity<?> findById(@RequestParam int id){
        try {
            return ResponseEntity.ok(shippingService.getShippingById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ошибка при создании shipping");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editUser(@RequestBody ShippingDto shippingDto, @RequestParam int id){
        try {
            return ResponseEntity.ok(shippingService.updateShipping(id,shippingMapper.toEntity(shippingDto)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ошибка при Изменений обьекта");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id){
        if (shippingService.getShippingById(id).isPresent()){
            shippingService.deleteShipping(id);
            ResponseEntity.status(HttpStatus.OK);
        }else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Неправильно веденные данные");
        }
    }
}
