package com.mapps.dao.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mapps.beans.AppBean;
import com.mapps.models.base.History;
import com.mapps.repositories.base.HistoryRepository;

/**
 * Interface describing the life-cycle operations (e.g. CRUD operations) for all models.
 */
public abstract class BaseDAO {
	
	@Autowired
	private HistoryRepository history;
	
	@Autowired
	private AppBean app;
	
	public boolean createHistory(Object Id, String user, String description) {
		History record = null;
		if(app.getDbLogger() < 99) {
			record = new History(Id.toString(), user, description);
			record = history.save(record);
		}
		return record != null;
	}
	
	public abstract List<?> findAll();

	public abstract Object save(Object entity, String description);

	public abstract Iterable<?> save(Iterable<?> entities, String description);
	
	public abstract Object findOne(Object id);
	
	public abstract boolean exists(Object id);

	public abstract long count();
	
	public abstract void delete(Object id);

	public abstract void delete(Iterable<?> entities);

	public abstract void deleteAll();

}
