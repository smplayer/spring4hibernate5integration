package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Newbody on 2016/3/1.
 */
@Configuration
//启用注解事务管理，使用CGLib代理
@EnableTransactionManagement(proxyTargetClass = true)
@Import({DataSourceConfig.class})
public class DaoConfig {
    private static final Logger logger = LoggerFactory.getLogger(DaoConfig.class);

    @Value("${hibernate.hbm2ddl.auto}")
    String hibernate_hbm2ddl_auto;
    @Value("${hibernate.dialect}")
    String hibernate_dialect;
    @Value("${hibernate.show_sql}")
    String hibernate_show_sql;

    /**
     * 描述 : <负责解析资源文件>. <br>
     *<p>
     <这个类必须有，而且必须声明为static，否则不能正常解析>
     </p>
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placehodlerConfigurer() {
        logger.info("PropertySourcesPlaceholderConfigurer");
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Resource(name="dataSource")
    public DataSource dataSource;


    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean localSessionFactoryBean() {
        logger.info("building sessionFactory");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        String[] packagesToScan = new String[] { "com.sm.**.entity" };
        sessionFactory.setPackagesToScan(packagesToScan);

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
        hibernateProperties.setProperty("hibernate.dialect", hibernate_dialect);
        hibernateProperties.setProperty("hibernate.show_sql", hibernate_show_sql);

        //注意hibernate版本对应, 否则会出现SessionFactory注入异常
        hibernateProperties.setProperty(
                "hibernate.current_session_context_class",
                "org.springframework.orm.hibernate5.SpringSessionContext"
        );
        sessionFactory.setHibernateProperties(hibernateProperties);

        return sessionFactory;

    }

//    @Bean(name = "hibernateDAO")
//    public CP_Hibernate4DAOImpl hibernate4Dao() {
//        logger.info("hibernateDAO");
//        CP_Hibernate4DAOImpl dao = new CP_Hibernate4DAOImpl();
//        dao.setSessionFactory(localSessionFactoryBean().getObject());
//        return dao;
//    }

    @Bean(name = "transactionManager")
    public HibernateTransactionManager hibernateTransactionManager() {
        logger.info("building transactionManager");
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(localSessionFactoryBean().getObject());
        return hibernateTransactionManager;
    }
}