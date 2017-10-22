package org.gm.user.repository;

import org.gm.user.domain.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AppUser, Long> {
}
