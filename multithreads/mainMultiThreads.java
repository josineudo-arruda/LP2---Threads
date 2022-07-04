package multithreads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import multithreads.IntPackage.*;
import multithreads.FloatPackage.*;
import multithreads.StringPackage.*;

public class mainMultiThreads {

	public static void main(String[] args) 
			throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService  threadRun = Executors.newCachedThreadPool();

		intBuffer intSharedLocation = new intUnsysnchronizedBuffer();

		List<Integer> intVetor = new ArrayList<>();
		intVetor.addAll(Arrays.asList(10,20,30,40,50));
		
		System.out.printf("Thread running\t\tValue\t "+ "Sum write\tSum read\n");
		System.out.println("-------------------------------------------------------------------");
		threadRun.execute(new intWriteBuffer(intSharedLocation, intVetor));
		threadRun.execute(new intReadBuffer(intSharedLocation, intVetor.size()));

		threadRun.awaitTermination(intVetor.size()*3, TimeUnit.SECONDS); // tempo para começar a próxima thread

		//============String=============================================================================

		stringBuffer stringSharedLocation = new stringUnsysnchronizedBuffer();

		List<String> stringVetor = new ArrayList<>();
		stringVetor.addAll(Arrays.asList("Tempestade de","Caralho","Gabriel vira","Para-Raio"));
		
		System.out.printf("Thread running\t\tValue\t "+ "Sum write\tSum read\n");
		System.out.println("-------------------------------------------------------------------");
		threadRun.execute(new stringWriteBuffer(stringSharedLocation, stringVetor));
		threadRun.execute(new stringReadBuffer(stringSharedLocation, stringVetor.size()));

		threadRun.awaitTermination(stringVetor.size()*3, TimeUnit.SECONDS);

		//===========Float===============================================================================

		floatBuffer floatSharedLocation = new floatUnsysnchronizedBuffer();

		List<Float> floatVetor = new ArrayList<>();
		floatVetor.addAll(Arrays.asList(2.3f,4.4f,5.3f,3.4f,6.0f));
		
		System.out.printf("Thread running\t\tValue\t "+ "Sum write\tSum read\n");
		System.out.println("-------------------------------------------------------------------");
		threadRun.execute(new floatWriteBuffer(floatSharedLocation, floatVetor));
		threadRun.execute(new floatReadBuffer(floatSharedLocation, floatVetor.size()));
		threadRun.shutdown();
		threadRun.awaitTermination(floatVetor.size()*1, TimeUnit.SECONDS);
	}
}
