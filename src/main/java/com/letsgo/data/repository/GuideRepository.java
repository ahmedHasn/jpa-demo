package com.letsgo.data.repository;

import com.letsgo.data.entities.Guide;
import com.letsgo.data.projection.GuideNameSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface GuideRepository extends JpaRepository<Guide, Long> {

//    @Query(value = """
//        select g.name, g.salary, g.created_at, g.updated_at from guide g where g.salary > :salary limit 2
//        """, nativeQuery = true)
    List<GuideNameSalary> findFirst2BySalaryGreaterThan(BigDecimal salary);
}
