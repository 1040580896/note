package com.c03.note.service;

import com.c03.note.po.Note;
import com.c03.note.util.Page;
import com.c03.note.vo.NoteVo;
import com.c03.note.vo.ResultInfo;

import java.util.List;
import java.util.Map;

public interface NoteService {



    /**
     * 添加或修改云记
         1. 参数的非空判断
            如果为空，code=0，msg=xxx，result=note对象，返回resultInfo对象
         2. 设置回显对象 Note对象
         3. 调用Dao层，添加云记记录，返回受影响的行数
         4. 判断受影响的行数
             如果大于0，code=1
             如果不大于0，code=0，msg=xxx，result=note对象
         5. 返回resultInfo对象
     * @param typeId
     * @param title
     * @param content
     * @return
     */
    public ResultInfo<Note> addOrUpdate(String typeId, String title,
                                        String content, String noteId, String lon, String lat);

    /**
     * 分页查询云记列表
         1. 参数的非空校验
            如果分页参数为空，则设置默认值
         2. 查询当前登录用户的云记数量，返回总记录数 （long类型）
         3. 判断总记录数是否大于0
         4. 如果总记录数大于0，调用Page类的带参构造，得到其他分页参数的值，返回Page对象
         5. 查询当前登录用户下当前页的数据列表，返回note集合
         6. 将note集合设置到page对象中
         7. 返回Page对象
     * @param pageNumStr
     * @param pageSizeStr
     * @param userId
     * @param title  条件查询的参数：标题
     * @return
     */
    public Page<Note> findNoteListByPage(String pageNumStr, String pageSizeStr,
                                         Integer userId, String title, String date, String typeId);

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
     * 查询云记详情
         1. 参数的非空判断
         2. 调用Dao层的查询，通过noteId查询note对象
         3. 返回note对象
     * @param noteId
     * @return
     */
    public Note findNoteById(String noteId);

    /**
     * 删除云记
         1. 判断参数
         2. 调用Dao层的更新方法，返回受影响的行数
         3. 判断受影响的行数是否大于0
            如果大于0，返回1；否则返回0
     * @param noteId
     * @return
     */
    public Integer deleteNote(String noteId);

    /**
     * 通过月份查询对应的云记数量
     * @param userId
     * @return
     */
    public ResultInfo<Map<String, Object>> queryNoteCountByMonth(Integer userId);

    /**
     * 查询用户发布云记时的坐标
     * @param userId
     * @return
     */
    public ResultInfo<List<Note>> queryNoteLonAndLat(Integer userId);
}
