package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.crudCurso;
import controller.crudDisciplinas;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCursoNome;
	private JTextField tfCursoAreaConhecimento;
	private JTextField tfDisciplinaNome;
	private JTextField tfDisciplinaDia;
	private JTextField tfDisciplinaHora;
	private JTextField tfDisciplinaQuantidadeHora;
	private JTextField tfProfessorNome;
	private JTextField tfProfessorCpf;
	private JTextField tfProfessorArea;
	private JTextField tfInscricaoCpfprofessor;
	private JTextField tfInscricaoIdDisciplina;
	private JTextField tfInscricaoCodProcesso;
	private JTextField tfDisciplinaCurso;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tela() {
		setTitle("Contratações Temporárias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 604, 419);
		contentPane.add(tabbedPane);
		
		JPanel tabCurso = new JPanel();
		tabbedPane.addTab("Curso", null, tabCurso, "Cadastro de Cursos");
		tabCurso.setLayout(null);
		
		JLabel lblCursoNome = new JLabel("Nome do Curso:");
		lblCursoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCursoNome.setBounds(30, 68, 128, 32);
		tabCurso.add(lblCursoNome);
		
		JLabel lblCursoAreaConhecimento = new JLabel("Área de Conhecimento:");
		lblCursoAreaConhecimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCursoAreaConhecimento.setBounds(28, 148, 179, 32);
		tabCurso.add(lblCursoAreaConhecimento);
		
		tfCursoNome = new JTextField();
		tfCursoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCursoNome.setBounds(188, 67, 382, 35);
		tabCurso.add(tfCursoNome);
		tfCursoNome.setColumns(10);
		
		tfCursoAreaConhecimento = new JTextField();
		tfCursoAreaConhecimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCursoAreaConhecimento.setBounds(188, 147, 382, 35);
		tabCurso.add(tfCursoAreaConhecimento);
		tfCursoAreaConhecimento.setColumns(10);
		
		JLabel lblCursoTitulo = new JLabel("Cadastro de Cursos");
		lblCursoTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCursoTitulo.setBounds(237, 11, 166, 32);
		tabCurso.add(lblCursoTitulo);
		
		JButton btnCursoBuscar = new JButton("Buscar");
		btnCursoBuscar.setBounds(309, 203, 118, 23);
		tabCurso.add(btnCursoBuscar);
		
		JButton btnCursoCadastrar = new JButton("Cadastrar");
		btnCursoCadastrar.setBounds(452, 203, 118, 23);
		tabCurso.add(btnCursoCadastrar);
		
		JScrollPane spCursoLista = new JScrollPane();
		spCursoLista.setBounds(10, 237, 579, 143);
		tabCurso.add(spCursoLista);
		
		JTextArea taCursoLista = new JTextArea();
		spCursoLista.setViewportView(taCursoLista);
		
		JPanel tabDisciplina = new JPanel();
		tabbedPane.addTab("Disciplina", null, tabDisciplina, "Cadastro de Disciplinas");
		tabDisciplina.setLayout(null);
		
		JLabel lblDisciplinaTitulo = new JLabel("Cadastro de Disciplinas");
		lblDisciplinaTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDisciplinaTitulo.setBounds(218, 11, 204, 32);
		tabDisciplina.add(lblDisciplinaTitulo);
		
		JLabel lblDisciplinaNome = new JLabel("Nome:");
		lblDisciplinaNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisciplinaNome.setBounds(28, 56, 80, 25);
		tabDisciplina.add(lblDisciplinaNome);
		
		JLabel lblDisciplinaDia = new JLabel("Dia da Semana:");
		lblDisciplinaDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisciplinaDia.setBounds(28, 92, 123, 25);
		tabDisciplina.add(lblDisciplinaDia);
		
		JLabel lblDisciplinaHora = new JLabel("Horário de Início:");
		lblDisciplinaHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisciplinaHora.setBounds(28, 128, 123, 25);
		tabDisciplina.add(lblDisciplinaHora);
		
		tfDisciplinaNome = new JTextField();
		tfDisciplinaNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDisciplinaNome.setBounds(171, 54, 213, 25);
		tabDisciplina.add(tfDisciplinaNome);
		tfDisciplinaNome.setColumns(10);
		
		tfDisciplinaDia = new JTextField();
		tfDisciplinaDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDisciplinaDia.setColumns(10);
		tfDisciplinaDia.setBounds(171, 90, 213, 25);
		tabDisciplina.add(tfDisciplinaDia);
		
		tfDisciplinaHora = new JTextField();
		tfDisciplinaHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDisciplinaHora.setColumns(10);
		tfDisciplinaHora.setBounds(171, 126, 213, 25);
		tabDisciplina.add(tfDisciplinaHora);
		
		JLabel lblDisciplinaQuantidadeHora = new JLabel("Quantidade de Horas:");
		lblDisciplinaQuantidadeHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisciplinaQuantidadeHora.setBounds(28, 164, 147, 25);
		tabDisciplina.add(lblDisciplinaQuantidadeHora);
		
		tfDisciplinaQuantidadeHora = new JTextField();
		tfDisciplinaQuantidadeHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDisciplinaQuantidadeHora.setColumns(10);
		tfDisciplinaQuantidadeHora.setBounds(171, 162, 213, 25);
		tabDisciplina.add(tfDisciplinaQuantidadeHora);
		
		JButton btnDisciplinaCadastrar = new JButton("Cadastrar");
		btnDisciplinaCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDisciplinaCadastrar.setBounds(447, 61, 106, 46);
		tabDisciplina.add(btnDisciplinaCadastrar);
		
		JButton btnDisciplinaBuscar = new JButton("Buscar");
		btnDisciplinaBuscar.setBounds(447, 136, 106, 46);
		tabDisciplina.add(btnDisciplinaBuscar);
		
		JScrollPane spDisciplinaLista = new JScrollPane();
		spDisciplinaLista.setBounds(10, 235, 579, 145);
		tabDisciplina.add(spDisciplinaLista);
		
		JTextArea taDisciplinaLista = new JTextArea();
		spDisciplinaLista.setViewportView(taDisciplinaLista);
		
		JPanel tabProfessor = new JPanel();
		tabbedPane.addTab("Professor", null, tabProfessor, "Cadastro de Professores");
		tabProfessor.setLayout(null);
		
		JLabel lblProfessorTitulo = new JLabel("Cadastro de Professores");
		lblProfessorTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProfessorTitulo.setBounds(218, 11, 204, 32);
		tabProfessor.add(lblProfessorTitulo);
		
		JLabel lblProfessoeNome = new JLabel("Nome:");
		lblProfessoeNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessoeNome.setBounds(36, 56, 80, 25);
		tabProfessor.add(lblProfessoeNome);
		
		JLabel lblProfessorCpf = new JLabel("CPF:");
		lblProfessorCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorCpf.setBounds(36, 92, 123, 25);
		tabProfessor.add(lblProfessorCpf);
		
		JLabel lblProfessorArea = new JLabel("Área de Conhecimento:");
		lblProfessorArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorArea.setBounds(36, 128, 165, 25);
		tabProfessor.add(lblProfessorArea);
		
		tfProfessorNome = new JTextField();
		tfProfessorNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfProfessorNome.setColumns(10);
		tfProfessorNome.setBounds(197, 54, 360, 25);
		tabProfessor.add(tfProfessorNome);
		
		tfProfessorCpf = new JTextField();
		tfProfessorCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfProfessorCpf.setColumns(10);
		tfProfessorCpf.setBounds(197, 90, 360, 25);
		tabProfessor.add(tfProfessorCpf);
		
		tfProfessorArea = new JTextField();
		tfProfessorArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfProfessorArea.setColumns(10);
		tfProfessorArea.setBounds(197, 126, 360, 25);
		tabProfessor.add(tfProfessorArea);
		
		JButton btnProfessorBuscar = new JButton("Buscar");
		btnProfessorBuscar.setBounds(296, 166, 118, 23);
		tabProfessor.add(btnProfessorBuscar);
		
		JButton btnProfessorCadastrar = new JButton("Cadastrar");
		btnProfessorCadastrar.setBounds(439, 166, 118, 23);
		tabProfessor.add(btnProfessorCadastrar);
		
		JScrollPane spProfessorLista = new JScrollPane();
		spProfessorLista.setBounds(10, 208, 577, 172);
		tabProfessor.add(spProfessorLista);
		
		JTextArea taProfessorLista = new JTextArea();
		spProfessorLista.setViewportView(taProfessorLista);
		
		JPanel tabInscricao = new JPanel();
		tabbedPane.addTab("Inscrição", null, tabInscricao, "Realizar Inscrição");
		tabInscricao.setLayout(null);
		
		JLabel lblInscricaoCpfprofessor = new JLabel("CPF do Professor:");
		lblInscricaoCpfprofessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInscricaoCpfprofessor.setBounds(39, 56, 151, 25);
		tabInscricao.add(lblInscricaoCpfprofessor);
		
		tfInscricaoCpfprofessor = new JTextField();
		tfInscricaoCpfprofessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfInscricaoCpfprofessor.setColumns(10);
		tfInscricaoCpfprofessor.setBounds(200, 54, 360, 25);
		tabInscricao.add(tfInscricaoCpfprofessor);
		
		tfInscricaoIdDisciplina = new JTextField();
		tfInscricaoIdDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfInscricaoIdDisciplina.setColumns(10);
		tfInscricaoIdDisciplina.setBounds(200, 90, 360, 25);
		tabInscricao.add(tfInscricaoIdDisciplina);
		
		JLabel lblInscricaoIdDisciplina = new JLabel("Código da Disciplina:");
		lblInscricaoIdDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInscricaoIdDisciplina.setBounds(39, 92, 151, 25);
		tabInscricao.add(lblInscricaoIdDisciplina);
		
		JLabel lblInscricaoCodProcesso = new JLabel("Código do Processo:");
		lblInscricaoCodProcesso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInscricaoCodProcesso.setBounds(39, 128, 165, 25);
		tabInscricao.add(lblInscricaoCodProcesso);
		
		tfInscricaoCodProcesso = new JTextField();
		tfInscricaoCodProcesso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfInscricaoCodProcesso.setColumns(10);
		tfInscricaoCodProcesso.setBounds(200, 126, 360, 25);
		tabInscricao.add(tfInscricaoCodProcesso);
		
		JButton btnInscricaoBuscar = new JButton("Buscar");
		btnInscricaoBuscar.setBounds(299, 166, 118, 23);
		tabInscricao.add(btnInscricaoBuscar);
		
		JButton btnInscricaoCadastrar = new JButton("Cadastrar");
		btnInscricaoCadastrar.setBounds(442, 166, 118, 23);
		tabInscricao.add(btnInscricaoCadastrar);
		
		JScrollPane spInscricaoLista = new JScrollPane();
		spInscricaoLista.setBounds(14, 209, 575, 170);
		tabInscricao.add(spInscricaoLista);
		
		JTextArea taInscricaoLista = new JTextArea();
		spInscricaoLista.setViewportView(taInscricaoLista);
		
		JLabel lblRealizarInscricoes = new JLabel("Realizar Inscrições");
		lblRealizarInscricoes.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRealizarInscricoes.setBounds(221, 11, 204, 32);
		tabInscricao.add(lblRealizarInscricoes);

		JLabel lblDisciplinaCurso = new JLabel("Nome do Curso:");
		lblDisciplinaCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisciplinaCurso.setBounds(28, 199, 147, 25);
		tabDisciplina.add(lblDisciplinaCurso);
		
		tfDisciplinaCurso = new JTextField();
		tfDisciplinaCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDisciplinaCurso.setColumns(10);
		tfDisciplinaCurso.setBounds(171, 197, 213, 25);
		tabDisciplina.add(tfDisciplinaCurso);
		
		crudCurso crudCurso = new crudCurso(tfCursoNome, tfCursoAreaConhecimento, taCursoLista);
		crudDisciplinas crudDisc = new crudDisciplinas(tfDisciplinaNome, tfDisciplinaDia, tfDisciplinaHora, tfDisciplinaQuantidadeHora,tfDisciplinaCurso , taDisciplinaLista);
		
		btnCursoCadastrar.addActionListener(crudCurso);
		btnCursoBuscar.addActionListener(crudCurso);
		
		btnDisciplinaCadastrar.addActionListener(crudDisc);
		btnDisciplinaBuscar.addActionListener(crudDisc);
		
		
	}
}
