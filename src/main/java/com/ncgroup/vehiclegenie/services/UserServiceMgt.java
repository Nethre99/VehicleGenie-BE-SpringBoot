package com.ncgroup.vehiclegenie.services;

import com.ncgroup.vehiclegenie.dto.models.ClientInfo;
import com.ncgroup.vehiclegenie.dto.models.User;
import reactor.core.publisher.Mono;

public interface UserServiceMgt {

    /**
     *
     * @param client
     * @return
     */
    User createUserAccount(ClientInfo client);

    /**
     *
     * @param client
     * @return
     */
    Mono<User> getUserByEmail(ClientInfo client);
}
