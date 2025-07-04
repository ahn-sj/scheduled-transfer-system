package tally.transfer.user.domain.repository;

import tally.transfer.user.domain.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    User getById(Long userId);
    void checkExists(Long userId);
}
