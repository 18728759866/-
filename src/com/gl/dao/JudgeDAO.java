package com.gl.dao;

public interface JudgeDAO {
    /**
     * 创建评委
     * @param projectID
     * @param judgeID
     * @param password
     */
    void select(String projectID,String judgeID,String password);

    /**
     * 判断是否可以创建裁判
     * @param projectID
     * @return 返回true,则可以创建，反之亦然
     */
    boolean ExistProject(String projectID);

    /**
     * 判断该评委ID是否存在
     * @param JudgeID
     * @return
     */
    boolean ExistJudge(String JudgeID);

    /**
     * 根据评委ID查询密码
     * @param JudgeID
     */
    String selectpasswordByJudgeID(String JudgeID);

    /**
     * 根据评委ID查询项目ID
     * @param JudgeID
     */
    String selectprojectIDByJudgeID(String JudgeID);

    /**
     * 判断评委是否能够投票
     * @return
     */
    boolean CanVote(String judgename);

    /**
     * 评委投完票后，让他不能投票
     * @param judgename
     */
    void UpdataVote(String judgename);

    /**
     * 项目结束，删除所有项目对应的评委
     */
    void DelectAll(String projectID);

    /**
     * 进入新一轮投票，让评委可以投票
     * @param judgeID
     */
    void UpdataAllVote(String judgeID);
}
