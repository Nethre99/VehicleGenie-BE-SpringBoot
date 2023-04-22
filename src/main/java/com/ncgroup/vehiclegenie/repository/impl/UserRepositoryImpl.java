package com.ncgroup.vehiclegenie.repository.impl;

import com.ncgroup.vehiclegenie.dto.UserMapper;
import com.ncgroup.vehiclegenie.dto.models.User;
import com.ncgroup.vehiclegenie.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;

@Slf4j
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    private final String INSERT_QUERY = "insert into client(client_Id, name, email) value (?,?,?)";

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User createUser(User user) {
        log.info("Create Watched Add :{}", user);
        try {
            GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
            int update = jdbcTemplate.update(connection -> {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, (user.getClient_Id()));
                preparedStatement.setString(2, (user.getName()));
                preparedStatement.setString(3, (user.getEmail()));
                return preparedStatement;
            }, keyHolder);
            log.info("User Created:{}", update);
            user.setClient_Id(Objects.requireNonNull(keyHolder.getKey()).intValue());
            log.info("User Id {}", user.getClient_Id());
            return user;
        } catch (InvalidResultSetAccessException e) {
            log.error("User | InvalidResultSetAccessException {}", e.getSql());
            log.error("User | InvalidResultSetAccessException 2 {}", e.getSQLException().getSQLState());
            throw e;
        } catch (DuplicateKeyException e) {
            log.error("User | DuplicateKeyException {}", e.getMostSpecificCause().getLocalizedMessage());
            throw e;
        } catch (DataAccessException e) {
            log.error("User | DuplicateKeyException {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public User getUserDetailsByUserEmail(String email) {
        log.info("User Repo | Get User by Email [{}]", email);

        try {
            User user = jdbcTemplate.queryForObject("Select * from client where email=?", new UserMapper(), email);
            log.info("User Repo | User query : [{}]", user);
            return user;
        }catch (EmptyResultDataAccessException e){

            log.error("User Repo | Result Data Access Exception: {}", e);
            return null;

        }catch (Exception e){
            log.error("User Repo | Get User by email [{}] throws: {}", email, e);
            return null;
        }
    }
}
