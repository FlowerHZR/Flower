package com.hzr.cms.thread;

import com.hzr.cms.utils.ThreadPoolUtil;

/**
 * 
 * **
 * <br>Title:TODO 类标题
 * <br>Description:主线程
 * <br>Author:老花
 * <br>Date:2019年12月24日
 */
public class MainThread {
  public static void main(String[] args) {
    ThreadOne one = new ThreadOne();
    ThreadTwo two = new ThreadTwo();
    ThreadThree three = new ThreadThree();
    ThreadFour four = new ThreadFour();
    ThreadFive five = new ThreadFive();
    //使用线程池管理线程（启动）
    ThreadPoolUtil.execute(one);
    ThreadPoolUtil.execute(two);
    ThreadPoolUtil.execute(three);
    ThreadPoolUtil.execute(four);
    ThreadPoolUtil.execute(five);
    //关闭
    ThreadPoolUtil.shutDown();
  }
}
