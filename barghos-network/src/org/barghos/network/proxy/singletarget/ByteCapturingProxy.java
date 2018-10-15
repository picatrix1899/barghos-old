package org.barghos.network.proxy.singletarget;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class ByteCapturingProxy
{
	private String proxyIp;
	private int proxyPort;
	private String ip;
	private int port;
	private String expectedIp;
	
	private ServerSocket serverSocket;
	
	private Socket inSocket;
	private Socket outSocket;
	
	private ExecutorService threadPool;
	
	public ByteCapturingProxy(String proxyIp, int proxyPort, String ip, int port, String expectedIp)
	{

	}
	
	public ByteCapturingProxy(String proxyIp, int proxyPort, String ip, int port, String expectedIp, ExecutorService threadPool)
	{
		this.proxyIp = proxyIp;
		this.proxyPort = proxyPort;
		this.ip = ip;
		this.port = port;
		this.expectedIp = expectedIp;
		this.threadPool = threadPool;
	}
	
	public void start() throws Exception
	{
		this.serverSocket = new ServerSocket(this.proxyPort, 1, InetAddress.getByName(this.proxyIp));
		this.outSocket = new Socket();
	}
	
	public void run() throws Exception
	{
		
	}
	
	
	public class BulkByteCapturingService
	{
		
	}
	
}
