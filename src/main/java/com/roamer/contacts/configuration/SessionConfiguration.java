package com.roamer.contacts.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Session 配置
 *
 * @author roamer
 * @version V1.0
 * @date 2018/5/19 22:35
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 10)
public class SessionConfiguration {
}
