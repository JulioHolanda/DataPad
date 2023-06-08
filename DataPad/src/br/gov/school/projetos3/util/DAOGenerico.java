package br.gov.school.projetos3.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.gov.school.projetos3.usuario.entidade.Identificavel;

public class DAOGenerico {
	private String diretorioBase;
    private static final String EXT = ".dat";

    public DAOGenerico(String diretorioBase){
    	this.diretorioBase = diretorioBase;
        File diretorio = new File(diretorioBase);
        if (!diretorio.exists()) {
            diretorio.mkdir();
        }
    }

    private File getArquivo(String chave) {
        String nomeArq = diretorioBase + chave + EXT;
        return new File(nomeArq);
    }
    private File getArquivo(Identificavel ident) {
    	String chave = ident.obterChave();
        return getArquivo(chave);
    }

    private void incluirAux(Identificavel ident, File arq) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(arq);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(ident);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao incluir identificavel");
        } finally {
            try {
                oos.close();
            } catch (Exception e) {
            }
            try {
                fos.close();
            } catch (Exception e) {
            }
        }
    }

    public boolean incluir(Identificavel ident) {
        File arq = getArquivo(ident);
        if (arq.exists()) {
            return false;
        }
        incluirAux(ident, arq);
        return true;
    }

    public boolean alterar(Identificavel ident) {
        File arq = getArquivo(ident);
        if (!arq.exists()) {
            return false;
        }
        if (!arq.delete()) {
            return false;
        }
        incluirAux(ident, arq);
        return true;
    }

    public Identificavel buscar(String chave) {
        File arq = getArquivo(chave);
        if (!arq.exists()) {
            return null;
        }
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(arq);
            ois = new ObjectInputStream(fis);
            return (Identificavel) ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler identificavel");
        } finally {
            try {
                ois.close();
            } catch (Exception e) {
            }
            try {
                fis.close();
            } catch (Exception e) {
            }
        }
    }
    
	public Identificavel[] buscarTodos() {
		File diretorio = new File(diretorioBase);
		
		if (!diretorio.exists()) {
			return null;
		}
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			
			File[] files = diretorio.listFiles((dir, name) -> name.toLowerCase().endsWith(".dat"));
			
			if(files.length == 0) {
				return new Identificavel[0];
			}
			
			Identificavel[] ident = new Identificavel[files.length];
			
			int cont = 0;
			
			for(File file: files) {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				
				ident[cont] = (Identificavel) ois.readObject();
						
				cont += 1;
			}
			Identificavel[] identRet = ident;
			return  identRet;

		} catch (Exception e) {
			throw new RuntimeException("Erro ao ler chave" + e.getMessage());
		} finally {
			try {
				ois.close();
			} catch (Exception e) {
			}
			try {
				fis.close();
			} catch (Exception e) {
			}
		}
	}
}