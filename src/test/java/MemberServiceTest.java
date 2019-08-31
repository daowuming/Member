import Member.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import static Member.MemberService.*;
import static org.junit.Assert.assertEquals;

public class MemberServiceTest {
    Member memberList = new Member();
    @Test
    public void check_member_have_null() throws IllegalAccessException {
        Member member = new Member();
        member.setId("1");
        member.setName("1");
        member.setSex("1");
        member.setAge(15);
        member.setIdNo("1");
        member.setMemberType("1");
        member.setPhone("1");
        member.setZip("1");
        member.setAddress("");
        member.setSubmitTime(new Date());
        Boolean result = checkMemberInfo.checkObjFieldIsNull(member);
        assertEquals(false,result);

    }
    @Test
    public void check_member_age() throws IllegalAccessException {
        Member member = new Member();
        member.setAge(18);
        Boolean result = checkMemberInfo.checkage(member.getAge());
        assertEquals(true,result);
    }
    @Test
    public void check_member_phone(){
        String phone = "20000000000";
        Boolean result = checkMemberInfo.checkphone(phone);
        assertEquals(false,result);
    }
    @Test
    public void check_member_idNo(){
        String idNo = "410881199900000000";
        Boolean result = checkMemberInfo.checkidNo(idNo);
        assertEquals(true,result);
    }


    @Test
    public void should_find_member_when_give_idNo(){
        String idNo = "410881199900000000";
        Member member = findByCard(idNo);
        boolean result;
        if (member.getId().equals("0000")){
            result = false;
        }else {
            result = true;
        }
        assertEquals(true,result);
    }

    @Test
    public void should_register(){
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
        assertEquals("注册成功",result);
        assertEquals(false,result);
    }

    @Test
    public void can_get_id(){
        Member member = new Member();
        member.setName("1");
        member.setSex("1");
        member.setAge(15);
        member.setIdNo("1");
        member.setMemberType("6");
        member.setPhone("1");
        member.setZip("1");
        member.setAddress("");
        member.setPay(BigDecimal.valueOf(50));
        member.setSubmitTime(new Date());
        String id = getMenberId(member);
        assertEquals("60000006", id);
    }
    @Test
    public void should_payAnnualFee(){
        Member member = new Member();
        member.setId("1");
        member.setName("1");
        member.setSex("1");
        member.setAge(15);
        member.setIdNo("1");
        member.setMemberType("6");
        member.setPhone("1");
        member.setZip("1");
        member.setAddress("");
        member.setPay(BigDecimal.valueOf(50));
        member.setSubmitTime(new Date());
        Member member1 = payAnnualFee(member, BigDecimal.valueOf(450));
        assertEquals(500,  Long.parseLong(member1.getPay().toString()));
        assertEquals(true, member1.getPaySuccess());
    }
}
