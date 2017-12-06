package com.imooc.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.imooc.dataobject.ProductInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品 包含类目
 * Created by Administrator on 2017/9/15.
 */
@Data
public class ProductVo implements Serializable {

    private static final long serialVersionUID = 5561871882792845885L;
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO>productVoList;
}
