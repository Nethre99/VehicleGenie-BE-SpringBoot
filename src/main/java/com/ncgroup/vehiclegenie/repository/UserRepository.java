package com.ncgroup.vehiclegenie.repository;

import com.ncgroup.vehiclegenie.dto.models.User;

public interface UserRepository {

    /**
     * Create User
     * @param - user
     * @return - User
     */
    User createUser(User user);


    /**
     * getUserDetailsByUserEmail
     * @param email
     * @return User
     */
    User getUserDetailsByUserEmail(String email);

}
