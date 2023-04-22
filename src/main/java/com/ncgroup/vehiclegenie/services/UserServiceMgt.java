package com.ncgroup.vehiclegenie.services;

import com.ncgroup.vehiclegenie.dto.models.ClientInfo;
import com.ncgroup.vehiclegenie.dto.models.User;
import reactor.core.publisher.Mono;

public interface UserServiceMgt {

    /**
     * createUserAccounts
     * @param client
     * @return
     */
    User createUserAccount(ClientInfo client);

    /**
     * getUserByEmail
     * @param client
     * @return
     */
    Mono<User> getUserByEmail(ClientInfo client);
}
