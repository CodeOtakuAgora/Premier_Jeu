
// on importe le package parent du projet
package fr.hugo.programme;

// classe principale
public class Main {
	public static void main(String[] args) {
		// on declare notre variable globale
		int replay;
		// on demare notre boucle du jeu
		do {
			// initialisation des variables locales
			int compteurPlayer1 = 0;
			int compteurPlayer2 = 0;
			int myRandom = (int) (Math.random() * 2);
			replay = 0;

			// on crée le Joueur 1
			Player player1 = new Player("Hugo", 20.0, 7.0);
			// on crée le Joueur 2
			Player player2 = new Player("Alexis", 20.0, 5.0);

			// Information sur les joueurs
			System.out.println("\t *** Informations de " + player1.getName() + " *** \t\t\t" + "*** Informations de "
					+ player2.getName() + " ***");
			System.out.println("Nom : " + player1.getName() + " / Vie : " + player1.getHealth() + " / Attaque : "
					+ player1.getAttack() + "\t\t Nom : " + player2.getName() + " / Vie : " + player2.getHealth()
					+ " / Attaque : " + player2.getAttack() + "\n");
			System.out.println("Tirage au sort : " + myRandom);

			// si la valeur random est 0 on fait jouer le joueur 2 d'abord
			if (myRandom == 0) {
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

				} else if ((player2.getStrPlayer() != 1) && (player2.getStrPlayer() != 2)) {
					System.out.println("\t\t !!! Valeur Incorrecte veuillez entré une valeur entre 1 et 2 !!!");
				}

				// si la valeur random n'est pas 0 on fait jouer le joueur 1 d'abord
			} else {
				System.out.println(
						"_________________________________________________________________________________________________________");
				System.out.println("\t\t\t * TOUR DU JOUEUR : " + player1.getName() + " * ");
				System.out.println("\t\t    " + player1.getName() + " C'est votre tour, Attaquer " + player2.getName());
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
				} else if ((player1.getStrPlayer() != 1) && (player1.getStrPlayer() != 2)) {
					System.out.println("\t\t !!! Valeur Incorrecte veuillez entré une valeur entre 1 et 2 !!!");
				}
			}

			// !!! On démarre le jeu !!!

			// Tour du joueur 2
			while ((player1.getHealth() > 0) && (player2.getHealth() > 0)) {

				if (player1.getHealth() > player2.getHealth()) {

					System.out.println(
							"_________________________________________________________________________________________________________");
					System.out.println("\t\t\t * TOUR DU JOUEUR : " + player2.getName() + " * ");
					System.out.println(
							"\t\t    " + player2.getName() + " C'est votre tour, Attaquer " + player1.getName());
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

					} else if ((player2.getStrPlayer() != 1) && (player2.getStrPlayer() != 2)) {
						System.out.println("\t\t !!! Valeur Incorrecte veuillez entré une valeur entre 1 et 2 !!!");
					}
				}

				// Tour du joueur 1
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
					} else if ((player1.getStrPlayer() != 1) && (player1.getStrPlayer() != 2)) {
						System.out.println("\t\t !!! Valeur Incorrecte veuillez entré une valeur entre 1 et 2 !!!");
					}
				}
				// es ce que l'un des 2 joueurs est mort
				if ((player1.getHealth() <= 0) || (player2.getHealth() <= 0)) {
					System.out.println("\n \t\t\t\t *** Fin Du Jeu ***");

					// vérification si la vie du joueur 1 tombe à 0
					if (player1.getHealth() <= 0) {
						System.out.println("\t\t\t *******   Gagnant : " + player2.getName() + "   *******");
						player2.replay(0);

						if (player2.getStrReplay() == 1) {
							System.out
									.println("\n\t\t\t Super " + player2.getName() + " / Et allez c'est reparti \n\n");
							System.out.println(
									"********************************************************************************************************\n");
							replay = 1;
						} else if (player2.getStrReplay() == 0) {
							System.out.println(
									"\n\t\t Ok " + player2.getName() + " Je te Remercie pour avoir joué à mon Jeu");
							System.out.println("\t\t\t ***** FIN DU PROGRAMME *** ");
						} else if ((player2.getStrReplay() != 1) && (player2.getStrReplay() != 0)) {
							System.out.println("\n\t\t Vous vous moquez de moi, " + player2.getName()
									+ " je viens de vous dire qu'il rentrer soit 1 soit 0");
							System.out.println("\t\t\t ***** FIN DU PROGRAMME *** ");
						}
					}
					// vérification si la vie du joueur 2 tombe à 0
					else if (player2.getHealth() <= 0) {
						System.out.println("\t\t\t *******   Gagnant : " + player1.getName() + "   *******");
						player1.replay(0);

						if (player1.getStrReplay() == 1) {
							System.out.println("\n\t\t\t Super " + player1.getName() + " / Et allez c'est reparti \n");
							System.out.println(
									"********************************************************************************************************\n");
							replay = 1;
						} else if (player1.getStrReplay() == 0) {
							System.out.println(
									"\n\t\t Ok " + player1.getName() + " / Je te Remercie pour avoir joué à mon Jeu");
							System.out.println("\t\t\t ***** FIN DU PROGRAMME *** ");
						} else if ((player1.getStrReplay() != 1) && (player1.getStrReplay() != 0)) {
							System.out.println("\n\t\t Vous vous moquez de moi, " + player1.getName()
									+ " je viens de vous dire qu'il rentrer soit 1 soit 0");
							System.out.println("\t\t\t ***** FIN DU PROGRAMME *** ");
						}

					}
				}

			}
			// fin de la boucle du jeu
		} while (replay == 1);

	}

}

/*************************************************************
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

/************************************************************
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

/*****************************************************
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