package com.baribir.events.repository;

import com.baribir.events.entity.UserFriend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserFriendRepository extends JpaRepository<UserFriend, UUID> {
}
