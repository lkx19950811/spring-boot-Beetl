package com.lee.beetl.config;

import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.DefaultNameConversion;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.beetl.sql.ext.spring4.BeetlSqlScannerConfigurer;
import org.beetl.sql.ext.spring4.SqlManagerFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author : lee Cather <br>
 * date : 2018-11-01 17:01 <br>
 * desc :  <br>
 */
@Configuration
public class BeetlConfig {
    @Bean(name = "sqlManagerFactoryBean")
    @Primary
    public SqlManagerFactoryBean getSqlManagerFactoryBean(@Qualifier("druidDataSource") DataSource dataSource,@Qualifier("environment") Environment env) {
        Boolean showSql = Boolean.valueOf(env.getProperty("spring.jpa.show-sql"));
        SqlManagerFactoryBean factory = new SqlManagerFactoryBean();
        BeetlSqlDataSource source = new BeetlSqlDataSource();
        source.setMasterSource(dataSource);
        factory.setCs(source);
        factory.setDbStyle(new MySqlStyle());
        if (showSql){
            factory.setInterceptors(new Interceptor[]{new DebugInterceptor()});
        }
        factory.setNc(new DefaultNameConversion());
        factory.setSqlLoader(new ClasspathLoader("/sql"));
        return factory;
    }
    /**
     *  开启事务
     */
    @Bean(name = "txManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(@Qualifier("druidDataSource") DataSource datasource) {
        DataSourceTransactionManager dsm = new DataSourceTransactionManager();
        dsm.setDataSource(datasource);
        return dsm;
    }

    /**
     * 配置包扫描
     */
    @Bean(name = "beetlSqlScannerConfigurer")
    public static BeetlSqlScannerConfigurer getBeetlSqlScannerConfigurer() {
        BeetlSqlScannerConfigurer conf = new BeetlSqlScannerConfigurer();
        conf.setBasePackage("com.lee.beetl.dao");
        //设置 包名后缀
        conf.setDaoSuffix("Repository");
        conf.setSqlManagerFactoryBeanName("sqlManagerFactoryBean");
        return conf;
    }
}
