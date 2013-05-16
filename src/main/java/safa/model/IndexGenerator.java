package safa.model;

import java.util.concurrent.ThreadLocalRandom;

public class IndexGenerator {
	private static final int RANDOM_RANGE = 10000;
	
	public static String generateIndex() {
		return Long.toString(System.currentTimeMillis()) + ThreadLocalRandom.current().nextInt(RANDOM_RANGE); 
	}
}
