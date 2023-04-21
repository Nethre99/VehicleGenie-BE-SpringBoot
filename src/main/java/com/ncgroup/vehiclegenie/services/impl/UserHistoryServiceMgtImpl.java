package com.ncgroup.vehiclegenie.services.impl;

import com.ncgroup.vehiclegenie.dto.models.UserHistory;
import com.ncgroup.vehiclegenie.dto.models.Vehicle;
import com.ncgroup.vehiclegenie.repository.UserVehicleRepository;
import com.ncgroup.vehiclegenie.repository.VehicleRepository;
import com.ncgroup.vehiclegenie.services.UserHistoryServiceMgt;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class UserHistoryServiceMgtImpl implements UserHistoryServiceMgt {

    private final UserVehicleRepository userVehicleRepository;

    private final VehicleRepository vehicleRepository;

    @Override
    public Mono<Vehicle> addWatchedAdd(int userId, int vehicleId) {

        UUID myuuid = UUID.randomUUID();
        long highbits = myuuid.getMostSignificantBits();
        long lowbits = myuuid.getLeastSignificantBits();

        log.info("UUID | Lowbit [{}], highBit [{}] ",lowbits,highbits);

        UserHistory userHistory = new UserHistory((int) lowbits,userId, vehicleId);

        Boolean insertion = userVehicleRepository.addWatchedAdds(userHistory);

        Vehicle converterVehicle = new Vehicle();

        if (insertion){
            Vehicle vehicle = vehicleRepository.getVehicleById(vehicleId);
            log.info("Get Vehicle by Id [{}]", vehicle);
            converterVehicle = Vehicle.builder()
                    .vehicle_Id(vehicle.getVehicle_Id())
                    .title(vehicle.getTitle())
                    .body(vehicle.getBody())
                    .brand(vehicle.getBrand())
                    .price(vehicle.getPrice())
                    .fuel(vehicle.getFuel())
                    .edition(vehicle.getEdition())
                    .mileage(vehicle.getMileage())
                    .model(vehicle.getModel())
                    .description(vehicle.getDescription())
                    .condition(vehicle.getCondition())
                    .location(vehicle.getLocation())
                    .capacity(vehicle.getCapacity())
                    .post_url(vehicle.getPost_url())
                    .seller_name(vehicle.getSeller_name())
                    .transmission(vehicle.getTransmission())
                    .sub_title(vehicle.getSub_title())
                    .seller_type(vehicle.getSeller_type())
                    .published_date(vehicle.getPublished_date())
                    .build();
        }

        return Mono.just(converterVehicle);
    }
}
