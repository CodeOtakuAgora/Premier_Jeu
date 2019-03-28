// on importe le package parent du projet
package fr.hugo.programme;

// on importe la librairie pour scanner des valeurs
import java.util.Scanner;

// classe Player
public class Player {
	// on crée le scanner
	Scanner sc = new Scanner(System.in);

	// on déclare variables d'instances privées pour mes méthodes
	private String name;
	private double health;
	private double attack;
	private int strPlayer;
	private int strReplay;

	// on définit la méthode principale avec le contructeur et on initialises nos
	// instances de classe
	public Player(String name, double health, double attack) {
		this.name = name;
		this.health = health;
		this.attack = attack;
	}

	// Méthode qui permet d'infliger des dégats àun joueur et lui afficher sa
	// nouvelle vie
	public void damage(double damage) {
		this.health -= damage;
		System.out.println("\n\t\t\t" + name + " vient de subir " + damage + " degats");
		if (health < 0) {
			System.out.println("\t\t\t\t vie de " + name + " : 0");
		} else {
			System.out.println("\t\t\t\t vie de " + name + " : " + health);
		}
	}

	// Méthodes informatives qui demandent au joueur de faire un choix
	public void choix(int choix) {
		System.out.print("Choissisez parmi vos 2 attaques => 1(Attaque Normale) / 2(Attaque Spéciale) : ");
		strPlayer = sc.nextInt();
	}

	public void replay(int replay) {
		System.out.print("\n\t\t\t ! Voulez Vous Rejouer (1/0) : ");
		strReplay = sc.nextInt();
	}

	// Méthode qui retourne le nom du joueur
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Méthode qui retourne la vie du joueur
	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	// Méthode qui retourne l'attaque du joueur
	public double getAttack() {
		return attack;
	}

	public void setAttack(double attack) {
		this.attack = attack;
	}

	// Méthode pour retourne le choix du joueur pour qu'il puisse attaquer
	public int getStrPlayer() {
		return strPlayer;
	}

	public void setStrPlayer(int strPlayer) {
		this.strPlayer = strPlayer;
	}

	// Méthode qui retourne le choix du joueur pour qu'il puisse rejoué
	public int getStrReplay() {
		return strReplay;
	}

	public void setStrReplay(int strReplay) {
		this.strReplay = strReplay;
	}
}
