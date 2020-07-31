package com.yaochen.manager.authorization.manager.dao;

import com.yaochen.manager.authorization.manager.bean.CommonUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommonUserRoleRepository extends JpaRepository<CommonUserRole, String> {

    List<CommonUserRole> findCommonUserRolesByUserId(String userId);

}
