package org.minat.joblisting.controller;

import org.minat.joblisting.repository.PostRepository;
import org.minat.joblisting.model.Post;
import org.minat.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController
{

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository searchRepo;

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return repo.findAll();
    }

    // posts/java
    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text) {
        return searchRepo.searchByText(text);
    }


    @PostMapping("/post")
    public Post addPost(@RequestBody Post post) {
        return repo.save(post);
    }



}