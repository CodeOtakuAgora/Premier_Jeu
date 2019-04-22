package fr.hugo.programme;

import java.util.Scanner;

/**
 * @author HUGO FIEF
 *
 */
public class Player {
	Scanner sc = new Scanner(System.in);

	private String name;
	private double health;
	private double attack;
	private int counterSpecialAttack;
	private int strPlayer;
	private int strReplay;

	/**
	 * Constructeur de notre joueur
	 * 
	 * @param name   : nom du joeur
	 * @param health : vie du joueur
	 * @param attack : attaque du joueur
	 * 
	 * @link {@link Main#run()}
	 * @link {@link Util#printConsole(String)}
	 */
	public Player(String name, double health, double attack) {
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.counterSpecialAttack = 1;
	}

	/**
	 * inflige des dégats au joueur et lui affiche sa nouvelle vie
	 * 
	 * @param damage : dommage recu par l'attaquant
	 */
	public void damage(double damage) {
		this.health -= damage;
		String msg = String.format("%n\t\t\t %s vient de subir %s degats", name, damage);
		Util.printlnConsole(msg);

		msg = String.format("\t\t\t\t vie de %s : %s ", name, health > 0 ? health : 0);
		Util.printlnConsole(msg);
	}

	/**
	 * on demande à l'attaquant de choisir son attaque
	 */
	public void choix() {
		Util.printConsole("Choissisez parmi vos 2 attaques => 1(Attaque Normale) / 2(Attaque Spéciale) : ");
		strPlayer = sc.nextInt();
	}

	/**
	 * on propose au gagnant la possibilité de rejouer
	 */
	public void replay() {
		Util.printConsole("\n\t\t\t ! Voulez Vous Rejouer (1/0) : ");
		strReplay = sc.nextInt();
	}

	/**
	 * on informe l'utilisateur des spécificités de son joueur
	 */
	public void info() {
		String msg = String.format(
				"%n\t\t *** Informations de %s ***%n [ Nom : %s / Vie : %s / Attaque : %s / counterSpecialAttack : %s ] %n  ",
				name, name, health, attack, counterSpecialAttack);
		Util.printlnConsole(msg);
	}

	/**
	 * on dit c'est à qui de jouer
	 */
	public void myRandom() {
		Util.printlnConsole(
				"___________________________________________________________________________________________\n");
		String msg = String.format("\t\t\t * TOUR DU JOUEUR : %s * %n \t    %s C'est votre tour, A l'attaque ", name,
				name);
		Util.printlnConsole(msg);
	}

	/**
	 * on retourne le nombre d'attaques spéciales restantes
	 * 
	 * @return : le nombre d'attaques spéciales restantes
	 * @link {@link #counterSpecialAttack}
	 */
	public boolean hasSpecialAttack() {
		return counterSpecialAttack > 0;
	}

	/**
	 * on rend l'attaque spéciale inutilisable
	 */
	public void deleteSpecialAttack() {
		counterSpecialAttack--;
	}

	/**
	 * on retourne les points de vies du joueur qui vient de mourir
	 * 
	 * @return : les points de vies du joueur qui vient de mourir
	 * @link {@link #health}
	 */
	public boolean isDead() {
		return health <= 0;
	}

	/**
	 * on retourne le nom du joueur
	 * 
	 * @return : le nom du joueur
	 * @link {@link #name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * on offre la possiblité à l'utilisateur de modifier le nom de son joueur
	 * 
	 * @param name : nouveau nom du joueur
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * on retourne les points de vies du joueur
	 * 
	 * @return : les points de vies du joueur
	 * @link {@link #health}
	 */
	public double getHealth() {
		return health;
	}

	/**
	 * on offre la possiblité à l'utilisateur de modifier les points de vie de son
	 * joueur
	 * 
	 * @param health : nouveaux points de vie du joueur
	 */
	public void setHealth(double health) {
		this.health = health;
	}

	/**
	 * on retourne les points d'attaques du joueur
	 * 
	 * @return : les points d'attaques du joueur
	 * @link {@link #attack}
	 */
	public double getAttack() {
		return attack;
	}

	/**
	 * on offre la possiblité à l'utilisateur de changer les points d'attaques de
	 * son joueur
	 * 
	 * @param attack : nouveaux points d'attaque du joueur
	 */
	public void setAttack(double attack) {
		this.attack = attack;
	}

	/**
	 * on retourne le choix du joueur pour qu'il puisse attaquer
	 * 
	 * @return : le choix du joueur pour qu'il puisse attaquer
	 * @link {@link #strPlayer}
	 */
	public int getStrPlayer() {
		return strPlayer;
	}

	/**
	 * on offre la possiblité à l'utilisateur de modifier les types d'attaques de
	 * son joueur
	 * 
	 * @param strPlayer : nouveaux types d'attaques du joueur
	 */
	public void setStrPlayer(int strPlayer) {
		this.strPlayer = strPlayer;
	}

	/**
	 * on retourne le choix du joueur pour qu'il puisse rejoué
	 * 
	 * @return : le choix du joueur pour qu'il puisse rejoué
	 * @link {@link #strReplay}
	 */
	public int getStrReplay() {
		return strReplay;
	}

	/**
	 * on offre la possiblité à l'utilisateur de modifier la possibilité de pouvoir
	 * rejoué
	 * 
	 * @param strReplay : nouvelles possibilité de pouvoir rejoué
	 */
	public void setStrReplay(int strReplay) {
		this.strReplay = strReplay;
	}
}
