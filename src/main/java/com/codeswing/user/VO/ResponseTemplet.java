package com.codeswing.user.VO;

import com.codeswing.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplet {

    private User user;

    private Department department;
}
