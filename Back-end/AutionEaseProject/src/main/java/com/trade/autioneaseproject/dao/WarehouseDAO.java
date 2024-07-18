package com.trade.autioneaseproject.dao;

import com.trade.autioneaseproject.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WarehouseDAO extends JpaRepository<Warehouse, Integer> {

    //Retrieve only non-deleted data
    @Query("SELECT w FROM Warehouse w WHERE w.delflag = false")
    List<Warehouse> getAll();

    @Query("SELECT w FROM Warehouse w WHERE w.warehouseID = :id AND w.delflag = false")
    Optional<Warehouse> findWarehouseById(Integer id);
}