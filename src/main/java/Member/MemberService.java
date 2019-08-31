package Member;

import java.math.BigDecimal;
import java.util.*;

public class MemberService {
    public static List<Member> memberList = new ArrayList<>();
    private static Map memberTypeMap = new HashMap<String, BigDecimal>() {
        {
            put("1", BigDecimal.valueOf(0));
            put("2", BigDecimal.valueOf(100));
            put("6", BigDecimal.valueOf(500));
            put("9", BigDecimal.valueOf(2000));
        }
    };
    private static Map memberMaxMap = new HashMap<String, Integer>() {
        {
            put("1", 0);
            put("2", 0);
            put("6", 0);
            put("9", 0);
        }
    };

    public static String register(Member member) {
        String resultid = getMenberId(member);
        if (resultid.equals("该会员类型注册人数已达上限")){
            return resultid;
        }else {
            member.setId(resultid);
        }
        String check = checkMemberInfo.check(member);
        if(check.equals("校验成功")){
            memberList.add(member);
            return "注册成功";
        }else {
            System.out.println(check);
            return check;
        }
    }

    public static Member findByCard(String idNo) {
        System.out.println(idNo);
        System.out.println(memberList.size());
        for (Member member : memberList) {
            if (member.getIdNo().equals(idNo)) {
                return member;
            }
        }
        Member member1 = new Member();
        member1.setId("0000");
        return member1;
    }

    public static Member payAnnualFee(Member member, BigDecimal money) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        date = calendar.getTime();
        boolean after = member.getSubmitTime().after(date);
        if (after == false){
            member.setPaySuccess(false);
            return member;
        }
        memberList.remove(member);
        member.setPay(member.getPay().add(money));
        if (member.getPay().compareTo((BigDecimal) memberTypeMap.get(member.getMemberType())) == -1) {
            member.setPaySuccess(false);
        }else {
            member.setPaySuccess(true);
        }
        memberList.add(member);
        return member;
    }

    public static String getMenberId(Member member) {
        String id = "";
        id += member.getMemberType();
        Integer count = (Integer) memberMaxMap.get(member.getMemberType());
        count++;
        if(String.valueOf(count).length()==8){
            return "该会员类型注册人数已达上限";
        }
        String strcount = count.toString();
        String lastNo = strcount.substring(strcount.length() - 1);
        if (lastNo.equals("4") || lastNo.equals("7")) {
            count++;
        }
        String newString = "";
        System.out.println(strcount);
        if (member.getMemberType().equals("6") || member.getMemberType().equals("9")) {
            if (strcount.indexOf("6") == -1 && strcount.indexOf("8") == -1 && strcount.indexOf("9") == -1) {
                if (Integer.parseInt(lastNo) <= 6) {
                    count = Integer.parseInt(strcount.substring(0, strcount.length() - 1) + "6");
                } else if (Integer.parseInt(lastNo) == 7) {
                    count = Integer.parseInt(strcount.substring(0, strcount.length() - 1) + "8");
                }
            }
        }
        newString = String.format("%0" + 7 + "d", count);
        newString.replace("44", "45");
        newString.replace("77", "78");
        id += newString;
        System.out.println(id);
        memberMaxMap.put(member.getMemberType(), count);
        return id;
    }
}
