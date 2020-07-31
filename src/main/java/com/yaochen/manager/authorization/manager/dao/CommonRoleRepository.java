package com.yaochen.manager.authorization.manager.dao;

import com.yaochen.manager.authorization.manager.bean.CommonRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonRoleRepository extends JpaRepository<CommonRole, String> {

    CommonRole findCommonRoleById(String id);

}
