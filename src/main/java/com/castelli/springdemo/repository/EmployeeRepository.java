/*Bohdan Pysarenko © All right reserved.
 *
 */
package com.castelli.springdemo.repository;

import com.castelli.springdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * An implementation of
 *
 * @param
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface  EmployeeRepository extends JpaRepository<Employee, Long> {
}
