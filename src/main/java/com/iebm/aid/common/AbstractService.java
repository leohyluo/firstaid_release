package com.iebm.aid.common;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 抽象实现的基本业务类，处理最基本的增删改查业务。
 * @author zdf
 *
 * @param <T> 继承自BaseEntity
 * @param <ID> ID类型，本项目中使用Long
 */
@Transactional
public abstract class AbstractService<T extends BaseEntity, ID extends Serializable> implements BaseService<T, ID> {
	protected final Logger logger = Logger.getLogger(this.getClass());

	protected abstract BaseRepository<T, ID> getRepository();

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public boolean exists(ID id) {
		return getRepository().exists(id);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public T get(ID id) {
		return getRepository().findOne(id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public T save(T t) {
		return getRepository().save(t);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public <S extends T> List<S> save(Iterable<S> entities) {
		return getRepository().save(entities);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public long count() {
		return getRepository().count();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<T> findAll() {
		return getRepository().findAll();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<T> findAll(Sort sort) {
		return getRepository().findAll(sort);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<T> findAll(Iterable<ID> ids) {
		return getRepository().findAll(ids);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Page<T> findAll(Specification<T> spec, Pageable pageable) {
		return getRepository().findAll(spec, pageable);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(ID id) {
		T t = this.get(id);
		if (t != null) {
			getRepository().delete(t);
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(T t) {
		getRepository().delete(t);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(Iterable<T> entities) {
		getRepository().delete(entities);
		getRepository().flush();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteAll() {
		// getRepository().deleteAll();
		throw new UnsupportedOperationException();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Page<T> findPage(final T t) {
		throw new UnsupportedOperationException();
	}

}
