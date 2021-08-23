package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImp implements RoleDao{

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    @Override
    public List<Role> getRoles() {
        return em.createQuery("from Role order by id", Role.class).getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")  // возврат ролей
    public Set<Role> getRolesByName(String[] roles) {
        return new HashSet<Role>(em.createQuery("from Role r where r.roleName in (:roles)")
                .setParameter("roles", Arrays.asList(roles))
                .getResultList());
    }
}
