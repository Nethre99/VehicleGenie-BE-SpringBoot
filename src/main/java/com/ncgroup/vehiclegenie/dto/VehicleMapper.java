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
        vehicle.setVehicle_Id(BigDecimal.valueOf(rs.getInt("Vehicle_Id")));
        vehicle.setTitle(rs.getString("Title"));
        vehicle.setSub_title(rs.getString("Sub_title"));
        vehicle.setPrice(rs.getString("Price"));
        vehicle.setBrand(rs.getString("Brand"));
        vehicle.setModel(rs.getString("Model"));
        vehicle.setEdition(rs.getString("Edition"));
        vehicle.setYear(rs.getString("Year"));
        vehicle.setCondition(rs.getString("Condition"));
        vehicle.setTransmission(rs.getString("Transmission"));
        vehicle.setBody(rs.getString("Body"));
        vehicle.setFuel(rs.getString("Fuel"));
        vehicle.setCapacity(rs.getString("Capacity"));
        vehicle.setMileage(rs.getString("Mileage"));
        vehicle.setLocation(rs.getString("Location"));
        vehicle.setDescription(rs.getString("Description"));
        vehicle.setPost_url(rs.getString("Post_URL"));
        vehicle.setSeller_name(rs.getString("Seller_name"));
        vehicle.setSeller_type(rs.getString("Seller_type"));
        vehicle.setPublished_date(rs.getString("published_date"));
        return vehicle;
    }
}
