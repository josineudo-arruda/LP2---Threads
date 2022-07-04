package multithreads.StringPackage;

public interface stringBuffer {
	public void putBuffer(String value) 
			throws InterruptedException;
	public String getBuffer() throws InterruptedException;
}
