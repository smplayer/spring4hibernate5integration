package com.sm.common.query;

import com.sm.common.Base;
import com.sm.common.query.hibernate.QueryForHibernate;

import static com.sm.common.config.PagingConfig.MAX_PAGE_SIZE;
import static com.sm.common.config.PagingConfig.DEFAULT_PAGE_SIZE;
import static com.sm.common.config.PagingConfig.UNDEFINED_DATA_QUANTITY;

import java.util.List;

/**
 * Created by Newbody on 2016/2/25.
 */
public class PageHandler extends Base {
    private QueryForHibernate queryHandler;
    private Long pageIndex = 0L;
    private Integer pageSize = DEFAULT_PAGE_SIZE;
    private Long dataQuantity = UNDEFINED_DATA_QUANTITY ;
    private List<?> dataList;


    public PageHandler(){
    }

    public Long getPageQuantity() {
        Long pageQuantity = dataQuantity / pageSize;
        return (0 == pageQuantity || 0 != pageQuantity % pageSize) ? ++pageQuantity : pageQuantity;
    }

    public Long getPageIndex() {
        return  1 > pageIndex ? 1 : pageIndex > getPageQuantity() ? getPageQuantity() : pageIndex;
    }

    public PageHandler setPageIndex(Long pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }

    public Integer getPageSize() {
        return 1 > pageSize ? DEFAULT_PAGE_SIZE : MAX_PAGE_SIZE < pageSize ? MAX_PAGE_SIZE : pageSize;
    }

    public PageHandler setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Long getDataQuantity() {
        return  0 > dataQuantity ? 0 : dataQuantity;
    }

    public PageHandler setDataQuantity(Long dataQuantity) {
        this.dataQuantity = dataQuantity;
        return this;
    }

    public List<?> getDataList() {
        return dataList;
    }

    public void setDataList(List<?> dataList) {
        this.dataList = dataList;
    }

}
