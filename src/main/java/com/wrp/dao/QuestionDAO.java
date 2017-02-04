package com.wrp.dao;

import com.wrp.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wuruiping on 2017/2/3.
 */
@Mapper
public interface QuestionDAO {

    String TABLE_NAME = " question ";
    String INSERT_FIELDS = " title, content, created_date, user_id, comment_count ";
    String SELECT_FIRLDS = " id, " + INSERT_FIELDS;

    @Insert({" insert into ",TABLE_NAME,"(",INSERT_FIELDS,") values (#{title},#{content},#{createdDate},#{userId},#{commentCount}"})
    int addQuestion(Question question);

    List<Question> selectLatestQuestions(@Param("userId") int userId,@Param("offset") int offset,
                                        @Param("limit") int limit);

//    @Select({"select ",SELECT_FIRLDS," from ",TABLE_NAME," order by id DESC limit #{offset},#{limit}"})
//        List<Question> selectLatestQuestions(@Param("userId") int userId,@Param("offset") int offset,
//                                        @Param("limit") int limit);
}