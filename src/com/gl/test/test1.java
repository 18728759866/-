package com.gl.test;

import com.gl.dao.impl.JudgeDaoImpl;
import com.gl.dao.impl.ProjectDaoImpl;
import com.gl.dao.impl.RespondentDaoImpl;
import com.gl.dao.impl.UserDaoImpl;
import com.gl.pojo.Respondent;
import com.gl.utils.JDBCUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.Iterator;
import java.util.List;


public class test1  {
    public static void main(String[] args) {
//        System.out.println(new ProjectDaoImpl().ExistUserID("201902185"));
//        System.out.println(new ProjectDaoImpl().ExistProject("23"));
        new JudgeDaoImpl().UpdataAllVote("1234");
    }


}
