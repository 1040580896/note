package com.c03.note.service;

import com.c03.note.po.User;
import com.c03.note.vo.ResultInfo;

import javax.servlet.http.HttpServletRequest;

public interface UserService {



    /**
     * 用户登录
         1. 判断参数是否为空
             如果为空
                 设置ResultInfo对象的状态码和提示信息
                 返回resultInfo对象
         2. 如果不为空，通过用户名查询用户对象
         3. 判断用户对象是否为空
             如果为空
                 设置ResultInfo对象的状态码和提示信息
                 返回resultInfo对象
         4. 如果用户对象不为空，将数据库中查询到的用户对象的密码与前台传递的密码作比较 （将密码加密后再比较）
             如果密码不正确
                 设置ResultInfo对象的状态码和提示信息
                 返回resultInfo对象
         5. 如果密码正确
            设置ResultInfo对象的状态码和提示信息
         6. 返回resultInfo对象
     * @param userName
     * @param userPwd
     * @return
     */
    public ResultInfo<User> userLogin(String userName, String userPwd);

    /**
     * 验证昵称的唯一性
     * 1. 判断昵称是否为空
     *    如果为空，返回"0"
     * 2. 调用Dao层，通过用户ID和昵称查询用户对象
     * 3. 判断用户对象存在
     *    存在，返回"0"
     *    不存在，返回"1"
     * @param nick
     * @param userId
     * @return
     */
    public Integer checkNick(String nick, Integer userId);

    /**
     * 修改用户信息
         1. 获取参数（昵称、心情）
         2. 参数的非空校验（判断必填参数非空）
            如果昵称为空，将状态码和错误信息设置resultInfo对象中，返回resultInfo对象
         3. 从session作用域中获取用户对象（获取用户对象中默认的头像）
         4. 实现上上传文件
             1. 获取Part对象 request.getPart("name"); name代表的是file文件域的那么属性值
             2. 通过Part对象获取上传文件的文件名
             3. 判断文件名是否为空
             4. 获取文件存放的路径  WEB-INF/upload/目录中
             5. 上传文件到指定目录
         5. 更新用户头像 （将原本用户对象中的默认头像设置为上传的文件名）
         6. 调用Dao层的更新方法，返回受影响的行数
         7. 判断受影响的行数
            如果大于0，则修改成功；否则修改失败
         8. 返回resultInfo对象

     * @param request
     * @return
     */
    public ResultInfo<User> updateUser(HttpServletRequest request);
}
