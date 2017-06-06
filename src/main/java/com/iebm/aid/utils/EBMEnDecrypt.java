package com.iebm.aid.utils;

import java.io.UnsupportedEncodingException;

public class EBMEnDecrypt {

	public static String encrypt(String bin)
	  {
	    return encrypt(bin, getNormalCharset());
	  }

	  public static String encrypt(String bin, String charsetName)
	  {
	    if (bin == null) {
	      return null;
	    }
	    char[] digital = getKey().toCharArray();
	    StringBuffer sb = new StringBuffer("");
	    byte[] bs = null;
	    try {
	      bs = bin.getBytes(charsetName);
	    }
	    catch (UnsupportedEncodingException e) {
	      e.printStackTrace();
	    }

	    for (int i = 0; i < bs.length; i++) {
	      int bit = (bs[i] & 0xF0) >> 4;
	      sb.append(digital[bit]);
	      bit = bs[i] & 0xF;
	      sb.append(digital[bit]);
	    }
	    if (getNormalCharset().equals(charsetName)) {
	      sb.delete(0, 4);
	    }

	    return sb.toString();
	  }

	  public static String decrypt(String hex)
	  {
	    return decrypt(hex, getNormalCharset());
	  }

	  public static String decrypt(String hex, String charsetName)
	  {
	    if (hex == null) {
	      return null;
	    }
	    if ("".equals(hex.trim())) {
	      return "";
	    }
	    String digital = getKey();
	    char[] hex2char = hex.toCharArray();
	    byte[] bytes = new byte[hex.length() / 2];

	    for (int i = 0; i < bytes.length; i++) {
	      long temp = digital.indexOf(hex2char[(2 * i)]) * 16;
	      temp += digital.indexOf(hex2char[(2 * i + 1)]);
	      bytes[i] = (byte)(int)(temp & 0xFF);
	    }
	    try
	    {
	      return new String(bytes, charsetName);
	    }
	    catch (UnsupportedEncodingException e) {
	      e.printStackTrace();
	    }return null;
	  }

	  private static String getKey()
	  {
	    return "0123456789ABCDEF";
	  }

	  public static final String getGBKCharset()
	  {
	    return "GBK";
	  }

	  private static final String getNormalCharset()
	  {
	    return "unicode";
	  }
}
