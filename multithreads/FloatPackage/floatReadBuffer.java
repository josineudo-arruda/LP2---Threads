package multithreads.FloatPackage;

import java.security.SecureRandom;

public class floatReadBuffer implements Runnable{
	private static final SecureRandom 
	generator = new SecureRandom();

	private final floatBuffer sharedLocation;

	private int size;
	
	public floatReadBuffer(floatBuffer sharedLocation,int size) {
		this.sharedLocation = sharedLocation;
		this.size = size;
	}
	public void run() {
		float sum = 0;
		for (int count =1;count <= size; count ++) {
			try {
				Thread.sleep(generator.nextInt(3000));
				sum += sharedLocation.getBuffer();
				System.out.printf("\t\t\t %.2f %n",sum);
				}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();				
			}			
		}
		System.out.printf("%n%s %.2f%n%s%n", "Leitura do total de valores: ", sum, "Leitura finalizada!");
	}
}