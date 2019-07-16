package org.maple.quickstart.dao;

import org.maple.quickstart.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User,Long> {

}
