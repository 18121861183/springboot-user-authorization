package com.yaochen.manager.authorization.manager.dao;

import com.yaochen.manager.authorization.manager.bean.CommonUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonUserRepository  extends JpaRepository<CommonUser, String> {

    CommonUser findByUsernameOrAlias(String username, String alias);

}
