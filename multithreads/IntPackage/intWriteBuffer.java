package multithreads.IntPackage;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class intWriteBuffer implements Runnable{

	private static final SecureRandom 
	generator = new SecureRandom();

	private final intBuffer sharedLocation;	

	private List<Integer> vetor = new ArrayList<>();
	
	public intWriteBuffer(intBuffer sharedLocation, List<Integer> vetor) {
		this.sharedLocation = sharedLocation;
		this.vetor = vetor;
	}
	public void run() {
		int sum = 0; // soma o total de números lidos
		for (int numero : vetor) { // colocando cada elemento da lista no buffer
			try {
				Thread.sleep(generator.nextInt(3000));
				sharedLocation.putBuffer(numero);
				sum+=numero;
				System.out.printf("\t%2d\n",sum);
				}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();				
			}			
		}
		System.out.println("Escrita do buffer realizada!\n");
	}
}
