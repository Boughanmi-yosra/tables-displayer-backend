package com.yobo.tablesdisplayer.repository;

import com.yobo.tablesdisplayer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
}
