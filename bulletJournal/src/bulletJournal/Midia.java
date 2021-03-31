package bulletJournal;

import java.util.ArrayList;

public interface Midia {
	public ArrayList<Midia> consumidos = new ArrayList<Midia>();
	public String getLabel();
	public boolean isStatus();
	public boolean addMidia(Midia m);
	public boolean modificarStatus(String label);
	public boolean excluirConsumido(String label);
	public void listarConsumidos();
}
