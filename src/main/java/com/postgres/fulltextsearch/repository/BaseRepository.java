package com.postgres.fulltextsearch.repository;

import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<T> extends PagingAndSortingRepository<T, UUID>, JpaSpecificationExecutor {
    default List<T> search(T obj){
        return findAll((t, cq, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            if(!ObjectUtils.isEmpty(obj)){
                predicates.add(criteriaBuilder.equal(criteriaBuilder.function("fts", String.class,
                        criteriaBuilder.literal(PropertyAccessorFactory.forBeanPropertyAccess(obj).getPropertyValue("description"))), true));
                predicates.add(criteriaBuilder.equal(criteriaBuilder.function("fts", String.class,
                        criteriaBuilder.literal(PropertyAccessorFactory.forBeanPropertyAccess(obj).getPropertyValue("name"))), true));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        });
    }
}
