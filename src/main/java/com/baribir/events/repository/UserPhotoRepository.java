package com.baribir.events.repository;

import com.baribir.events.entity.UserPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserPhotoRepository extends JpaRepository<UserPhoto, UUID> {
    List<UserPhoto> findByUser_Id(UUID id);

    @Transactional
    @Modifying
    @Query("update UserPhoto u set u.isMain = ?1 where u.id = ?2")
    void updateIsMainById(Boolean isMain, UUID id);

    UserPhoto findByUser_IdAndIsMainTrue(UUID id);

    @Transactional
    @Modifying
    @Query("update UserPhoto u set u.isMain = false where u.user.id = ?1")
    void updateIsMainByUserId(UUID userId);
}
