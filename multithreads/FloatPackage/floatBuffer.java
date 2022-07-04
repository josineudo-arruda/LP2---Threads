package multithreads.FloatPackage;

public interface floatBuffer {
	public void putBuffer(float value) 
			throws InterruptedException;
	public float getBuffer() throws InterruptedException;
}
