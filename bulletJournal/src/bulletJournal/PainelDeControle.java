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
		System.out.println("Bem vindo! Este � o seu Bullet Journal novinho em folha.");
		System.out.print("Por favor, insira seu nome para que possamos come�ar a preench�-lo: ");
		
		String word = scan.nextLine();
		bullet = new BulletJournal(word);
		
		System.out.println("\nBullet Journal criado, " + bullet.getProprietario()
		+"! Ele est� organizado em 3 se��es:\n"
		+ "Entretenimento: series, filmes, livros e mangas\n"
		+ "Lifestyle: atividades, h�bitos\n"
		+ "Universidade: trabalhos e APs\n" +
		bullet.getProprietario() + ", o que deseja fazer com seu Bullet Journal?");
		this.escolha();
		
	}
	
	public void escolha() {
		System.out.print("\nOp��o 0: adicionar algo ao seu Bullet Journal\n"
				+ "Op��o 1: modificar algo em seu Bullet Journal\n"
				+ "Op��o 2: remover algo do seu Bullet Journal\n"
				+ "Op��o 3: listar o conte�do do seu Bullet Journal\n"
				+ "Op��o 4: finalizar altera��es\n"
				+ "Digite sua op��o: ");
		try {
			op = scan.nextInt();
			if(op == 0) {
				System.out.println("\nVoc� escolheu: adicionar algo ao seu Bullet Journal");
				System.out.println("o que deseja adicionar ao seu Bullet Journal?\n");
				this.adicionar();
			}else if( op == 1) {
				System.out.println("\nVoc� escolheu: modificar algo em seu Bullet Journal");
				System.out.println("o que deseja modificar em seu Bullet Journal?\n");
				this.modificar();
			}else if(op == 2) {
				this.remover();
			}else if(op == 3) {
				System.out.println("\nVoc� escolheu: listar o conte�do do seu Bullet Journal");
				System.out.println("o que deseja listar?\n");
				this.listar();
			}else if(op == 4) {
				System.out.println("Finalizando altera��es...");
				System.out.println("Volte sempre que necessitar!");
				System.exit(0);
			}else {
				System.out.println("\nOp��o inv�lida, tente novamente.");
				this.escolha();
			}
		}catch (Exception e) {
			System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
			System.exit(1);
		}
	}
	
	// ADICIONANDO
	
	public void adicionar() {
		System.out.print("Op��o 0: livro\n"
				+ "Op��o 1: mang�\n"
				+ "Op��o 2: filme\n"
				+ "Op��o 3: s�rie\n"
				+ "Op��o 4: h�bitos\n"
				+ "Op��o 5: exerc�cios f�sicos\n"
				+ "Op��o -1: voltar ao menu inicial\n"
				+ "Digite sua op��o: ");
		try {
			op = scan.nextInt();
			if(op == 0) {
				System.out.println("\nVoc� escolheu: adicionar livro");
				this.addLivroOuManga(0);
			}else if( op == 1) {
				System.out.println("\nVoc� escolheu: adicionar mang�");	
				this.addLivroOuManga(1);
			}else if(op == 2) {
				System.out.println("\nVoc� escolheu: adicionar filme");
				this.addFilme();
			}else if(op == 3) {
				System.out.println("\nVoc� escolheu: adicionar s�rie");
				this.addSerie();
			}else if(op == 4) {
				System.out.println("\nVoc� escolheu: adicionar h�bitos");
				this.addHabito();
			}else if(op == 5) {
				System.out.println("\nVoc� escolheu: adicionar exerc�cios f�sicos");
				this.addFitness();
			}else if(op == -1) {
				this.escolha();
			}else {
				System.out.println("\nOp��o inv�lida, tente novamente.");
				this.adicionar();
			}
		}catch (Exception e) {
			System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
			System.exit(1);
		}
	}
	
	public void addLivroOuManga(int lom) {
		scan.nextLine();
		System.out.print("T�tulo: ");
		String label = scan.nextLine();
		System.out.print("Autor: ");
		String author = scan.nextLine();
		
		boolean stat = false;
		System.out.print("Status (0 - j� li, 1 - estou lendo): ");
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
					System.out.print("Op��o inv�lida, insira novamente: ");
					continue;				
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
		
		if(lom == 0) {
			System.out.print("N� de p�ginas: ");
		}else {
			System.out.print("N� de volumes: ");
		}
		
		int tam = 0;
		try {
			tam = scan.nextInt();
			while(true) {
				if(tam <= 0){
					System.out.print("Valor inv�lido, insira outro: ");
					tam = scan.nextInt();
					continue;
				}else {
					break;
				}
			}
		}catch(Exception e) {
			System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
			System.exit(1);
		}

		if(lom == 0) {
			Midia m = new Leituras("livro", label, author, stat, tam);
			l.addMidia(m);
		}else {
			Midia m = new Leituras("mang�", label, author, stat, tam);
			l.addMidia(m);
		}
		
		while(true) {
			System.out.println("\ninsira 0 para adicionar outro livro");
			System.out.println("insira 1 para adicionar outro mang�");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}

	}
	
	public void addFilme() {
		scan.nextLine();
		System.out.print("T�tulo: ");
		String label = scan.nextLine();
		System.out.print("Review: ");
		String review = scan.nextLine();
		System.out.print("Nota (entre 1 e 5): ");
		
		double nota = 0;
		try {
			nota = scan.nextDouble();
			if(nota < 1 || nota > 5) {
				System.out.println("Nota inv�lida, insira outra: ");
				while(true) {
					nota = scan.nextDouble();
					if(nota < 1 || nota > 5) {
						System.out.print("Nota inv�lida, insira outra: ");
						continue;
					}else {
						break;
					}
				}
			}
		}catch(Exception e) {
			System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro/double.");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
		
	}
	
	public void addSerie() {
		scan.nextLine();
		System.out.print("T�tulo da s�rie: ");
		String label = scan.nextLine();
		System.out.print("Nota para a s�rie (1 a 5): ");
		
		double nota = 4;
		try {
			nota = scan.nextDouble();
			while(true) {
				if(nota < 1 || nota > 5) {
					System.out.print("Nota inv�lida, insira outra: ");
					nota = scan.nextDouble();
					continue;
				}else {
					break;
				}
			}
		}catch(Exception e) {
			System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro/double.");
			System.exit(1);
		}
		
		scan.nextLine();
		System.out.print("Review da s�rie: ");
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
					System.out.print("Valor inv�lido, insira novamente: ");
					status = scan.nextInt();
					continue;
				}
			}
		}catch(Exception e) {
			System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
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
					System.out.print("Valor inv�lido, insira novamente: ");
					qtd = scan.nextInt();
					continue;
				}
			}
		}catch(Exception e) {
			System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
			System.exit(1);
		}
		
		s.addMidia(new Series(label, nota, review, stat, qtd));
		
		while(true) {
			System.out.println("\ninsira 0 para continuar adicionando s�ries");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
		
	}
	
	public void addHabito() {
		
		scan.nextLine();
		
		System.out.print("Insira o h�bito que deseja adicionar (ex.: medita��o, yoga, etc): ");
		String label = scan.nextLine();
		System.out.print("Insira a dura��o (1 - r�pido, 2 - demorado): ");
		int duracao = 9;
		while(true) {
			try {
				duracao = scan.nextInt();
				if(duracao == 1 || duracao == 2) {
					break;
				}else {
					System.out.print("Insira uma op��o v�lida: ");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
		
		System.out.print("Insira a quantidade de vezes que o h�bito ser� praticado por dia: ");
		int qtd = 9;
		try {
			qtd = scan.nextInt();
				
		}catch(Exception e) {
			System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
			System.exit(1);
		}
		
		ativ.addAtividade(new Habitos(label, duracao, qtd));
		
		while(true) {
			System.out.println("insira 0 para continuar adicionando h�bitos\n"
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
					System.out.println("Insira uma op��o v�lida.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void addFitness() {

		scan.nextLine();
		System.out.print("Insira o nome do exerc�cio: ");
		String label = scan.nextLine();
		
		System.out.print("Insira a dificuldade (1 - f�cil, 2 - m�dio, 3 - dif�cil): ");
		int dif = 9;
		while(true) {
			try {
				dif = scan.nextInt();
				if(dif == 1 || dif == 2 || dif == 3) {
					break;
				}else {
					System.out.print("Insira uma op��o v�lida: ");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
		
		ativ.addAtividade(new Fitness(label, dif));
		
		while(true) {
			System.out.println("insira 0 para continuar adicionando exerc�cios\n"
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
					System.out.println("Insira uma op��o v�lida.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	// MODIFICANDO
	
	public void modificar() {
		System.out.print("\nOp��o 0: modificar status de um livro/mang�\n"
				+ "Op��o 1: atualizar a p�gina/volume de um livro/mang�\n"
				+ "Op��o 2: modificar nota de um filme\n"
				+ "Op��o 3: modificar review de um filme\n"
				+ "Op��o 4: modificar nota de uma s�rie\n"
				+ "Op��o 5: modificar review de uma s�rie\n"
				+ "Op��o 6: modificar status de uma s�rie\n"
				+ "Op��o 7: atualizar o �ltimo epis�dio assistido de uma s�rie\n"
				+ "Op��o -1: voltar ao menu inicial\n"
				+ "Digite sua op��o: ");
		try {
			op = scan.nextInt();
			if(op == 0) {
				System.out.println("\nVoc� escolheu: modificar status de um livro/mang�");
				this.modificandoStatusLeituras();
			}else if( op == 1) {
				System.out.println("\nVoc� escolheu: atualizar a p�gina/volume de um livro/mang�");
				this.atualizarLeituras();
			}else if(op == 2) {
				System.out.println("\nVoc� escolheu: modificar nota de um filme");
				this.modificandoNotaFilme();
			}else if(op == 3) {
				System.out.println("\nVoc� escolheu: modificar review de um filme");
				this.modificarReviewFilme();
			}else if(op == 4) {
				System.out.println("\nVoc� escolheu: modificar nota de uma s�rie");
				this.modificarNotaSerie();
			}else if(op == 5) {
				System.out.println("\nVoc� escolheu: modificar review de uma s�rie");
				this.modificarReviewSerie();
			}else if(op == 6) {
				System.out.println("\nVoc� escolheu: modificar status de uma s�rie");
				this.modificarStatusSerie();
			}else if(op == 7) {
				System.out.println("\nVoc� escolheu: atualizar o �ltimo epis�dio assistido de uma s�rie");
				this.modificandoUltimoEpisodio();
			}else if(op == -1) {
				this.escolha();
			}else {
				System.out.println("\nOp��o inv�lida, tente novamente.");
				this.modificar();
			}
		}catch (Exception e) {
			System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
			System.exit(1);
		}
	}
	
	public void modificandoStatusLeituras() {	
		scan.nextLine();
		System.out.println("Nome do livro/mang�: ");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void atualizarLeituras() {
		scan.nextLine();
		System.out.println("Nome do livro/mang�: ");
		String label = scan.nextLine();
		System.out.println("P�gina onde parou: ");
		int pag = 0;
		try {
			pag = scan.nextInt();
		}catch(Exception e) {
			System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
			System.exit(1);
		}
		
		l.ondeParei(label, pag);
		
		while(true) {
			System.out.println("\ninsira 0 para continuar atualizando p�gina/volume de livro/mang�");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
		
	}
	
	public void modificandoNotaFilme() {
		scan.nextLine();
		System.out.print("T�tulo: ");
		String label = scan.nextLine();
		System.out.print("Nova nota (entre 1 e 5): ");
		
		double nota = 9;
		try {
			nota = scan.nextDouble();
			if(nota < 1 || nota > 5) {
				System.out.println("Nota inv�lida, insira outra: ");
				while(true) {
					nota = scan.nextDouble();
					if(nota < 1 || nota > 5) {
						System.out.print("Nota inv�lida, insira outra: ");
						continue;
					}else {
						break;
					}
				}
			}
		}catch(Exception e) {
			System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro/double.");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void modificarReviewFilme() {
		scan.nextLine();
		System.out.print("T�tulo: ");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void modificarNotaSerie() {
		scan.nextLine();
		System.out.print("Nome da s�rie: ");
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
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
		
		s.modificarNota1(name, nota);
		
		while(true) {
			System.out.println("\ninsira 0 para modificar notas de mais s�ries");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void modificarReviewSerie() {
		scan.nextLine();
		System.out.print("Nome da s�rie: ");
		String name = scan.nextLine();
		System.out.println("Novo review: ");
		String review = scan.nextLine();
		
		s.modificarReview1(name, review);
		
		while(true) {
			System.out.println("\ninsira 0 para modificar reviews de mais s�ries");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void modificarStatusSerie() {
		scan.nextLine();
		System.out.print("Nome da s�rie: ");
		String name = scan.nextLine();
		s.modificarStatus(name);
		
		while(true) {
			System.out.println("\ninsira 0 para continuar modificando status de s�ries");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void modificandoUltimoEpisodio() {
		scan.nextLine();
		System.out.print("Nome da s�rie: ");
		String name = scan.nextLine();
		System.out.println("�ltimo epis�dio visto: ");
		
		int ep = 1;
		try {
			ep = scan.nextInt();
		}catch(Exception e) {
			System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
			System.exit(1);
		}
		
		s.modificarEpisodioAtual(name, ep);
		
		while(true) {
			System.out.println("\ninsira 0 para continuar modificando �ltimos epis�dios de s�ries");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	// REMOVENDO
	
	public void remover() {
		System.out.print("\nOp��o 0: remover um livro/mang� da lista de lidos\n"
				+ "Op��o 1: remover um filme da lista de assistidos\n"
				+ "Op��o 2: remover uma s�rie da lista de assistidos\n"
				+ "Op��o -1: voltar ao menu incial"
				+ "Digite sua op��o: ");
		try {
			op = scan.nextInt();
			if(op == 0) {
				System.out.println("\nVoc� escolheu: remover um livro/mang� da lista de lidos");
				this.excluirLidos();
			}else if( op == 1) {
				System.out.println("\nVoc� escolheu: remover um filme da lista de assistidos");
				this.excluirFilme();
			}else if(op == 2) {
				System.out.println("\nVoc� escolheu: remover uma s�rie da lista de assistidos");
				this.excluirSerie();
			}else if(op == -1) {
				this.escolha();
			}else {
				System.out.println("\nOp��o inv�lida, tente novamente.");
				this.remover();
			}
		}catch (Exception e) {
			System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
			System.exit(1);
		}
	}
	
	public void excluirLidos() {
		scan.nextLine();
		System.out.println("Nome do livro/mang�: ");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void excluirFilme() {
		scan.nextLine();
		System.out.print("T�tulo: ");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
		
	}
	
	public void excluirSerie() {
		scan.nextLine();
		System.out.print("Nome da s�rie: ");
		String name = scan.nextLine();
		s.excluirConsumido(name);
		
		while(true) {
			System.out.println("\ninsira 0 para remover mais s�ries da lista");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	// LISTANDO
	
	public void listar() {
		System.out.print("\nOp��o 0: listar livros/mang�s j� lidos\n"
				+ "Op��o 1: listar livros/mang�s que voc� est� lendo no momento\n"
				+ "Op��o 2: listar filmes assistidos\n"
				+ "Op��o 3: listar s�ries assistidas\n"
				+ "Op��o 4: listar s�ries que voc� est� assistindo no momento\n"
				+ "Op��o 5: listar h�bitos\n"
				+ "Op��o 6: listar exerc�cios f�sicos\n"
				+ "Op��o 7: visualizar todo o Bullet Journal\n"
				+ "Op��o -1: voltar ao menu inicial\n"
				+ "Digite sua op��o: ");
		try {
			op = scan.nextInt();
			if(op == 0) {
				System.out.println("\nVoc� escolheu: listar livros/mang�s j� lidos");
				this.listandoLidos();
			}else if( op == 1) {
				System.out.println("\nVoc� escolheu: listar livros/mang�s que voc� est� lendo no momento");
				this.listandoLendo();
			}else if(op == 2) {
				System.out.println("\nVoc� escolheu: listar filmes assistidos");
				this.listandoFilmes();
			}else if(op == 3) {
				System.out.println("\nVoc� escolheu: listar s�ries assistidas");
				this.seriesAssistidas();
			}else if(op == 4) {
				System.out.println("\nVoc� escolheu: listar s�ries que voc� est� assistindo no momento");
				this.seriesAssistindo();
			}else if(op == 5) {
				System.out.println("\nVoc� escolheu: listar h�bitos");
				this.listarHabitos();
			}else if(op == 6) {
				System.out.println("\nVoc� escolheu: listar exerc�cios f�sicos");
				this.listarFitness();
			}else if(op == 7) {
				System.out.println("\nVoc� escolheu: visualizar todo o Bullet Journal");
				this.visualizar();
			}else if(op == -1) {
				this.escolha();
			}else {
				System.out.println("\nOp��o inv�lida, tente novamente.");
				this.listar();
			}
		}catch (Exception e) {
			System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}
	
	public void visualizar() {
		System.out.println("\n");
		System.out.println("*~*~********************" + bullet.getProprietario() + "'s Bullet Journal"
		+ "*********************~*~*");
		System.out.println("\n");
		System.out.println("***********Livros & Mang�s***********");
		System.out.println("\n");
		l.listarConsumidos();
		l.listarLendo();
		System.out.println("\n");
		System.out.println("***********Filmes***********");
		System.out.println("\n");
		f.listarConsumidos();
		System.out.println("\n");
		System.out.println("***********S�ries***********");
		System.out.println("\n");
		s.listarConsumidos();
		s.listarAssistindo();
		System.out.println("\n");
		System.out.println("***********H�bitos***********");
		System.out.println("\n");
		ativ.listarHabitos();
		System.out.println("\n");
		System.out.println("***********Exerc�cios***********");
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
					System.out.println("Op��o inv�lida, tente novamente.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("Exception: op��o inv�lida; voc� deve inserir um inteiro.");
				System.exit(1);
			}
		}
	}

}
