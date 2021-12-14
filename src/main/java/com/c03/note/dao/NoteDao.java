package com.c03.note.dao;

import com.c03.note.po.Note;
import com.c03.note.vo.NoteVo;

import java.util.List;

public interface NoteDao {

    /**
     * 添加或修改云记，返回受影响的行数
     * @param note
     * @return
     */
    public int addOrUpdate(Note note);

    /**
     * 查询当前登录用户的云记数量，返回总记录数
     * @param userId
     * @return
     */
    public long findNoteCount(Integer userId, String title, String date, String typeId);

    /**
     * 分页查询当前登录用户下当前页的数据列表，返回note集合
     * @param userId
     * @param index
     * @param pageSize
     * @return
     */
    public List<Note> findNoteListByPage(Integer userId, Integer index, Integer pageSize,
                                         String title, String date, String typeId);



    /**
     * 通过日期分组查询当前登录用户下的云记数量
     * @param userId
     * @return
     */
    public List<NoteVo> findNoteCountByDate(Integer userId);

    /**
     * 通过类型分组查询当前登录用户下的云记数量
     * @param userId
     * @return
     */
    public List<NoteVo> findNoteCountByType(Integer userId);


    /**
     * 通过id查询云记对象
     * @param noteId
     * @return
     */
    public Note findNoteById(String noteId);

    /**
     * 通过noteId删除云记记录，返回受影响的行数
     * @param noteId
     * @return
     */
    public int deleteNoteById(String noteId);

    /**
     * 通过用户ID查询云记列表
     * @param userId
     * @return
     */
    public List<Note> queryNoteList(Integer userId);
}
