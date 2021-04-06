package Lifestyle;

public class Habitos {
	private String label;
	private int qtdVezesPorDia;
	private int duracao;
	
	public Habitos(String label, int duracao, int qtd) {
		this.label = label;
		this.qtdVezesPorDia = qtd;
		this.duracao = duracao;
	}

	public String getLabel() {
		return label;
	}

	public int getQtdVezesPorDia() {
		return qtdVezesPorDia;
	}

	public int getDuracao() {
		return duracao;
	}
	
	public String toString() {
		String strin = "***********************\n";
		strin += this.getLabel() + "\nQuantidade de vezes por dia: " + this.getQtdVezesPorDia()
			+ "\nDuracao: ";
		if(getDuracao() == 1) {
			strin += "rápido\n";
		}else {
			strin += "demorado\n";
		}
		return strin;
	}
	
	
}
