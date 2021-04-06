package Lifestyle;

import java.util.ArrayList;

public class Atividades {
	private ArrayList<Habitos> habitos;
	private ArrayList<Fitness> fitness;
	private int cont = 0;
	
	public Atividades() {
		habitos = new ArrayList<Habitos>();
		fitness = new ArrayList<Fitness>();
	}
	
	public boolean isAtividadeValid(Object ativ) {
		if(ativ instanceof Habitos) {
			for(int i = 0; i < habitos.size(); i++) {
				if(habitos.get(i).getLabel().matches(((Habitos) ativ).getLabel())) {
					return true;
				}
			}
		}else if(ativ instanceof Fitness){
			for(int i = 0; i < fitness.size(); i++) {
				if(fitness.get(i).getLabel().matches(((Fitness) ativ).getLabel())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean canAddAtividade(Object ativ) {
		if(isAtividadeValid(ativ)) {
			if(ativ instanceof Habitos) {
				if(habitos.size() == 7) {
					return false;
				}
				for(int i = 0; i < habitos.size(); i++) {
					
				}
			}else if(ativ instanceof Fitness) {
				for(int i = 0; i < fitness.size(); i++) {
					
				}
			}
		}
		return false;
	}
	
	public boolean addAtividade(Object ativ) {
		int demorado = 0;
		if(ativ instanceof Habitos) {
			if(isAtividadeValid(ativ)) {
				System.out.println("Hábito adicionado anteriormente.");
				return false;
			}else {
				if(habitos.size() == 7) {
					System.out.println("Não é possível adicionar mais hábitos,"
							+ " a não ser que outro hábito seja removido.");
					return false;
				}else {
					for(int i = 0; i < habitos.size(); i++) {
						if(habitos.get(i).getDuracao() == 2) {
							demorado++;
						}
					}
					if(((Habitos) ativ).getDuracao() == 2) {
						if(demorado == 2) {
							System.out.println("Não é possível praticar mais de dois hábitos demorados,"
									+ " poderia te deixar sobrecarregado(a).");
							return false;
						}
						if(((Habitos) ativ).getQtdVezesPorDia() > 2) {
							System.out.println("Um hábito demorado não pode ser praticado mais de duas vezes por dia,"
									+ " pode ser desgastante para sua saúde.");
							return false;
						}
					}
				}
				habitos.add((Habitos) ativ);
				System.out.println("Hábito adicionado!");
				return true;
			}
		}else if(ativ instanceof Fitness) {
			if(isAtividadeValid(ativ)) {
				System.out.println("Exercício físico adicionado anteriormente.");
				return false;
			}else {
				if(fitness.size() == 5) {
					System.out.println("Não é possível praticar mais de cinco exercícios diários,  "
							+ "mas você pode remover outro exercício para abrir espaço.");
					return false;
				}else {
					int dif = 0;
					for(int i = 0; i < fitness.size(); i++) {
						if(fitness.get(i).getDificuldade() == 3) {
							dif++;
						}
					}
					if(((Fitness) ativ).getDificuldade() == 3) {
						if(dif == 2) {
							System.out.println("Não são permitidos mais de dois exercícios com alta dificuldade,"
									+ " poderia comprometer sua saúde.");
							return false;
						}else {
							fitness.add((Fitness) ativ);
							System.out.println("Exercício físico adicionado!");
							return true;
						}
					}
					fitness.add((Fitness) ativ);
					System.out.println("Exercício físico adicionado!");
					return true;
					}
				}
			}
		return false;
	}
	
	public boolean removerHabito(String label) {
		for(int i = 0; i < habitos.size(); i++) {
			if(habitos.get(i).getLabel().matches(label)) {
				habitos.remove(i);
				System.out.println("Hábito removido!");
				return true;
			}
		}
		System.out.println("Hábito não encontrado.");
		return false;
	}
	
	public boolean removerFitness(String label) {
		for(int i = 0; i < fitness.size(); i++) {
			if(fitness.get(i).getLabel().matches(label)) {
				fitness.remove(i);
				System.out.println("Exercício físico removido!");
				return true;
			}
		}
		System.out.println("Exercício não encontrado;");
		return false;
	}
	
	public void listarHabitos() {
		if(habitos.size() == 0) {
			System.out.println("Nenhum hábito adicionado até agora.");
		}else {
			for(int i = 0; i < habitos.size(); i++) {
				System.out.println(habitos.get(i).toString());
			}
		}
	}
	
	public void listarExercicios() {
		if(fitness.size() == 0) {
			System.out.println("Nenhum exercício físico adicionado até agora.");
		}else {
			for(int i = 0; i < fitness.size(); i++) {
				System.out.println(fitness.get(i).toString());
			}
		}
	}
}
