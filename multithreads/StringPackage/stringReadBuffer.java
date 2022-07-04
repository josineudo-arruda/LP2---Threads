package multithreads.StringPackage;

import java.security.SecureRandom;

public class stringReadBuffer implements Runnable{
	private static final SecureRandom 
	generator = new SecureRandom(); // gerador de números aleatórios
	
	private final stringBuffer sharedLocation; // criar o buffer

	private int size;
	
	public stringReadBuffer(stringBuffer sharedLocation,int size) {
		this.sharedLocation = sharedLocation; // seta o buffer que será usado
		this.size = size;
	}
	public void run() {
		String stringTotal = "";
		for (int count =1; count <= size; count ++) {
			try {
				Thread.sleep(generator.nextInt(3000));
				stringTotal += sharedLocation.getBuffer() + " ";
				System.out.printf("\t\t\t%s%n",stringTotal);
				}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();				
			}			
		}
		System.out.printf("%n%s %s%n%s%n","Leitura do total das string: ", stringTotal, "Leitura finalizada!");
	}
}