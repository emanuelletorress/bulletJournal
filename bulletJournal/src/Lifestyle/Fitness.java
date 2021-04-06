package Lifestyle;

public class Fitness {
	private String label;
	private int dificuldade;
	
	public Fitness(String label, int dif) {
		this.label = label;
		this.dificuldade = dif;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public int getDificuldade() {
		return this.dificuldade;
	}
	
	public String toString() {
		String strin = "***********************\n";
		strin += this.getLabel() + "\nDificuldade: ";
		if(this.getDificuldade() == 1) {
			strin += "leve\n";
		}else if(this.getDificuldade() == 2) {
			strin += "médio\n";
		}else if(this.getDificuldade() == 3) {
			strin += "difícil\n";
		}
		return strin;
	}
}
