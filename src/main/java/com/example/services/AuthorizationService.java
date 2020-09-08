package com.example.services;

import com.example.models.User;

public class AuthorizationService {

    private UserService userService;

    public AuthorizationService() {
        userService = new UserService();
    }

    public String login(User user) {
        if (user != null && user.getLogin() != null && user.getPassword() != null) {
            User userDB = userService.findUserByLogin(user.getLogin());
            if (userDB != null) {
                if (userDB.getPassword().equals(userService.convertUser(user).getPassword())) {
                    return generateAuthorizationToken();
                }
            }
        }
        return null;
    }

    public String generateAuthorizationToken() {
        //Todo complete
        return "someAuthorizationToken";
    }
}
