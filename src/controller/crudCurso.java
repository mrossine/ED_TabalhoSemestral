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
			this.idCurso = defineIdCursoAtual();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
			String auxLinha = null;
			while (linha != null) {
				auxLinha = linha;
				linha = bufferedReader.readLine();
			}
			String[] vetorLinha = auxLinha.split(";");
			String[] aux = vetorLinha[0].split("C");
			if (auxLinha != null) {
				id = Integer.parseInt(aux[0]);
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
		}
	}

	private void consultaCurso() throws IOException {
		Curso auxCurso = new Curso();
		auxCurso.setNomeCurso(tfCursoNome.getText());

		auxCurso = consultaCursoArquivo(auxCurso);

		if (auxCurso.getAreaConhecimento() != null) {
			taCursoLista.setText(auxCurso.getIdCurso() + "\t" + auxCurso.getNomeCurso() + "\t"
					+ auxCurso.getAreaConhecimento());
		} else {
			taCursoLista.setText("Curso não encontrado");
		}
		tfCursoNome.setText("");
		tfCursoArea.setText("");
	}

	private void insereCurso() throws IOException {
		Curso auxCurso = new Curso();
		idCurso++;
		auxCurso.setIdCurso("C" + idCurso);
		auxCurso.setNomeCurso(tfCursoNome.getText());
		auxCurso.setAreaConhecimento(tfCursoArea.getText());
		
		Curso aux = consultaCursoArquivo(auxCurso);

		if (aux.getAreaConhecimento() != null) {
			adicionaDisciplinaArquivo(auxCurso.toString());
		} else {
			taCursoLista.setText("Curso já foi cadastrado");
		}
		
		tfCursoNome.setText("");
		tfCursoArea.setText("");
	}

	private Curso consultaCursoArquivo(Curso curso) throws IOException {
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
					curso.setIdCurso(vetorLinha[0]);
					curso.setAreaConhecimento(vetorLinha[2]);
					break;
				}
				linha = bufferedReader.readLine();
			}
			bufferedReader.close();
			inputStreamReader.close();
			fileInputStream.close();
		}
		return curso;
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

	

}
