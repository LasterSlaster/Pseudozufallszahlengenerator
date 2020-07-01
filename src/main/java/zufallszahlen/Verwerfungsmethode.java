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
	private DoubleFunction<Double> F;
	
	/**
	 * Dichtefunktion von F
	 */
	private DoubleFunction<Double> f;

	/**
	 * Hilfsverteilungsfunktion für die Erzeugung von Zufallszahlen 
	 */
	private DoubleFunction<Double> G;
	
	/**
	 * Dichtefunktion von G
	 */
	private DoubleFunction<Double> g;

	/**
	 * Funktion zur Erzeugung von Standartzufallszahlen der Verteilung G
	 */
	private DoubleFunction<Double> standartzufallszahlG;
	
	/**
	 * Funktion zur Erzeugung von Zufallszahlen der Verteilung G
	 */
	private DoubleFunction<Double> zufallszahlG;

	
	public Verwerfungsmethode(
			DoubleFunction<Double> F, 
			DoubleFunction<Double> f, 
			DoubleFunction<Double> G, 
			DoubleFunction<Double> g, 
			DoubleFunction<Double> standartzufallszahlG, 
			DoubleFunction<Double> zufallszahlG, 
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
			x = zufallszahlG.apply(1d);
			u = standartzufallszahlG.apply(1d);
		} while ( !(u * k * g.apply(x) < f.apply(x)) );
		
		// Valide Zufallszahl gefunden, welche der Verteilungsfunktion F genügt
		return x;
	}
	
	
}
