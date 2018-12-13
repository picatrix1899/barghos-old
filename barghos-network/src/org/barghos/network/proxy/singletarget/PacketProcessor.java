package org.barghos.network.proxy.singletarget;

import java.util.ArrayDeque;
import java.util.Deque;

public class PacketProcessor extends Thread
{
	public Deque<byte[]> queue = new ArrayDeque<byte[]>();
}
