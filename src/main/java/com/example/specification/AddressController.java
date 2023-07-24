package com.example.specification;

import com.example.specification.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressRepo addressRepo;


    @GetMapping("/addresses")
    public List<Address> getUser(){
        return addressRepo.findAll();
    }

}
