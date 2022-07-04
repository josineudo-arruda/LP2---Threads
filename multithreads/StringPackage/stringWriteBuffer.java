package multithreads.StringPackage;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class stringWriteBuffer implements Runnable{

	private static final SecureRandom 
	generator = new SecureRandom();

	private final stringBuffer sharedLocation;	

	private List<String> vetor = new ArrayList<>();
	
	public stringWriteBuffer(stringBuffer sharedLocation, List<String> vetor) {
		this.sharedLocation = sharedLocation;
		this.vetor = vetor;
	}
	public void run() {
		String sum = ""; // soma o total de números lidos
		for (String string : vetor) { // colocando cada elemento da lista no buffer
			try {
				Thread.sleep(generator.nextInt(3000));
				sharedLocation.putBuffer(string);
				sum+=string + " ";
				System.out.printf("\t%2s\n",sum);
				}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();				
			}			
		}
		System.out.println("Escrita do buffer realizada!\n");
	}
}
