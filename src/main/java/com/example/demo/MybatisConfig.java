package com.example.demo;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

public class MybatisConfig implements EnvironmentAware {
    private final Logger log = Logger.getLogger(MybatisConfig.class);

    @Autowired
    private Environment env;

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }

    /**
     * 创建数据源
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     */
    @Bean
    @Primary

    public DataSource getDataSource() throws Exception{
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("spring.datasource.driver-class-name"));
        props.put("url", env.getProperty("spring.datasource.url"));
        props.put("username", env.getProperty("spring.datasource.username"));
        props.put("password", env.getProperty("spring.datasource.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception{
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);//指定数据源(这个必须有，否则报错)
        //下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        //实体类包
        fb.setTypeAliasesPackage("com.example.bean");//指定基包
        //表示我们的Mapper文件存放的位置，当我们的Mapper文件跟对应的Mapper接口处于同一位置的时候可以不用指定该属性的值。
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("classpath*:mybatis.mapper")));//指定xml文件位置
        return fb.getObject();
    }
}
