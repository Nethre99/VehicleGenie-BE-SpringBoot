package com.ncgroup.vehiclegenie.dto;

import com.ncgroup.vehiclegenie.dto.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return new User(
                resultSet.getInt("client_Id"),
                resultSet.getString("name"),
                resultSet.getString("email")
        );
    }
}
