package test;

import java.util.Scanner;

public class Hangman {
	String[] liste_de_mots = {""};
	private void creerDictionnaire() {
		liste_de_mots = new String[4];
		liste_de_mots[0] = "Atmosphérique";
		liste_de_mots[1] = "Mazda";
		liste_de_mots[2] = "Zoom";
		liste_de_mots[3] = "Lithosphère";
	}
	
	Scanner keyboardScanner = new Scanner(System.in);
	boolean win = false;
	boolean good = false;
	byte essais = 3;
	byte imot = (byte) ((Math.random() * 10) % 3);
	
	private byte jouer() {
		System.out.println("imot: " + imot);
		creerDictionnaire();
		String mot_a_deviner = liste_de_mots[imot];
		String deviner = "";
		
		while(!win && essais > 0) {
			System.out.println("Essais: " + essais);
			System.out.println("Mot à deviner: " + mot_a_deviner);
			System.out.println("Mot actuel: " + deviner);
			System.out.print("Lettre: ");
			String temp = keyboardScanner.nextLine();
			
			for(byte i = 0; i < mot_a_deviner.length(); ++i) {
				if(mot_a_deviner.charAt(i) == temp.charAt(0)) {
					deviner = deviner.substring(0, i) + mot_a_deviner.charAt(i) + deviner.substring(i, deviner.length());
					good = true;
				}
			}
			if(deviner.contains(mot_a_deviner)) {
				win = true;
			}
			if(!good) {
				essais--;
			}
			good = false;
			
		}
		keyboardScanner.close();
		return 0;
	}
	
	
	public static void main(String args[]) throws InterruptedException{
		Hangman jeu = new Hangman();
		jeu.jouer();
	}
}
