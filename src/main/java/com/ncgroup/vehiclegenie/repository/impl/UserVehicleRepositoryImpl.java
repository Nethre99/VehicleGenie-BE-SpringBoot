package com.ncgroup.vehiclegenie.repository.impl;

import com.ncgroup.vehiclegenie.dto.models.UserHistory;
import com.ncgroup.vehiclegenie.repository.UserVehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Slf4j
@Repository
public class UserVehicleRepositoryImpl implements UserVehicleRepository {

    private final JdbcTemplate jdbcTemplate;

    private String INSERT_QUERY = "insert into user_vehicle(uv_Id, Client_Id, Vehicle_Id) value (?,?,?)";

    public UserVehicleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boolean addWatchedAdds(UserHistory userHistory) {
        log.info("Create Watched Add :{}", userHistory);
        try {
            GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
            int update = jdbcTemplate.update(connection -> {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, (userHistory.getUv_id()));
                preparedStatement.setInt(2, (userHistory.getClient_Id()));
                preparedStatement.setInt(3, (userHistory.getVehicle_Id()));
                return preparedStatement;
            }, keyHolder);
            log.info("Watched Add Created:{}", update);
            userHistory.setUv_id(keyHolder.getKey().intValue());
            log.info("Watched add {}", userHistory);
            return true;
        } catch (InvalidResultSetAccessException e) {
            log.error("User | {}", e.getSql());
            log.error("User | {}", e.getSQLException().getSQLState());
            throw e;
        } catch (DuplicateKeyException e) {
            log.error("User | {}", e.getMostSpecificCause().getLocalizedMessage());
            throw e;
        } catch (DataAccessException e) {
            log.error("User | {}", e.getMessage());
            throw e;
        }
    }
}
