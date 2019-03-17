package fr.hugo.programme;

import java.util.Scanner;

public class Player {
	Scanner sc = new Scanner(System.in);

	private String name;
	private double health;
	private double attack;
	private int strPlayer;
//	private String strReplay;

	public Player(String name, double health, double attack) {
		this.name = name;
		this.health = health;
		this.attack = attack;
	}

	public void damage(double damage) {
		this.health -= damage;
		System.out.println("\n\t\t\t" + name + " vient de subir " + damage + " degats");
		if (health < 0) {
			System.out.println("\t\t\t\t vie de " + name + " : 0");
		} else {
			System.out.println("\t\t\t\t vie de " + name + " : " + health);
		}

	}

	public void choix(int choix) {
		System.out.print("Choissisez parmi vos 2 attaques => 1(Attaque Normale) / 2(Attaque Spéciale) : ");
		strPlayer = sc.nextInt();
	}

//	public void replay(String string)
//	{
//		System.out.print("\n\t\t\t ! Voulez Vous Rejouer (y/n) : ");
//		sc.nextLine();
//		strReplay = sc.nextLine();
//
//	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public double getAttack() {
		return attack;
	}

	public void setAttack(double attack) {
		this.attack = attack;
	}

	public int getStrPlayer() {
		return strPlayer;
	}

	public void setStrPlayer(int strPlayer) {
		this.strPlayer = strPlayer;
	}

//	public String getStrReplay()
//	{
//		return strReplay;
//	}
//	
//	public void setStrReplay(String strReplay)
//	{
//		this.strReplay = strReplay;
//	}
}
