package com.example.demo.repository;

import com.example.demo.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findByCategoryId(long id);
    List<PostEntity> findAllById(long id);


    @Modifying
    @Transactional
    @Query("update PostEntity post set post.title=:qTitle, post.description=:qDescription,post.categoryId=:qCategoryId where post.id=:qId")
    public void updatePost(@Param ("qTitle") String title,
                          @Param ("qDescription") String description,
                          @Param("qCategoryId") long categoryId,

                          @Param ("qId") long id);


 }
