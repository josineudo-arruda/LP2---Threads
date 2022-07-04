package multithreads.IntPackage;

import java.security.SecureRandom;

public class intReadBuffer implements Runnable{
	private static final SecureRandom 
	generator = new SecureRandom(); // gerador de números aleatórios
	
	private final intBuffer sharedLocation; // criar o buffer

	private int size;
	
	public intReadBuffer(intBuffer sharedLocation,int size) {
		this.sharedLocation = sharedLocation; // seta o buffer que será usado
		this.size = size;
	}
	public void run() {
		int sum = 0;
		for (int count =1; count <=size; count ++) {
			try {
				Thread.sleep(generator.nextInt(3000));
				sum += sharedLocation.getBuffer();
				System.out.printf("\t\t\t%2d%n",sum);
				}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();				
			}			
		}
		System.out.printf("%n%s %d%n%s%n","Leitura do total de valores: ", sum, "Leitura finalizada!");
	}
}