package bulletJournal;

import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Bem vindo! Este � o seu Bullet Journal novinho em folha.");
		System.out.print("Por favor, insira seu nome para que possamos come�ar a preench�-lo: ");
		String word = scan.nextLine();
		
		BulletJournal bullet = new BulletJournal(word);
		System.out.println("Muito bem, " + word + ", pode come�ar escolhendo uma categoria: ");
		
		PainelDeControle painel = new PainelDeControle();
		painel.escolhaCategoria();
	}

}
