package com.hzr.cms.service;

import java.util.List;

import com.hzr.cms.domain.ComMessage;

public interface ComMessageService {
  /**
   * 添加投诉信息
   * @param comMessage
   * @return
   */
  public int addComMessage(ComMessage comMessage);

  List<ComMessage> listMessage(ComMessage cm);

  int updMessage(Integer id);
}
