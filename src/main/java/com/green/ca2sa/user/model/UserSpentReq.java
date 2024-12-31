package com.green.ca2sa.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@Setter
public class UserSpentReq {
    @Schema(name = "first_day_of_month")
    private String firstDayOfMonth;
    @Schema(name = "user_id")
    private long userId;
    private String today;

    public UserSpentReq(@BindParam("first_day_of_month") String firstDayOfMonth, @BindParam("user_id") long userId, String today) {
        this.firstDayOfMonth = firstDayOfMonth;
        this.userId = userId;
        this.today = today;
    }
}
