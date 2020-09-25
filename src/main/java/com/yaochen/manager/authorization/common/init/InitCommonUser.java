package com.yaochen.manager.authorization.common.init;

import com.yaochen.manager.authorization.manager.bean.CommonUser;
import com.yaochen.manager.authorization.manager.dao.CommonUserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.UUID;

@Component
public class InitCommonUser {

    @Resource
    private CommonUserRepository commonUserRepository;

    @PostConstruct
    public void initUser() {
        long count = commonUserRepository.count();
        if (count != 0) {
            return;
        }

        String userId = UUID.randomUUID().toString().replaceAll("-", "");

        CommonUser user = new CommonUser();
        user.setId(userId);
    }

}
