package com.hzr.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hzr.cms.dao.ComMessageDAO;
import com.hzr.cms.domain.ComMessage;
import com.hzr.cms.service.ComMessageService;

@Service
@Transactional
public class ComMessageServiceImpl implements ComMessageService {
  @Autowired
  public ComMessageDAO comMessageDAO;

  @Override
  public int addComMessage(ComMessage comMessage) {
    return comMessageDAO.addComMessage(comMessage);
  }

  @Override
  public List<ComMessage> listMessage(ComMessage cm) {
    // TODO Auto-generated method stub
    return comMessageDAO.listMessage(cm);
  }

  @Override
  public int updMessage(Integer id) {
    // TODO Auto-generated method stub
    return comMessageDAO.updMessage(id);
  }

}
