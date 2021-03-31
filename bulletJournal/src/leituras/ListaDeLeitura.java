package leituras;

import java.util.ArrayList;
import bulletJournal.*;

public interface ListaDeLeitura extends Midia {
	public ArrayList<Midia> lendo = new ArrayList<Midia>();
	public ArrayList<Midia> lidos = new ArrayList<Midia>();
	public ArrayList<Midia> leituras = new ArrayList<Midia>();
	public boolean ondeParei(String label, int pag);
	public void listarLendo();
}
