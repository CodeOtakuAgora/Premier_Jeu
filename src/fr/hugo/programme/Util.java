package fr.hugo.programme;

/**
 * @author HUGO FIEF
 *
 */
public class Util {
	// contructeur par défaut
	private Util() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Affiche le texte avec un retour à la ligne
	 * 
	 * @param text : texte passé en parametre
	 * @link {@link Main#run()}
	 */
	public static void printlnConsole(String text) {
		System.out.println(text);
	}

	/**
	 * Affiche le texte sans retour à la ligne
	 * 
	 * @param text : texte passé en parametre
	 * @link {@link Player#Player(String, double, double)
	 */
	public static void printConsole(String text) {
		System.out.print(text);
	}
}
