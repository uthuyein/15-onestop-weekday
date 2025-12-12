package com.jdc.mkt.listener;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class EntityListener {

	@PrePersist
	void create(Object obj) {
		if(obj instanceof EnableEntityListener entity) {
			Times times = entity.getTimes();
			if(null == times) {
				times = new Times();
				entity.setTimes(times);
			}
			times.setCreateTimes(LocalDateTime.now());
		}
	}
	
	@PreUpdate
	void update(Object obj) {
		if(obj instanceof EnableEntityListener entity) {
			Times times = entity.getTimes();
			if(null == times) {
				times = new Times();
				entity.setTimes(times);
			}
			times.setUpdateTimes(LocalDateTime.now());
		}
	}
}
