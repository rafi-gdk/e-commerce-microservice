package com.sonu.customer.repository;


import com.sonu.customer.beans.entity.UserDetailsImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetailsImpl, String> {

}
