package br.gov.school.projetos3.main;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import br.gov.school.projetos3.geral.util.StringUtil;
import br.gov.school.projetos3.post.Enum.EnumNecessidades;
import br.gov.school.projetos3.post.entidade.Post;
import br.gov.school.projetos3.relatorio.entidade.Relatorio;
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
	private static UProjetoSocial projetoSocial;
	private static boolean isLogged = false;
	
	public static void main(String[] args) {
    	
    	int opcao = -1;
	    while (opcao != 0) {
	    	
	    	if(isLogged) {
	    		
	    		exibirMenuInicialLogado();
	    		
	    		opcao = ENTRADA.nextInt();
	    		
	            switch (opcao) {
	                case 1:
	                    exibirOpcaoBusca();
	                    break;
	                case 2:
	                	exibirOpcaoPerfil();
	                    
	                    break;
	                case 0:
	                    System.out.println("Deslogando...");
	                    isLogged = false;
	                    opcao = -1;
	                    
	                    break;
	                default:
	                    System.out.println("Opção inválida. Digite um número válido.");
	                    
	                    break;
	            }
	    	}
	    	else {
		        exibirMenuInicialDeslogado();
	    		
	            opcao = ENTRADA.nextInt();
	
	            switch (opcao) {
	                case 1:
	                	exibirOpcaoBusca();
	                	
	                    break;
	                case 2:
	                    exibirOpcaoLogin();
	                    
	                    break;
	                case 3:
	                	exibirOpcaoCadastro();
	                	
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
        
   }
	
	public static void exibirMenuInicialDeslogado() {
		System.out.println("Bem-vindo(a) à Tela Inicial");
        System.out.println("============================");
        System.out.println("Selecione uma opção:");
        System.out.println("1. Visualizar Projetos");
        System.out.println("2. Login");
        System.out.println("3. Cadastrar");
        System.out.println("0. Sair");
        System.out.print("Digite o número da opção desejada: ");
	}
	
	public static void exibirMenuInicialLogado() {
		System.out.println("Bem-vindo(a) à Tela Inicial");
        System.out.println("============================");
        System.out.println("Selecione uma opção:");
        System.out.println("1. Visualizar Projetos");
        System.out.println("2. Ver Perfil");
        System.out.println("0. Deslogar");
        System.out.print("Digite o número da opção desejada: ");
	}
	
	public static void exibirMenuBusca() {
        System.out.println("\n\n===== Menu de Busca =====");
        System.out.println("1. Buscar por nome");
        System.out.println("2. Buscar por estado");
        System.out.println("3. Buscar por categoria");
        System.out.println("4. Buscar por necessidade");
        System.out.println("0. Sair");
        System.out.print("Digite a opção desejada: ");
    }
	
	public static void exibirMeuPerfil() {
		System.out.println("\nOpção selecionada: Ver Perfil");
		System.out.println("===== Meu Perfil =====");
        System.out.println("1. Postar uma necessidade");
        System.out.println("2. Adicionar uma atualização");
        System.out.println("3. Ver Publicações");
        System.out.println("0. Retornar");
        System.out.print("Digite a opção desejada: ");
    }
	
	private static void exibirOpcaoCadastro() {
		String temp;
		System.out.println("Opção selecionada: Cadastrar\n");
        
        System.out.println("==== Cadastro de Usuário ====\n");
        
        do {
	        System.out.print("Nome de usuário: ");
	        temp = ENTRADA.nextLine();
        }while(StringUtil.ehNuloOuBranco(temp));
        String nome = temp;
        temp = "";
        
        do {
	        System.out.print("Senha: ");
	        temp = ENTRADA.nextLine();
        }while(StringUtil.ehNuloOuBranco(temp));
        String senha = temp;
        temp = "";
        
        System.out.println("\n==== Cadastro de Projeto Social ====\n");
        
        do {
	        System.out.print("Nome Fantasia: ");
	        temp = ENTRADA.nextLine();
        }while(StringUtil.ehNuloOuBranco(temp));
        String nomeFantasia = temp;
        temp = "";

        do {
	        System.out.print("CPF/CNPJ (Apenas Números): ");
	        temp = ENTRADA.nextLine();
        }while(StringUtil.ehNuloOuBranco(temp));
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
	        cont =1;
	        temp = ENTRADA.nextLine();
        }while(StringUtil.ehNuloOuBranco(temp) || Integer.parseInt(temp)<1 || Integer.parseInt(temp)>6 );
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
	        cont = 1;
	        temp = ENTRADA.nextLine();
        }while(StringUtil.ehNuloOuBranco(temp) ||Integer.parseInt(temp)<1 || Integer.parseInt(temp)>11);
        String nicho = temp;
        temp = "";
        
        Categoria categoria = new Categoria();
        categoria.setCategoria(EnumCategoria.obterPorCodigo(Integer.parseInt(areaAtacao)));
        categoria.setNicho(EnumNicho.obterPorCodigo(Integer.parseInt(nicho)));

        do {
	        System.out.print("(Descricao) Fale um pouco sobre o projeto: ");
	        temp = ENTRADA.nextLine();
        }while(StringUtil.ehNuloOuBranco(temp));
        String descricao = temp;
        temp = "";
        
        System.out.println("\n==== Cadastro de Localização ====\n");
        
        do {
	        System.out.print("País: ");
	        temp = ENTRADA.nextLine();
        }while(StringUtil.ehNuloOuBranco(temp));
        String pais = temp;
        temp = "";
        
        do {
	        System.out.print("Estado/Província: ");
	        temp = ENTRADA.nextLine();
        }while(StringUtil.ehNuloOuBranco(temp));
        String estado = temp;
        temp = "";
        
        do {
	        System.out.print("Rua: ");
	        temp = ENTRADA.nextLine();
        }while(StringUtil.ehNuloOuBranco(temp));
        String rua = temp;
        temp = "";
        
        do {
	        System.out.print("Número do Imóvel: ");
	        temp = ENTRADA.nextLine();
        }while(StringUtil.ehNuloOuBranco(temp));
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
	        System.out.print("Telefone (com DDD): ");
	        temp = ENTRADA.nextLine();
        }while(StringUtil.ehNuloOuBranco(temp));
        String telefone = temp;
        temp = "";
        
        do {
	        System.out.print("Email: ");
	        temp = ENTRADA.nextLine();
        }while(StringUtil.ehNuloOuBranco(temp));
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
        
        UProjetoSocial projetoSocialNovo = new UProjetoSocial(projetoSocialMediator.gerarIdDeCnpj(cadastroFisJur), senha, nome, localUProjetoSocial, nomeFantasia, cadastroFisJur,
        		categoria, contatoNovoProjeto, descricao);
        
        isLogged = true;
        
        System.out.println("\n --- "+projetoSocialMediator.incluir(projetoSocialNovo)+" ---\n");
	}

	private static void exibirOpcaoBusca() {
		System.out.println("Opção selecionada: Visualizar Projetos");
        int opcaoBusca;
        do {
            exibirMenuBusca();
            opcaoBusca = ENTRADA.nextInt();
            ENTRADA.nextLine(); // Limpar o buffer
            String temp;
            switch (opcaoBusca) {
          
                case 1:
                    System.out.print("Digite o nome para buscar: ");
                    String nome = ENTRADA.nextLine();
                    List<UProjetoSocial> ongsEncontradasNome = buscarPorNome(projetoSocialMediator, nome);
                    System.out.println("\nResultados da busca por nome: "+ nome);
                    exibirResultados(ongsEncontradasNome);
                    
                    expandirPerfil(ongsEncontradasNome);
                    
                    break;
                case 2:
                    System.out.print("Digite o estado para buscar: ");
                    String estadoBusca = ENTRADA.nextLine();
                    List<UProjetoSocial> ongsEncontradasEstado = buscarPorEstado(projetoSocialMediator, estadoBusca);
                    System.out.println("\nResultados da busca por estado: " + estadoBusca);
                    exibirResultados(ongsEncontradasEstado);
                    
                    expandirPerfil(ongsEncontradasEstado);
                    
                    break;
                case 3:
                    System.out.print("\n\nDigite a categoria para buscar: \n");
                   
                    EnumCategoria[] enumCategoria = EnumCategoria.values();
                    int cont = 1;
                    
                    do {
                    for (EnumCategoria eCategoria:enumCategoria ) {
                    	System.out.println(cont+ " - " + eCategoria);
                    	cont++;
                    }
                    System.out.print("Selecione a categoria por número -> ");
                    cont =1;
                    temp = ENTRADA.nextLine();
                    }while(StringUtil.ehNuloOuBranco(temp) || Integer.parseInt(temp)<1 || Integer.parseInt(temp)>6 );
                    
                    String categoriaBusca = temp;
                    EnumCategoria enumCategoriaBusca = EnumCategoria.obterPorCodigo(Integer.parseInt(categoriaBusca));
                    List<UProjetoSocial> ongsEncontradasCategoria = buscarPorCategoria(projetoSocialMediator, enumCategoriaBusca);
                    System.out.println("\nResultados da busca por categoria: " + categoriaBusca);
                    exibirResultados(ongsEncontradasCategoria);
                    
                    expandirPerfil(ongsEncontradasCategoria);
                    
                    break;
                case 4:
                    System.out.print("Digite a necessidade para buscar : \n");
                   
                    EnumNecessidades[] enumNecessidades = EnumNecessidades.values();
                    cont = 1;
                    
                    do {
                    for (EnumNecessidades eNecessidades:enumNecessidades ) {
                    	System.out.println(cont+ " - " + eNecessidades);
                    	cont++;
                    }
                    System.out.print("Selecione a necessidade por número -> ");
                    cont =1;
                    temp = ENTRADA.nextLine();
                    }while(StringUtil.ehNuloOuBranco(temp) || Integer.parseInt(temp)<1 || Integer.parseInt(temp)>8 );
                    
                    String necessidadesBusca = temp;
                    EnumNecessidades enumNecessidadesBusca = EnumNecessidades.obterPorCodigo(Integer.parseInt(necessidadesBusca));
                    List<UProjetoSocial> ongsEncontradasNecessidades = buscarPorNecessidades(projetoSocialMediator, enumNecessidadesBusca);
                    System.out.println("\nResultados da busca por necessidade: " + necessidadesBusca);
                    exibirResultados(ongsEncontradasNecessidades);
                    
                    expandirPerfil(ongsEncontradasNecessidades);
                    
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
	}
	
	private static void expandirPerfil(List<UProjetoSocial> ongs){
		System.out.println("Digite o número do perfil que deseja visitar (Digite 0 para sair): ");
		int escolha = ENTRADA.nextInt();
		do {
			if(escolha <= ongs.size() && escolha > 0) {
				UProjetoSocial ong = ongs.get(escolha-1);
				exibirPerfilCompleto(ong);
				break;
			}else {
				System.out.println("Perfil inválido. Digite um número entre 1 e " + ongs.size());
			}
		}while(escolha != 0);
	}

	private static void exibirOpcaoPerfil() {
	    int opcaoPerfil;
	    String temp;
	    
	    do {
	    	exibirMeuPerfil();
	        opcaoPerfil = ENTRADA.nextInt();
	        ENTRADA.nextLine(); // Limpar o buffer
	
	        switch (opcaoPerfil) {
	            case 1: // Cria post
	            	System.out.println("Opção selecionada: Postar uma necessidade");
	            	
	            	System.out.println("\n==== Criação de Post ====\n");
	            	
	            	EnumNecessidades[] enumNecessidades = EnumNecessidades.values();
	            	
	                int cont = 1;
	                do {
		                System.out.print("Necessidade (escolha por número): \n");
		                
		                for (EnumNecessidades eNecessidade:enumNecessidades ) {
		                	System.out.println(cont+ " - " + eNecessidade);
		                	cont++;
		                }
		                temp = ENTRADA.nextLine();
	                }while(StringUtil.ehNuloOuBranco(temp) || Integer.parseInt(temp)<1 || Integer.parseInt(temp)>6 );
	                int necessidade = Integer.parseInt(temp);
	                temp = "";
	                
	                do {
	                    System.out.print("(Descricao) Fale um pouco sobre o projeto: ");
	                    temp = ENTRADA.nextLine();
	                    }while(StringUtil.ehNuloOuBranco(temp));
                    String descricaoPost = temp;
                    temp = "";
                    
                    LocalDateTime atualPost = LocalDateTime.now();
                    
                    Post post = new Post(atualPost, EnumNecessidades.obterPorCodigo(necessidade), descricaoPost);
                    
                    projetoSocial.setPost(post);
	          
	                break;
	            case 2: 
	            	System.out.println("Opção selecionada: Publicar uma atualização");
	            	
	            	System.out.println("\n==== Criação de Atualizações ====\n");
	                
	                do {
	                    System.out.print("(Descricao) Fale um pouco sobre o projeto: ");
	                    temp = ENTRADA.nextLine();
	                    }while(StringUtil.ehNuloOuBranco(temp));
                    String descricaoAtualizacao = temp;
                    temp = "";
                    
                    LocalDate atualAtualizacao = LocalDate.now();
                    
                    Relatorio relatorioAdd = new Relatorio(atualAtualizacao, descricaoAtualizacao);
                    
                    projetoSocial.setRelatorio(relatorioAdd);
	            	
	                break;
	            case 3: // mostra relatorios e posts
				exibirPerfilCompleto(projetoSocial);
	                
	                break;
	            case 0: // sai do perfil
	                System.out.println("Saindo do perfil...");
	                break;
	            default:
	                System.out.println("Opção inválida. Por favor, tente novamente.");
	                break;
	        }
	        System.out.println();
	        } while (opcaoPerfil != 0);
	}

	private static void exibirPerfilCompleto(UProjetoSocial projetoSocial) {
		String nomeFantasia = projetoSocial.getNomeFantasia();
		Categoria categoria = projetoSocial.getCategoria();
		String nome = projetoSocial.getNome();
		Contato contato = projetoSocial.getContato();
		Relatorio relatorio = projetoSocial.getRelatorio();
		ArrayList<Post >ongPosts = projetoSocial.getPosts();
		
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("Nome: ").append(nome).append("\n");
		mensagem.append("Nome Fantasia: ").append(nomeFantasia).append("\n");
		mensagem.append("Categoria: ").append(categoria.getCategoria()).append("\n");
		mensagem.append("Contatos:\n");
		mensagem.append("- Telefone: ").append(contato.getTelefone()).append("\n");
		mensagem.append("- Email: ").append(contato.getEmail()).append("\n");
		mensagem.append("- Rede Social 1: ").append(contato.getRedeSocial1()).append("\n");
		mensagem.append("- Rede Social 2: ").append(contato.getRedeSocial2()).append("\n");
		
		if(ongPosts != null) {
			for(int i=ongPosts.size()-1; i>=0; i--) {
				mensagem.append("\nPrecisamos de:\n");
				mensagem.append("- Necessidade: ").append(ongPosts.get(i).getNecessidade().getDescricao()).append("\n");
				mensagem.append("- Descrição: ").append(ongPosts.get(i).getDescricao()).append("\n");
				mensagem.append(" ------------------------------------------------------------- \n");
			}
		}
		
		if(relatorio != null) {
		    mensagem.append("\nInformações do Relatório:\n");
		    mensagem.append("- Data de Criação: ").append(relatorio.getDataCriacao()).append("\n");
			mensagem.append("- Descrição: ").append(relatorio.getDescricao()).append("\n");
		}
		
		System.out.println("\nInformações da ONG:\n" + mensagem.toString());
	}

	private static void exibirOpcaoLogin() {
		String temp;
		
		System.out.println("Opção selecionada: Login");
        
        System.out.println("Digite o nome de Usuário");
        do {
            temp = ENTRADA.nextLine();
        }while(StringUtil.ehNuloOuBranco(temp));
        String nomeLogin = temp;
        temp = "";
        
        UProjetoSocial projetoSocialLogin = null; 
        int usuarioEncontrado=0;
        
        UProjetoSocial[] projetoSocialListados = projetoSocialMediator.buscarTodos();
        for (UProjetoSocial analisandoProjetoSocial: projetoSocialListados) {
            if(analisandoProjetoSocial.getNome().equalsIgnoreCase(nomeLogin)) {
                projetoSocialLogin = analisandoProjetoSocial;
                usuarioEncontrado=1;
                break;
            }
        }
        
        if (usuarioEncontrado == 0) {
            System.out.println("Usuário não encontrado!\n");
        }else {
            System.out.println("Digite a senha: ");
            do {
                temp = ENTRADA.nextLine();
            }while(StringUtil.ehNuloOuBranco(temp));
            String senhaLogin = temp;
            temp = "";
            
            if(projetoSocialLogin.getSenha().equalsIgnoreCase(senhaLogin)) {
            	isLogged = true;
                System.out.println("\n--- Logado com SUCESSO ---\n");
                projetoSocial = projetoSocialLogin;
            }else {
                System.out.println("\n--- SENHA INCORRETA ---\n");
            }
        }
	}

    public static List<UProjetoSocial> buscarPorNome(UProjetoSocialMediator projetoSocialMediator, String nome) {
        UProjetoSocial[] todos = projetoSocialMediator.consultarUProjetosSociaisOrdemAleatoria();
        List<UProjetoSocial> resultado = new ArrayList<>();
        for (UProjetoSocial ong : todos) {
            if (ong.getNomeFantasia().equalsIgnoreCase(nome)) {
                resultado.add(ong);
            }
        }
        return resultado;
    }

    public static List<UProjetoSocial> buscarPorEstado(UProjetoSocialMediator projetoSocialMediator, String estado) {
        UProjetoSocial[] todos = projetoSocialMediator.consultarUProjetosSociaisOrdemAleatoria();
        List<UProjetoSocial> resultado = new ArrayList<>();
        for (UProjetoSocial ong : todos) {
            if (ong.getCep().getEstadoProv().equalsIgnoreCase(estado)) {
                resultado.add(ong);
            }
        }
        return resultado;
    }

     public static List<UProjetoSocial> buscarPorCategoria(UProjetoSocialMediator projetoSocialMediator, EnumCategoria categoria) {
        UProjetoSocial[] todos = projetoSocialMediator.consultarUProjetosSociaisOrdemAleatoria();
        List<UProjetoSocial> resultado = new ArrayList<>();
        for (UProjetoSocial ong : todos) {
            if (ong.getCategoria().getCategoria() == categoria) {
                resultado.add(ong);
            }
        }
        return resultado;
     }
        
     public static List<UProjetoSocial> buscarPorNecessidades(UProjetoSocialMediator projetoSocialMediator, EnumNecessidades necessidade)
     {
        UProjetoSocial[] todos = projetoSocialMediator.buscarTodos();
        ArrayList<UProjetoSocial> resultado = new ArrayList<>();
        int ongCount = 0;
        for (UProjetoSocial ong : todos) {
            ArrayList<Post> posts = ong.getPosts();
            for(Post post : posts) {
            	if(post.getNecessidade() == necessidade) {
            		ongCount++;
            	}
            }
            
			if(ongCount > 0) {
				resultado.add(ong);
			}
        }
        
        return resultado;
    }

     public static void exibirResultados(List<UProjetoSocial> ongs) {
        if (ongs.isEmpty()) {
            System.out.println("Nenhum resultado encontrado.");
            return;
        }
        int count = 1;
        for (UProjetoSocial ong : ongs) {
        	System.out.println(count+"-");
            System.out.println("Nome: " + ong.getNomeFantasia());
            System.out.println("Categoria: " + ong.getCategoria().getCategoria());
            System.out.println("Localização: " + ong.getCep().getEstadoProv());
            if(ong.getPosts() != null) {
            	ArrayList<Post> necessidade = ong.getPosts();
            	System.out.println("Necessidade: " + necessidade.get(2).getNecessidade() +" | " +
            	necessidade.get(1).getNecessidade() + " | " + necessidade.get(0).getNecessidade());
            }
            System.out.println("-----\n");
            count++;
        }
    }

}
