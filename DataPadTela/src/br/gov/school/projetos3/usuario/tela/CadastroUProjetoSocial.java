package br.gov.school.projetos3.usuario.tela;

import org.eclipse.swt.widgets.Display;
import br.gov.school.projetos3.usuario.entidade.UProjetoSocial;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import br.gov.school.projetos3.usuario.dao.UProjetoSocialDAO;
import br.gov.school.projetos3.usuario.entidade.UProjetoSocial;
import br.gov.school.projetos3.usuario.negocio.UProjetoSocialMediator;
import br.gov.school.projetos3.util.Enum.EnumCategoria;
import br.gov.school.projetos3.util.Enum.EnumNicho;
import br.gov.school.projetos3.util.entidade.Categoria;
import br.gov.school.projetos3.util.entidade.Contato;
import br.gov.school.projetos3.util.entidade.Localizacao;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;

public class CadastroUProjetoSocial {

	protected Shell shell;
	private Text textNomeUsuario;
	private Text textSenha;
	private Text textNomeFantasia;
	private Text textCadastroFisJur;
	private Text textDescricao;
	private Text textTelefone;
	private Text textRedeSocial1;
	private Text textEmail;
	private Text textRedeSocial2;
	private Text textPais;
	private Text textEstado;
	private Text textCidade;
	private Text textRua;
	private Text textNumero;
	private Text textComplemento;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CadastroUProjetoSocial window = new CadastroUProjetoSocial();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(570, 485);
		shell.setText("SWT Application");
		
		textNomeUsuario = new Text(shell, SWT.BORDER);
		textNomeUsuario.setToolTipText("");
		textNomeUsuario.setBounds(107, 10, 139, 21);
		
		textSenha = new Text(shell, SWT.BORDER);
		textSenha.setBounds(107, 37, 139, 21);
		
		textNomeFantasia = new Text(shell, SWT.BORDER);
		textNomeFantasia.setBounds(107, 64, 139, 21);
		
		textCadastroFisJur = new Text(shell, SWT.BORDER);
		textCadastroFisJur.setBounds(107, 91, 139, 21);
		
		textDescricao = new Text(shell, SWT.BORDER);
		textDescricao.setBounds(107, 145, 414, 37);
		
		textTelefone = new Text(shell, SWT.BORDER);
		textTelefone.setBounds(107, 188, 139, 21);
		
		textRedeSocial1 = new Text(shell, SWT.BORDER);
		textRedeSocial1.setBounds(107, 215, 139, 21);
		
		textEmail = new Text(shell, SWT.BORDER);
		textEmail.setBounds(374, 188, 147, 21);
		
		textRedeSocial2 = new Text(shell, SWT.BORDER);
		textRedeSocial2.setBounds(374, 215, 147, 21);
		
		textPais = new Text(shell, SWT.BORDER);
		textPais.setBounds(107, 252, 139, 21);
		
		textEstado = new Text(shell, SWT.BORDER);
		textEstado.setBounds(374, 252, 147, 21);
		
		textCidade = new Text(shell, SWT.BORDER);
		textCidade.setBounds(107, 279, 139, 21);
		
		textRua = new Text(shell, SWT.BORDER);
		textRua.setBounds(107, 306, 414, 21);
		
		textNumero = new Text(shell, SWT.BORDER);
		textNumero.setBounds(107, 333, 139, 21);
		
		textComplemento = new Text(shell, SWT.BORDER);
		textComplemento.setBounds(374, 333, 147, 21);
		
		Label lblNomeUsuario = new Label(shell, SWT.NONE);
		lblNomeUsuario.setBounds(10, 16, 91, 15);
		lblNomeUsuario.setText("Nome Usuario:");
		
		Label lblSenha = new Label(shell, SWT.NONE);
		lblSenha.setBounds(10, 43, 55, 15);
		lblSenha.setText("Senha:");
		
		Label lblNomeFantasia = new Label(shell, SWT.NONE);
		lblNomeFantasia.setBounds(10, 70, 91, 15);
		lblNomeFantasia.setText("Nome Fantasia:");
		
		Label lblCpfcnpj = new Label(shell, SWT.NONE);
		lblCpfcnpj.setBounds(10, 97, 55, 15);
		lblCpfcnpj.setText("CPF/CNPJ:");
		
		Label lblCategoria = new Label(shell, SWT.NONE);
		lblCategoria.setBounds(10, 124, 55, 15);
		lblCategoria.setText("Categoria:");
		
		Label lblNicho = new Label(shell, SWT.NONE);
		lblNicho.setBounds(268, 124, 55, 15);
		lblNicho.setText("Nicho:");
		
		Label lblDescrio = new Label(shell, SWT.NONE);
		lblDescrio.setBounds(10, 145, 55, 15);
		lblDescrio.setText("Descrição:");
		
		Label lblTelefone = new Label(shell, SWT.NONE);
		lblTelefone.setBounds(10, 194, 55, 15);
		lblTelefone.setText("Telefone:");
		
		Label lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setBounds(268, 194, 55, 15);
		lblEmail.setText("Email:");
		
		Label lblRedeSocial = new Label(shell, SWT.NONE);
		lblRedeSocial.setBounds(10, 221, 91, 15);
		lblRedeSocial.setText("Rede Social 1:");
		
		Label lblRedeSocial_1 = new Label(shell, SWT.NONE);
		lblRedeSocial_1.setBounds(268, 221, 76, 15);
		lblRedeSocial_1.setText("Rede Social 2:");
		
		Label lblPas = new Label(shell, SWT.NONE);
		lblPas.setBounds(10, 258, 55, 15);
		lblPas.setText("País:");
		
		Label lblCidade = new Label(shell, SWT.NONE);
		lblCidade.setBounds(10, 282, 55, 15);
		lblCidade.setText("Cidade:");
		
		Label lblEstadoprovncia = new Label(shell, SWT.NONE);
		lblEstadoprovncia.setBounds(268, 258, 91, 15);
		lblEstadoprovncia.setText("Estado/Província:");
		
		Label lblRua = new Label(shell, SWT.NONE);
		lblRua.setBounds(10, 312, 55, 15);
		lblRua.setText("Rua:");
		
		Label lblNmero = new Label(shell, SWT.NONE);
		lblNmero.setBounds(10, 339, 55, 15);
		lblNmero.setText("Número:");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(268, 339, 91, 15);
		lblNewLabel.setText("Complemento:");
		
		Combo comboCategoria = new Combo(shell, SWT.NONE);
		comboCategoria.setItems(new String[] {"EDUCAÇÃO", "SAÚDE", "RECURSOS_BÁSICOS", "ACOLHIMENTOS", "NATUREZA", "ARTE"});
		comboCategoria.setBounds(106, 118, 140, 23);
		
		Combo comboNicho = new Combo(shell, SWT.NONE);
		comboNicho.setItems(new String[] {"CRIANÇAS", "JOVENS", "ADULTOS", "ANIMAIS", "FAMÍLIAS", "COMUNIDADES", "IDOSOS", "PCD", "DEPENDENTES_QUÍMICOS", "MULHERES", "LGBTQIAP"});
		comboNicho.setBounds(329, 116, 136, 23);
		
		Button btnCadastrar = new Button(shell, SWT.NONE);
		btnCadastrar.setBounds(360, 387, 161, 25);
		btnCadastrar.setText("Cadastrar");
		
		Button btnCancelar = new Button(shell, SWT.NONE);
		btnCancelar.setBounds(85, 387, 112, 25);
		btnCancelar.setText("Cancelar");
		
		btnCadastrar.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {

				if (comboCategoria.getText()==null || comboNicho.getText()==null|| textCadastroFisJur.getText()==null || textCidade.getText()==null|| textDescricao.getText()==null||
						textEmail.getText()==null||textEstado.getText()==null||textNomeFantasia.getText()==null||textNomeUsuario.getText()==null||
						textNumero.getText()==null||textPais.getText()==null||textPais.getText()==null||textRua.getText()==null||
						textSenha.getText()==null||textTelefone.getText().length()<10) {
					 JOptionPane.showMessageDialog(null, "Formato inválido");
					 return;
				}
							
				Contato pContato = new Contato();
				pContato.setEmail(textEmail.getText());
				pContato.setTelefone(textTelefone.getText());
				pContato.setRedeSocial1(textRedeSocial1.getText());
				pContato.setRedeSocial2(textRedeSocial2.getText());
				
				Categoria projetoCategoria = new Categoria();
				projetoCategoria.setCategoria(EnumCategoria.obterPorCodigo(comboCategoria.getCaretPosition()));
				projetoCategoria.setNicho(EnumNicho.obterPorCodigo(comboNicho.getCaretPosition()));
				
				Localizacao pLocalizacao = new Localizacao();
				pLocalizacao.setComplemento(textComplemento.getText());
				pLocalizacao.setEstadoProv(textEstado.getText());
				pLocalizacao.setNumero(Integer.parseInt(textNumero.getText()));
				pLocalizacao.setPais(textPais.getText());
				pLocalizacao.setRua(textRua.getText());
				
				UProjetoSocialMediator pMediator = UProjetoSocialMediator.getInstance();
				
				UProjetoSocial novoUProjetoSocial = new UProjetoSocial(pMediator.gerarIdDeCnpj(textCadastroFisJur.getText()), textSenha.getText(), textNomeUsuario.getText(), pLocalizacao, textNomeFantasia.getText(), textCadastroFisJur.getText(), projetoCategoria, pContato, textDescricao.getText());
				
				JOptionPane.showMessageDialog(null, pMediator.incluir(novoUProjetoSocial));
				return;
			}
		});

	}
}
