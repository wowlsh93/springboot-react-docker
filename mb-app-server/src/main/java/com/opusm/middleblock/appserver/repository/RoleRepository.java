package com.opusm.middleblock.appserver.repository;

import com.opusm.middleblock.appserver.model.Role;
import com.opusm.middleblock.appserver.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleName roleName);
}
