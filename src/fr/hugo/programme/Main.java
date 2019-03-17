package fr.hugo.programme;

import java.util.Scanner;

//classe principale
public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int replay;

		do {
			int compteurPlayer1 = 0;
			int compteurPlayer2 = 0;
			String strReplay;
			replay = 0;

			// Joueur 1
			Player player1 = new Player("Hugo", 15.0, 7.0);
			// Joueur 2
			Player player2 = new Player("Alexis", 20.0, 5.0);

			System.out.println("\t *** Informations de " + player1.getName() + " *** \t\t\t" + "*** Informations de "
					+ player2.getName() + " ***");
			System.out.println("Nom : " + player1.getName() + " / Vie : " + player1.getHealth() + " / Attaque : "
					+ player1.getAttack() + "\t\t Nom : " + player2.getName() + " / Vie : " + player2.getHealth()
					+ " / Attaque : " + player2.getAttack());

			while ((player1.getHealth() > 0) && (player2.getHealth() > 0)) {
				System.out.println(
						"_________________________________________________________________________________________________________");
				System.out.println("\t\t\t * TOUR DU JOUEUR : " + player2.getName() + " * ");
				System.out.println("\t\t    " + player2.getName() + " C'est votre tour, Attaquer " + player1.getName());
				player2.choix(0);

				if (player2.getStrPlayer() == 1) {
					player1.damage(5.0);
				}

				else if (player2.getStrPlayer() == 2) {
					if (compteurPlayer2 < 1) {
						player1.damage(10.0);
						compteurPlayer2++;
					} else {
						System.out.println("\t\t !!! " + player2.getName()
								+ " Vous avez atteint la limite d'attaque spéciale !!!");
					}

				} else {
					System.out.println("\t\t !!! Valeur Incorrecte veuillez entré une valeur entre 1 et 2 !!!");
				}

				if ((player1.getHealth() > 0) && (player2.getHealth() > 0)) {
					System.out.println(
							"_________________________________________________________________________________________________________");
					System.out.println("\t\t\t * TOUR DU JOUEUR : " + player1.getName() + " * ");
					System.out.println(
							"\t\t    " + player1.getName() + " C'est votre tour, Attaquer " + player2.getName());
					player1.choix(0);

					if (player1.getStrPlayer() == 1) {
						player2.damage(7.0);
					} else if (player1.getStrPlayer() == 2) {
						if (compteurPlayer1 < 1) {
							player2.damage(14.0);
							compteurPlayer1++;
						} else {
							System.out.println("\t\t !!! " + player1.getName()
									+ " Vous avez atteint la limite d'attaque spéciale !!!");
						}
					}
				}
				if ((player1.getHealth() <= 0) || (player2.getHealth() <= 0)) {
					System.out.println("\n \t\t\t\t *** Fin Du Jeu ***");

					if (player1.getHealth() <= 0) {
						System.out.println("\t\t\t *******   Gagnant : " + player2.getName() + "   *******");

						System.out.print("\n\t\t\t ! Voulez Vous Rejouer (y/n) : ");
						sc.nextLine();
						strReplay = sc.nextLine();

						if ((strReplay == "y") || (strReplay == "Y")) {
							System.out.println("\t\t Super " + player2.getName() + " / Et allez c'est reparti");
							replay = 1;
						} else if ((strReplay == "n") || (strReplay == "N")) {
							System.out.println(
									"\t\t Ok " + player2.getName() + " Je te Remercie pour avoir joué à mon Jeu");
							System.out.println("\t\t\t ***** FIN DU PROGRAMME *** ");
						} else if ((strReplay != "y") && (strReplay != "Y") && (strReplay != "n")
								&& (strReplay != "N")) {
							System.out.println(
									"\t\t Vous vous fichez de moi, je viens de vous dire qu'il rentrer soit y soit n");
							System.out.println("\t\t\t ***** FIN DU PROGRAMME *** ");
						}
					}

					else if (player2.getHealth() <= 0) {
						System.out.println("\t\t\t *******   Gagnant : " + player1.getName() + "   *******");
						System.out.print("\n\t\t\t ! Voulez Vous Rejouer (y/n) : ");
						sc.nextLine();
						strReplay = sc.nextLine();

						if ((strReplay == "y") || (strReplay == "Y")) {
							System.out.println("\t\t Super " + player1.getName() + " / Et allez c'est reparti");
							replay = 1;
						} else if ((strReplay == "n") || (strReplay == "N")) {
							System.out.println(
									"\t\t Ok " + player1.getName() + " / Je te Remercie pour avoir joué à mon Jeu");
							System.out.println("\t\t\t ***** FIN DU PROGRAMME *** ");
						} else if ((strReplay != "y") && (strReplay != "Y") && (strReplay != "n")
								&& (strReplay != "N")) {
							System.out.println("\t\t Vous vous fichez de moi, " + player1.getName()
									+ " je viens de vous dire qu'il rentrer soit y soit n");
							System.out.println("\t\t\t ***** FIN DU PROGRAMME *** ");
						}
					}
				}

			}
		} while (replay != 1);

	}

}

/***************************************
 * TUTO OBJET
 ************************************************************/
/*
 * 
 * //Joueur 1 Player player1 = new Player("Hugo", 30.0, 7.0);
 * System.out.println("*** Informations de " + player1.getName() + " ***");
 * System.out.println("Mon Nom : " + player1.getName());
 * System.out.println("Ma vie : " + player1.getHealth());
 * System.out.println("Mon Attaque : " + player1.getAttack());
 * //player1.damage(10.0); //System.out.println("Ma vie : " +
 * player1.getHealth());
 * 
 * System.out.println("_____________________________________\n");
 * 
 * // Joueur 2 Player player2 = new Player("Alexis", 50.0, 3.0);
 * player2.setName("Ludovic"); System.out.println("*** Informations de "
 * +player2.getName() + " ***"); System.out.println("Mon Nom : " +
 * player2.getName()); System.out.println("Ma Vie : " + player2.getHealth());
 * System.out.println("Mon Attaque : " + player2.getAttack());
 */

/*************************************
 * TUTO HERITAGE
 ***********************************************************/

/*
 * 
 * Strawberry maFraise = new Strawberry(null); maFraise.taste();
 * maFraise.miam();
 * 
 * Kiwi monKiwi = new Kiwi(null); monKiwi.taste(); monKiwi.miam();
 * 
 * if((monKiwi instanceof PeelFruit) && (maFraise instanceof PeelFruit)) {
 * System.out.
 * println("La classe kiwi et fraise implémente l'interface PeelFruit");
 * //PeelFruit fruit = monAnanas; //fruit.isPeeled() } else if(!(monKiwi
 * instanceof PeelFruit) && (maFraise instanceof PeelFruit)) { System.out.
 * println("La classe kiwi et fraise n'implémente pas l'interface Peelfruit"); }
 * 
 */

/*************************************
 * TUTO LECTURE CLAVIER
 ****************************************************/

/*
 * 
 * @SuppressWarnings("resource") Scanner sc = new Scanner(System.in);
 * 
 * System.out.print("Veuillez saisir un mot : "); String str1 = sc.nextLine();
 * System.out.print("Veuillez saisir un nombre : "); int str2 = sc.nextInt();
 * System.out.print("Saisissez une lettre : "); sc.nextLine(); String str3 =
 * sc.nextLine(); char carac = str3.charAt(0);
 * System.out.println("Vous avez saisi : " + str1);
 * System.out.println("Vous avez saisi le nombre : " + str2);
 * System.out.println("Vous avez saisi le caractère : " + carac);
 * 
 */
