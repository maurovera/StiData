package fpuna.sti.serviceBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import fpuna.sti.base.entity.Regla;
import fpuna.sti.base.service.GenericServiceImpl;
import fpuna.sti.service.ReglaService;

@LocalBean
@Stateless
public class ReglaServiceBean extends GenericServiceImpl<Regla, Integer> implements ReglaService {

    public ReglaServiceBean() {
        super(Regla.class);
    }
    @Override
    public List<Regla> findByID(Integer id) throws Throwable {
        TypedQuery<Regla> query = 
        		em.createNamedQuery("Regla.findById", Regla.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
