package com.example.practice1.repo;
import com.example.practice1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RestInterface extends JpaRepository<User, Long>, RestInterfaceCustom {


}
