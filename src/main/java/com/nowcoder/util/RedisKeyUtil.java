package com.nowcoder.util;


/**
 * 参考淘宝,支付宝的支付订单编号.
 *
 */
public class RedisKeyUtil {
   private static String SPLIT= ":";
   private static String BIZ_LIKE= "LIKE";
   private static String BIZ_DISLIKE= "DISLIKE";

   public static String getLikeKey(int entityId,int entityType){
       return BIZ_LIKE +SPLIT + String.valueOf(entityType)+ SPLIT + String.valueOf(entityId);
   }

    public static String getDisLikeKey(int entityId,int entityType){
        return BIZ_DISLIKE +SPLIT + String.valueOf(entityType)+ SPLIT + String.valueOf(entityId);
    }

}




















