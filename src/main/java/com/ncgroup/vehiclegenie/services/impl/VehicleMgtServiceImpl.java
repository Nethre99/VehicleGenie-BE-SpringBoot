package com.ncgroup.vehiclegenie.services.impl;

import com.ncgroup.vehiclegenie.client.impl.VehicleGenieClientImpl;
import com.ncgroup.vehiclegenie.dto.AddVehicle;
import com.ncgroup.vehiclegenie.dto.models.Vehicle;
import com.ncgroup.vehiclegenie.repository.VehicleRepository;
import com.ncgroup.vehiclegenie.services.VehicleMgtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class VehicleMgtServiceImpl implements VehicleMgtService {

    private final VehicleGenieClientImpl vehicleGenieClient;
    private final VehicleRepository vehicleRepository;

    public VehicleMgtServiceImpl(VehicleGenieClientImpl vehicleGenieClient, VehicleRepository vehicleRepository) {
        this.vehicleGenieClient = vehicleGenieClient;
        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public Flux<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.getAllVehicles();
        return Flux.fromIterable(vehicles);
    }

    @Override
    public Flux<Vehicle> getRecommendedVehicles(int UserId){
        log.info("Get Recommendations | user id: {}", UserId);
        Flux<Vehicle> vehicles = vehicleGenieClient.getRecommendations(UserId);
        log.info("VehicleGenie Recommendation Service | Get Recommendations for User: {}", UserId);
        return vehicles;
    }

    @Override
    public Flux<Vehicle> addVehicle(AddVehicle addvehicle) {
        UUID myuuid = UUID.randomUUID();
        long highbits = myuuid.getMostSignificantBits();
        long lowbits = myuuid.getLeastSignificantBits();

        int lowbit = (int) (lowbits & Long.MAX_VALUE);

        log.info("UUID | Lowbit [{}], highBit [{}] ", lowbit, highbits);

        Vehicle vehicle = Vehicle.builder()
                .body(addvehicle.getBody())
                .brand(addvehicle.getBrand())
                .vehicle_Id(BigDecimal.valueOf(lowbit))
                .edition(addvehicle.getEdition())
                .title(addvehicle.getTitle())
                .sub_title(addvehicle.getSub_title())
                .capacity(addvehicle.getCapacity())
                .mileage(addvehicle.getMileage())
                .condition(addvehicle.getCondition())
                .fuel(addvehicle.getFuel())
                .price(String.valueOf(addvehicle.getPrice()))
                .model(addvehicle.getModel())
                .year(String.valueOf(addvehicle.getYear()))
                .transmission(addvehicle.getTransmission())
                .fuel(addvehicle.getFuel())
                .capacity(addvehicle.getCapacity())
                .mileage(addvehicle.getMileage())
                .location(addvehicle.getLocation())
                .description(addvehicle.getDescription())
                .post_url(addvehicle.getPost_Url())
                .seller_name(addvehicle.getSeller_Name())
                .seller_type(addvehicle.getSeller_Type())
                .published_date(addvehicle.getPublished_Date())
                .build();

        List<Vehicle> vehicleList = vehicleRepository.addVehicle(vehicle);

        log.info("Vehicle Service MGT | Add vehicle return list length: {}", vehicleList.size());

        return Flux.fromIterable(vehicleList);
    }
}
