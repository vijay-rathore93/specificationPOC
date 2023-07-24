package com.example.specification.repo;

import com.example.specification.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomRepo {
    private final UserRepo userRepository;

    public List<User> getUserWithSpecification(FilterDO filterDO){
        Specification<User> specification=new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get(filterDO.getColumnName()),filterDO.getValue()));
                predicates.add(criteriaBuilder.equal(root.join("address").get("city"),"Ambah"));
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };

        return userRepository.findAll(specification);
    }


}
