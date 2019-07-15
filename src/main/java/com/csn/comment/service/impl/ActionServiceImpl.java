package com.csn.comment.service.impl;

import com.csn.comment.bean.Action;
import com.csn.comment.dao.ActionDao;
import com.csn.comment.dto.ActionDto;
import com.csn.comment.service.ActionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionServiceImpl implements ActionService {
	
	@Autowired
	private ActionDao actionDao;
	
	@Override
	public boolean add(ActionDto dto) {
		return actionDao.insert(dto) == 1;
	}

	@Override
	public boolean remove(Long id) {
		return actionDao.deleteById(id) == 1;
	}

	@Override
	public boolean modify(ActionDto dto) {
		Action action = new Action();
		BeanUtils.copyProperties(dto,action);
		return actionDao.update(action) == 1;
	}

	@Override
	public ActionDto getById(Long id) {
		ActionDto result = new ActionDto();
		Action action = actionDao.selectById(id);
		BeanUtils.copyProperties(action, result);
		return result;
	}
}
