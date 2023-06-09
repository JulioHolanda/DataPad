package br.gov.school.projetos3.post.negocio;

import java.time.LocalDateTime;

import br.gov.school.projetos3.geral.util.StringUtil;
import br.gov.school.projetos3.post.dao.PostDAO;
import br.gov.school.projetos3.post.entidade.Post;
import br.gov.school.projetos3.usuario.entidade.UProjetoSocial;
import br.gov.school.projetos3.util.Validador;

public class PostMediator {
	private static PostMediator instance;
	public PostDAO repositorioPost;
	
	private PostMediator() {
		repositorioPost = new PostDAO();
	}
	
	public static PostMediator getInstance() {
		if(instance == null) {
			instance = new PostMediator();
		}
		return instance;
	}
    
	public static String generateId(LocalDateTime dateTime, String idUser) {
        String formattedDateTime = dateTime.toString().replace(":", "");
        return formattedDateTime + "_" + idUser;
    }
	
	public String incluir(Post post) {
		String msg = validar(post); 
        if (msg == null){
        	msg = "Post registrado com Sucesso";
            boolean res = repositorioPost.incluir(post);
            if (!res) {
            	msg = "Erro ao incluir Post no reposit�rio";
            }
        } 
        return msg;
    }

	private String validar(Post post) {

		if (post.getNecessidade() == null){
	        return "Necessidade Invalido";
	    }

		else if (StringUtil.ehNuloOuBranco(post.getDescricao())){
	        return "Descricao Invalida";
	    }

	    return null;
    }

}
