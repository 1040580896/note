package com.c03.note.dao;

import com.c03.note.po.User;

public interface UserDao {

    /**
     * 通过用户名查询用户对象
     *  1. 定义sql语句
     *  2. 设置参数集合
     *  3. 调用BaseDao的查询方法
     * @param userName
     * @return
     */
    public User queryUserByName(String userName);

    /**
        通过用户名查询用户对象， 返回用户对象
         1. 获取数据库连接
         2. 定义sql语句
         3. 预编译
         4. 设置参数
         5. 执行查询，返回结果集
         6. 判断并分析结果集
         7. 关闭资源
     * @param userName
     * @return
     */
    public User queryUserByName02(String userName);

    /**
     * 通过昵称与用户ID查询用户对象
     *  1. 定义SQL语句
     *     通过用户ID查询除了当前登录用户之外是否有其他用户使用了该昵称
     *          指定昵称  nick （前台传递的参数）
     *          当前用户  userId （session作用域中的user对象）
     *          String sql = "select * from tb_user where nick = ? and userId != ?";
     *  2. 设置参数集合
     *  3. 调用BaseDao的查询方法
     * @param nick
     * @param userId
     * @return
     */
    public User queryUserByNickAndUserId(String nick, Integer userId);

    /**
     * 通过用户ID修改用户信息
         1. 定义SQL语句
            String sql = "update tb_user set nick = ?, mood = ?, head = ? where userId = ? ";
         2. 设置参数集合
         3. 调用BaseDao的更新方法，返回受影响的行数
         4. 返回受影响的行数
     * @param user
     * @return
     */
    public int updateUser(User user);
}
