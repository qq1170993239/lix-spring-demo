package cn.lix.spring.demo.entity;

import java.io.Serializable;

/**
 * (test_user)实体类
 *
 * @author lix
 * @since 2020-07-18 10:03:55
 */
public class TestUser implements Serializable {
    private static final long serialVersionUID = 984293892030750380L;

    private Integer id;

    private String userName;

    private String userGender;

    private String userPhone;

    private String userAddr;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

}