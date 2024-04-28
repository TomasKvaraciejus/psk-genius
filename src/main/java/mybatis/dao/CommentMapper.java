package mybatis.dao;

import java.util.List;
import mybatis.model.Comment;
import org.mybatis.cdi.Mapper;

@Mapper
public interface CommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMMENT
     *
     * @mbg.generated Tue Apr 09 22:49:33 EEST 2024
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMMENT
     *
     * @mbg.generated Tue Apr 09 22:49:33 EEST 2024
     */
    int insert(Comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMMENT
     *
     * @mbg.generated Tue Apr 09 22:49:33 EEST 2024
     */
    Comment selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMMENT
     *
     * @mbg.generated Tue Apr 09 22:49:33 EEST 2024
     */
    List<Comment> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMMENT
     *
     * @mbg.generated Tue Apr 09 22:49:33 EEST 2024
     */
    int updateByPrimaryKey(Comment record);
}