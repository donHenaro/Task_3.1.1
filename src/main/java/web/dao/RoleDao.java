package web.dao;

import web.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    List<Role> getRoles();
    Set<Role> getRolesByName(String[] roles);
}
