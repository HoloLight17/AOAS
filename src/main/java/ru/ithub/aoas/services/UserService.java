package ru.ithub.aoas.services;

import ru.ithub.aoas.domain.entity.User;

import java.security.Principal;

public interface UserService {
    User getUserByUsername(String username);

    User getUserByEmail(String email);

    User getUser(Principal principal);

    User getUser(Long id);

    User getCurrentUser();
}
