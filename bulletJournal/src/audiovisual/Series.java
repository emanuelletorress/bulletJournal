package audiovisual;

import java.util.ArrayList;
import java.util.Scanner;

import bulletJournal.*;

public class Series extends Audiovisual {
	private String label;
	private boolean status;
	private int qtdEpisodios;
	private int episodioAtual;
	protected ArrayList<Audiovisual> assistindo;
	protected ArrayList<Audiovisual> all;
	
	Scanner scan = new Scanner(System.in);
	
	public Series() {
		assistindo = new ArrayList<Audiovisual>();
		all = new ArrayList<Audiovisual>();
	}
	
	public Series(String label, double nota, String review, boolean status, int qtdEpisodios) {
		this.label = label;
		this.nota = nota;
		this.review = review;
		this.status = status;
		this.qtdEpisodios = qtdEpisodios;
		
		if(status) {
			this.episodioAtual = qtdEpisodios;
		}else {
			this.episodioAtual = 0;
		}
	}
	
	public double getNota() {
		return nota;
	}
	
	public void setNota(double nota) {
		this.nota = nota;
	}
	

	public String getLabel() {
		return this.label;
	}

	public boolean isStatus() {
		return this.status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getReview() {
		return this.review;
	}
	
	public void setReview(String review) {
		this.review = review;
	}
	
	public int getQtdEpisodios() {
		return this.qtdEpisodios;
	}
	
	public int getEpisodioAtual() {
		return this.episodioAtual;
	}
	
	public void setEpisodioAtual(int ep) {
		this.episodioAtual = ep;
	}
	
	
	public boolean modificarNota(String label, double nota) {
		if(super.modificarNota(label, nota)) {
			System.out.println("Nota alterada com sucesso.");
			return true;
		}
		System.out.println("Série não encontrada na lista.");
		return false;
	}
	
	public boolean modificarReview(String label, String review) {
		if(super.modificarReview(label, review)) {
			System.out.println("Review alterado com sucesso.");
			return true;
		}
		System.out.println("Série não encontrada na lista.");
		return false;
	}

	public boolean addMidia(Midia m) {
		for(int i = 0; i < assistidos.size(); i++) {
			if(assistidos.get(i).getLabel().matches(m.getLabel())) {
				System.out.println("Série já adicionada à lista anteriormente.");
				return false;
			}
		}
		if(m.isStatus()) {
			if(assistindo.size() < 2) {
				System.out.println("Série adicionada à lista.");
				assistindo.add((Audiovisual) m);
				all.add((Audiovisual) m);
			}else {
				System.out.println("Não assista mais de duas séries ao mesmo tempo >:( pode acabar atrapalhando seus estudos.");
				return false;
			}
		}else {
			System.out.println("Série adicionada à lista.");
			assistidos.add((Audiovisual) m);
			all.add((Audiovisual) m);
		}
		return true;
	}

	public boolean modificarStatus(String label) {
		for(int i = 0; i < all.size(); i++) {
			if(all.get(i).getLabel().matches(label)) {
				if(all.get(i).isStatus()) {
					((Series) all.get(i)).setStatus(false);
					((Series) all.get(i)).setEpisodioAtual(((Series) all.get(i)).getQtdEpisodios());
					assistidos.add(all.get(i));
					assistindo.remove(all.get(i));
					System.out.println("Status alterado com sucesso.");
					System.out.println("Status antes: assistindo");
					System.out.println("Status agora: assistida");
					return true;
				}else {
					((Series) all.get(i)).setStatus(true);
					((Series) all.get(i)).setEpisodioAtual(0);
					assistindo.add(all.get(i));
					assistidos.remove(all.get(i));
					System.out.println("Status alterado com sucesso.");
					System.out.println("Status antes: assistida");
					System.out.println("Status agora: assistindo");
					return true;
				}
			}
		}
		System.out.println("Série não encontrada.");
		return false;
	}
	
	public boolean modificarEpisodioAtual(String label, int ep) {
		for(int i = 0; i < assistindo.size(); i++) {
			if(assistindo.get(i).getLabel().matches(label)) {
				if(ep <= 0 || ep > ((Series) assistindo.get(i)).getQtdEpisodios()) {
					while(true) {
						System.out.println("Episódio inválido. Escolha outro: ");
						ep = scan.nextInt();
						if(ep > 0 || ep < ((Series) assistindo.get(i)).getQtdEpisodios()) {
							((Series) assistindo.get(i)).setEpisodioAtual(ep);
							System.out.println("Último episódio visto alterado.");
							break;
						}else if(ep <= 0 || ep > ((Series) assistindo.get(i)).getQtdEpisodios()) {
							continue;
						}else if(ep == ((Series) assistindo.get(i)).getQtdEpisodios()) {
							System.out.println("Você terminou de assistir a série " + label + "!");
							((Series) assistindo.get(i)).setEpisodioAtual(ep);
							assistidos.add(assistindo.get(i));
							assistindo.remove(assistindo.get(i));
							break;
						}
					}
					return true;
				}else {
					if(ep == ((Series) assistindo.get(i)).getQtdEpisodios()) {
						System.out.println("Você terminou de assistir a série " + label + "!");
						((Series) assistindo.get(i)).setEpisodioAtual(ep);
						assistidos.add(assistindo.get(i));
						assistindo.remove(assistindo.get(i));
						return true;
					}else {
						((Series) assistindo.get(i)).setEpisodioAtual(ep);
						System.out.println("Último episódio visto alterado.");
						return true;
					}
				}
			}
		}
		System.out.println("Série não encontrada.");
		return false;
	}

	public boolean excluirConsumido(String label) {
		for(int i = 0; i < assistidos.size(); i++) {
			if(assistidos.get(i).getLabel().matches(label)) {
				assistidos.remove(i);
				System.out.println("Série removida.");
				return true;
			}
		}
		for(int i = 0; i < assistindo.size(); i++) {
			if(assistindo.get(i).getLabel().matches(label)) {
				assistindo.remove(i);
				System.out.println("Série removida.");
				return true;
			}
		}
		System.out.println("Série não encontrada.");
		return false;
	}

	public void listarConsumidos() {
		for(int i = 0; i < assistidos.size(); i++) {
			if(assistidos.get(i) instanceof Series) {
				System.out.println(assistidos.get(i).toString());
			}
		}
		if(assistidos.size() == 0) {
			System.out.println("Esta lista está vazia no momento.");
		}
	}
	
	public void listarAssistindo() {
		for(int i = 0; i < assistindo.size(); i++) {
			System.out.println(assistindo.get(i).toString());
		}
		if(assistindo.size() == 0) {
			System.out.println("Esta lista está vazia no momento.");
		}
	}
	
	public boolean modificarNota1(String label, double nota) {
		if(super.modificarNota(label, nota)) {
			System.out.println("Nota alterada.");
			return true;
		}else {
			for(int i = 0; i < assistindo.size(); i++) {
				if(assistindo.get(i).getLabel().matches(label)) {
					((Audiovisual) assistindo.get(i)).setNota(nota);
					System.out.println("Nota alterada.");
					return true;
				}
			}
		}
		System.out.println("Série não encontrada.");
		return false;
	}
	
	public boolean modificarReview1(String label, String review) {
		if(super.modificarReview(label, review)) {
			System.out.println("Review alterado.");
			return true;
		}else {
			for(int i = 0; i < assistindo.size(); i++) {
				if(assistindo.get(i).getLabel().matches(label)) {
					assistindo.get(i).setReview(review);
					System.out.println("Review alterado.");
					return true;
				}
			}
		}
		System.out.println("Série não encontrada.");
		return false;
	}
	
	
	public String toString() {
		String strin = "*******************************************************\n";
		if(this.status == false) {
			strin += "Tipo: Série\nTítulo: " + this.getLabel() + "\nNota: " + this.getNota() + "\nReview: " + this.getReview()
			+ "\nStatus: assistida\nQuantidade de episódios: " +  this.getQtdEpisodios();
		}else {
			strin += "Tipo: Série\nTítulo:" + this.getLabel() + "\nNota: " + this.getNota() + "\nReview: " + this.getReview()
			+ "\nStatus: assistindo\nQuantidade de episódios: " +  this.getQtdEpisodios() + "\nEpisodio atual: "
			+ this.getEpisodioAtual();
		}
		return strin;
	}
}
