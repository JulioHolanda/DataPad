package br.gov.school.projetos3.post.entidade;

import java.util.ArrayList;
import java.util.List;

public class PostList {
    private List<Post> posts;
    
    public PostList() {
        this.posts = new ArrayList<>();
    }
    
    public void addPost(Post post) {
        posts.add(post);
    }
    
    public void deletePost(Post post) {
        posts.remove(post);
    }
}