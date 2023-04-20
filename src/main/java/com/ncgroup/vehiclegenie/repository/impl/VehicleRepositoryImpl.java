package com.ncgroup.vehiclegenie.repository.impl;

import com.ncgroup.vehiclegenie.dto.VehicleMapper;
import com.ncgroup.vehiclegenie.dto.models.Vehicle;
import com.ncgroup.vehiclegenie.repository.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Slf4j
@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    private final JdbcTemplate jdbcTemplate;

    public VehicleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        try {
            List<Vehicle> vehicles = jdbcTemplate.query("select * from vehicles", new VehicleMapper());
            return vehicles;
        }catch (EmptyResultDataAccessException e){
            log.error("Vehicle Repo | Result Data Access Exception: {}", e);
            return null;
        }catch (Exception e){
            return null;
        }
    }
}
