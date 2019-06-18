package com.project.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.catalina.SessionListener;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.session.DefaultWebSessionManager;

import com.project.shiro.MyRealm;


/**
 * shiro的配置类
 * @author Mac Book Pro
 *
 */
@Configuration
public class ShiroConfig {
	/**
	 * shiro的核心过滤器,放在类的最前面
	 * @return
	 */
	@Bean(name="shiroFilterFactoryBean")//@Qualifier("defaultWebSecurityManager")可以不要
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager securityManager){
		
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		//需要注入安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//认证失败需要跳转的地址
		shiroFilterFactoryBean.setLoginUrl("/evaluation/pages/login.html");
		//授权失败需要跳转的地址
		shiroFilterFactoryBean.setUnauthorizedUrl("/evaluation/pages/fail.html");
		
		//设置访问路径的权限
		Map<String,String> fmap = new LinkedHashMap<String,String>();
		fmap.put("/evaluation/pages/register.html", "anon");
		fmap.put("/evaluation/pages/login.html", "anon");
		
		fmap.put("/login", "anon");
		fmap.put("/user", "anon");
		//记住我
		fmap.put("/evaluation/pages/login.html", "user");
		//fmap.put("/evaluation/pages/register.html", "user");
		fmap.put("/goods", "user");
		fmap.put("/loginout", "logout");
		//fmap.put("/**", "anon");
		
		fmap.put("/evaluation/pages/index.html", "authc");
		fmap.put("/evaluation/pages/replyPost.html", "authc");
		fmap.put("/goods", "authc");
		//fmap.put("/**", "authc");
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(fmap);
		
		
		return shiroFilterFactoryBean;
	}
	/**
	 * 定义安全管理器
	 * @Qualifier("myRealm1")可能存在多个realm，通过注解来区分，如果只有一个可以省略注解
	 */
	@Bean(name="defaultWebSecurityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("myRealm1")MyRealm realm){
		
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(realm);
		return securityManager;
	}
	
	/**
	 * 使用md5来进行密码加密,自定义凭证匹配器
	 * @return
	 */
	@Bean("hashedCredentialsMatcher")
	public HashedCredentialsMatcher getHashedCredentialsMatcher(){
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		//加密算法
		hashedCredentialsMatcher.setHashAlgorithmName("MD5");
		//加密次数
		hashedCredentialsMatcher.setHashIterations(1024);
		//决定hex还是base64，可以不用设置
		hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
		return hashedCredentialsMatcher;
	}
	
	/**
	 * realm对象，对认证、权限进行校验
	 * @return
	 */
	@Bean(name="myRealm1")
	public MyRealm getMyRealm(@Qualifier("hashedCredentialsMatcher")HashedCredentialsMatcher hashedCredentialsMatcher){
		MyRealm realm = new MyRealm();
		//传入自定义凭证匹配器
		realm.setCredentialsMatcher(hashedCredentialsMatcher);
		return realm;
	}
	
	
	/*@Bean
    public EhCacheManager ehCacheManager(CacheManager cacheManager) {
        EhCacheManager em = new EhCacheManager();
        //将ehcacheManager转换成shiro包装后的ehcacheManager对象
        em.setCacheManager(cacheManager);
        //em.setCacheManagerConfigFile("classpath:ehcache.xml");
        return em;
    }*/
    /**
     * shiro session的管理
     */
    /*@Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(18000);
        //设置sessionDao对session查询，在查询在线用户service中用到了
        sessionManager.setSessionDAO(sessionDAO());
        //配置session的监听
        Collection<SessionListener> listeners = new ArrayList<SessionListener>();
        listeners.add(new BDSessionListener());
        sessionManager.setSessionListeners(listeners);
        //设置在cookie中的sessionId名称
        sessionManager.setSessionIdCookie(simpleCookie());
        return sessionManager;
    }*/

	
	
}
