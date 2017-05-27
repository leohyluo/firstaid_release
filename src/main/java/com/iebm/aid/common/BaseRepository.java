package com.iebm.aid.common;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.iebm.aid.common.BaseEntity;
/**
 * 持久化
 * @author zdf
 *
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T>{
}
