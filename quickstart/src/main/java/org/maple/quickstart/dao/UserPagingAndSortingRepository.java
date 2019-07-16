package org.maple.quickstart.dao;

import org.maple.quickstart.pojo.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User,Long> {
}
