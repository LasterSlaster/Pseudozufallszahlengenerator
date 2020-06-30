package zufallszahlen;

/**
 * Implementierung eines Pseudozufallszahlengenerators mithilfe der Verwerfungsmethode.
 * Hierbei werden für die Verteilungsfunktion F Zufallszahlen erzeugt.
 * G ist die Hilfsverteilungsfunktion mitwelcher einfach solche Zufallszahlen erzeugt werden.
 * G wird über die Inversionsmethode berechnet.
 * 
 * @author laster
 *
 */
public class Verwerfungsmethode {
	
	/**
	 * Reelle Konstante, so dass f(x) <= k * g(x) für jedes reele x gilt
	 */
	private Double k;
	
	public Verwerfungsmethode() {
		// TODO: set k so that f(x) <= k * g(x) für jedes x element der reelen Zahlen ???
		
	}
	
	public Double generate() {
		Double x;
		Double u;
		do {
			x = gVerteilteZufallszahl();
			u = gleichförmigVerteilteZufallszahl();
		} while ( !(u * k * g(x) < f(x)) );
		
		// Valide Zufallszahl gefunden, welche der Verteilungsfunktion F genügt
		return x;
		
	}
	
	/**
	 * Verteilungsfunktion der Verteilung, für die ZUfallszahlen erzeugt werden
	 * 
	 * @param x
	 * @return 
	 */
	public Double F(Double x) {
		
	}
	
	/**
	 * Hilfsverteilungsfunktion für die Erzeugung von Zufallszahlen 
	 * 
	 * @param x
	 * @return
	 */
	public Double G(Double x) {
		
	}
	
	/**
	 * Erzeugt Zufallszahlen die der Verteilung G genügen
	 * 
	 * @return Zufallszahl
	 */
	public Double gVerteilteZufallszahl() {
		
	}
	
	/**
	 * Erzeugt Standartzufallszahl die der Verteilung G genügen
	 * 
	 * @return Standartzufallszahl
	 */
	public Double gleichförmigVerteilteZufallszahl() {
		
	}
	
	/**
	 * Dichtefunktion von G
	 * 
	 * @param x: Wert für welchen die Dichte von G bestimmt werden soll
	 * @return Dichte für den Wert x
	 */
	public Double g(Double x) {
		
	}
	
	/**
	 * Dichtefunktion von F
	 * 
	 * @param x: Wert für welchen die Dichte von F bestimmt werden soll
	 * @return Dichte für den Wert x
	 */
	public Double f(Double x) {
		
	}

}
