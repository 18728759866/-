package com.gl.dao;

public interface ProjectDAO {
    /**
     * 存入项目
     * @param projectID
     * @param projectType
     */
    void select(String userID,String projectID,String projectType,Integer votecount);

    /**
     * 删除项目
     * @param projectID
     */
    void delete(String projectID);

    /**
     * 判断用户是否可以创建项目
     * @param userID
     * @return
     */
    boolean creatproject(String userID);

    /**
     * 判断项目是否存在
     * @return
     */
    boolean ExistProject(String projectID);

    /**
     * 判断用户ID是否存在
     * @param userID
     * @return
     */
    boolean ExistUserID(String userID);

    /**
     * 根据用户ID查询项目名
     * @param userID
     * @return
     */
    String SelectprojectIDByuserID(String userID);

    /**
     * 返回项目得投票轮数
     * @param projectID
     * @return
     */
    Integer GetVoteCount(String userID,String projectID);

    /**
     * 把投票轮数减一
     * @param projectID
     */
    void UpdataVoteCount(String userID,String projectID);
}
