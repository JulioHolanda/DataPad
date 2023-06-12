package br.gov.school.projetos3.post.negocio;

import br.gov.school.projetos3.geral.util.StringUtil;
import br.gov.school.projetos3.post.entidade.Post;
import br.gov.school.projetos3.usuario.dao.UProjetoSocialDAO;
import br.gov.school.projetos3.usuario.entidade.UProjetoSocial;

public class PostMediator{
	private static PostMediator instance;
	public UProjetoSocialDAO repositorioPost;
	
	private PostMediator() {
		repositorioPost = new UProjetoSocialDAO();
	}
	
	public static PostMediator getInstance() {
		if(instance == null) {
			instance = new PostMediator();
		}
		return instance;
	}
    
	public String incluir(UProjetoSocial projetoSocial) {

    	String msg = "Post registrado com Sucesso";
        boolean res = repositorioPost.alterar(projetoSocial);
        if (!res) {
        	msg = "Erro ao incluir Post no reposit�rio";
        }
         
        return msg;
    }

	public String validar(Post post) {

		if (post.getNecessidade() == null){
	        return "Necessidade Invalido";
	    }

		else if (StringUtil.ehNuloOuBranco(post.getDescricao())){
	        return "Descricao Invalida";
	    }

	    return null;
    }

}
