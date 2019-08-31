package Member;

import java.math.BigDecimal;
import java.util.Date;

public class Member {
    private String id;
    private String name;
    private String sex;
    private Integer age;
    private String idNo;
    private String memberType;
    private String phone;
    private String zip;
    private String address;
    private Date  submitTime;
    private boolean paySuccess;
    private BigDecimal pay = BigDecimal.valueOf(0);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public boolean getPaySuccess() {
        return paySuccess;
    }

    public void setPaySuccess(boolean paySuccess) {
        this.paySuccess = paySuccess;
    }
}
