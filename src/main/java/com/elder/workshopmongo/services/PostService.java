package com.elder.workshopmongo.services;

import com.elder.workshopmongo.domain.Post;
import com.elder.workshopmongo.repository.PostRepository;
import com.elder.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post não encontrado."));
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitle(text);
    }

    public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate) {
        // início do minDate (00:00)
        Instant min = minDate
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant();

        // início do dia seguinte ao maxDate (para incluir o dia inteiro)
        Instant max = maxDate
                .plusDays(1)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant();

        return repository.fullSearch(text, min, max);
    }

}
