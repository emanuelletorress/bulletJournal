package audiovisual;

import bulletJournal.Midia;

public class Filmes extends Audiovisual {
	private String label;
	private boolean status;
	private double nota;
	private String review;
	
	public Filmes() {
		this.status = true;
	}
	
	public Filmes(String label, double nota, String review) {
		this.label = label;
		this.nota = nota;
		this.review = review;
	}

	public String getLabel() {
		return this.label;
	}

	public boolean isStatus() {
		return this.status;
	}
	
	public double getNota() {
		return this.nota;
	}
	
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	public String getReview() {
		return this.review;
	}
	
	public void setReview(String review) {
		this.review = review;
	}

	public boolean addMidia(Midia m) {
		for(int i = 0; i < assistidos.size(); i++) {
			if(assistidos.get(i).getLabel().matches(m.getLabel())) {
				if(assistidos.get(i) instanceof Filmes) {
					System.out.println("Filme já adicionado anteriormente.");
					return false;
					
				}
			}
		}
		assistidos.add((Audiovisual) m);
		System.out.println("Filme adicionado com sucesso!");
		return true;
	}

	public boolean modificarStatus(String label) {
		return false;
	}

	public boolean excluirConsumido(String label) {
		for(int i = 0; i < assistidos.size(); i++) {
			if(assistidos.get(i).getLabel().matches(label)) {
				assistidos.remove(i);
				System.out.println("Filme removido com sucesso!");
				return true;
			}
		}
		System.out.println("Filme não encontrado.");
		return false;
	}

	public void listarConsumidos() {
		for(int i = 0; i < assistidos.size(); i++) {
			if(assistidos.get(i) instanceof Filmes) {
				System.out.println(assistidos.get(i).toString());
			}
		}
		if(assistidos.size() == 0) {
			System.out.println("Esta lista está vazia no momento.");
		}
	}
	
	public boolean modificarNota(String label, double nota) {
		for(int i = 0; i < assistidos.size(); i++) {
			if(assistidos.get(i) instanceof Filmes) {
				if(assistidos.get(i).getLabel().matches(label)) {
					assistidos.get(i).setNota(nota);
					System.out.println("Nota alterada.");
					return true;
				}
			}
		}
		System.out.println("Filme não encontrado.");
		return false;
	}
	
	public boolean modificarReview(String label, String review) {
		for(int i = 0; i < assistidos.size(); i++) {
			if(assistidos.get(i) instanceof Filmes) {
				if(assistidos.get(i).getLabel().matches(label)) {
					assistidos.get(i).setReview(review);
					System.out.println("Review alterada.");
					return true;
				}
			}
		}
		System.out.println("Filme não encontrado.");
		return false;
	}
	
	public String toString() {
		String strin = "*******************************************************\n";
		strin += "Tipo: Filme\nTítulo: " + this.getLabel() + "\nReview: " + this.getReview() +
				"\nNota: " + this.getNota();
		return strin;
	}

}
