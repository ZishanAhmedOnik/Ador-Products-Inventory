package com.onik.repository;

import com.onik.entity.Outlet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by onik on 1/7/17.
 */
@Repository
public interface OutletRepository extends JpaRepository<Outlet, Long> {
}
