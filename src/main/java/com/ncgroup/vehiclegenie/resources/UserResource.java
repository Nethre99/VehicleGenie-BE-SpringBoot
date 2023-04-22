package com.ncgroup.vehiclegenie.resources;

import com.ncgroup.vehiclegenie.dto.models.ClientInfo;
import com.ncgroup.vehiclegenie.dto.models.User;
import com.ncgroup.vehiclegenie.services.UserServiceMgt;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
@RequestMapping("usermgt")
@AllArgsConstructor
public class UserResource {

    @Autowired
    private final UserServiceMgt userServiceMgt;


    @PostMapping( "/adduser")
    @ResponseBody
    public User createUser(@RequestBody ClientInfo client){
        log.info("User Resource | client info [{}]", client.toString());
        User user = userServiceMgt.createUserAccount(client);
        log.info("User Resource | User [{}]", user);

        return user;
    }


    @PostMapping("/login")
    @ResponseBody
    public Mono<User> userLogin(@RequestBody ClientInfo client){
        return userServiceMgt.getUserByEmail(client);
    }
}
