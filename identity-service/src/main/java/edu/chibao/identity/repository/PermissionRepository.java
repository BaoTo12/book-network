package edu.chibao.identity.repository;

import edu.chibao.identity.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {}
