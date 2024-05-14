package com.devlog.repositories;

import com.devlog.models.Dev;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DevRepository extends MongoRepository<Dev, String> {


}
