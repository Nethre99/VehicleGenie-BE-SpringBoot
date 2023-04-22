package com.ncgroup.vehiclegenie.services.impl;

import com.ncgroup.vehiclegenie.dto.models.ClientInfo;
import com.ncgroup.vehiclegenie.dto.models.User;
import com.ncgroup.vehiclegenie.repository.UserRepository;
import com.ncgroup.vehiclegenie.services.UserServiceMgt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Service
public class UserServiceMgtImpl implements UserServiceMgt {

    private final UserRepository userRepository;

    public UserServiceMgtImpl(UserRepository userHistory) {
        this.userRepository = userHistory;
    }

    @Override
    public User createUserAccount(ClientInfo client) {
        UUID myuuid = UUID.randomUUID();
        long highbits = myuuid.getMostSignificantBits();
        long lowbits = myuuid.getLeastSignificantBits();

        int lowbit = (int) (lowbits & Long.MAX_VALUE);

        log.info("UUID | Lowbit [{}], highBit [{}] ", lowbit, highbits);

        User user = new User((int) lowbits, client.getEmail(), client.getName());
        User createdUser;
//        Check user existence
        User existence = userRepository.getUserDetailsByUserEmail(client.getEmail());
        if ( existence == null){
            createdUser = userRepository.createUser(user);
        }else {
            createdUser = existence;
        }

        return createdUser;
    }

    @Override
    public Mono<User> getUserByEmail(ClientInfo client) {
        User user = userRepository.getUserDetailsByUserEmail(client.getEmail());
        return Mono.just(user);
    }
}
