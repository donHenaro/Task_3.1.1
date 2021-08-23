package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.model.Role;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImp implements RoleService{

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

    @Transactional(readOnly = true)
    @Override
    public Set<Role> getRolesByName(String[] roles) {
        return roleDao.getRolesByName(roles);
    }

}
