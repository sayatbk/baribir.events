package com.baribir.events.repository;

import com.baribir.events.entity.Category;
import com.baribir.events.entity.Event;
import com.baribir.events.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {

    List<Event> findByCategoryInAndDate(Collection<Category> categories, LocalDate date);

    @Query("""
        SELECT e FROM Event e
        WHERE (:categories IS NULL OR e.category IN :categories)
        AND (:eventDate IS NULL OR e.date = :eventDate)
        AND (:interests IS NULL OR EXISTS (
            SELECT 1 FROM Interest i
            WHERE i.name IN :interests
        ))
    """)
    List<Event> findEventsByParams(
            @Param("categories") List<Category> categories,
            @Param("interests") List<String> interests,
            @Param("eventDate") LocalDate eventDate
    );

    @Query(value = """
        SELECT e.*
        FROM events e
        JOIN (
            SELECT ep.event_id, COUNT(ep.user_id) AS participant_count
            FROM event_participants ep
            WHERE ep.is_staff = false
            GROUP BY ep.event_id
        ) participants ON e.id = participants.event_id
        WHERE e.date >= CURRENT_DATE
        AND e.date < CURRENT_DATE + INTERVAL '30 days'
        ORDER BY participants.participant_count DESC
        LIMIT 10
    """, nativeQuery = true)
    List<Event> getPopular();

    @Query(value = """
        SELECT u.*
        FROM users u
        JOIN event_participants ep ON u.id = ep.user_id
        WHERE ep.event_id = :event
    """, nativeQuery = true)
    List<User> findUsersByEvent(@Param("event") UUID event);
}
