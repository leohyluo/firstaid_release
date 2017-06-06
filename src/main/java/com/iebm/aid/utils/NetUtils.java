package com.iebm.aid.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetUtils {

	private static Logger logger = LoggerFactory.getLogger(NetUtils.class);
	
	/**
	 * 获取本机所有ip地址(内外网或多网卡)
	 * @return
	 * @throws Exception
	 */
	public static List<InetAddress> getLocalInetAddress() throws Exception {
		String localip = null;// 本地IP，如果没有配置外网IP则返回它
		String netip = null;// 外网IP
		Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
		InetAddress ip = null;
		boolean finded = false;// 是否找到外网IP

		List<InetAddress> addressList = new ArrayList<>();
		while (netInterfaces.hasMoreElements() && !finded) {
			NetworkInterface ni = netInterfaces.nextElement();
			Enumeration<InetAddress> address = ni.getInetAddresses();
			while (address.hasMoreElements()) {
				ip = address.nextElement();
				if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
					netip = ip.getHostAddress();
					logger.info("外网ip = " + netip);
					finded = true;
					addressList.add(ip);
					break;
				} else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
						&& ip.getHostAddress().indexOf(":") == -1) {// 内网IP
					localip = ip.getHostAddress();
					addressList.add(ip);
					System.out.println("内网ip = " + localip);
				}
			}
		}
		return addressList;
	}
	
	/**
	 * 获取本机所有网卡mac地址
	 * @return
	 * @throws SocketException 
	 */
	public static List<String> getLocalMac() throws Exception {
		List<InetAddress> addressList = getLocalInetAddress();
		List<String> macList = new ArrayList<>();
		for(InetAddress address : addressList) {
	    	String mac = getLocalMac(address);
	    	macList.add(mac);
	    }
		return macList;
	}
	
	private static String getLocalMac(InetAddress ia) throws SocketException {
		// TODO Auto-generated method stub
		String result = "";//主机名+/+mac地址
		//获取网卡，获取地址
		byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
		System.out.println("mac数组长度："+mac.length);
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<mac.length; i++) {
			if(i!=0) {
				sb.append("-");
			}
			//字节转换为整数
			int temp = mac[i]&0xff;
			String str = Integer.toHexString(temp);
			System.out.println("每8位:"+str);
			if(str.length()==1) {
				sb.append("0"+str);
			}else {
				sb.append(str);
			}
		}
		String hostName = ia.getHostName();
		String macAddr = sb.toString().toUpperCase();
		logger.info("本机主机名:"+hostName);
		logger.info("本机MAC地址:"+macAddr);
		result = hostName + "/" + macAddr;
		return result;
	}
}
