package multithreads.StringPackage;

public class stringUnsysnchronizedBuffer implements stringBuffer {
	private String buffer = "";
	
	public void putBuffer(String value) 
			throws InterruptedException{
		System.out.printf("Escrevendo valor: \t %s", value);
		buffer = value;
	}
	public String getBuffer() throws InterruptedException{
		System.out.printf("Leitura valor: \t\t %s", buffer);
		return buffer;
	}
}
