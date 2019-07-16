package com.csn.comment.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * Description:
 *
 * @author csn
 */
public class ConfigUtil {
    private static Logger logger= LoggerFactory.getLogger(ConfigUtil.class);

    public static boolean redisSwitch;
    public static int maxIdle;
    public static boolean testOnBorrow;
    public static boolean testOnReturn;
    public static String ip;
    public static int port;
    public static String key;
    public static String password;
    public static int timeout;
    public static int fail_count=0;

    static{
        Properties props=new Properties();
        try {
            props.load(JedisUtil.class.getResourceAsStream("classpath:properties/redis.properties"));

            redisSwitch=Boolean.valueOf(props.getProperty("redis.switch"));
            maxIdle=Integer.valueOf(props.getProperty("jedis.pool.maxIdle"));
            testOnBorrow=Boolean.valueOf(props.getProperty("jedis.pool.testOnBorrow"));
            testOnReturn=Boolean.valueOf(props.getProperty("jedis.pool.testOnReturn"));
            ip=String.valueOf(props.getProperty("redis.ip"));
            port=Integer.valueOf(props.getProperty("redis.port"));
            password=String.valueOf(props.getProperty("redis.password"));
            key=String.valueOf(props.getProperty("redis.key"));
            timeout=Integer.valueOf(props.getProperty("jedis.pool.timeout"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    //对redis开关进行设置,有三种情况：1.如果现在开关开，则关闭redispool  2.如果开关关闭，则设置redispool为开启状态  3.现在状态和要设置的状态一致，不做操作。
    public static void setSwitch(boolean redisSwitch){
        if(true==ConfigUtil.redisSwitch && false== redisSwitch){
            logger.info("switch:open-->close");
            JedisUtil.closeJedisPool();
        }else if(ConfigUtil.redisSwitch==false && true == redisSwitch){
            logger.info("switch:close-->open");
            JedisUtil.getInstance();
        }
        ConfigUtil.redisSwitch=redisSwitch;
    }
    //当redis连接异常超过一定数量之后，不再走redis,但是没有一个机制，当reids恢复后重新使用redis
    public static void setFail(){
        if(redisSwitch){
            fail_count=fail_count+1;

            if(fail_count >10){
                logger.info("setSwitch(false)");
                setSwitch(false);
            }
        }
    }

    public static void setSucc(){
        if(fail_count >0){
            fail_count=0;
        }
        if(!redisSwitch){
            setSwitch(true);
        }
    }
}
