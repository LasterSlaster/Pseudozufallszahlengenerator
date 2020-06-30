package zufallszahlen;

/**
 * 
 * @author Marius Degen
 *
 */
public class Zufallszahlengenerator {

	public static void main(String[] args) {
		Verwerfungsmethode vMethode = new Verwerfungsmethode(
				Zufallszahlengenerator::verteilungsFunktionAnrufeFernsehabstimmung, 
				Zufallszahlengenerator::dichteFunktionAnrufeFernsehabstimmung, 
				Zufallszahlengenerator::hilfsverteilungsFunktion, 
				Zufallszahlengenerator::dichteFunktionHilfsverteilungsfunktion);
		StandartGenerator stdGen = new StandartGenerator();

		Double zufallsvariableDerVerwerfungsmethode = vMethode.generate();
		Double zufallsvariableDerStdMethode = stdGen.generate();
		
		System.out.println("Zufallszahl der Verwergungsmethode: " + zufallsvariableDerVerwerfungsmethode);
		System.out.println("Zufallszahl der Standart Methode: " + zufallsvariableDerStdMethode);
		
	}
	
	/**
	 * Verteilungsfunktion der eingehenden Anrufe bei der Fernsehabstimmungen nach https://de.wikibooks.org/wiki/Statistik:_Stetige_Zufallsvariablen#Beispiel:_Eingehende_Anrufe_bei_Fernsehabstimmungen
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
	 * Dichtefunktion zur Verteilungsfunktion verteilungsFunktionAnrufeFernsehabstummung
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
	 * Hilfsverteilungsfunktion G.
	 * Berechnet über die Inversionsmehtode
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
	 * Dichtefunktion g der Hilfsverteilungsfunktion G(hilfsverteilungsfunktion())
	 */
	public static Double dichteFunktionHilfsverteilungsfunktion(Double x) {
		// TODO: Implement based on hilfsverteilungsFunktion()
		return 1d; 
	}
}
