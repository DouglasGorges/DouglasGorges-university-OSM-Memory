package application;

import java.util.Random;

public class MemorySimulator {

	static Random generator = new Random();
	static int[] myMemory;

	public static void main(String[] args) {

		myMemory = new int[generator.nextInt(20) + 30];
		System.out.println("Inicio do array:");
		for (int i = 0; i < myMemory.length; i++) {
			myMemory[i] = 0;
			System.out.print(myMemory[i]);
		}
		System.out.println("");

		for (int i = 1; i <= 4; i++) { // trocar o 4 por 30
			int frame = generator.nextInt(4) + 1; // trocar o 4 por 8
			System.out.println("Tamanho do frame: " + frame);
			boolean control = true;

			for (int j = 0; j <= (myMemory.length - frame) && control; j++) {
				if (myMemory[j] == 0) {
					for (int k = j; k <= (j + frame); k++) {
						if (myMemory[k] == 0 && k == (j + (frame - 1))) {
							for (int aloc = j; aloc < (j + frame); aloc++) {
								myMemory[aloc] = 1;
							}
							control = false;
							break;
						}
					}
				}
			}

			for (int pos = 0; pos < myMemory.length; pos++) {
				System.out.print(myMemory[pos]);
			}
			System.out.println("");
		}
	}

	public final void arrayInput() {
		for (int i = 0; i < myMemory.length; i++) {
			myMemory[i] = generator.nextInt(2);
		}
	}
}
