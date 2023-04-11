package com.eindopdracht.eindopdracht.repository;

import com.eindopdracht.eindopdracht.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}

