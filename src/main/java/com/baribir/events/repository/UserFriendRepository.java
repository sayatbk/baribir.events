package com.baribir.events.repository;

import com.baribir.events.entity.UserFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserFriendRepository extends JpaRepository<UserFriend, UUID> {
}
