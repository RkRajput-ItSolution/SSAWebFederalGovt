package com.ssa.federal.gov.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssa.federal.gov.entity.SSAAppEntity;

@Repository
public interface SSAAppRepository extends JpaRepository<SSAAppEntity, Serializable> {

	

	
}
