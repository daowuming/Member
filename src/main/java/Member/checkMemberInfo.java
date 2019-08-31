package Member;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class checkMemberInfo {
    public static String phoneREG = "^1[0-9]{10}$";
    public static String idNoREG = "^[0-9]{18}$";


    public static String check(Member member){
        try {
            Boolean nullCheck = checkObjFieldIsNull(member);
            if (nullCheck==false){
                return "输入参数不能有空值";
            }
            Boolean checkage = checkage(member.getAge());
            if (checkage==false){
                return "年龄不能小于十八岁";
            }
            Boolean checkphone = checkphone(member.getPhone());
            if (checkphone==false){
                return "手机号不正确";
            }
            Boolean checkidno = checkidNo(member.getIdNo());
            if (checkidno==false){
                return "身份证号不正确";
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "校验成功";
    }

    public static boolean checkage(Integer age){
        if (age<18) {
            return false;
        }else {
            return true;
        }
    }

    public static boolean checkObjFieldIsNull(Member member) throws IllegalAccessException {
        boolean flag = true;
        for(Field f : member.getClass().getDeclaredFields()){
            f.setAccessible(true);
            if(f.get(member) == null || f.get(member).equals("")){
                flag = false;
                return flag;
            }
        }
        return flag;
    }
    public static boolean checkphone(String phone){
        Boolean regReuslt =  regTest(phoneREG,phone);
        return regReuslt;
    }
    public static boolean checkidNo(String idNo){
        Boolean regReuslt =  regTest(idNoREG,idNo);
        return regReuslt;
    }




    private static Boolean regTest(String reg, String val) {
        Pattern r = Pattern.compile(reg);
        Matcher m = r.matcher(val);
        return m.matches();
    }
}
