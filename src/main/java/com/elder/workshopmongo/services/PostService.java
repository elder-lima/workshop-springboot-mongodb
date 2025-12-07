package com.elder.workshopmongo.services;

import com.elder.workshopmongo.domain.Post;
import com.elder.workshopmongo.repository.PostRepository;
import com.elder.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
