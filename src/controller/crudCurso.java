package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.fateczl.lista.Lista;
import model.Curso;

public class crudCurso implements ActionListener {

	private int idCurso;

	private JTextField tfCursoNome;
	private JTextField tfCursoArea;
	private JTextArea taCursoLista;

	public crudCurso(JTextField tfCursoNome, JTextField tfCursoArea, JTextArea taCursoLista) {
		super();
		this.tfCursoNome = tfCursoNome;
		this.tfCursoArea = tfCursoArea;
		this.taCursoLista = taCursoLista;
		try {
			int idAux = defineIdCursoAtual();
			this.idCurso = idAux;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void zeraCampos() {
		tfCursoNome.setText("");
		tfCursoArea.setText("");
	}

	private int defineIdCursoAtual() throws IOException {
		String path = System.getProperty("user.home") + File.separator + "Sistema Contratação";
		File arq = new File(path, "cursos.csv");
		int id = 0;
		if (arq.exists() && arq.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(arq);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String linha = bufferedReader.readLine();
			String aux = null;
			while (linha != null) {
				aux = linha;
				linha = bufferedReader.readLine();
			}
			if (aux != null) {
				String[] vetorAux = aux.split(";");
				String[] vetor = vetorAux[0].split("");
				id = Integer.parseInt(vetor[1]);
			}
			bufferedReader.close();
			inputStreamReader.close();
			fileInputStream.close();
		}
		return id;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Cadastrar")) {
			try {
				insereCurso();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (command.equals("Buscar")) {
			try {
				consultaCurso();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (command.equals("Atualizar")) {
//			try {
//				atualizaCurso();
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
		} else if (command.equals("Excluir")) {
			try {
				excluiCurso();
			} catch (Exception e1) {
				System.err.println(e1.getMessage());
			}
		}
	}

	private void consultaCurso() throws IOException {
		Curso auxCurso = new Curso();
		auxCurso.setNomeCurso(tfCursoNome.getText());

		auxCurso = consultaCursoArquivo(auxCurso);

		if (auxCurso.getAreaConhecimento() != null) {
			taCursoLista.setText(
					auxCurso.getIdCurso() + "\t" + auxCurso.getNomeCurso() + "\t" + auxCurso.getAreaConhecimento());
		} else {
			taCursoLista.setText("Curso não encontrado");
		}
		zeraCampos();
	}

	private void insereCurso() throws IOException {
		Curso auxCurso = new Curso();
		idCurso++;
		auxCurso.setIdCurso("C" + idCurso);
		auxCurso.setNomeCurso(tfCursoNome.getText());
		auxCurso.setAreaConhecimento(tfCursoArea.getText());

		Curso aux = consultaCursoArquivo(auxCurso);

		if (aux.getAreaConhecimento() == null || aux.getAreaConhecimento().isEmpty()) {
			adicionaDisciplinaArquivo(auxCurso.toString());
		} else {
			taCursoLista.setText("Curso já foi cadastrado");
		}
		zeraCampos();
	}

	private Curso consultaCursoArquivo(Curso curso) throws IOException {
		Curso auxCurso = new Curso();
		String path = System.getProperty("user.home") + File.separator + "Sistema Contratação";
		File arq = new File(path, "cursos.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(arq);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String linha = bufferedReader.readLine();
			while (linha != null) {
				String[] vetorLinha = linha.split(";");
				if (vetorLinha[1].equals(curso.getNomeCurso())) {
					auxCurso.setIdCurso(vetorLinha[0]);
					auxCurso.setNomeCurso(vetorLinha[1]);
					auxCurso.setAreaConhecimento(vetorLinha[2]);
					break;
				}
				linha = bufferedReader.readLine();
			}
			bufferedReader.close();
			inputStreamReader.close();
			fileInputStream.close();
		}
		return auxCurso;
	}

	private void adicionaDisciplinaArquivo(String csvCurso) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "Sistema Contratação";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "cursos.csv");
		boolean existe = false;
		if (arq.equals(arq)) {
			existe = true;
		}
		FileWriter fileWriter = new FileWriter(arq, existe);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.write(csvCurso + "\r\n");
		printWriter.flush();
		printWriter.close();
		fileWriter.close();
	}

	private void excluiCurso() throws Exception {
		Lista<String> lista = new Lista<>();
		String verifica = tfCursoNome.getText();
		if (verifica == null || verifica.equals("")) {
			taCursoLista.setText("Digite o nome da disciplina que será excluída");
			zeraCampos();
		} else {
			lista = alimentaLista();
			int tamanho = lista.size();
			for (int i = 0; i < tamanho; i++) {
				String[] vetor = lista.get(i).split(";");
				if (tfCursoNome.getText().equals(vetor[1])) {
					remove(lista, i);
					break;
				} else if (i == tamanho - 1) {
					taCursoLista.setText("Disciplina não encontrada");
				}
			}
			zeraCampos();
		}
	}

	private Lista<String> alimentaLista() throws Exception {
		Lista<String> lista = new Lista<>();
		String path = System.getProperty("user.home") + File.separator + "Sistema Contratação";
		File arq = new File(path, "cursos.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(arq);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String linha = bufferedReader.readLine();
			while (linha != null) {
				lista.addLast(linha);
				linha = bufferedReader.readLine();
			}
			bufferedReader.close();
			inputStreamReader.close();
			fileInputStream.close();
		}
		return lista;
	}

	private void remove(Lista<String> lista, int posicao) throws Exception {
		String path = System.getProperty("user.home") + File.separator + "Sistema Contratação";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "cursos.csv");
		lista.remove(posicao);
		int tamanho = lista.size();
		for (int i = 0; i < tamanho; i++) {
			System.out.println(lista.get(i));
		}
		if (tamanho != 0) {
			for (int i = 0; i < tamanho; i++) {
				if (i == 0) {
					FileWriter fileWriter = new FileWriter(arq, false);
					PrintWriter printWriter = new PrintWriter(fileWriter);
					printWriter.write(lista.get(i) + "\r\n");
					printWriter.flush();
					printWriter.close();
					fileWriter.close();
				} else {
					FileWriter fileWriter = new FileWriter(arq, true);
					PrintWriter printWriter = new PrintWriter(fileWriter);
					printWriter.write(lista.get(i) + "\r\n");
					printWriter.flush();
					printWriter.close();
					fileWriter.close();
				}
			}
		}
		zeraCampos();
	}
}
