package br.gov.school.projetos3.post.entidade;

import java.io.Serializable;
import java.util.ArrayList;

import br.gov.school.projetos3.post.Enum.EnumNecessidades;
import br.gov.school.projetos3.post.negocio.PostMediator;

@SuppressWarnings("serial")
public class PostList implements Serializable {
    private ArrayList<Post> posts;
    private PostMediator postMediator;
    
    public PostList() {
        this.posts = new ArrayList<>();
    }
    
    public void addPost(Post post) {
        posts.add(post);
        postMediator.incluir(post);
        
    }
    
    public Post getSpecificPost(EnumNecessidades necessidade) {
        for (Post post : posts) {
        	if (post.getNecessidade() == necessidade) {
        		return post;
        	}
        }
        
        return null;
    }
        
    public ArrayList<Post> getAllPosts(){
    	return posts;
    }
}