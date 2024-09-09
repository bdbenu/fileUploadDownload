package com.bd.benu.repositary;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bd.benu.model.UserDetails;

public interface UserdetailsRepositary extends JpaRepository<UserDetails, Serializable>{

}
