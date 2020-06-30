package zufallszahlen;

import java.util.function.DoubleFunction;

/**
 * Implementierung eines Pseudozufallszahlengenerators mithilfe der Verwerfungsmethode.
 * Hierbei werden für die Verteilungsfunktion F Zufallszahlen erzeugt.
 * G ist die Hilfsverteilungsfunktion mitwelcher einfach solche Zufallszahlen erzeugt werden.
 * G wird über die Inversionsmethode berechnet.
 * 
 * @author Marius Degen
 *
 */
public class Verwerfungsmethode implements Generator {
	
	/**
	 * Reelle Konstante, so dass f(x) <= k * g(x) für jedes reele x gilt
	 */
	private Double k;

	
	/**
	 * Verteilungsfunktion der Verteilung, für die ZUfallszahlen erzeugt werden
	 */
	private DoubleFunction F;
	
	/**
	 * Dichtefunktion von F
	 */
	private DoubleFunction f;

	/**
	 * Hilfsverteilungsfunktion für die Erzeugung von Zufallszahlen 
	 */
	private DoubleFunction G;
	
	/**
	 * Dichtefunktion von G
	 */
	private DoubleFunction g;

	
	public Verwerfungsmethode(DoubleFunction F, DoubleFunction f, DoubleFunction G, DoubleFunction g) {
		// TODO: set k so that f(x) <= k * g(x) für jedes x element der reelen Zahlen ???
		this.F = F;
		this.f = f;
		this.G = G;
		this.g = g;
	}
	
	@Override
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
	 * Erzeugt Zufallszahlen die der Verteilung G genügen
	 * 
	 * @return Zufallszahl
	 */
	public Double gVerteilteZufallszahl() {
		
	}
	
	/**
	 * Erzeugt Standartzufallszahl(unabhängiger, auf [ 0 ; 1 ] {\displaystyle [0;1]} [0;1] gleichverteilter Zufallsvariablen) die der Verteilung G genügen
	 * 
	 * @return Standartzufallszahl
	 */
	public Double gleichförmigVerteilteZufallszahl() {
		
	}
}
