package application;

import java.util.Random;

public class MemorySimulator {

	static Random generator = new Random();
	static int[] myMemory;
	static int[] alocationSize;
	static int[] alocationStart;

	public static void main(String[] args) {

		alocationSize = new int[51];
		alocationStart = new int[51];
		myMemory = new int[generator.nextInt(20) + 30];

		System.out.println("Memória vazia:");
		for (int i = 0; i < myMemory.length; i++) {
			myMemory[i] = 0;
			System.out.print(myMemory[i]);
		}
		System.out.println("");
		int index = 0;

		for (int i = 1; i <= 30; i++) {
			int frame = generator.nextInt(8) + 1;
			System.out.println("Tamanho do frame: " + frame);
			boolean control = true;

			alocationSize[index] = frame;

			for (int j = 0; control; j++) {
				if (j <= myMemory.length - frame) {
					if (myMemory[j] == 0) {
						for (int k = j; k <= (j + frame); k++) {
							if (myMemory[k] == 0 && k == (j + (frame - 1))) {
								for (int aloc = j; aloc < (j + frame); aloc++) {
									myMemory[aloc] = 1;
								}
								control = false;
								alocationStart[index] = j;
								break;
							}
						}
					}
				} else {
					for (int m = 0; m <= myMemory.length; m++) {
						if (frame <= alocationSize[m]) {
							for (int aloc = alocationStart[m]; aloc <= alocationStart[m] + alocationSize[m]
									- 1; aloc++) {
								myMemory[aloc] = 0;
							}

							for (int aloc = alocationStart[m]; aloc <= alocationStart[m] + frame - 1; aloc++) {
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
			index++;
			System.out.println("");
		}
	}

	public final void arrayInput() {
		for (int i = 0; i < myMemory.length; i++) {
			myMemory[i] = generator.nextInt(2);
		}
	}
}
