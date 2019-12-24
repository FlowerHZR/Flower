package com.hzr.cms.dao;

import java.util.List;

import com.hzr.cms.domain.ComMessage;

/**
 * 投诉信息dao
 * @author Administrator
 *
 */
public interface ComMessageDAO {
  /**
   * 添加投诉信息
   * @param comMessage
   * @return
   */
  public int addComMessage(ComMessage comMessage);

  List<ComMessage> listMessage(ComMessage cm);

  int updMessage(Integer id);
}
