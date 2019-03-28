// on importe le package parent du projet
package fr.hugo.programme;

// on importe la librairie pour scanner des valeurs
import java.util.Scanner;

// classe Player
public class Player {
	// on cr�e le scanner
	Scanner sc = new Scanner(System.in);

	// on d�clare variables d'instances priv�es pour mes m�thodes
	private String name;
	private double health;
	private double attack;
	private int strPlayer;
	private int strReplay;

	// on d�finit la m�thode principale avec le contructeur et on initialises nos
	// instances de classe
	public Player(String name, double health, double attack) {
		this.name = name;
		this.health = health;
		this.attack = attack;
	}

	// M�thode qui permet d'infliger des d�gats �un joueur et lui afficher sa
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

	// M�thodes informatives qui demandent au joueur de faire un choix
	public void choix(int choix) {
		System.out.print("Choissisez parmi vos 2 attaques => 1(Attaque Normale) / 2(Attaque Sp�ciale) : ");
		strPlayer = sc.nextInt();
	}

	public void replay(int replay) {
		System.out.print("\n\t\t\t ! Voulez Vous Rejouer (1/0) : ");
		strReplay = sc.nextInt();
	}

	// M�thode qui retourne le nom du joueur
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// M�thode qui retourne la vie du joueur
	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	// M�thode qui retourne l'attaque du joueur
	public double getAttack() {
		return attack;
	}

	public void setAttack(double attack) {
		this.attack = attack;
	}

	// M�thode pour retourne le choix du joueur pour qu'il puisse attaquer
	public int getStrPlayer() {
		return strPlayer;
	}

	public void setStrPlayer(int strPlayer) {
		this.strPlayer = strPlayer;
	}

	// M�thode qui retourne le choix du joueur pour qu'il puisse rejou�
	public int getStrReplay() {
		return strReplay;
	}

	public void setStrReplay(int strReplay) {
		this.strReplay = strReplay;
	}
}
