package zufallszahlen;

/**
 * 
 * @author Marius Degen
 *
 */
public class Zufallszahlengenerator {

	public static void main(String[] args) {

		// Generiert Zufallszahlen basierend auf einer Verteilungsfunktion
		StandartGenerator stdGen = new StandartGenerator(
				Zufallszahlengenerator::verteilungsFunktionAnrufeFernsehabstimmung, 
				Zufallszahlengenerator::zufallsZahl, 
				0d, 
				Math.log(1.5));

		// Generiert Zufallszahlen mithilfe der Inversionsmethode
		StandartGenerator stdGenInv = new StandartGenerator(
				Zufallszahlengenerator::verteilungsFunktionAnrufeFernsehabstimmung, 
				Zufallszahlengenerator::zufallsZahl, 
				0d, 
				Math.log(1.5));

		// Generiert Zufallszahlen mithilfe der Verwerfungsmethode
		Verwerfungsmethode vMethode = new Verwerfungsmethode(
				Zufallszahlengenerator::verteilungsFunktionAnrufeFernsehabstimmung, 
				Zufallszahlengenerator::dichteFunktionAnrufeFernsehabstimmung, 
				Zufallszahlengenerator::hilfsverteilungsFunktion, 
				Zufallszahlengenerator::dichteFunktionHilfsverteilungsfunktion,
				Zufallszahlengenerator::gleichförmigVerteilteZufallszahl,
				Zufallszahlengenerator::gVerteilteZufallszahl,
				Zufallszahlengenerator.k);

		// TODO: In mehreren Duchläufen die folgednen drei Methoden zu berechnung der Zufallszahlen durchlaufen lassen und für jeden Durchlauf je Methode die Laufzaufzeit, mean, stdDev, variance bestimmen
		// z.B. in for/while loop ca 1000 mal
		// und dann DOkumentieren welche am besten war
		// Gut bedeutet kurze Laufzeit und gleichmäßige Häufigkeitsverteilung, geringe Korrelation
		Double zufallsvariableDerStdMethode = stdGen.generate();
		Double zufallsvariableDerInvMethode = stdGenInv.generate();
		Double zufallsvariableDerVerwerfungsmethode = vMethode.generate();
		
		System.out.println("Zufallszahl der Standart Methode: " + zufallsvariableDerStdMethode);
		System.out.println("Zufallszahl der Inversionsmethode: " + zufallsvariableDerInvMethode);
		System.out.println("Zufallszahl der Verwergungsmethode: " + zufallsvariableDerVerwerfungsmethode);
		
	}
	
	/*
	  TODO: Implementiere folgende Funktionen für die Auswertung
	   	def mean[T: Numeric](xs: Iterable[T]): Double = xs.sum.toDouble / xs.size

  		def variance[T: Numeric](xs: Iterable[T]): Double = {
    		val avg = mean(xs)

    		xs.map(_.toDouble).map(a => math.pow(a - avg, 2)).sum / xs.size
  		}

  		def stdDev[T: Numeric](xs: Iterable[T]): Double = math.sqrt(variance(xs))
	 */
	
	public static final Double k = 1d; // TODO: Dieser Wert ist wahrscheinlich nicht korrekt und dient daher vorerst als Platzhalter
	
	/**
	 * Verteilungsfunktion F der eingehenden Anrufe bei der Fernsehabstimmungen nach https://de.wikibooks.org/wiki/Statistik:_Stetige_Zufallsvariablen#Beispiel:_Eingehende_Anrufe_bei_Fernsehabstimmungen
	 * 
	 * @param x: Zufallsvariable. Parameter der Verteilungsfunktion. Gibt einen Zeitpunkt an zu dem zu erwartende Anrufe berechnet werden.
	 * @return Anrufe zum Zeitpunkt x
	 */
	public static Double verteilungsFunktionAnrufeFernsehabstimmung(Double x) {
		if (x < 2d) {

			return 0d;

		} else if( x >= 2d && x <= 2d * Math.E ) {

			return Math.log(x) - Math.log(2d);

		} else { // equals case if( x > 2 * Math.E )

			return 1d;

		}
	}
	
	/**
	 * Hilfsverteilungsfunktion G.
	 * Berechnet über die Inversionsmethode für die Verteilungsfunktion F
	 * 
	 */
	public static Double hilfsverteilungsFunktion(Double x) {
		if ( x < 0d ) {

			return 0d;

		} else if (x >= 0d && x <= Math.log(1.5)) {

			return 2d * Math.exp(x) - 2;

		} else {

			return 1d;

		}
	}

	/**
	 * Dichtefunktion f zur Verteilungsfunktion F(verteilungsFunktionAnrufeFernsehabstummung)
	 * 
	 * @param x
	 * @return
	 */
	public static Double dichteFunktionAnrufeFernsehabstimmung(Double x) {
		if (x < 2d) {

			return 0d;

		} else if( x >= 2d && x <= 2d * Math.E ) {

			return 1 / x;

		} else { // equals case if( x > 2 * Math.E )

			return 0d;

		}
	}
	
	/**
	 * Dichtefunktion g der Hilfsverteilungsfunktion G(hilfsverteilungsfunktion())
	 */
	public static Double dichteFunktionHilfsverteilungsfunktion(Double x) {
		if ( x < 0d ) {
			
			return 0d;

		} else if (x >= 0d && x <= Math.log(1.5)) {

			return 2 * Math.exp(x);

		} else {

			return 0d;

		}
	}

	/**
	 * Erzeugt Zufallszahlen 
	 * 
	 * @return Zufallszahl
	 */
	public static Double zufallsZahl(Double min, Double max) {
		return min + (max - min) * Math.random();
	}

	/**
	 * Erzeugt Zufallszahlen die der Verteilung G genügen
	 * 
	 * @return Zufallszahl
	 */
	public static Double gVerteilteZufallszahl(Double x) {
		return 0 + (Math.log(1.5) - 0) * Math.random();
	}
	
	/**
	 * Erzeugt Standartzufallszahl(unabhängiger, auf [ 0 ; 1 ] {\displaystyle [0;1]} [0;1] gleichverteilter Zufallsvariablen) die der Verteilung G genügen
	 * 
	 * @return Standartzufallszahl
	 */
	public static Double gleichförmigVerteilteZufallszahl(Double x) {
		return 0 + (Math.log(1.5) - 0) * Math.random();
	}
}
