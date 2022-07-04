package multithreads.FloatPackage;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

//runnable para rodar threads
public class floatWriteBuffer implements Runnable{
	private static final SecureRandom 
	generator = new SecureRandom();

	private final floatBuffer sharedLocation;

	private List<Float> vetor = new ArrayList<>();

	public floatWriteBuffer(floatBuffer sharedLocation, List<Float> vetor) {
		this.sharedLocation = sharedLocation;
		this.vetor = vetor;
	}
	public void run() {
		float sum = 0;
		for (float numero : vetor) {
			try {
				Thread.sleep(generator.nextInt(3000));
				sharedLocation.putBuffer(numero);
				sum+=numero;
				System.out.printf("\t%.2f\n",sum);
				}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();				
			}			
		}
		System.out.println("Escrita do buffer realizada!\n");
	}
}
