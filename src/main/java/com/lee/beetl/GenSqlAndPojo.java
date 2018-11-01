package com.lee.beetl;

import org.beetl.sql.core.*;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;

/**
 * author : lee Cather <br>
 * date : 2018-11-01 15:44 <br>
 * desc : 自动生成pojo类 <br>
 */
public class GenSqlAndPojo {
    public static void main(String[] args) throws Exception {
        ConnectionSource source = ConnectionSourceHelper.getSimple("com.mysql.cj.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/beetl",
                "root", "!Qaz2wsx");
        DBStyle mysql = new MySqlStyle();
        SQLLoader loader = new ClasspathLoader("/sql");
        DefaultNameConversion nc = new DefaultNameConversion();
        SQLManager sqlManager = new SQLManager(mysql,loader,source,nc,new
                Interceptor[]{new DebugInterceptor()});
        sqlManager.genPojoCodeToConsole("user");
        sqlManager.genSQLTemplateToConsole("user");
    }
}
