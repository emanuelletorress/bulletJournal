package leituras;

import java.util.ArrayList;
import java.util.Scanner;
import bulletJournal.*;

public class Leituras implements ListaDeLeitura {
	private String label;
	private String livroOuManga;
	private boolean status;
	private String author;
	private int ondeParei;
	private int tamanho;
	
	Scanner scan = new Scanner(System.in);
	
	public Leituras(String livroOuManga, String label, String author, boolean status, int tamanho) {
		this.livroOuManga = livroOuManga;
		this.label = label;
		this.author = author;
		this.status = status;
		this.tamanho = tamanho;
		
		if(!status) {
			this.ondeParei = this.tamanho;
		}else {
			this.ondeParei = 0;
		}
	}
	
	public Leituras() {
		
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getOndeParei() {
		return ondeParei;
	}

	public void setOndeParei(int ondeParei) {
		this.ondeParei = ondeParei;
	}

	public int getTamanho() {
		return tamanho;
	}
	
	public String getLivroOuManga() {
		return this.livroOuManga;
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public boolean addMidia(Midia m) {
		if(m instanceof Leituras) {
			for(int i = 0; i < leituras.size(); i++) {
				if(((Leituras) m).getLivroOuManga().matches("livro") 
						&& ((Leituras) leituras.get(i)).getLivroOuManga().matches("livro") 
						&& m.getLabel().matches(leituras.get(i).getLabel())) {
					System.out.println("Livro já adicionado na lista.");
					return false;
				}else if(((Leituras) m).getLivroOuManga().matches("mangá") 
						&& ((Leituras) leituras.get(i)).getLivroOuManga().matches("mangá") 
						&& m.getLabel().matches(leituras.get(i).getLabel())) {
					System.out.println("Mangá já adicionado na lista.");
					return false;
				}
			}
		}
		
		leituras.add(m);
		
		if(m.isStatus() == true) {
			lendo.add(m);
		}else {
			lidos.add(m);
		}
		
		if(((Leituras) m).getLivroOuManga().matches("livro")) {
			System.out.println("Livro adicionado com sucesso!");
		}else {
			System.out.println("Mangá adicionado com sucesso!");
		}
		
		return true;
	}

	public boolean modificarStatus(String label) {
		for(int i = 0; i < leituras.size(); i++) {
			if(leituras.get(i).getLabel().equals(label)) {
				System.out.println("Status modificado com sucesso.");
				if(leituras.get(i).isStatus() == true) {
					lidos.add(leituras.get(i));
					((Leituras) leituras.get(i)).setStatus(false);
					lendo.remove(leituras.get(i));
					return true;
				}else {
					lendo.add(leituras.get(i));
					((Leituras) leituras.get(i)).setStatus(true);
					lidos.remove(leituras.get(i));
					return true;
				}
			}
		}
		// se nao achar o nome, jogar uma exceção
		
		System.out.println("Mangá/livro não encontrado.");
		return false;

	}

	public boolean excluirConsumido(String label) {
		for(int i = 0; i < lidos.size(); i++) {
			if(lidos.get(i).getLabel().equals(label)) {
				if(((Leituras) lidos.get(i)).getLivroOuManga().matches("livro")) {
					System.out.println("Livro removido.");
				}else {
					System.out.println("Mangá removido.");
				}
				lidos.remove(i);
				return true;
			}
		}

		System.out.println("Livro não encontrado.");
		return false;
	}
	
	public boolean ondeParei(String label, int pag) {
		for(int i = 0; i < leituras.size(); i++) {
			if(leituras.get(i).getLabel().equals(label)) {
				if(pag > ((Leituras) leituras.get(i)).getTamanho() || pag < 0) {
					while(true) {
						System.out.println("Página/Volume inválido. Insira outro(a): ");
						pag = scan.nextInt();
						if(pag <= ((Leituras) leituras.get(i)).getTamanho() || pag > 0) {
							((Leituras) leituras.get(i)).setOndeParei(pag);
							if(((Leituras) leituras.get(i)).getLivroOuManga().matches("livro")) {
								System.out.println("Página alterada com sucesso");
							}else {
								System.out.println("Volume alterado com sucesso");
							}
							return true;
						}
					}
				}else if(pag < ((Leituras) leituras.get(i)).getTamanho() && pag > 0){
					((Leituras) leituras.get(i)).setOndeParei(pag);
					if(((Leituras) leituras.get(i)).getLivroOuManga().matches("livro")) {
						System.out.println("Página alterada com sucesso");
					}else {
						System.out.println("Volume alterado com sucesso");
					}
					return true;
				}else if(pag == ((Leituras) leituras.get(i)).getTamanho()) {
					if(((Leituras) leituras.get(i)).getLivroOuManga().matches("livro")) {
						System.out.println("Você chegou ao fim do livro! :'(");
					}
					if(((Leituras) leituras.get(i)).getLivroOuManga().matches("mangá")) {
						System.out.println("Você chegou ao último vol. do mangá! :'(");
					}
					lidos.add(leituras.get(i));
					lendo.remove(leituras.get(i));
					return true;
				}
			}
		}

		System.out.println("Livro não encontrado.");
		return false;
		// se nao achou o livro/manga, exceção
	}
	
	public void listarLendo() {
		if(lendo.size() == 0) {
			System.out.println("Não há livros/mangás nesta lista ainda.");
		}
		for(int i = 0; i < lendo.size(); i++) {
			System.out.println(lendo.get(i).toString());
		}
	}
	
	public void listarConsumidos() {
		if(lidos.size() == 0) {
			System.out.println("Não há livros/mangás nesta lista ainda.");
		}
		for(int i = 0; i < lidos.size(); i++) {
			System.out.println(lidos.get(i).toString());
		}
	}
	
	public String toString() {
		String strin = "*******************************************************\n";
		if(this.status == false) {
			strin += "Tipo: " + this.livroOuManga + "\nTítulo: " + this.label + "\nAutor: " + this.author + "\nNº de páginas: "
					+ this.tamanho + "\nStatus: lido\nOnde parei: " + this.ondeParei;
		}else {
			strin += "Tipo: " + this.livroOuManga + "\nTítulo: " + this.label + "\nAutor: " + this.author + "\nNº de páginas: "
					+ this.tamanho + "\nStatus: lendo\nOnde parei: " + this.ondeParei;
		}
		return strin + "\n";
	}
}

