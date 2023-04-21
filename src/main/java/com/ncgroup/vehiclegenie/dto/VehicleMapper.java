package com.ncgroup.vehiclegenie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.ncgroup.vehiclegenie.dto.models.Vehicle;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class VehicleMapper implements RowMapper<Vehicle> {
    @Override
    public Vehicle mapRow(ResultSet rs, int i) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_Id(BigDecimal.valueOf(rs.getInt("vehicle_Id")));
        vehicle.setTitle(rs.getString("title"));
        vehicle.setSub_title(rs.getString("sub_title"));
        vehicle.setPrice(rs.getString("price"));
        vehicle.setBrand(rs.getString("brand"));
        vehicle.setModel(rs.getString("model"));
        vehicle.setEdition(rs.getString("edition"));
        vehicle.setYear(rs.getString("year"));
        vehicle.setCondition(rs.getString("condition"));
        vehicle.setTransmission(rs.getString("transmission"));
        vehicle.setBody(rs.getString("body"));
        vehicle.setFuel(rs.getString("fuel"));
        vehicle.setCapacity(rs.getString("capacity"));
        vehicle.setMileage(rs.getString("mileage"));
        vehicle.setLocation(rs.getString("location"));
        vehicle.setDescription(rs.getString("description"));
        vehicle.setPost_url(rs.getString("post_URL"));
        vehicle.setSeller_name(rs.getString("seller_name"));
        vehicle.setSeller_type(rs.getString("seller_type"));
        vehicle.setPublished_date(rs.getString("published_date"));
        return vehicle;
    }
}
