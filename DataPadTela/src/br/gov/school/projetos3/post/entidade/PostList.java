package br.gov.school.projetos3.post.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import br.gov.school.projetos3.post.Enum.EnumNecessidades;
import br.gov.school.projetos3.post.negocio.PostMediator;
import br.gov.school.projetos3.usuario.entidade.UProjetoSocial;

@SuppressWarnings("serial")
public class PostList implements Serializable {
	private static final long serialVersionUID = 2210250118L;
    private ArrayList<Post> posts;
    
    public PostList() {
        this.posts = new ArrayList<Post>();
    }
    
    public void addPost(UProjetoSocial projetoSocial, Post post) {
    	PostMediator postMediator = PostMediator.getInstance();
	    if(postMediator.validar(post) == null) {
	    	
	    	if(this.posts.size() == 3) {
	    		this.posts.remove(0);
	    		this.posts.set(0, posts.get(1));
	    		this.posts.set(1, posts.get(2));
	    	}
	    	
		    this.posts.add(post);
		    projetoSocial.setPostList(this);
		    postMediator.incluir(projetoSocial);
	    }
    }

        
    public ArrayList<Post> getAllPosts(){
    	Collections.reverse(posts);
    	return posts;
    }
    
    public boolean isEmpty() {
    	return posts.isEmpty();
    }
}