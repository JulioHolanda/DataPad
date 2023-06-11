import java.util.Scanner;
import br.gov.school.projetos3.usuario.entidade.UProjetoSocial;
import br.gov.school.projetos3.usuario.negocio.UProjetoSocialMediator;
import br.gov.school.projetos3.util.Enum.EnumCategoria;
import br.gov.school.projetos3.util.Enum.EnumNicho;
import br.gov.school.projetos3.util.entidade.Categoria;
import br.gov.school.projetos3.util.entidade.Contato;
import br.gov.school.projetos3.util.entidade.Localizacao;

public class BussolaSolidaria {

	private static final Scanner ENTRADA = new Scanner(System.in);
	public static void main(String[] args) {
        
    	String temp;
    	
        System.out.println("==== Cadastro de Usuário ====");
        
        do {
        System.out.print("Nome: ");
        temp = ENTRADA.nextLine();
        }while(temp == "" || temp == null);
        String nome = ENTRADA.nextLine();
        temp = "";
        
        do {
        System.out.print("Senha: ");
        temp = ENTRADA.nextLine();
        }while(temp == "" || temp == null);
        String senha = ENTRADA.nextLine();
        temp = "";
        
        System.out.println("\n==== Cadastro de Projeto Social ====");
        
        do {
        System.out.print("Nome Fantasia: ");
        temp = ENTRADA.nextLine();
        }while(temp == "" || temp == null);
        String nomeFantasia = ENTRADA.nextLine();
        temp = "";

        do {
        System.out.print("CPF/CNPJ: ");
        temp = ENTRADA.nextLine();
        }while(temp == "" || temp == null);
        String cadastroFisJur = ENTRADA.nextLine();
        temp = "";

        EnumCategoria[] enumCategoria = EnumCategoria.values();
        int cont = 1;
        do {
        System.out.print("Categoria (escolha por número): \n");
        for (EnumCategoria eCategoria:enumCategoria ) {
        	System.out.println(cont+ " - " + eCategoria+"\n");
        	cont++;
        }
        temp = ENTRADA.nextLine();
        }while(temp == "" || temp == null || Integer.parseInt(temp)<1 || Integer.parseInt(temp)>6 );
        String areaAtacao = ENTRADA.nextLine();
        temp = "";
        
        EnumNicho[] enumNicho = EnumNicho.values();
        cont = 1;
        do {
        System.out.print("Publico Alvo (escolha por número): \n");
        for(EnumNicho eNicho: enumNicho) {
        	System.out.println(cont+ " - " + eNicho+"\n");
        	cont++;
        }
        temp = ENTRADA.nextLine();
        }while(temp == "" || temp == null ||Integer.parseInt(temp)<1 || Integer.parseInt(temp)>11);
        String nicho = ENTRADA.nextLine();
        temp = "";
        
        Categoria categoria = new Categoria();
        categoria.setCategoria(EnumCategoria.obterPorCodigo(Integer.parseInt(areaAtacao)));
        categoria.setNicho(EnumNicho.obterPorCodigo(Integer.parseInt(nicho)));

        do {
        System.out.print("(Descricao) Fale um pouco sobre o projeto: ");
        temp = ENTRADA.nextLine();
        }while(temp == "" || temp == null);
        String descricao = ENTRADA.nextLine();
        temp = "";
        
        System.out.println("\n==== Cadastro de Localização ====");
        
        do {
        System.out.print("País: ");
        temp = ENTRADA.nextLine();
        }while(temp == "" || temp == null);
        String pais = ENTRADA.nextLine();
        temp = "";
        
        do {
        System.out.print("Estado/Província: ");
        temp = ENTRADA.nextLine();
        }while(temp == "" || temp == null);
        String estado = ENTRADA.nextLine();
        temp = "";
        
        do {
        System.out.print("Rua: ");
        temp = ENTRADA.nextLine();
        }while(temp == "" || temp == null);
        String rua = ENTRADA.nextLine();
        temp = "";
        
        do {
        System.out.print("Número do Imóvel: ");
        temp = ENTRADA.nextLine();
        }while(temp == "" || temp == null);
        String numEndereco = ENTRADA.nextLine();
        temp = "";
        

        System.out.print("Complemento (não obrigatório): ");
        temp = ENTRADA.nextLine();
        String complemento = ENTRADA.nextLine();
        temp = "";
        
        Localizacao localUProjetoSocial = new Localizacao();
        localUProjetoSocial.setComplemento(complemento);
        localUProjetoSocial.setEstadoProv(estado);
        localUProjetoSocial.setNumero(numEndereco);
        localUProjetoSocial.setPais(pais);
        localUProjetoSocial.setRua(rua);
        
        System.out.println("\n==== Cadastro de Contato ====");
        
        do {
        System.out.print("Telefone: ");
        temp = ENTRADA.nextLine();
        }while(temp == "" || temp == null);
        String telefone = ENTRADA.nextLine();
        temp = "";
        
        do {
        System.out.print("Email: ");
        temp = ENTRADA.nextLine();
        }while(temp == "" || temp == null);
        String email = ENTRADA.nextLine();
        temp = "";
        
        System.out.print("Rede social 1 (não obrigatório): ");
        temp = ENTRADA.nextLine();

        String redeSocial1 = ENTRADA.nextLine();
        temp = "";
        
        System.out.print("Rede social 2 (não obrigatório): ");
        temp = ENTRADA.nextLine();
        String redeSocial2 = ENTRADA.nextLine();
        temp = "";
        
        Contato contatoNovoProjeto = new Contato();
        contatoNovoProjeto.setEmail(email);
        contatoNovoProjeto.setRedeSocial1(redeSocial1);
        contatoNovoProjeto.setRedeSocial2(redeSocial2);
        contatoNovoProjeto.setTelefone(telefone);
 
        UProjetoSocialMediator projetoMediator = UProjetoSocialMediator.getInstance();
        
        UProjetoSocial novoProjeto = new UProjetoSocial(projetoMediator.gerarIdDeCnpj(cadastroFisJur), senha, nome, localUProjetoSocial, nomeFantasia, cadastroFisJur,
        		categoria, contatoNovoProjeto, descricao);
        
        System.out.println(projetoMediator.incluir(novoProjeto));
    }

	

}
