package multithreads.IntPackage;

public interface intBuffer {
	public void putBuffer(int value) 
			throws InterruptedException;
	public int getBuffer() throws InterruptedException;
}
