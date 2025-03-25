package com.baribir.events.repository;

import com.baribir.events.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

    @Query(value = """
    SELECT u.*
    FROM users u
    JOIN event_participants ep ON u.id = ep.user_id
    WHERE ep.event_id = :event
""", nativeQuery = true)
    List<User> findByEvent(@Param("event") UUID event);
}
