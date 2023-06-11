import java.util.List;
import java.util.ArrayList;
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
	private static UProjetoSocialMediator projetoSocialMediator = UProjetoSocialMediator.getInstance();
	
	public static void main(String[] args) {
        
    	String temp;
    	
    	int opcao = -1;
    	while (opcao != 0) {

	        System.out.println("Bem-vindo(a) à Tela Inicial");
	        System.out.println("============================");
	        System.out.println("Selecione uma opção:");
	        System.out.println("1. Visualizar Projetos");
	        System.out.println("2. Login");
	        System.out.println("3. Cadastrar");
	        System.out.println("0. Sair");

            System.out.print("Digite o número da opção desejada: ");
            opcao = ENTRADA.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Opção selecionada: Visualizar Projetos");
                    int opcaoBusca;
        do {
            exibirMenuBusca();
            opcaoBusca = ENTRADA.nextInt();
            ENTRADA.nextLine(); // Limpar o buffer

            switch (opcaoBusca) {
                case 1:
                    System.out.print("Digite o nome para buscar: ");
                    String nome = ENTRADA.nextLine();
                    List<UProjetoSocial> ongsEncontradasNome = buscarPorNome(projetoSocialMediator, nome);
                    System.out.println("Resultados da busca por nome: "+ nome);
                    exibirResultados(ongsEncontradasNome);
                    break;
                case 2:
                    System.out.print("Digite o estado para buscar: ");
                    String estadoBusca = ENTRADA.nextLine();
                    List<UProjetoSocial> ongsEncontradasEstado = buscarPorEstado(projetoSocialMediator, estadoBusca);
                    System.out.println("Resultados da busca por estado: " + estadoBusca);
                    exibirResultados(ongsEncontradasEstado);
                    break;
                case 3:
                    System.out.print("Digite a categoria para buscar (EDUCACAO, SAUDE, CULTURA): ");
                    String categoriaBusca = ENTRADA.nextLine();
                    EnumCategoria enumCategoria = EnumCategoria.valueOf(categoriaBusca.toUpperCase());
                    List<UProjetoSocial> ongsEncontradasCategoria = buscarPorCategoria(projetoSocialMediator, enumCategoria);
                System.out.println("Resultados da busca por categoria: " + categoriaBusca);
                  exibirResultados(ongsEncontradasCategoria);
                    break;
                case 4:
                    //implementação necessidade
                    break;
                case 0:
                    System.out.println("Saindo da busca...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
            System.out.println();
        } while (opcaoBusca != 0);
			 
                    break;
                case 2:
                    System.out.println("Opção selecionada: Login");
                    // Não precisa, vamo esquecer esse fluxo.
                    break;
                case 3:
                    System.out.println("Opção selecionada: Cadastrar\n");
                    
                    System.out.println("==== Cadastro de Usuário ====\n");
                    
                    do {
                    System.out.print("Nome: ");
                    temp = ENTRADA.nextLine();
                    }while(temp == "" || temp == null);
                    String nome = temp;
                    temp = "";
                    
                    do {
                    System.out.print("Senha: ");
                    temp = ENTRADA.nextLine();
                    }while(temp == "" || temp == null);
                    String senha = temp;
                    temp = "";
                    
                    System.out.println("\n==== Cadastro de Projeto Social ====\n");
                    
                    do {
                    System.out.print("Nome Fantasia: ");
                    temp = ENTRADA.nextLine();
                    }while(temp == "" || temp == null);
                    String nomeFantasia = temp;
                    temp = "";

                    do {
                    System.out.print("CPF/CNPJ: ");
                    temp = ENTRADA.nextLine();
                    }while(temp == "" || temp == null);
                    String cadastroFisJur = temp;
                    temp = "";

                    EnumCategoria[] enumCategoria = EnumCategoria.values();
                    int cont = 1;
                    do {
                    System.out.print("Categoria (escolha por número): \n");
                    for (EnumCategoria eCategoria:enumCategoria ) {
                    	System.out.println(cont+ " - " + eCategoria);
                    	cont++;
                    }
                    temp = ENTRADA.nextLine();
                    }while(temp == "" || temp == null || Integer.parseInt(temp)<1 || Integer.parseInt(temp)>6 );
                    String areaAtacao = temp;
                    temp = "";
                    
                    EnumNicho[] enumNicho = EnumNicho.values();
                    cont = 1;
                    do {
                    System.out.print("Publico Alvo (escolha por número): \n");
                    for(EnumNicho eNicho: enumNicho) {
                    	System.out.println(cont+ " - " + eNicho);
                    	cont++;
                    }
                    temp = ENTRADA.nextLine();
                    }while(temp == "" || temp == null ||Integer.parseInt(temp)<1 || Integer.parseInt(temp)>11);
                    String nicho = temp;
                    temp = "";
                    
                    Categoria categoria = new Categoria();
                    categoria.setCategoria(EnumCategoria.obterPorCodigo(Integer.parseInt(areaAtacao)));
                    categoria.setNicho(EnumNicho.obterPorCodigo(Integer.parseInt(nicho)));

                    do {
                    System.out.print("(Descricao) Fale um pouco sobre o projeto: ");
                    temp = ENTRADA.nextLine();
                    }while(temp == "" || temp == null);
                    String descricao = temp;
                    temp = "";
                    
                    System.out.println("\n==== Cadastro de Localização ====\n");
                    
                    do {
                    System.out.print("País: ");
                    temp = ENTRADA.nextLine();
                    }while(temp == "" || temp == null);
                    String pais = temp;
                    temp = "";
                    
                    do {
                    System.out.print("Estado/Província: ");
                    temp = ENTRADA.nextLine();
                    }while(temp == "" || temp == null);
                    String estado = temp;
                    temp = "";
                    
                    do {
                    System.out.print("Rua: ");
                    temp = ENTRADA.nextLine();
                    }while(temp == "" || temp == null);
                    String rua = temp;
                    temp = "";
                    
                    do {
                    System.out.print("Número do Imóvel: ");
                    temp = ENTRADA.nextLine();
                    }while(temp == "" || temp == null);
                    String numEndereco = temp;
                    temp = "";
                    

                    System.out.print("Complemento (não obrigatório): ");
                    temp = ENTRADA.nextLine();
                    String complemento = temp;
                    temp = "";
                    
                    Localizacao localUProjetoSocial = new Localizacao();
                    localUProjetoSocial.setComplemento(complemento);
                    localUProjetoSocial.setEstadoProv(estado);
                    localUProjetoSocial.setNumero(numEndereco);
                    localUProjetoSocial.setPais(pais);
                    localUProjetoSocial.setRua(rua);
                    
                    System.out.println("\n==== Cadastro de Contato ====\n");
                    
                    do {
                    System.out.print("Telefone: ");
                    temp = ENTRADA.nextLine();
                    }while(temp == "" || temp == null);
                    String telefone = temp;
                    temp = "";
                    
                    do {
                    System.out.print("Email: ");
                    temp = ENTRADA.nextLine();
                    }while(temp == "" || temp == null);
                    String email = temp;
                    temp = "";
                    
                    System.out.print("Rede social 1 (não obrigatório): ");
                    temp = ENTRADA.nextLine();
                    String redeSocial1 = temp;
                    temp = "";
                    
                    System.out.print("Rede social 2 (não obrigatório): ");
                    temp = ENTRADA.nextLine();
                    String redeSocial2 = temp;
                    temp = "";
                    
                    Contato contatoNovoProjeto = new Contato();
                    contatoNovoProjeto.setEmail(email);
                    contatoNovoProjeto.setRedeSocial1(redeSocial1);
                    contatoNovoProjeto.setRedeSocial2(redeSocial2);
                    contatoNovoProjeto.setTelefone(telefone);
                    
                    UProjetoSocial novoProjeto = new UProjetoSocial(projetoSocialMediator.gerarIdDeCnpj(cadastroFisJur), senha, nome, localUProjetoSocial, nomeFantasia, cadastroFisJur,
                    		categoria, contatoNovoProjeto, descricao);
                    
                    System.out.println("\n --- "+projetoSocialMediator.incluir(novoProjeto)+" ---\n");
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite um número válido.");
                    break;
            }
        }
    	
        
   }

	
	public static void exibirMenuBusca() {
        System.out.println("===== Menu de Busca =====");
        System.out.println("1. Buscar por nome");
        System.out.println("2. Buscar por estado");
        System.out.println("3. Buscar por categoria");
        System.out.println("4. Buscar por necessidade");
        System.out.println("0. Sair");
        System.out.print("Digite a opção desejada: ");
    }

    public static List<UProjetoSocial> buscarPorNome(UProjetoSocialMediator projetoSocialMediator, String nome) {
        UProjetoSocial[] todos = projetoSocialMediator.buscarTodos();
        List<UProjetoSocial> resultado = new ArrayList<>();
        for (UProjetoSocial ong : todos) {
            if (ong.getNome().equalsIgnoreCase(nome)) {
                resultado.add(ong);
            }
        }
        return resultado;
    }

    public static List<UProjetoSocial> buscarPorEstado(UProjetoSocialMediator projetoSocialMediator, String estado) {
        UProjetoSocial[] todos = projetoSocialMediator.buscarTodos();
        List<UProjetoSocial> resultado = new ArrayList<>();
        for (UProjetoSocial ong : todos) {
            if (ong.getCep().getEstadoProv().equalsIgnoreCase(estado)) {
                resultado.add(ong);
            }
        }
        return resultado;
    }

     public static List<UProjetoSocial> buscarPorCategoria(UProjetoSocialMediator projetoSocialMediator, EnumCategoria categoria) {
        UProjetoSocial[] todos = projetoSocialMediator.buscarTodos();
        List<UProjetoSocial> resultado = new ArrayList<>();
        for (UProjetoSocial ong : todos) {
            if (ong.getCategoria().getCategoria() == categoria) {
                resultado.add(ong);
            }
        }
        return resultado;
     }
        
     /*public static List<UProjetoSocial> buscarPorPost(UProjetoSocialDAO projetoSocialDAO, EnumNecessidades necessidade)
     {
        UProjetoSocial[] todos = projetoSocialDAO.buscarTodos();
        List<UProjetoSocial> resultado = new ArrayList<>();
        for (UProjetoSocial ong : todos) {
            PostList posts = ong.getPosts();
            for (Post post : posts) {
            	if (post.getNecessidade() == necessidade) {
            		resultado.add(ong;)
            	}
            }
        }
        return resultado;
    }*/

     public static void exibirResultados(List<UProjetoSocial> ongs) {
        if (ongs.isEmpty()) {
            System.out.println("Nenhum resultado encontrado.");
            return;
        }
        for (UProjetoSocial ong : ongs) {
            System.out.println("Nome: " + ong.getNome());
            System.out.println("Categoria: " + ong.getCategoria().getCategoria());
            System.out.println("Localização: " + ong.getCep().getEstadoProv());
            System.out.println("Necessidade: " + ong.getPosts());
            System.out.println("-----");
        }
    }

}
