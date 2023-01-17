package com.userservice.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    @TableId
    String userId;
    String saleId;
    String userName;
    String userUsername;
    String userPassword;
    String userAddress;
    String userSex;
    String userPhone;
}
