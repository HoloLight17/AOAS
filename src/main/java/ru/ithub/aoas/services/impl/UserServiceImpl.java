package ru.ithub.aoas.services.impl;

import java.security.Principal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.ithub.aoas.domain.entity.User;
import ru.ithub.aoas.domain.repository.UserRepository;
import ru.ithub.aoas.exceptions.NotFoundException;
import ru.ithub.aoas.services.UserService;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public User getUserByUsername(String username) {
    return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException(User.class, username));
  }

  @Override
  public User getUser(Principal principal) {
    return this.getUserByUsername(principal.getName());
  }


  @Override
  public User getUser(Long id) {
    return userRepository.findById(id).orElseThrow(() -> new NotFoundException(User.class, id));
  }


  @Override
  public User getCurrentUser() {
    return getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
  }

}
