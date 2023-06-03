package br.gov.school.projetos3.post.dao;

import br.gov.school.projetos3.post.entidade.Post;
import br.gov.school.projetos3.usuario.entidade.Identificavel;
import br.gov.school.projetos3.util.DAOGenerico;

public class PostDAO {
	private static final String FILE_SEP;
    private static final String DIR_BASE;
    private DAOGenerico daoEncapsulado;
    
    static {
        FILE_SEP = System.getProperty("file.separator");
        DIR_BASE = "." + PostDAO.FILE_SEP + "projetos3" + PostDAO.FILE_SEP + "post" + PostDAO.FILE_SEP;
    }
    
    public PostDAO() {
        this.daoEncapsulado = new DAOGenerico(PostDAO.DIR_BASE);
    }
    
    public boolean incluir(final Post post) {
        return this.daoEncapsulado.incluir((Identificavel)post);
    }
    
    public boolean alterar(final Post post) {
        return this.daoEncapsulado.alterar((Identificavel)post);
    }
    
    public Post buscar(final String chave) {
        return (Post)this.daoEncapsulado.buscar(chave);
    }

  //metodo para deletar seria necessario?

}
