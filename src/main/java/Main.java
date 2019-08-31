import Member.Member;

import java.math.BigDecimal;
import java.util.Date;

import static Member.MemberService.*;

public class Main {
    public static void main(String[] args){
        Member member = new Member();
        member.setName("1");
        member.setSex("1");
        member.setAge(19);
        member.setIdNo("410881199900000000");
        member.setMemberType("6");
        member.setPhone("13200000000");
        member.setZip("1");
        member.setAddress("11111");
        member.setSubmitTime(new Date());
        String result = register(member);
        System.out.println(result);

        String idNo = "410881199900000000";
        Member member1 = findByCard(idNo);
        boolean result1;
        if (member1.getId().equals("0000")){
            result1 = false;
        }else {
            result1 = true;
        }
        System.out.println(member1.getId());

        payAnnualFee(member, BigDecimal.valueOf(500));

        Member member3 = findByCard(idNo);
        System.out.println(member1.getPaySuccess());
        System.out.println(member1.getPay());

        Member member4 = new Member();
        member4.setName("1");
        member4.setSex("1");
        member4.setAge(19);
        member4.setIdNo("410881199900000000");
        member4.setMemberType("6");
        member4.setPhone("13200000000");
        member4.setZip("1");
        member4.setAddress("11111");
        member4.setSubmitTime(new Date());
        String result4 = register(member4);
        System.out.println(result4);


    }
}

