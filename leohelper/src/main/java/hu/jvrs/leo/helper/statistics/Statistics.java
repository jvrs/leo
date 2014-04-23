package hu.jvrs.leo.helper.statistics;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Statistics {
	private static final Logger LOG = LoggerFactory.getLogger(Statistics.class.getSimpleName());
	private static long startTime;

	public static void startTimer() {
		startTime = System.nanoTime();
	}
	
	public static double getDuration() {
		double durationInSeconds = (double) (System.nanoTime() - startTime)	/ (1000.0 * 1000.0 * 1000.0);
		LOG.info("Run duration: " + durationInSeconds + " secs!");
		return durationInSeconds;
	}

	public static String getProcessId() {
		String processId = ManagementFactory.getRuntimeMXBean().getName();
		LOG.info("Process id @ host: " + processId);
		return processId;
	}
	
	public static UUID getRandomUniqueId() {
		UUID idOne = UUID.randomUUID();
		LOG.info("Generated unique id: " + idOne);
		return idOne;
	}
	
	public static Integer getProcessorCores() {
		/* Total number of processors or cores available to the JVM */
		Integer processorCores = Runtime.getRuntime().availableProcessors();
		LOG.info("Available processors (cores): " + processorCores);
		return processorCores;
	}
	
	public static Long getFreeMemory() {
		/* Total amount of free memory available to the JVM */
		Long freeMemory = Runtime.getRuntime().freeMemory()	/ (1024 * 1024);
		LOG.info("Free memory (MB): " + freeMemory);
		return freeMemory;
	}
	
	public static Long getMaxMemory() {
		/* This will return Long.MAX_VALUE if there is no preset limit */
		Long maxMemory = Runtime.getRuntime().maxMemory() / (1024 * 1024);
		/* Maximum amount of memory the JVM will attempt to use */
		LOG.info("Maximum memory (MB): " + (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));
		return maxMemory;
	}
	
	public static Long getTotalMemory() {
		/* Total memory currently available to the JVM */
		Long totalMemory = Runtime.getRuntime().totalMemory() / (1024 * 1024);
		LOG.info("Total memory available to JVM (MB): "	+ totalMemory);
		return totalMemory;
	}
	
	public static Integer getFileSystemsNo() {
		/* Get a list of all filesystem roots on this system */
		File[] roots = File.listRoots();
		/* For each filesystem root, print some info */
		for (File root : roots) {
			LOG.info("File system root: " + root.getAbsolutePath());
			LOG.info("   Total space (GB): " + root.getTotalSpace()
					/ (1024 * 1024 * 1024));
			LOG.info("   Free space (GB): " + root.getFreeSpace()
					/ (1024 * 1024 * 1024));
			LOG.info("   Usable space (GB): " + root.getUsableSpace()
					/ (1024 * 1024 * 1024));
		}		
		return roots.length;
	}
	
	public static InetAddress getIp(){
		InetAddress ip = null;
		try {
			ip = InetAddress.getLocalHost();
			LOG.info("Current IP address : " + ip.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}		
		return ip;
	}
	
	public static String getMac(InetAddress ip) {
		/* MAC address */
		StringBuilder sb = new StringBuilder();
		try {			
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			byte[] mac = network.getHardwareAddress();			
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i],
						(i < mac.length - 1) ? "-" : ""));
			}
			LOG.info("Current MAC address : " + sb.toString());
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
