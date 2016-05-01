package fpuna.sti.service;

import java.util.List;

import fpuna.sti.base.entity.Regla;
import fpuna.sti.base.service.GenericService;

public interface ReglaService extends GenericService<Regla, Integer> {
    
	
	public List<Regla> findByID(Integer id) throws Throwable;

}
