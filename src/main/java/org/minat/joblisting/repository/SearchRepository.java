package org.minat.joblisting.repository;

import org.minat.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> searchByText(String text);

}
