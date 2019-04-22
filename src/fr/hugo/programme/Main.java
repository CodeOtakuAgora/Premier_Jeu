package fr.hugo.programme;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @author HUGO FIEF
 *
 */
public class Main {
	private static final String INDENT = " \t\t !!! ";
	private static final String FINISH = "\t\t\t ***** FIN DU PROGRAMME *** ";
	private static final String INFO = " Vous avez atteint la limite d'attaque spéciale !!!";
	private static Random rand;

	/**
	 * @param args : argument passé à main
	 * @throws NoSuchAlgorithmException : exception si rand rencontre un problème
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {
		Main processMain = new Main();
		rand = SecureRandom.getInstanceStrong();
		processMain.run();
	}

	/**
	 * on initialise le jeu
	 * 
	 * @link {@link Player#Player(String, double, double)}
	 * @link {@link Util#printlnConsole(String)
	 */
	public void run() {
		Player attacker;
		Player defender;

		do {
			int myRandom = rand.nextInt(2);

			Player player1 = new Player("Hugo", 05.0, 7.0);
			Player player2 = new Player("Alexis", 07.0, 5.0);

			String msg = String.format("Tirage au sort : %s", myRandom);
			Util.printlnConsole(msg);

			if (myRandom == 0) {
				attacker = player2;
				defender = player1;
			} else {
				attacker = player1;
				defender = player2;
			}
			attacker.info();
			defender.info();
		} while (process(attacker, defender));

	}

	// on démarre le jeu
	private boolean process(Player attacker, Player defender) {

		boolean result = true;

		do {
			attack(attacker, defender);

			if (defender.isDead()) {
				result = finish(attacker);
			}

			Player swap = attacker;
			attacker = defender;
			defender = swap;
		} while (result || (attacker.getHealth() > 0) && (defender.getHealth() > 0));

		return result;
	}

	// on lui propose de jouer
	private void attack(Player attacker, Player defender) {
		Util.printlnConsole(
				"___________________________________________________________________________________________\n");
		Util.printlnConsole("\t\t\t * TOUR DU JOUEUR : " + attacker.getName() + " * ");
		Util.printlnConsole("\t\t    " + attacker.getName() + " C'est votre tour, Attaquer " + defender.getName());
		attacker.choix();

		if (attacker.getStrPlayer() == 1) {
			defender.damage(7.0);
		} else if (attacker.getStrPlayer() == 2) {
			if (attacker.hasSpecialAttack()) {
				defender.damage(14.0);
				attacker.deleteSpecialAttack();
			} else {
				Util.printlnConsole(INDENT + attacker.getName() + INFO);
			}
		} else if ((attacker.getStrPlayer() != 1) && (attacker.getStrPlayer() != 2)) {
			Util.printlnConsole("\t\t !!! Valeur Incorrecte veuillez entré une valeur entre 1 et 2 !!!");
		}
	}

	// on lui propose de rejouer
	private boolean finish(Player player) {
		Util.printlnConsole("\n \t\t\t\t *** Fin Du Jeu ***");
		Util.printlnConsole("\t\t\t *******   Gagnant : " + player.getName() + "   *******");
		player.replay();

		if (player.getStrReplay() == 1) {
			Util.printlnConsole("\n\t\t\t Super " + player.getName() + " / Et allez c'est reparti \n");
			Util.printlnConsole(
					"*******************************************************************************************\n");

			return true;
		} else if (player.getStrReplay() == 0) {
			Util.printlnConsole("\n\t\t Ok " + player.getName() + " / Je te Remercie pour avoir joué à mon Jeu");
			Util.printlnConsole(FINISH);
		} else if ((player.getStrReplay() != 1) && (player.getStrReplay() != 0)) {
			Util.printlnConsole("\n\t\t Vous vous moquez de moi, " + player.getName()
					+ " je viens de vous dire qu'il rentrer soit 1 soit 0");
			Util.printlnConsole(FINISH);
		}
		return false;
	}

}

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
