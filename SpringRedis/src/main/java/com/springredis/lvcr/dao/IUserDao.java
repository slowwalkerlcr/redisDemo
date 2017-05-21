package com.springredis.lvcr.dao;

import com.springredis.lvcr.bean.User;

import java.util.List;

/**
 * Created by Administrator on 2017/5/17.
 */
public interface IUserDao {
    /**
     * 新增
     * @param user
     * @return
     */
    boolean add(User user);

    /**
     * 批量新增 使用pipeline方式
     * <br>------------------------------<br>
     * @param list
     * @return
     */
    boolean add(List<User> list);

    /**
     * 删除
     * <br>------------------------------<br>
     * @param key
     */
    void delete(String key);

    /**
     * 删除多个
     * <br>------------------------------<br>
     * @param keys
     */
    void delete(List<String> keys);

    /**
     * 修改
     * <br>------------------------------<br>
     * @param user
     * @return
     */
    boolean update(User user);

    /**
     * 通过key获取
     * <br>------------------------------<br>
     * @param keyId
     * @return
     */
    User get(String keyId);
}
