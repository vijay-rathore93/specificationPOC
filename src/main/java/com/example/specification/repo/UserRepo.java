package com.example.specification.repo;

import com.example.specification.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.function.Predicate;

public interface UserRepo extends JpaRepository<User,Integer> , JpaSpecificationExecutor<User> {


}
