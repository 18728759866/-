package com.gl.dao;

import java.util.List;

public interface RespondentDAO {
    /**
     * 增加被投票的目标
     * @param ID
     * @param introduce
     */
    void select(String ID,String introduce,String projectID);

    /**
     * 返回被投票目标的名字的集合
     * @return
     */
    List ReturnName();

    /**
     * 返回被投票目标票数的集合
     * @return
     */
    List ReturnVote();

    /**
     * 返回被投票目标答辩内容的集合
     * @return
     */
    List ReturnIntroduce();

    /**
     * 更新被投票目标的票数
     * @param username
     */
    void UpdateVote(String username);

    /**
     * 根据被投票者的名字查询票数
     * @param username
     * @return
     */
    Integer GetVoteByUsername(String username);

    /**
     * 返回被投票目标对象
     * @return
     */
    List GetRespondent(String projectID);

    /**
     * 根据票数查用户名
     * @return
     */
    String GetUsernameByscore(int score,String projectID);
}
