package com.ncgroup.vehiclegenie.repository.impl;

import com.ncgroup.vehiclegenie.dto.VehicleMapper;
import com.ncgroup.vehiclegenie.dto.models.Vehicle;
import com.ncgroup.vehiclegenie.repository.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Slf4j
@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    private final JdbcTemplate jdbcTemplate;

    private final String INSERT_QUERY = "INSERT INTO vehicles(title, sub_title, price, brand, model, edition, year, " +
            "condition, transmission, body, fuel, capacity, mileage, location, description, post_URL, seller_name, " +
            "seller_type, published_date, vehicle_Id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public VehicleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Vehicle> addVehicle(Vehicle vehicle) {
        log.info("Add vehicle Advertisement :{}", vehicle);
        try {
            GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
            int update = jdbcTemplate.update(connection -> {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, (vehicle.getTitle()));
                preparedStatement.setString(2, (vehicle.getSub_title()));
                preparedStatement.setString(3, (vehicle.getPrice()));
                preparedStatement.setString(4, (vehicle.getBrand()));
                preparedStatement.setString(5, (vehicle.getModel()));
                preparedStatement.setString(6, (vehicle.getEdition()));
                preparedStatement.setString(7, (vehicle.getYear()));
                preparedStatement.setString(8, (vehicle.getCondition()));
                preparedStatement.setString(9, (vehicle.getTransmission()));
                preparedStatement.setString(10, (vehicle.getBody()));
                preparedStatement.setString(11, vehicle.getFuel());
                preparedStatement.setString(12, (vehicle.getCapacity()));
                preparedStatement.setString(13, (vehicle.getMileage()));
                preparedStatement.setString(14, (vehicle.getLocation()));
                preparedStatement.setString(15, (vehicle.getDescription()));
                preparedStatement.setString(16, (vehicle.getPost_url()));
                preparedStatement.setString(17, (vehicle.getSeller_name()));
                preparedStatement.setString(18, (vehicle.getSeller_type()));
                preparedStatement.setString(19, (vehicle.getPublished_date()));
                preparedStatement.setBigDecimal(20, (vehicle.getVehicle_Id()));
                return preparedStatement;
            }, keyHolder);
            log.info("Vehicle Created:{}", update);
            vehicle.setVehicle_Id((BigDecimal) keyHolder.getKey());
            log.info("Vehicle Id {}", vehicle.getVehicle_Id());

            return getAllVehicles();
        } catch (InvalidResultSetAccessException e) {
            log.error("Vehicle | InvalidResultSetAccessException {}", e.getSql());
            log.error("Vehicle | InvalidResultSetAccessException 2 {}", e.getSQLException().getSQLState());
            throw e;
        } catch (DuplicateKeyException e) {
            log.error("Vehicle | DuplicateKeyException {}", e.getMostSpecificCause().getLocalizedMessage());
            throw e;
        } catch (DataAccessException e) {
            log.error("Vehicle | DuplicateKeyException {}", e.getMessage());
            throw e;
        }
    }


    @Override
    public List<Vehicle> getAllVehicles() {
        try {
            List<Vehicle> vehicles = jdbcTemplate.query("select * from vehicles", new VehicleMapper());
            log.error("Vehicle Repo | Get All vehicles: {}", vehicles.size());
            return vehicles;
        }catch (EmptyResultDataAccessException e){
            log.error("Vehicle Repo | Result Data Access Exception: {}", e);
            return null;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Vehicle getVehicleById(int vehicleId) {
        log.info("Vehicle Repo | Get Vehicle by Id [{}]", vehicleId);

        try {
            Vehicle vehicle = jdbcTemplate.queryForObject("Select * from vehicles where vehicle_Id=?", new VehicleMapper(), vehicleId);
            log.info("Vehicle Repo | vehicle by Id query : [{}]", vehicle);
            return vehicle;
        }catch (EmptyResultDataAccessException e){

            log.error("Vehicle Repo | Result Data Access Exception: {}", e);
            return null;

        }catch (Exception e){
            log.error("Vehicle Repo | Get Vehicle by Id [{}] throws: {}", vehicleId, e);
            return null;
        }
    }
}

