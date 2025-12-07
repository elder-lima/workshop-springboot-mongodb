package com.elder.workshopmongo.repository;

import com.elder.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ " +
            "date: { $gte: ?1, $lt: ?2 }, " +
            "$or: [ " +
            "  { 'title': { $regex: ?0, $options: 'i' } }, " +
            "  { 'body': { $regex: ?0, $options: 'i' } }, " +
            "  { 'comments.text': { $regex: ?0, $options: 'i' } } " +
            "] " +
            "}")
    List<Post> fullSearch(String text, Instant minDate, Instant maxDate);

}
