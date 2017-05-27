/*package  com.iebm.aid.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

*//**
 * 
 * Summary : 字符串管理器
 *
 *
 * @author Lineshow  Email:lineshow7@gmail.com
 *
 * @since 2013-4-26
 *//*
public class PinyinUtils {

	public static String getFirstPinYin(String str) {
		if (!StringUtils.isEmpty(str)) {
			try {
				String result = "";
				HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
				defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
				defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
				char[] charcell = str.toCharArray();
				Pattern pattern = Pattern.compile("[\u4E00-\u9FA5]");  
				for (int i = 0; i < charcell.length; i++) {
					char ccell = charcell[i];
					Matcher match = pattern.matcher(ccell+"");  
					if(match.matches()){
						String[] pinyinArr = PinyinHelper.toHanyuPinyinStringArray(
								ccell, defaultFormat);
						if(pinyinArr != null && pinyinArr.length > 0)
							result += pinyinArr[0].charAt(0);
					}else{
						result += ccell;
					}
				}
				return result;
			} catch (BadHanyuPinyinOutputFormatCombination e) {
				e.printStackTrace();
			}
		}
		return null;
	}	
}
*/