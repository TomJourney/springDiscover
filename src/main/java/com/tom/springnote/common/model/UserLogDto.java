package com.tom.springnote.common.model;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName UserLogDto.java
 * @Description TODO
 * @createTime 2024年09月08日 14:52:00
 */
public class UserLogDto {

    private long id;

    private long userId;

    private String logInfo;

    public static UserLogDto newUserLogDto(Long id, Long userId, String logInfo) {
        UserLogDto userLogDto = new UserLogDto();
        userLogDto.id = id;
        userLogDto.userId = userId;
        userLogDto.logInfo = logInfo;
        return userLogDto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo;
    }
}
