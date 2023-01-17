package com.managerservice.dao;



import com.managerservice.domain.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


//TODO 添加@Mapper
@Mapper
public interface ManagerDao {

//    void save1();

//    @Select("select count(*) from manager where mana_username = #{username} and mana_password = #{password}")
//    int selectUserByUsernameAndUserPwd(@Param("username") String username, @Param("password") String password);


    @Select("select * from manager where mana_username = #{username} and mana_password = #{password}")
    Manager selectUserByUsernameAndUserPwd(@Param("username") String username, @Param("password") String password);
//
//    @Select("select count(*) from salesman")
//    int querySalesman();
//
//    @Select("select * from salesman limit #{startPage},10")
//    List<Salesman> querySalesmanByPage(@Param("startPage") int startPage);
//
//    @Update("update salesman set sale_username=#{su},sale_password=#{sp},sale_phone=#{spo},sale_sex=#{ss} where sale_id=#{si}")
//    int updateSalesman(@Param("su") String su,@Param("sp") String sp,@Param("spo") String spo,@Param("ss") String ss,@Param("si") String si);
}
