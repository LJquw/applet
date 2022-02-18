package www.xiyou.utils;

public class StringUtils {


    public static final String APPID="wx40f6ae61904081f4";
    public static final String SECRET="a10c9a575053be7527c722371e5a4a16";

    /**
     * 字符串的非空校验
     * @param str
     * @return
     */
    public static boolean isNull(String str){
        if(str==null){
            return true;
        }
        str = str.trim(); //去除空格
        if("".equals(str)){
            return true;
        }
        return false;
    }
}
