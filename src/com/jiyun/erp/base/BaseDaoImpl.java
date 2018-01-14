package com.jiyun.erp.base;

import java.util.List;
import java.lang.reflect.ParameterizedType;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class BaseDaoImpl<T> {
	
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	private Class<T> entityClass;
	
	public BaseDaoImpl(){
		entityClass=(Class)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void buildCriteria(DetachedCriteria criteria,BaseVo baseVo){
		
	}
	
	public List<T> list() {
		List<T> list = (List<T>) hibernateTemplate.find("from"+entityClass.getSimpleName());
		return list;
	}

	public List<T> pageList(int pageNo, int pageSize, BaseVo baseVo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		//构建查询参数
		buildCriteria(criteria,baseVo);
		
		List<T> list = (List<T>) hibernateTemplate.findByCriteria(criteria, (pageNo-1)*pageSize, pageSize);
		return list;
	}

	public int totalCount(BaseVo baseVo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		//构建条数投影  查询记录的总条数
		criteria.setProjection(Projections.rowCount());
		//构建查询参数
		buildCriteria(criteria,baseVo);
	
		List<Long> list = (List<Long>) hibernateTemplate.findByCriteria(criteria);
		return list.get(0).intValue();
	}

	public void save(T t) {
		hibernateTemplate.save(t);
	}

	public void delete(T t) {
		hibernateTemplate.delete(t);
	}

	public T findById(Integer id) {
		return hibernateTemplate.get(entityClass, id);
	}

	public void update(T t) {
		hibernateTemplate.update(t);
	}
}
