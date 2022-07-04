package multithreads.FloatPackage;

public class floatUnsysnchronizedBuffer implements floatBuffer {
	private float buffer = 0;
	
	public void putBuffer(float value) 
			throws InterruptedException{
		System.out.printf("Escrevendo valor: \t %.2f", value);
		buffer = value;
	}
	public float getBuffer() throws InterruptedException{
		System.out.printf("Leitura valor: \t\t %.2f", buffer);
		return buffer;
	}
}
