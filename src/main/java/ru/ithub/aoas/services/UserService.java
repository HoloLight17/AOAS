package ru.ithub.aoas.services;

import java.security.Principal;
import ru.ithub.aoas.domain.entity.User;

public interface UserService {

  User getUserByUsername(String username);

  User getUser(Principal principal);

  User getUser(Long id);

  User getCurrentUser();
}
