package com.allin.knowledge.util;


import java.util.Map;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

public class StringTool {

    public static String replace(String mobiles, String srcString,
                                 String replaceString) {

        return mobiles.replace(srcString, replaceString);
    }

    public static boolean isMobile(String mobiles) {

        Pattern p = Pattern.compile("^((1))\\d{10}$");

        Matcher m = p.matcher(mobiles);

        System.out.println(m.matches() + "---");

        return m.matches();
    }

    public static boolean isEmail(String email) {

        Pattern pattern = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");

		/*
         * Pattern pattern = Pattern
		 * .compile("\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*");
		 */

        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    public static String getMapString(Map paramMap, String mapStr) {

        String returnString = (paramMap != null && paramMap.get(mapStr) != null) ? paramMap.get(
                mapStr).toString() : "";

        return returnString;
    }

    /**
     * 获取分割后的字符串
     *
     * @param arrString
     * @param split
     * @param index     0 或1
     * @return
     */
    public static String arrValue(String arrString, String split, int index) {
        String v = arrString;
        int i = arrString.indexOf(split);
        if (i > -1) {
            int len = arrString.length();
            if (index == 0) {
                v = arrString.substring(0, i);
            } else if (index == 1) {
                v = arrString.substring(i + 1, len);
            }
        }
        return v;
    }

    public static Long convertObjectToLong(Object obj) {
        return Long.valueOf(String.valueOf(obj));
    }

    public static String convertObjectToString(Object obj) {
        return String.valueOf(obj);
    }

    public static boolean isLongEmpty(Long l) {

        if (null != null && l > 0l) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isStringEmpty(String str) {

        return StringUtils.isEmpty(str);
    }

    public static StringBuffer splitTail(StringBuffer str) {

        int length = str.length();
        System.out.println("length=" + length);
        System.out.println("ad=" + str.lastIndexOf(","));

        if (length > 0 && str.lastIndexOf(",") + 1 == length) {
            return str.delete(length - 1, length);
        } else {
            return str;
        }

    }

    public static void main(String[] args) {

        StringBuffer str = new StringBuffer("");
        str.append("1313,213,1312");

        System.out.println(StringTool.splitTail(str));

        System.out.println("email" + StringTool.isEmail("zybyjy@sohu.com"));
        System.out.println(StringTool.isMobile("1333011111111"));

		/*
		 * String ss = "','"; // "<p>ad,'{[</p>"
		 * System.out.println("escapeHtml=" + StringTool.escapeJavaScript(ss));
		 * System.out .println("unescapeHtml=" +
		 * StringTool.unescapeJavaScript(StringTool .escapeJavaScript(ss)));
		 */

		/*
		 * System.out.println(generateString(15));
		 * System.out.println(generateMixString(15));
		 * System.out.println(generateLowerString(15));
		 * System.out.println(generateUpperString(15));
		 * System.out.println(generateZeroString(15));
		 * System.out.println(toFixdLengthString(123, 15));
		 * System.out.println(toFixdLengthString(123L, 15));
		 */

        // System.out.println(generateStringMixUpperAndNumber(12));

        // System.out.println("aaa="+StringUtil.toUnicode("测试订单"));
        // System.out.println(StringTool.toUnicode("测试订单") + "=="
        // + StringTool.ascii2Native(StringTool.toUnicode("测试订单")));

    }

    public static String toUnicode(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) <= 256) {
                sb.append("\\u00");
            } else {
                sb.append("\\u");
            }
            sb.append(Integer.toHexString(s.charAt(i)));
        }
        return sb.toString();
    }

    // unicode转为本地
    public static String ascii2Native(String str) {
        StringBuilder sb = new StringBuilder();
        int begin = 0;
        int index = str.indexOf("\\u");
        while (index != -1) {
            sb.append(str.substring(begin, index));
            sb.append(ascii2Char(str.substring(index, index + 6)));
            begin = index + 6;
            index = str.indexOf("\\u", begin);
        }
        sb.append(str.substring(begin));
        return sb.toString();
    }

    private static char ascii2Char(String str) {
        if (str.length() != 6) {
            throw new IllegalArgumentException(
                    "Ascii string of a native character must be 6 character.");
        }
        if (!"\\u".equals(str.substring(0, 2))) {
            throw new IllegalArgumentException(
                    "Ascii string of a native character must start with \"\\u\".");
        }
        String tmp = str.substring(2, 4);
        int code = Integer.parseInt(tmp, 16) << 8;
        tmp = str.substring(4, 6);
        code += Integer.parseInt(tmp, 16);
        return (char) code;
    }

    public static String escapeJavaScript(String htmlString) {

        String aa = StringEscapeUtils.escapeJavaScript(htmlString);
        return aa;
    }

    public static String unescapeJavaScript(String htmlString) {

        String aa = StringEscapeUtils.unescapeJavaScript(htmlString);
        return aa;
    }

    /**
     * object 转换成字符串
     */
    public static String objectToString(Object obj) {
        String str = "";
        if (obj != null) {
            str = String.valueOf(obj);
        }
        return str;
    }

    /**
     * 字符串去重方法
     */
    public static String removeDuplicate(String s) {
        if (!isStringEmpty(s)) {
            String[] stringArr = s.split(",");
            TreeSet<String> tr = new TreeSet<String>();
            for (int i = 0; i < stringArr.length; i++) {
                System.out.print(stringArr[i] + " ");
                tr.add(stringArr[i]);
            }
            StringBuffer buf = new StringBuffer();
            for (String str : tr) {
                buf.append(str);
                buf.append(",");
            }
            buf = StringTool.splitTail(buf);
            return buf.toString();
        } else {
            return "";
        }
    }

    /**
     * 批量替换新闻体内的URL
     */

    public static String repalcePattern(String inputStr) {
//		inputStr = StringTool.htmlEncode(inputStr);
//		System.out.println("======wybregex===inputStr=="+inputStr);
//		String   regex= "(http://|https://)((\\w)+\\.)(allinmd)\\.(com|net|cn)";
//		Pattern pat = Pattern.compile(regex);  
//		   Matcher matcher = pat.matcher(inputStr); 
//		   StringBuffer  strBuffer =  new StringBuffer(); 
//		   if(matcher.find()){
//			   while (matcher.find()) { 
//				  try{
//			     String temp = inputStr.substring(matcher.start(),matcher.end());
//			     System.out.println("======wybregex===temp=="+temp);
//			     String newChar = temp.substring(temp.indexOf("//"),temp.length());
//			     System.out.println("======wybregex===newChar=="+newChar);
//			     matcher.appendReplacement(strBuffer, newChar);
//				   }catch (Exception ex){
//					   ex.printStackTrace();
//				   }
//			   }     
//		   }else{
//			   strBuffer.append(inputStr);
//		   }
//		   String tempHtml = encodeHtml(strBuffer.toString());
//		   System.out.println("======wybregex===tempHtml=="+tempHtml);
        inputStr = replaceAllUrl(inputStr);
        return inputStr;
    }

    public static String htmlEncode(String source) {
        if (source == null) {
            return "";
        }
        String html = "";
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            switch (c) {
                case '<':
                    buffer.append("&lt;");
                    break;
                case '>':
                    buffer.append("&gt;");
                    break;
//            case '&':
//                buffer.append("&amp;");
//                break;
                case '"':
                    buffer.append("&quot;");
                    break;
                case 10:
                case 13:
                    break;
                default:
                    buffer.append(c);
            }
        }
        html = buffer.toString();
        return html;
    }

    public static String encodeHtml(String source) {
        if (source == null) {
            return "";
        }
        String html = "";
        StringBuffer buffer = new StringBuffer(source);
        source = source.replaceAll("&lt;", "<");
        source = source.replaceAll("&gt;", ">");
        // source = source.replaceAll("&amp;", "&");
        // source = source.replaceAll("&quot;", "\"");
        return source;
    }

    public static String replaceAllUrl(String source) {
        source = source.replaceAll("http://www.allinmd.cn", "//www.allinmd.cn");
        source = source.replaceAll("http://img00.allinmd.cn", "//img00.allinmd.cn");
        source = source.replaceAll("http://img01.allinmd.cn", "//img01.allinmd.cn");
        source = source.replaceAll("http://img02.allinmd.cn", "//img02.allinmd.cn");
        source = source.replaceAll("http://img03.allinmd.cn", "//img03.allinmd.cn");
        source = source.replaceAll("http://img04.allinmd.cn", "//img04.allinmd.cn");
        source = source.replaceAll("http://img05.allinmd.cn", "//img05.allinmd.cn");
        source = source.replaceAll("http://img98.allinmd.cn", "//img98.allinmd.cn");
        source = source.replaceAll("http://img99.allinmd.cn", "//img99.allinmd.cn");
        source = source.replaceAll("http://m.allinmd.cn", "//m.allinmd.cn");
        source = source.replaceAll("http://v.allinmd.cn", "//v.allinmd.cn");
        source = source.replaceAll("http://d.allinmd.cn", "//d.allinmd.cn");
        source = source.replaceAll("http://js.allinmd.cn", "//js.allinmd.cn");
        source = source.replaceAll("http://css.allinmd.cn", "//css.allinmd.cn");
        source = source.replaceAll("http://c.allinmd.cn", "//c.allinmd.cn");
        source = source.replaceAll("http://video.allinmd.cn", "//video.allinmd.cn");
        source = source.replaceAll("http://doc.allinmd.cn", "//doc.allinmd.cn");
        return source;
    }

}
