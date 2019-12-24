package com.hzr.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hzr.cms.dao.FavDAO;
import com.hzr.cms.domain.Fav;
import com.hzr.cms.service.FavService;


@Service
public class FavServiceImpl implements FavService {
	
	@Resource
	private FavDAO favDAO;
	@Override
	public List<Fav> list() {
		// TODO Auto-generated method stub
		return favDAO.list();
	}

}
