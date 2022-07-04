package multithreads.IntPackage;

public class intUnsysnchronizedBuffer implements intBuffer {
	private int buffer = 0;
	
	public void putBuffer(int value) 
			throws InterruptedException{
		System.out.printf("Escrevendo valor: \t %d", value);
		buffer = value;
	}
	public int getBuffer() throws InterruptedException{
		System.out.printf("Leitura valor: \t\t %d", buffer);
		return buffer;
	}
}
