package br.gov.school.projetos3.geral.dao;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import br.gov.school.projetos3.usuario.entidade.Identificavel;

public class DAOGenerico {
	private String diretorioBase;
    private static final String EXT = ".dat";

    public DAOGenerico(String diretorioBase) {
        this.diretorioBase = diretorioBase;
        Path diretorio = Path.of(diretorioBase);
        try {
            if (!Files.exists(diretorio)) {
                Files.createDirectory(diretorio);
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar diretório: " + diretorioBase);
        }
    }

    private Path getArquivo(String chave) {
        String nomeArq = diretorioBase + chave + EXT;
        return Path.of(nomeArq);
    }

    private Path getArquivo(Identificavel ident) {
        String chave = ident.obterChave();
        return getArquivo(chave);
    }

    private void incluirAux(Identificavel ident, Path arquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(arquivo))) {
            oos.writeObject(ident);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao incluir identificavel: " + e.getMessage());
        }
    }

    public boolean incluir(Identificavel ident) {
        Path arquivo = getArquivo(ident);
        if (Files.exists(arquivo)) {
            return false;
        }
        incluirAux(ident, arquivo);
        return true;
    }

    public boolean alterar(Identificavel ident) {
        Path arquivo = getArquivo(ident);
        if (!Files.exists(arquivo)) {
            return false;
        }
        try {
            Files.delete(arquivo);
            incluirAux(ident, arquivo);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao alterar o arquivo: " + arquivo.toString());
        }
    }

    public Identificavel buscar(String chave) {
        Path arquivo = getArquivo(chave);
        if (!Files.exists(arquivo)) {
            return null;
        }
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(arquivo))) {
            return (Identificavel) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Erro ao ler identificavel: " + e.getMessage());
        }
    }

    public Identificavel[] buscarTodos() {
        Path diretorio = Path.of(diretorioBase);

        if (!Files.exists(diretorio)) {
            return null;
        }

        try {
            Identificavel[] ident;
            try (Stream<Path> paths = Files.list(diretorio)) {
                ident = paths
                    .filter(p -> p.getFileName().toString().toLowerCase().endsWith(".dat"))
                    .map(this::readIdentificavel)
                    .toArray(Identificavel[]::new);
            }

            if (ident.length == 0) {
                return new Identificavel[0];
            }

            return ident;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler chave: " + e.getMessage());
        }
    }

    private Identificavel readIdentificavel(Path arquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(arquivo))) {
            return (Identificavel) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Erro ao ler identificavel: " + e.getMessage());
        }
    }
}