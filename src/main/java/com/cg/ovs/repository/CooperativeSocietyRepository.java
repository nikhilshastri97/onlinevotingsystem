package com.cg.ovs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ovs.entities.CooperativeSociety;


@Repository
public interface CooperativeSocietyRepository extends JpaRepository<CooperativeSociety,Integer> {

}
