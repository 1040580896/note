package com.c03.note.dao;

import com.c03.note.po.NoteType;

import java.util.List;

public interface NoteTypeDao {


    /**
     * 通过用户ID查询类型集合
         1. 定义SQL语句
            String sql = "select typeId,typeName,userId from tb_note_type where userId = ? ";
         2. 设置参数列表
         3. 调用BaseDao的查询方法，返回集合
         4. 返回集合
     * @param userId
     * @return
     */
    public List<NoteType> findTypeListByUserId(Integer userId);

    /**
     * 通过类型ID查询云记记录的数量，返回云记数量
     *
     * @param typeId
     * @return
     */
    public long findNoteCountByTypeId(String typeId);


    /**
     * 通过类型ID删除指定的类型记录，返回受影响的行数
     * @param typeId
     * @return
     */
    public int deleteTypeById(String typeId);

    /**
     * 查询当前登录用户下，类型名称是否唯一
     *     返回1，表示成功
     *     返回0，表示失败
     * @param typeName
     * @param userId
     * @param typeId
     * @return
     */
    public Integer checkTypeName(String typeName, Integer userId, String typeId);
    /**
     * 添加方法，返回主键
     * @param typeName
     * @param userId
     * @return
     */
    public Integer addType(String typeName, Integer userId);

    /**
     * 修改方法，返回受影响的行数
     * @param typeName
     * @param typeId
     * @return
     */
    public Integer updateType(String typeName, String typeId);
}
