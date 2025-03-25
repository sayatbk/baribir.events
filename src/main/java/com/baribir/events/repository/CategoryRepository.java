package com.baribir.events.repository;

import com.baribir.events.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = """
    WITH RECURSIVE category_tree AS (
        SELECT * FROM categories WHERE code = :code
        UNION ALL
        SELECT c.* FROM categories c
        INNER JOIN category_tree ct ON c.parent_id = ct.id
    )
    SELECT * FROM category_tree;
    """, nativeQuery = true)
    List<Category> findByCodeWithChildren(@Param("code") String code);
}
