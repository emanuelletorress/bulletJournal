package audiovisual;

import java.util.ArrayList;
import java.util.Scanner;

import bulletJournal.*;

public abstract class Audiovisual implements Midia {
	protected double nota;
	protected String review;
	protected ArrayList<Audiovisual> assistidos = new ArrayList<Audiovisual>();
	
	Scanner scan = new Scanner(System.in);
	
	public double getNota() {
		return this.nota;
	}
	
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	public void setReview(String review) {
		this.review = review;
	}
	
	public String getReview() {
		return this.review;
	}
	
	public boolean modificarNota(String label, double nota) {
		double op;
		if(nota < 1 || nota > 5) {
			while(true) {
				System.out.println("Nota precisa ser >= 1 ou <= 5, insira novamente: ");
				op = scan.nextDouble();
				if(op < 1 || op > 5) {
					continue;
				}else {
					nota = op;
					break;
				}
			}
		}
		for(int i = 0; i < assistidos.size(); i++) {
			if(assistidos.get(i).getLabel().matches(label)) {
				((Audiovisual) assistidos.get(i)).setNota(nota);
				return true;
			}
		}
		return false;
	}
	public boolean modificarReview(String label, String review) {
		for(int i = 0; i < assistidos.size(); i++) {
			if(assistidos.get(i).getLabel().matches(label)) {
				((Audiovisual) assistidos.get(i)).setReview(review);
				return true;
			}
		}
		return false;
	}
}
