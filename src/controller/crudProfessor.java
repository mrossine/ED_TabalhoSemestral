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
import model.Professor;

public class crudProfessor implements ActionListener {

	private int qntdPontos;

	private JTextField tfProfessorNome;
	private JTextField tfProfessorCpf;
	private JTextField tfProfessorArea;
	private JTextArea taProfessorLista;

	private int quantidadePontos() {
		int pontos = (int) (Math.random() * 101);
		return pontos;
	}

	public crudProfessor(JTextField tfProfessorNome, JTextField tfProfessorCpf, JTextField tfProfessorArea,
			JTextArea taProfessorLista) {
		this.tfProfessorNome = tfProfessorNome;
		this.tfProfessorCpf = tfProfessorCpf;
		this.tfProfessorArea = tfProfessorArea;
		this.taProfessorLista = taProfessorLista;
	}

	private void zeraCampos() {
		tfProfessorNome.setText("");
		tfProfessorCpf.setText("");
		tfProfessorArea.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Cadastrar")) {
			try {
				insereProfessor();
				zeraCampos();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (command.equals("Buscar")) {
			try {
				buscaDisciplina();
				zeraCampos();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (command.equals("Atualizar")) {
//			try {
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
		} else if (command.equals("Excluir")) {
			try {
				excluiProfessor();
				zeraCampos();
			} catch (Exception e1) {
				System.err.println(e1.getMessage());
			}
		}
	}

	private void insereProfessor() throws IOException {
		Professor professor = new Professor();
		qntdPontos = quantidadePontos();
		professor.setNomeProfessor(tfProfessorNome.getText());
		professor.setCpf(tfProfessorCpf.getText());
		professor.setAreaInteresse(tfProfessorArea.getText());
		professor.setQuantidadePontos(qntdPontos);
		Professor aux = consultaProfessorArquivo(professor);
		if (aux.getAreaInteresse() == null || aux.getAreaInteresse().isEmpty()) {
			adicionaProfessorArquivo(professor.toString());
		} else {
			taProfessorLista.setText("Professor já cadastrado");
		}
	}

	private void adicionaProfessorArquivo(String csvProfessor) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "Sistema Contratação";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "professores.csv");
		boolean existe = false;
		if (arq.equals(arq)) {
			existe = true;
		}
		FileWriter fileWriter = new FileWriter(arq, existe);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.write(csvProfessor + "\r\n");
		printWriter.flush();
		printWriter.close();
		fileWriter.close();
	}

	private Professor consultaProfessorArquivo(Professor professor) throws IOException {
		Professor aux = new Professor();
		String path = System.getProperty("user.home") + File.separator + "Sistema Contratação";
		File arq = new File(path, "professores.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(arq);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String linha = bufferedReader.readLine();
			while (linha != null) {
				String[] vetorLinha = linha.split(";");
				if (vetorLinha[1].equals(professor.getCpf())) {
					aux.setNomeProfessor(vetorLinha[0]);
					aux.setCpf(vetorLinha[1]);
					aux.setAreaInteresse(vetorLinha[2]);
					aux.setQuantidadePontos(Integer.parseInt(vetorLinha[3]));
					break;
				}
				linha = bufferedReader.readLine();
			}
			bufferedReader.close();
			inputStreamReader.close();
			fileInputStream.close();
		}
		return aux;
	}

	private void buscaDisciplina() throws IOException {
		Professor professor = new Professor();
		if (tfProfessorCpf.getText() == null || tfProfessorCpf.getText().equals("")) {
			taProfessorLista.setText("A consulta deve ser realizada pelo CPF");
		} else {
			professor.setCpf(tfProfessorCpf.getText());
			Professor auxProf = consultaProfessorArquivo(professor);
			if (auxProf.getNomeProfessor() == null || auxProf.getNomeProfessor().equals("")) {
				taProfessorLista.setText("Professor não encontrado");
			} else {
				taProfessorLista.setText(auxProf.getNomeProfessor() + "\t" + auxProf.getCpf() + "\t"
						+ auxProf.getAreaInteresse() + "\t" + auxProf.getQuantidadePontos());
			}
		}
	}

	private void excluiProfessor() throws Exception {
		Lista<String> listaProf = new Lista<>();
		String cpf = tfProfessorCpf.getText();
		if (cpf == null || cpf.equals("")) {
			taProfessorLista.setText("Para excluir o cadastro de um professor é necessário inserir o seu CPF");
		} else  {
			listaProf = alimentaLista();
			int tamanho = listaProf.size();
			for (int i = 0; i < tamanho; i++) {
				String[] csv = listaProf.get(i).split(";");
				if (tfProfessorCpf.getText().equals(csv[1])) {
					remove(listaProf, i);
					break;
				} else if (i == tamanho - 1) {
					taProfessorLista.setText("Professor não encontrado");
				}
			}
		}
		
	}

	private Lista<String> alimentaLista() {
		// TODO Auto-generated method stub
		return null;
	}

	private void remove(Lista<String> listaProf, int posicao) {
		
	}
}
