package bulletJournal;

import java.util.Date;
import java.util.Scanner;
import leituras.*;
import audiovisual.*;
import Lifestyle.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class PainelDeControle {

	private Scanner scan = new Scanner(System.in);
	private int op;
	private Leituras l = new Leituras();
	private Series s = new Series();
	private Filmes f = new Filmes();
	private Atividades ativ = new Atividades();
	
	BulletJournal bullet;
	
	public PainelDeControle() {
		
	}
	
	public void init() {
		System.out.println("Bem vindo! Este é o seu Bullet Journal novinho em folha.");
		System.out.print("Por favor, insira seu nome para que possamos começar a preenchê-lo: ");
		
		String word = scan.nextLine();
		bullet = new BulletJournal(word);
		
		System.out.println("\nBullet Journal criado, " + bullet.getProprietario()
		+"! Ele está organizado em 3 seções:\n"
		+ "Entretenimento: series, filmes, livros e mangas\n"
		+ "Lifestyle: atividades, hábitos\n"
		+ "Universidade: trabalhos e APs\n" +
		bullet.getProprietario() + ", o que deseja fazer com seu Bullet Journal?");
		this.escolha();
		
	}
	
	public void escolha() {
		System.out.print("\nOpção 0: adicionar algo ao seu Bullet Journal\n"
				+ "Opção 1: modificar algo em seu Bullet Journal\n"
				+ "Opção 2: remover algo do seu Bullet Journal\n"
				+ "Opção 3: listar o conteúdo do seu Bullet Journal\n"
				+ "Opção 4: finalizar alterações\n"
				+ "Digite sua opção: ");
		try {
			op = scan.nextInt();
			if(op == 0) {
				System.out.println("\nVocê escolheu: adicionar algo ao seu Bullet Journal");
				System.out.println("o que deseja adicionar ao seu Bullet Journal?\n");
				this.adicionar();
			}else if( op == 1) {
				System.out.println("\nVocê escolheu: modificar algo em seu Bullet Journal");
				System.out.println("o que deseja modificar em seu Bullet Journal?\n");
				this.modificar();
			}else if(op == 2) {
				this.remover();
			}else if(op == 3) {
				System.out.println("\nVocê escolheu: listar o conteúdo do seu Bullet Journal");
				System.out.println("o que deseja listar?\n");
				this.listar();
			}else if(op == 4) {
				System.out.println("Finalizando alterações...");
				System.out.println("Volte sempre que necessitar!");
				System.exit(0);
			}else {
				System.out.println("\nOpção inválida, tente novamente.");
				this.escolha();
			}
		}catch (Exception e) {
			System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
			System.exit(1);
		}
	}
	
	// ADICIONANDO
	
	public void adicionar() {
		System.out.print("Opção 0: livro\n"
				+ "Opção 1: mangá\n"
				+ "Opção 2: filme\n"
				+ "Opção 3: série\n"
				+ "Opção 4: hábitos\n"
				+ "Opção 5: exercícios físicos\n"
				+ "Opção -1: voltar ao menu inicial\n"
				+ "Digite sua opção: ");
		try {
			op = scan.nextInt();
			if(op == 0) {
				System.out.println("\nVocê escolheu: adicionar livro");
				this.addLivroOuManga(0);
			}else if( op == 1) {
				System.out.println("\nVocê escolheu: adicionar mangá");	
				this.addLivroOuManga(1);
			}else if(op == 2) {
				System.out.println("\nVocê escolheu: adicionar filme");
				this.addFilme();
			}else if(op == 3) {
				System.out.println("\nVocê escolheu: adicionar série");
				this.addSerie();
			}else if(op == 4) {
				System.out.println("\nVocê escolheu: adicionar hábitos");
				this.addHabito();
			}else if(op == 5) {
				System.out.println("\nVocê escolheu: adicionar exercícios físicos");
				this.addFitness();
			}else if(op == -1) {
				this.escolha();
			}else {
				System.out.println("\nOpção inválida, tente novamente.");
				this.adicionar();
			}
		}catch (Exception e) {
			System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
			System.exit(1);
		}
	}
	
	public void addLivroOuManga(int lom) {
		scan.nextLine();
		System.out.print("Título: ");
		String label = scan.nextLine();
		System.out.print("Autor: ");
		String author = scan.nextLine();
		
		boolean stat = false;
		System.out.print("Status (0 - já li, 1 - estou lendo): ");
		int status;
		while(true) {
			try {
				status = scan.nextInt();
				if(status == 0) {
					stat = false;
					break;
				}else if(status == 1) {
					stat = true;
					break;
				}else {
					System.out.print("Opção inválida, insira novamente: ");
					continue;				
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
		
		if(lom == 0) {
			System.out.print("Nº de páginas: ");
		}else {
			System.out.print("Nº de volumes: ");
		}
		
		int tam = 0;
		try {
			tam = scan.nextInt();
			while(true) {
				if(tam <= 0){
					System.out.print("Valor inválido, insira outro: ");
					tam = scan.nextInt();
					continue;
				}else {
					break;
				}
			}
		}catch(Exception e) {
			System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
			System.exit(1);
		}

		if(lom == 0) {
			Midia m = new Leituras("livro", label, author, stat, tam);
			l.addMidia(m);
		}else {
			Midia m = new Leituras("mangá", label, author, stat, tam);
			l.addMidia(m);
		}
		
		while(true) {
			System.out.println("\ninsira 0 para adicionar outro livro");
			System.out.println("insira 1 para adicionar outro mangá");
			System.out.println("insira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			try {
				op = scan.nextInt();
				if(op == 0) {
					this.addLivroOuManga(0);
				}else if(op == 1) {
					this.addLivroOuManga(1);
				}else if(op == -1) {
					System.out.println('\n');
					this.escolha();
				}else if(op == -2) {
					System.out.println('\n');
					this.adicionar();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}

	}
	
	public void addFilme() {
		scan.nextLine();
		System.out.print("Título: ");
		String label = scan.nextLine();
		System.out.print("Review: ");
		String review = scan.nextLine();
		System.out.print("Nota (entre 1 e 5): ");
		
		double nota = 0;
		try {
			nota = scan.nextDouble();
			if(nota < 1 || nota > 5) {
				System.out.println("Nota inválida, insira outra: ");
				while(true) {
					nota = scan.nextDouble();
					if(nota < 1 || nota > 5) {
						System.out.print("Nota inválida, insira outra: ");
						continue;
					}else {
						break;
					}
				}
			}
		}catch(Exception e) {
			System.out.println("Exception: opção inválida; você deve inserir um inteiro/double.");
			System.exit(1);
		}
		
		f.addMidia( new Filmes(label, nota, review));
		
		while(true) {
			System.out.println("\ninsira 0 para adicionar mais filmes");
			System.out.println("insira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			
			try {
				op = scan.nextInt();
				if(op == 0) {
					this.addFilme();
				}else if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.adicionar();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
		
	}
	
	public void addSerie() {
		scan.nextLine();
		System.out.print("Título da série: ");
		String label = scan.nextLine();
		System.out.print("Nota para a série (1 a 5): ");
		
		double nota = 4;
		try {
			nota = scan.nextDouble();
			while(true) {
				if(nota < 1 || nota > 5) {
					System.out.print("Nota inválida, insira outra: ");
					nota = scan.nextDouble();
					continue;
				}else {
					break;
				}
			}
		}catch(Exception e) {
			System.out.println("Exception: opção inválida; você deve inserir um inteiro/double.");
			System.exit(1);
		}
		
		scan.nextLine();
		System.out.print("Review da série: ");
		String review = scan.nextLine();
		System.out.print("Status (0 - assistida, 1 - assistindo): ");
		
		boolean stat = false;
		int status = 5;
		try {
			status = scan.nextInt();
			while(true) {
				if(status == 0) {
					stat = false;
					break;
				}else if(status == 1) {
					stat = true;
					break;
				}else {
					System.out.print("Valor inválido, insira novamente: ");
					status = scan.nextInt();
					continue;
				}
			}
		}catch(Exception e) {
			System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
			System.exit(1);
		}
		
		System.out.print("Quantidade de episodios: ");
		int qtd = 0;
		try {
			qtd = scan.nextInt();
			while(true) {
				if(qtd > 0) {
					break;
				}else {
					System.out.print("Valor inválido, insira novamente: ");
					qtd = scan.nextInt();
					continue;
				}
			}
		}catch(Exception e) {
			System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
			System.exit(1);
		}
		
		s.addMidia(new Series(label, nota, review, stat, qtd));
		
		while(true) {
			System.out.println("\ninsira 0 para continuar adicionando séries");
			System.out.println("insira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			try {
				op = scan.nextInt();
				if(op == 0) {
					this.addSerie();
				}else if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.adicionar();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
		
	}
	
	public void addHabito() {
		
		scan.nextLine();
		
		System.out.print("Insira o hábito que deseja adicionar (ex.: meditação, yoga, etc): ");
		String label = scan.nextLine();
		System.out.print("Insira a duração (1 - rápido, 2 - demorado): ");
		int duracao = 9;
		while(true) {
			try {
				duracao = scan.nextInt();
				if(duracao == 1 || duracao == 2) {
					break;
				}else {
					System.out.print("Insira uma opção válida: ");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
		
		System.out.print("Insira a quantidade de vezes que o hábito será praticado por dia: ");
		int qtd = 9;
		try {
			qtd = scan.nextInt();
				
		}catch(Exception e) {
			System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
			System.exit(1);
		}
		
		ativ.addAtividade(new Habitos(label, duracao, qtd));
		
		while(true) {
			System.out.println("insira 0 para continuar adicionando hábitos\n"
					+ "insira -1 para voltar ao menu principal\n"
					+ "insira -2 para voltar ao menu anterior\n");
			try {
				op = scan.nextInt();
				if(op == 0) {
					this.addHabito();
				}else if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.adicionar();
				}else{
					System.out.println("Insira uma opção válida.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void addFitness() {

		scan.nextLine();
		System.out.print("Insira o nome do exercício: ");
		String label = scan.nextLine();
		
		System.out.print("Insira a dificuldade (1 - fácil, 2 - médio, 3 - difícil): ");
		int dif = 9;
		while(true) {
			try {
				dif = scan.nextInt();
				if(dif == 1 || dif == 2 || dif == 3) {
					break;
				}else {
					System.out.print("Insira uma opção válida: ");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
		
		ativ.addAtividade(new Fitness(label, dif));
		
		while(true) {
			System.out.println("insira 0 para continuar adicionando exercícios\n"
					+ "insira -1 para voltar ao menu principal\n"
					+ "insira -2 para voltar ao menu anterior\n");
			try {
				op = scan.nextInt();
				if(op == 0) {
					this.addFitness();
				}else if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.adicionar();
				}else{
					System.out.println("Insira uma opção válida.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	// MODIFICANDO
	
	public void modificar() {
		System.out.print("\nOpção 0: modificar status de um livro/mangá\n"
				+ "Opção 1: atualizar a página/volume de um livro/mangá\n"
				+ "Opção 2: modificar nota de um filme\n"
				+ "Opção 3: modificar review de um filme\n"
				+ "Opção 4: modificar nota de uma série\n"
				+ "Opção 5: modificar review de uma série\n"
				+ "Opção 6: modificar status de uma série\n"
				+ "Opção 7: atualizar o último episódio assistido de uma série\n"
				+ "Opção -1: voltar ao menu inicial\n"
				+ "Digite sua opção: ");
		try {
			op = scan.nextInt();
			if(op == 0) {
				System.out.println("\nVocê escolheu: modificar status de um livro/mangá");
				this.modificandoStatusLeituras();
			}else if( op == 1) {
				System.out.println("\nVocê escolheu: atualizar a página/volume de um livro/mangá");
				this.atualizarLeituras();
			}else if(op == 2) {
				System.out.println("\nVocê escolheu: modificar nota de um filme");
				this.modificandoNotaFilme();
			}else if(op == 3) {
				System.out.println("\nVocê escolheu: modificar review de um filme");
				this.modificarReviewFilme();
			}else if(op == 4) {
				System.out.println("\nVocê escolheu: modificar nota de uma série");
				this.modificarNotaSerie();
			}else if(op == 5) {
				System.out.println("\nVocê escolheu: modificar review de uma série");
				this.modificarReviewSerie();
			}else if(op == 6) {
				System.out.println("\nVocê escolheu: modificar status de uma série");
				this.modificarStatusSerie();
			}else if(op == 7) {
				System.out.println("\nVocê escolheu: atualizar o último episódio assistido de uma série");
				this.modificandoUltimoEpisodio();
			}else if(op == -1) {
				this.escolha();
			}else {
				System.out.println("\nOpção inválida, tente novamente.");
				this.modificar();
			}
		}catch (Exception e) {
			System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
			System.exit(1);
		}
	}
	
	public void modificandoStatusLeituras() {	
		scan.nextLine();
		System.out.println("Nome do livro/mangá: ");
		String label = scan.nextLine();
		l.modificarStatus(label);
		
		while(true) {
			System.out.println("\ninsira 0 para continuar modificando status");
			System.out.println("insira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			try {
				op = scan.nextInt();
				if(op == 0) {
					this.modificandoStatusLeituras();
				}else if(op == -1) {
					System.out.println('\n');
					this.escolha();
				}else if(op == -2) {
					System.out.println('\n');
					this.modificar();
				}else {
					System.out.println('\n');
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void atualizarLeituras() {
		scan.nextLine();
		System.out.println("Nome do livro/mangá: ");
		String label = scan.nextLine();
		System.out.println("Página onde parou: ");
		int pag = 0;
		try {
			pag = scan.nextInt();
		}catch(Exception e) {
			System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
			System.exit(1);
		}
		
		l.ondeParei(label, pag);
		
		while(true) {
			System.out.println("\ninsira 0 para continuar atualizando página/volume de livro/mangá");
			System.out.println("insira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			try {
				op = scan.nextInt();
				if(op == 0) {
					this.atualizarLeituras();
				}else if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.modificar();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
		
	}
	
	public void modificandoNotaFilme() {
		scan.nextLine();
		System.out.print("Título: ");
		String label = scan.nextLine();
		System.out.print("Nova nota (entre 1 e 5): ");
		
		double nota = 9;
		try {
			nota = scan.nextDouble();
			if(nota < 1 || nota > 5) {
				System.out.println("Nota inválida, insira outra: ");
				while(true) {
					nota = scan.nextDouble();
					if(nota < 1 || nota > 5) {
						System.out.print("Nota inválida, insira outra: ");
						continue;
					}else {
						break;
					}
				}
			}
		}catch(Exception e) {
			System.out.println("Exception: opção inválida; você deve inserir um inteiro/double.");
			System.exit(1);
		}
		
		f.modificarNota(label, nota);
		
		while(true) {
			System.out.println("\ninsira 0 para continuar modificando notas");
			System.out.println("insira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			try {
				op = scan.nextInt();
				if(op == 0) {
					this.modificandoNotaFilme();
				}else if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.modificar();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void modificarReviewFilme() {
		scan.nextLine();
		System.out.print("Título: ");
		String label = scan.nextLine();
		System.out.print("Novo review: ");
		String review = scan.nextLine();
		
		f.modificarReview(label, review);
		
		while(true) {
			System.out.println("\ninsira 0 para continuar modificando reviews de filmes");
			System.out.println("insira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			try {
				op = scan.nextInt();
				if(op == 0) {
					this.modificarReviewFilme();
				}else if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.modificar();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void modificarNotaSerie() {
		scan.nextLine();
		System.out.print("Nome da série: ");
		String name = scan.nextLine();
		System.out.println("Nova nota (entre 1 e 5): ");
		
		double nota = 9;
		while(true) {
			try {
				nota = scan.nextDouble();
				if(nota < 1 || nota > 5) {
					System.out.println("Nota precisa estar entre 1 e 5, insira outra: ");
					continue;
				}else {
					break;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
		
		s.modificarNota1(name, nota);
		
		while(true) {
			System.out.println("\ninsira 0 para modificar notas de mais séries");
			System.out.println("insira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			try {
				op = scan.nextInt();
				if(op == 0) {
					this.modificarNotaSerie();
				}else if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.modificar();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void modificarReviewSerie() {
		scan.nextLine();
		System.out.print("Nome da série: ");
		String name = scan.nextLine();
		System.out.println("Novo review: ");
		String review = scan.nextLine();
		
		s.modificarReview1(name, review);
		
		while(true) {
			System.out.println("\ninsira 0 para modificar reviews de mais séries");
			System.out.println("insira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			try {
				op = scan.nextInt();
				if(op == 0) {
					this.modificarReviewSerie();
				}else if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.modificar();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void modificarStatusSerie() {
		scan.nextLine();
		System.out.print("Nome da série: ");
		String name = scan.nextLine();
		s.modificarStatus(name);
		
		while(true) {
			System.out.println("\ninsira 0 para continuar modificando status de séries");
			System.out.println("insira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			try {
				op = scan.nextInt();
				if(op == 0) {
					this.modificarStatusSerie();
				}else if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.modificar();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void modificandoUltimoEpisodio() {
		scan.nextLine();
		System.out.print("Nome da série: ");
		String name = scan.nextLine();
		System.out.println("Último episódio visto: ");
		
		int ep = 1;
		try {
			ep = scan.nextInt();
		}catch(Exception e) {
			System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
			System.exit(1);
		}
		
		s.modificarEpisodioAtual(name, ep);
		
		while(true) {
			System.out.println("\ninsira 0 para continuar modificando últimos episódios de séries");
			System.out.println("insira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			try {
				op = scan.nextInt();
				if(op == 0) {
					this.modificandoUltimoEpisodio();
				}else if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.modificar();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	// REMOVENDO
	
	public void remover() {
		System.out.print("\nOpção 0: remover um livro/mangá da lista de lidos\n"
				+ "Opção 1: remover um filme da lista de assistidos\n"
				+ "Opção 2: remover uma série da lista de assistidos\n"
				+ "Opção -1: voltar ao menu incial"
				+ "Digite sua opção: ");
		try {
			op = scan.nextInt();
			if(op == 0) {
				System.out.println("\nVocê escolheu: remover um livro/mangá da lista de lidos");
				this.excluirLidos();
			}else if( op == 1) {
				System.out.println("\nVocê escolheu: remover um filme da lista de assistidos");
				this.excluirFilme();
			}else if(op == 2) {
				System.out.println("\nVocê escolheu: remover uma série da lista de assistidos");
				this.excluirSerie();
			}else if(op == -1) {
				this.escolha();
			}else {
				System.out.println("\nOpção inválida, tente novamente.");
				this.remover();
			}
		}catch (Exception e) {
			System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
			System.exit(1);
		}
	}
	
	public void excluirLidos() {
		scan.nextLine();
		System.out.println("Nome do livro/mangá: ");
		String label = scan.nextLine();
		l.excluirConsumido(label);
		
		while(true) {
			System.out.println("\ninsira 0 para continuar excluindo");
			System.out.println("insira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			try {
				op = scan.nextInt();
				if(op == 0) {
					this.excluirLidos();
				}else if(op == -1) {
					System.out.println('\n');
					this.escolha();
				}else if(op == -2) {
					System.out.println('\n');
					this.remover();
				}else {
					System.out.println('\n');
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void excluirFilme() {
		scan.nextLine();
		System.out.print("Título: ");
		String label = scan.nextLine();
		
		f.excluirConsumido(label);
		
		while(true) {
			System.out.println("\ninsira 0 para continuar removendo filmes");
			System.out.println("insira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			try {
				op = scan.nextInt();
				if(op == 0) {
					this.excluirFilme();
				}else if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.remover();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
		
	}
	
	public void excluirSerie() {
		scan.nextLine();
		System.out.print("Nome da série: ");
		String name = scan.nextLine();
		s.excluirConsumido(name);
		
		while(true) {
			System.out.println("\ninsira 0 para remover mais séries da lista");
			System.out.println("insira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			try {
				op = scan.nextInt();
				if(op == 0) {
					this.excluirSerie();
				}else if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.remover();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	// LISTANDO
	
	public void listar() {
		System.out.print("\nOpção 0: listar livros/mangás já lidos\n"
				+ "Opção 1: listar livros/mangás que você está lendo no momento\n"
				+ "Opção 2: listar filmes assistidos\n"
				+ "Opção 3: listar séries assistidas\n"
				+ "Opção 4: listar séries que você está assistindo no momento\n"
				+ "Opção 5: listar hábitos\n"
				+ "Opção 6: listar exercícios físicos\n"
				+ "Opção 7: visualizar todo o Bullet Journal\n"
				+ "Opção -1: voltar ao menu inicial\n"
				+ "Digite sua opção: ");
		try {
			op = scan.nextInt();
			if(op == 0) {
				System.out.println("\nVocê escolheu: listar livros/mangás já lidos");
				this.listandoLidos();
			}else if( op == 1) {
				System.out.println("\nVocê escolheu: listar livros/mangás que você está lendo no momento");
				this.listandoLendo();
			}else if(op == 2) {
				System.out.println("\nVocê escolheu: listar filmes assistidos");
				this.listandoFilmes();
			}else if(op == 3) {
				System.out.println("\nVocê escolheu: listar séries assistidas");
				this.seriesAssistidas();
			}else if(op == 4) {
				System.out.println("\nVocê escolheu: listar séries que você está assistindo no momento");
				this.seriesAssistindo();
			}else if(op == 5) {
				System.out.println("\nVocê escolheu: listar hábitos");
				this.listarHabitos();
			}else if(op == 6) {
				System.out.println("\nVocê escolheu: listar exercícios físicos");
				this.listarFitness();
			}else if(op == 7) {
				System.out.println("\nVocê escolheu: visualizar todo o Bullet Journal");
				this.visualizar();
			}else if(op == -1) {
				this.escolha();
			}else {
				System.out.println("\nOpção inválida, tente novamente.");
				this.listar();
			}
		}catch (Exception e) {
			System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
			System.exit(1);
		}
	}
	
	public void listandoLidos() {
		l.listarConsumidos();
		
		while(true) {
			System.out.println("\ninsira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			try {
				op = scan.nextInt();
				if(op == -1) {
					this.escolha();
					break;
				}else if(op == -2) {
					this.listar();
					break;
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
		
	}

	
	
	public void listandoLendo() {
		l.listarLendo();
		
		while(true) {
			System.out.println("\ninsira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			try {
				op = scan.nextInt();
				if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.listar();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	
	
	public void listandoFilmes() {
		f.listarConsumidos();
		
		while(true) {
			System.out.println("\ninsira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			try {
				op = scan.nextInt();
				if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.listar();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	
	public void seriesAssistidas() {
		s.listarConsumidos();
		
		while(true) {
			System.out.println("\ninsira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			try {
				op = scan.nextInt();
				if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.listar();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void seriesAssistindo() {
		s.listarAssistindo();
		
		while(true) {
			System.out.println("\ninsira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			try {
				if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.listar();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void listarHabitos() {
		ativ.listarHabitos();
		
		while(true) {
			System.out.println("\ninsira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			try {
				if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.listar();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void listarFitness() {
		ativ.listarExercicios();
		
		while(true) {
			System.out.println("\ninsira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			try {
				if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.listar();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void visualizar() {
		System.out.println("\n");
		System.out.println("*~*~********************" + bullet.getProprietario() + "'s Bullet Journal"
		+ "*********************~*~*");
		System.out.println("\n");
		System.out.println("***********Livros & Mangás***********");
		System.out.println("\n");
		l.listarConsumidos();
		l.listarLendo();
		System.out.println("\n");
		System.out.println("***********Filmes***********");
		System.out.println("\n");
		f.listarConsumidos();
		System.out.println("\n");
		System.out.println("***********Séries***********");
		System.out.println("\n");
		s.listarConsumidos();
		s.listarAssistindo();
		System.out.println("\n");
		System.out.println("***********Hábitos***********");
		System.out.println("\n");
		ativ.listarHabitos();
		System.out.println("\n");
		System.out.println("***********Exercícios***********");
		System.out.println("\n");
		ativ.listarExercicios();
		
		while(true) {
			System.out.println("\ninsira -1 para retornar ao menu principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			try {
				if(op == -1) {
					this.escolha();
				}else if(op == -2) {
					this.listar();
				}else {
					System.out.println("Opção inválida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: opção inválida; você deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}

}
