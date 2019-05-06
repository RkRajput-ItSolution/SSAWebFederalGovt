package com.ssa.federal.gov.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssa.federal.gov.entity.SSAAppStateEntity;

@Repository
public interface SSAAppStateRepository extends CrudRepository<SSAAppStateEntity, Serializable> {

List<SSAAppStateEntity>	findAll();
}
