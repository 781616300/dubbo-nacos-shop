package com.xialuo.shop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageRowBounds;
import com.xialuo.shop.dao.CouponMapper;
import com.xialuo.shop.domain.Coupon;
import com.xialuo.shop.utils.ObjectMapperUtil;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Service
public class CouponServiceImpl implements CouponService {

  @Autowired
  CouponMapper couponMapper;

  @Override
  public Map<String,Object> getCounponById(Long id) {
    return couponMapper.getCounponById(id);
  }

  @Override
  public Coupon selectById(Long id) {
    return couponMapper.selectByPrimaryKey(id);
  }

  @Override
  public List<Coupon> list(int pageNum, int pageSize) {
    /**
     * 使用RowBounds
     * 只查询当前页数据，不包含总数
     * 会执行1个SQL
     * 1、selectListWithRowBounds
     */
    Page<Coupon> page = new Page<>(pageNum, pageSize);

    List<Coupon> list = couponMapper
        .selectListWithRowBounds(new RowBounds(page.getStartRow(), pageSize));

    log.info("pageList: {}", list);
    // PageHelper处理后的返回值 实际上是Page对象
    if (list instanceof Page) {
      page = (Page) list;
      // 无total
      log.info("page: {}", page);
    }
    return list;
  }

  @Override
  public PageInfo<Coupon> doSelectPageInfo(int pageNum, int pageSize) {

    /**
     * 推荐的分页查询用法
     * 会执行两个SQL
     * 1、自动识别的count查询
     * 2、selectList
     */
    PageInfo<Coupon> pageInfo = PageHelper.startPage(pageNum, pageSize)
        .doSelectPageInfo(() -> couponMapper.selectList());

    log.info("pageList: {}", pageInfo);

    return pageInfo;
  }

  @Override
  public PageInfo<Coupon> pageList(int pageNum, int pageSize) {
    /**
     * 使用PageRowBounds,包含总数
     * 会执行两个SQL
     * 1、自动识别的count查询
     * 2、selectListWithRowBounds
     */
    Page<Coupon> page = new Page<>(pageNum, pageSize);

    PageRowBounds pageRowBounds = new PageRowBounds(page.getStartRow(), pageSize);

    List<Coupon> list = couponMapper.selectListWithRowBounds(pageRowBounds);

    // pageRowBounds 中的total也包含总数
    log.info("pageRowBounds: {}", ObjectMapperUtil.toJSONString(pageRowBounds));
    log.info("pageList: {}", list);
    // PageHelper处理后的返回值 实际上是Page对象
    if (list instanceof Page) {
      page = (Page) list;
      log.info("page: {}", page);
    }

    return ((Page<Coupon>) list).toPageInfo();
  }

  @Override
  public PageInfo<Coupon> pageList2(int pageNum, int pageSize) {

    /**
     * 使用PageHelper.startPage(pageNum, pageSize)
     * 紧跟着的查询会被分页
     * 会执行两个SQL
     * 1、自动识别的count查询
     * 2、selectList
     */
    PageHelper.startPage(pageNum, pageSize);
    List<Coupon> list = couponMapper.selectList();

    log.info("pageList: {}", list);
    // PageHelper处理后的返回值 实际上是Page对象
    if (list instanceof Page) {
      Page page = (Page) list;
      log.info("page: {}", page);
    }

    return ((Page<Coupon>) list).toPageInfo();
  }

  @Override
  public PageInfo<Coupon> pageListCustomCount(int pageNum, int pageSize) {
    /**
     * 使用查询参数分页,包含总数
     * SQL不需要加limit
     *
     * 会执行两个SQL
     * 1、selectListCustomCount
     * 2、selectListCustomCount_COUNT  自定义总数查询SQL 在原SQL后加_COUNT
     *
     */

    List<Coupon> list = couponMapper.selectListCustomCount(pageNum, pageSize);

    log.info("pageList: {}", list);
    // PageHelper处理后的返回值 实际上是Page对象
    if (list instanceof Page) {
      Page page = (Page) list;
      log.info("page: {}", page);
    }

    return ((Page<Coupon>) list).toPageInfo();
  }

}