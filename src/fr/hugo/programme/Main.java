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
