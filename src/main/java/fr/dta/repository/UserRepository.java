package fr.dta.repository;

import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import fr.dta.modele.User;

@Repository
public class UserRepository extends AbstractJpaRepository<User>{

	@Override
	protected Class<User> getEntityClass() {
		return null;
	}

	
	@Transactional
    public User findOneByLogin(String login) {
        return (User) getSession().createCriteria(entityClass).add(Restrictions.eq("login", login)).uniqueResult();
    }

    @Transactional
    public User findById(Long id) {
        return (User) getSession().createCriteria(entityClass).add(Restrictions.eq("identifiant", id)).uniqueResult();
    }
}
