package zufallszahlen;

import java.util.function.BiFunction;
import java.util.function.DoubleFunction;

/**
 * 
 * @author Marius Degen
 *
 */
public class StandartGenerator implements Generator {
	
	private DoubleFunction<Double> verteilung;
	
	private BiFunction<Double, Double, Double> zufallszahl;
	
	private Double min;
	
	private Double max;
	

	public StandartGenerator(DoubleFunction<Double> verteilung, BiFunction<Double, Double, Double> zufallszahl, Double min, Double max) {
		this.verteilung = verteilung;
		this.zufallszahl = zufallszahl;
		this.min = min;
		this.max = max;
	}

	@Override
	public Double generate() {
		Double r = zufallszahl.apply(min, max);
		return verteilung.apply(r);
	}

}
