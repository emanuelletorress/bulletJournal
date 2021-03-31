package bulletJournal;

import java.util.Scanner;
import leituras.*;
import audiovisual.*;

public class PainelDeControle {
	
	Scanner scan = new Scanner(System.in);
	int op;
	Leituras l = new Leituras();
	Series s = new Series();
	Filmes f = new Filmes();
	
	public PainelDeControle() {
		
	}
	
	public void escolhaCategoria() {
		System.out.println("Op��o 0: Lazer");
		System.out.println("Op��o 1: Lifestyle");
		System.out.println("Op��o 2: Universidade");
		System.out.println("p.s.: por hora, apenas Lazer foi implementada.");
		System.out.print("Digite sua op��o: ");
		op = scan.nextInt();
		
		if(op == 0) {
			System.out.println("Voc� escolheu: lazer");
			System.out.println("Escolha qual das seguintes p�ginas deseja preencher: ");
			this.escolhaLazer();
		}else if( op == 1) {
				
		}else if(op == 2) {
				
		}else {
			System.out.println("Op��o inv�lida, tente novamente.");
			this.escolhaCategoria();
		}
	}
	
	public void escolhaLazer() {
		System.out.println("Op��o 0: Livros & Mang�s");
		System.out.println("Op��o 1: S�ries");
		System.out.println("Op��o 2: Filmes");
		System.out.print("Digite sua op��o (-1 para voltar ao painel principal): ");
		op = scan.nextInt();
		
		if(op == 0) {
			System.out.println("Voc� escolheu: Lista de leitura");
			System.out.println("Oba! O que deseja fazer com a sua lista de leitura?");
			this.escolhaLeituras();
		}else if(op == 1) {
			this.escolhaSerie();
		}else if(op == 2) {
			this.escolhaFilme();
		}else if(op == -1) {
			this.escolhaCategoria();
		}else {
			System.out.println("Op��o inv�lida, tente outra.");
			this.escolhaLazer();
		}
	}
	
	// LIVROS & MANG�S
	
	public void escolhaLeituras() {
		
		System.out.println("Op��o 0: adicionar um livro");
		System.out.println("Op��o 1: adicionar um mang�");
		System.out.println("Op��o 2: modificar o status de um livro/mang�");
		System.out.println("Op��o 3: excluir um livro/mang� da lista de literatura lida");
		System.out.println("Op��o 4: listar as obras liter�rias que j� li");
		System.out.println("Op��o 5: atualizar a p�gina de um livro onde parei ou o �ltimo mang� que li");
		System.out.println("Op��o 6: listar as obras ques estou lendo no momento.");
		System.out.print("Digite sua op��o (-1 para voltar ao painel principal,");
		System.out.print("\n-2 para voltar ao painel anterior): ");
		op = scan.nextInt();
		
		if(op == 0) {
			this.addLivroOuManga(0);
		}else if(op == 1) {
			this.addLivroOuManga(1);
		}else if(op == 2) {
			this.modificandoStatusLeituras();
		}else if(op == 3) {
			this.excluirLidos();
		}else if(op == 4) {
			this.listandoLidos();
		}else if(op == 5) {
			this.atualizarLeituras();
		}else if(op == 6) {
			this.listandoLendo();
		}else if(op == -1) {
			this.escolhaCategoria();
		}else if(op == -2) {
			this.escolhaLazer();
		}else {
			System.out.println("Op��o inv�lida, tente outra.");
			this.escolhaLeituras();
		}
	}
	
	public void addLivroOuManga(int lom) {
		// int livroOuManga, String label, String author, boolean status, int tamanho
		scan.nextLine();
		System.out.print("T�tulo: ");
		String label = scan.nextLine();
		System.out.print("Autor: ");
		String author = scan.nextLine();
		
		boolean stat;
		System.out.print("Status (0 - j� li, 1 - estou lendo): ");
		while(true) {
			int status = scan.nextInt();
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
		}
		
		if(lom == 0) {
			System.out.print("N� de p�ginas: ");
		}else {
			System.out.print("N� de volumes: ");
		}
		

		int tam = scan.nextInt();
		while(true) {
			if(tam <= 0){
			System.out.print("Valor inv�lido, insira outro: ");
			tam = scan.nextInt();
			continue;
			}else {
				break;
			}	
		}

		if(lom == 0) {
			Midia m = new Leituras("livro", label, author, stat, tam);
			l.addMidia(m);
		}else {
			Midia m = new Leituras("mang�", label, author, stat, tam);
			l.addMidia(m);
		}
		
		while(true) {
			System.out.println("insira 0 para adicionar outro livro");
			System.out.println("insira 1 para adicionar outro mang�");
			System.out.println("insira -1 para retornar ao painel principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			if(op == 0) {
				this.addLivroOuManga(0);
			}else if(op == 1) {
				this.addLivroOuManga(1);
			}else if(op == -1) {
				this.escolhaCategoria();
			}else if(op == -2) {
				this.escolhaLeituras();
			}else {
				System.out.println("Op��o inv�lida, tente novamente.");
				continue;
			}
		}

	}
	
	public void modificandoStatusLeituras() {	
		scan.nextLine();
		System.out.println("Nome do livro/mang�: ");
		String label = scan.nextLine();
		l.modificarStatus(label);
		
		while(true) {
			System.out.println("insira 0 para continuar modificando status");
			System.out.println("insira -1 para retornar ao painel principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			if(op == 0) {
				this.modificandoStatusLeituras();
			}else if(op == -1) {
				this.escolhaCategoria();
			}else if(op == -2) {
				this.escolhaLeituras();
			}else {
				System.out.println("Op��o inv�lida, tente novamente.");
				continue;
			}
		}
	}
	
	public void excluirLidos() {
		scan.nextLine();
		System.out.println("Nome do livro/mang�: ");
		String label = scan.nextLine();
		l.excluirConsumido(label);
		
		while(true) {
			System.out.println("insira 0 para continuar excluindo");
			System.out.println("insira -1 para retornar ao painel principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			if(op == 0) {
				this.excluirLidos();
			}else if(op == -1) {
				this.escolhaCategoria();
			}else if(op == -2) {
				this.escolhaLeituras();
			}else {
				System.out.println("Op��o inv�lida, tente novamente.");
				continue;
			}
		}
	}
	
	public void listandoLidos() {
		l.listarConsumidos();
		
		while(true) {
			System.out.println("insira -1 para retornar ao painel principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			if(op == -1) {
				this.escolhaCategoria();
			}else if(op == -2) {
				this.escolhaLeituras();
			}else {
				System.out.println("Op��o inv�lida, tente novamente.");
				continue;
			}
		}
		
	}
	
	public void listandoLendo() {
		l.listarLendo();
		
		while(true) {
			System.out.println("insira -1 para retornar ao painel principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			if(op == -1) {
				this.escolhaCategoria();
			}else if(op == -2) {
				this.escolhaLeituras();
			}else {
				System.out.println("Op��o inv�lida, tente novamente.");
				continue;
			}
		}
	}
	
	public void atualizarLeituras() {
		scan.nextLine();
		System.out.println("Nome do livro/mang�: ");
		String label = scan.nextLine();
		System.out.println("P�gina onde parou: ");
		int pag = scan.nextInt();
		l.ondeParei(label, pag);
		
	}
	
	// S�RIES
	
	public void escolhaSerie() {
		System.out.println("Op��o 0: adicionar uma s�rie");
		System.out.println("Op��o 1: modificar status de um s�rie");
		System.out.println("Op��o 2: alterar qual foi o �ltimo epis�dio assistido");
		System.out.println("Op��o 3: excluir s�rie da lista de s�ries assistidas");
		System.out.println("Op��o 4: listar s�ries j� assistidas");
		System.out.println("Op��o 5: listar s�ries que estou assistindo atualmente");
		System.out.println("Op��o 6: modificar nota de uma s�rie");
		System.out.println("Op��o 7: modificar review da s�rie");
		System.out.print("Digite sua op��o (-1 para voltar ao painel principal,");
		System.out.print("\n-2 para voltar ao painel anterior): ");
		op = scan.nextInt();
		
		if(op == 0) {
			this.addSerie();
		}else if(op == 1) {
			this.modificarStatusSerie();
		}else if(op == 2) {
			this.modificandoUltimoEpisodio();
		}else if(op == 3) {
			this.excluirSerie();
		}else if(op == 4) {
			this.seriesAssistidas();
		}else if(op == 5) {
			this.seriesAssistindo();
		}else if(op == 6) {
			this.modificarNotaSerie();
		}else if(op == 7) {
			this.modificarReviewSerie();
		}else if(op == -1) {
			this.escolhaCategoria();
		}else if(op == -2) {
			this.escolhaLazer();
		}else {
			System.out.println("Op��o inv�lida, tente outra.");
			this.escolhaSerie();
		}
	}
	
	public void addSerie() {
		//String label, double nota, String review, boolean status, int qtdEpisodios
		scan.nextLine();
		System.out.print("T�tulo da s�rie: ");
		String label = scan.nextLine();
		System.out.print("Nota para a s�rie (1 a 5): ");
		
		double nota;
		while(true) {
			nota = scan.nextDouble();
			if(nota < 1 || nota > 5) {
				System.out.print("Nota inv�lida, insira outra: ");
				continue;
			}else {
				break;
			}
		}
		scan.nextLine();
		System.out.print("Review da s�rie: ");
		String review = scan.nextLine();
		System.out.print("Status (0 - assistida, 1 - assistindo): ");
		
		boolean stat;
		while(true) {
			int status = scan.nextInt();
			if(status == 0) {
				stat = false;
				break;
			}else if(status == 1) {
				stat = true;
				break;
			}else {
				System.out.print("Valor inv�lido, insira novamente: ");
				continue;
			}
		}
		System.out.print("Quantidade de episodios: ");
		int qtd;
		while(true) {
			qtd = scan.nextInt();
			if(qtd > 0) {
				break;
			}else {
				System.out.print("Valor inv�lido, insira novamente: ");
				continue;
			}
		}
		
		s.addMidia(new Series(label, nota, review, stat, qtd));
		
		while(true) {
			System.out.println("insira 0 para continuar adicionando s�ries");
			System.out.println("insira -1 para retornar ao painel principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			if(op == 0) {
				this.addSerie();
			}else if(op == -1) {
				this.escolhaCategoria();
			}else if(op == -2) {
				this.escolhaSerie();
			}else {
				System.out.println("Op��o inv�lida, tente novamente.");
				continue;
			}
		}
		
	}
	
	public void modificarStatusSerie() {
		scan.nextLine();
		System.out.print("Nome da s�rie: ");
		String name = scan.nextLine();
		s.modificarStatus(name);
		
		while(true) {
			System.out.println("insira 0 para continuar modificando status de s�ries");
			System.out.println("insira -1 para retornar ao painel principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			if(op == 0) {
				this.modificarStatusSerie();
			}else if(op == -1) {
				this.escolhaCategoria();
			}else if(op == -2) {
				this.escolhaSerie();
			}else {
				System.out.println("Op��o inv�lida, tente novamente.");
				continue;
			}
		}
	}
	
	public void modificandoUltimoEpisodio() {
		scan.nextLine();
		System.out.print("Nome da s�rie: ");
		String name = scan.nextLine();
		System.out.println("�ltimo epis�dio visto: ");
		int ep = scan.nextInt();
		s.modificarEpisodioAtual(name, ep);
		
		while(true) {
			System.out.println("insira 0 para continuar modificando �ltimos epis�dios de s�ries");
			System.out.println("insira -1 para retornar ao painel principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			if(op == 0) {
				this.modificandoUltimoEpisodio();
			}else if(op == -1) {
				this.escolhaCategoria();
			}else if(op == -2) {
				this.escolhaSerie();
			}else {
				System.out.println("Op��o inv�lida, tente novamente.");
				continue;
			}
		}
	}
	
	public void excluirSerie() {
		scan.nextLine();
		System.out.print("Nome da s�rie: ");
		String name = scan.nextLine();
		s.excluirConsumido(name);
		
		while(true) {
			System.out.println("insira 0 para remover mais s�ries da lista");
			System.out.println("insira -1 para retornar ao painel principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			if(op == 0) {
				this.excluirSerie();
			}else if(op == -1) {
				this.escolhaCategoria();
			}else if(op == -2) {
				this.escolhaSerie();
			}else {
				System.out.println("Op��o inv�lida, tente novamente.");
				continue;
			}
		}
	}
	
	public void seriesAssistidas() {
		s.listarConsumidos();
		
		while(true) {
			System.out.println("insira -1 para retornar ao painel principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			if(op == -1) {
				this.escolhaCategoria();
			}else if(op == -2) {
				this.escolhaSerie();
			}else {
				System.out.println("Op��o inv�lida, tente novamente.");
				continue;
			}
		}
	}
	
	public void seriesAssistindo() {
		s.listarAssistindo();
		
		while(true) {
			System.out.println("insira -1 para retornar ao painel principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			if(op == -1) {
				this.escolhaCategoria();
			}else if(op == -2) {
				this.escolhaSerie();
			}else {
				System.out.println("Op��o inv�lida, tente novamente.");
				continue;
			}
		}
	}
	
	public void modificarNotaSerie() {
		scan.nextLine();
		System.out.print("Nome da s�rie: ");
		String name = scan.nextLine();
		System.out.println("Nova nota: ");
		double nota = scan.nextDouble();
		
		s.modificarNota1(name, nota);
		
		while(true) {
			System.out.println("insira 0 para modificar notas de mais s�ries");
			System.out.println("insira -1 para retornar ao painel principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			if(op == 0) {
				this.modificarNotaSerie();
			}else if(op == -1) {
				this.escolhaCategoria();
			}else if(op == -2) {
				this.escolhaSerie();
			}else {
				System.out.println("Op��o inv�lida, tente novamente.");
				continue;
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
			System.out.println("insira 0 para modificar reviews de mais s�ries");
			System.out.println("insira -1 para retornar ao painel principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			if(op == 0) {
				this.modificarReviewSerie();
			}else if(op == -1) {
				this.escolhaCategoria();
			}else if(op == -2) {
				this.escolhaSerie();
			}else {
				System.out.println("Op��o inv�lida, tente novamente.");
				continue;
			}
		}
	}
	
	// FILMES
	
	public void escolhaFilme() {
		System.out.println("Op��o 0: adicionar um filme");
		System.out.println("Op��o 1: excluir filme da lista de filmes assistidos");
		System.out.println("Op��o 2: listar filmes j� assistidas");
		System.out.println("Op��o 3: modificar nota de um filme");
		System.out.println("Op��o 4: modificar review de um filme");
		System.out.print("Digite sua op��o (-1 para voltar ao painel principal,");
		System.out.print("\n-2 para voltar ao painel anterior): ");
		op = scan.nextInt();
		
		if(op == 0) {
			this.addFilme();
		}else if(op == 1) {
			this.excluirFilme();
		}else if(op == 2) {
			this.listandoFilmes();
		}else if(op == 3) {
			this.modificandoNotaFilme();
		}else if(op == 4) {
			this.modificarReviewFilme();
		}else if(op == -1) {
			this.escolhaCategoria();
		}else if(op == -2) {
			this.escolhaLazer();
		}else {
			System.out.println("Op��o inv�lida, tente outra.");
			this.escolhaFilme();
		}
	}
	
	public void addFilme() {
		scan.nextLine();
		System.out.print("T�tulo: ");
		String label = scan.nextLine();
		System.out.print("Review: ");
		String review = scan.nextLine();
		System.out.print("Nota (entre 1 e 5): ");
		double nota = scan.nextDouble();
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
		
		f.addMidia( new Filmes(label, nota, review));
		
		while(true) {
			System.out.println("insira 0 para adicionar mais filmes");
			System.out.println("insira -1 para retornar ao painel principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			if(op == 0) {
				this.addFilme();
			}else if(op == -1) {
				this.escolhaCategoria();
			}else if(op == -2) {
				this.escolhaFilme();
			}else {
				System.out.println("Op��o inv�lida, tente novamente.");
				continue;
			}
		}
		
	}
	
	public void excluirFilme() {
		scan.nextLine();
		System.out.print("T�tulo: ");
		String label = scan.nextLine();
		
		f.excluirConsumido(label);
		
		while(true) {
			System.out.println("insira 0 para continuar removendo filmes");
			System.out.println("insira -1 para retornar ao painel principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			if(op == 0) {
				this.excluirFilme();
			}else if(op == -1) {
				this.escolhaCategoria();
			}else if(op == -2) {
				this.escolhaFilme();
			}else {
				System.out.println("Op��o inv�lida, tente novamente.");
				continue;
			}
		}
		
	}
	
	public void listandoFilmes() {
		f.listarConsumidos();
		
		while(true) {
			System.out.println("insira -1 para retornar ao painel principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			if(op == -1) {
				this.escolhaCategoria();
			}else if(op == -2) {
				this.escolhaFilme();
			}else {
				System.out.println("Op��o inv�lida, tente novamente.");
				continue;
			}
		}
	}
	
	public void modificandoNotaFilme() {
		scan.nextLine();
		System.out.print("T�tulo: ");
		String label = scan.nextLine();
		System.out.print("Nova nota (entre 1 e 5): ");
		double nota = scan.nextDouble();
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
		
		f.modificarNota(label, nota);
		
		while(true) {
			System.out.println("insira 0 para continuar modificando notas");
			System.out.println("insira -1 para retornar ao painel principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			if(op == 0) {
				this.modificandoNotaFilme();
			}else if(op == -1) {
				this.escolhaCategoria();
			}else if(op == -2) {
				this.escolhaFilme();
			}else {
				System.out.println("Op��o inv�lida, tente novamente.");
				continue;
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
			System.out.println("insira 0 para continuar modificando reviews");
			System.out.println("insira -1 para retornar ao painel principal");
			System.out.println("insira -2 para retornar ao menu anterior");
			op = scan.nextInt();
			if(op == 0) {
				this.modificarReviewFilme();
			}else if(op == -1) {
				this.escolhaCategoria();
			}else if(op == -2) {
				this.escolhaFilme();
			}else {
				System.out.println("Op��o inv�lida, tente novamente.");
				continue;
			}
		}
	}
}
