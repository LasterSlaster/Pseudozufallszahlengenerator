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

	private DoubleFunction standartzufallszahlG;
	
	private DoubleFunction zufallszahlG;
	
	public Verwerfungsmethode(
			DoubleFunction F, 
			DoubleFunction f, 
			DoubleFunction G, 
			DoubleFunction g, 
			DoubleFunction standartzufallszahlG, 
			DoubleFunction zufallszahlG, 
			Double k) {
		this.F = F;
		this.f = f;
		this.G = G;
		this.g = g;
		this.standartzufallszahlG = standartzufallszahlG;
		this.zufallszahlG = zufallszahlG;
		this.k = k;
	}
	
	@Override
	public Double generate() {
		Double x;
		Double u;
		do {
			x = (Double) zufallszahlG.apply(1d);
			u = (Double) standartzufallszahlG.apply(1d);
		} while ( !(u * k * ((Double) g.apply(x)) < ((Double) f.apply(x))) );
		
		// Valide Zufallszahl gefunden, welche der Verteilungsfunktion F genügt
		return x;
	}
	
	
}
