package br.gov.school.projetos3.geral.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

import br.gov.school.projetos3.usuario.entidade.UProjetoSocial;
import br.gov.school.projetos3.usuario.negocio.UProjetoSocialMediator;

public class TelaNavegacaoProjetos {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaNavegacaoProjetos window = new TelaNavegacaoProjetos();
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
		shell.setSize(549, 300);
		shell.setText("SWT Application");
		
		List list = new List(shell, SWT.BORDER | SWT.V_SCROLL);
		list.setItems(new String[] {});
		list.setBounds(26, 66, 372, 185);
		
		
		Combo comboCategoria = new Combo(shell, SWT.NONE);
		comboCategoria.setItems(new String[] {"EDUCACAO", "SAUDE", "RECURSOS_BASICOS", "ACOLHIMENTO", "NATUREZA", "ARTE"});
		comboCategoria.setBounds(26, 30, 126, 23);
		
		Button btnFiltrar = new Button(shell, SWT.NONE);
		btnFiltrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnFiltrar.setBounds(306, 28, 75, 25);
		btnFiltrar.setText("Filtrar");
		
		Combo comboNicho = new Combo(shell, SWT.NONE);
		comboNicho.setItems(new String[] {"CRIANCAS", "JOVENS", "ADULTOS", "ANIMAIS", "FAMILIAS", "COMUNIDADES", "IDOSOS", "PCD", "DEPENDENTES_QUIMICOS", "MULHERES", "LGBTQIAP"});
		comboNicho.setBounds(158, 30, 131, 23);
		
		Label lblCategoria = new Label(shell, SWT.NONE);
		lblCategoria.setBounds(26, 9, 55, 15);
		lblCategoria.setText("Categoria");
		
		Label lblNicho = new Label(shell, SWT.NONE);
		lblNicho.setBounds(158, 9, 55, 15);
		lblNicho.setText("Nicho");
		
		Button btnVisualizar = new Button(shell, SWT.NONE);
		btnVisualizar.setBounds(425, 226, 75, 25);
		btnVisualizar.setText("Visualizar");
		
		UProjetoSocialMediator pMediator = UProjetoSocialMediator.getInstance();
		
		
		UProjetoSocial[] todosOsProjetos = pMediator.consultarUProjetosSociaisOrdemAleatoria();
		
		for (UProjetoSocial ups : todosOsProjetos) {
		    list.add(ups.getNomeFantasia().toString() + "- - - -"+ups.getCategoria().getCategoria().getDescricao());
		}

	}
}
