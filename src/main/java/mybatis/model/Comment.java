package mybatis.model;

public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMMENT.ID
     *
     * @mbg.generated Tue Apr 09 22:49:33 EEST 2024
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMMENT.CONTENT
     *
     * @mbg.generated Tue Apr 09 22:49:33 EEST 2024
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMMENT.USER
     *
     * @mbg.generated Tue Apr 09 22:49:33 EEST 2024
     */
    private String user;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMMENT.SONG_ID
     *
     * @mbg.generated Tue Apr 09 22:49:33 EEST 2024
     */
    private Long songId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMMENT.ID
     *
     * @return the value of PUBLIC.COMMENT.ID
     *
     * @mbg.generated Tue Apr 09 22:49:33 EEST 2024
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMMENT.ID
     *
     * @param id the value for PUBLIC.COMMENT.ID
     *
     * @mbg.generated Tue Apr 09 22:49:33 EEST 2024
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMMENT.CONTENT
     *
     * @return the value of PUBLIC.COMMENT.CONTENT
     *
     * @mbg.generated Tue Apr 09 22:49:33 EEST 2024
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMMENT.CONTENT
     *
     * @param content the value for PUBLIC.COMMENT.CONTENT
     *
     * @mbg.generated Tue Apr 09 22:49:33 EEST 2024
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMMENT.USER
     *
     * @return the value of PUBLIC.COMMENT.USER
     *
     * @mbg.generated Tue Apr 09 22:49:33 EEST 2024
     */
    public String getUser() {
        return user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMMENT.USER
     *
     * @param user the value for PUBLIC.COMMENT.USER
     *
     * @mbg.generated Tue Apr 09 22:49:33 EEST 2024
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMMENT.SONG_ID
     *
     * @return the value of PUBLIC.COMMENT.SONG_ID
     *
     * @mbg.generated Tue Apr 09 22:49:33 EEST 2024
     */
    public Long getSongId() {
        return songId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMMENT.SONG_ID
     *
     * @param songId the value for PUBLIC.COMMENT.SONG_ID
     *
     * @mbg.generated Tue Apr 09 22:49:33 EEST 2024
     */
    public void setSongId(Long songId) {
        this.songId = songId;
    }
}