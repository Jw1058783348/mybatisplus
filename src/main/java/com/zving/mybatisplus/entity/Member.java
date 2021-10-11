package com.zving.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author JiangWei
 * @since 2021-10-09
 */
@Getter
@Setter
@TableName("member")
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId("ID")
    private Long id;

    @TableField("UserName")
    private String userName;

    @TableField("RealName")
    private String realName;

    @TableField("Age")
    private Integer age;


}
