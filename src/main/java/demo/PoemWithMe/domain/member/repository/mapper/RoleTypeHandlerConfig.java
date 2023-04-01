package demo.PoemWithMe.domain.member.repository.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class RoleTypeHandlerConfig {
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setTypeHandlers(roleTypeHandler());
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    private static RoleTypeHandler roleTypeHandler() {
        return new RoleTypeHandler();
    }

}