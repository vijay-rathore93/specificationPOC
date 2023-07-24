package com.example.specification;


import com.example.specification.repo.AddressRepo;
import com.example.specification.repo.CustomRepo;
import com.example.specification.repo.FilterDO;
import com.example.specification.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private CustomRepo customRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AddressRepo addressRepo;


    @PostMapping("/users")
    public List<User> getUser(@RequestBody FilterDO filterDO){
        return customRepo.getUserWithSpecification(filterDO);
    }

    @PostMapping("/user")
    public List<User> createUser(){
        List<User> users=new ArrayList<>();
        for(int i=0;i<10;i++){
            User user=new User();

            user.setUsername("User"+i);
            user.setPassword("userPassword"+i);

            Address address=new Address();
            address.setCity("Ambah");
            address.setCountry("USA"+1);
            user.setAddress(address);
            users.add(user);
        }

       List<User>  usersCreated= userRepo.saveAll(users);

        /*List<Address> arr=new ArrayList<>();
       usersCreated.forEach(obj->{
            Address address=new Address();
            address.setCity("Ambah");
            address.setCountry("USA"+obj.getUserId());
            address.setUserId(obj.getUserId());
           arr.add(address);

        });
        addressRepo.saveAll(arr);*/
        return usersCreated;
    }
}
