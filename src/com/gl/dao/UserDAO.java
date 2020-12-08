package com.gl.dao;

public interface UserDAO {
    /**
     * 判断是否用户ID是否存在
     *
     * @return
     */
     boolean ExistUserID(String UserID) ;


    /**
     * 执行插入操作
     * @param userID
     * @param password
     * @param email
     */
    void Select(String userID,String password,String email);

    /**
     * 删除操作
     */
    void Delete();


    /**
     * 根据邮箱重置密码
     * @param email
     * @param password
     */
    boolean UpdataByEmail(String email,String password);


    /**
     * 判断数据库中是否存在该用户
     * @param userID
     * @param password
     */
    boolean ExistUser(String userID,String password);


    /**
     * 根据用户ID查密码
     * @param userID
     * @return 返回用户密码，不存在返回null
     */
   String SelectPasswordByuserID(String userID);
}
