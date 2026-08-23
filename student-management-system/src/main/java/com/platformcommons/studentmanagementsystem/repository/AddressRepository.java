package com.platformcommons.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platformcommons.studentmanagementsystem.entity.Address;

public interface AddressRepository extends JpaRepository <Address , Long> {

}
