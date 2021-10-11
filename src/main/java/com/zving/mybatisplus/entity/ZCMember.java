package com.zving.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author JiangWei
 * @since 2021-10-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("zcmember")
public class ZCMember extends Model<ZCMember> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private Long ID;

    @TableField("UserName")
    private String UserName;

    @TableField("RealName")
    private String RealName;

    @TableField("Age")
    private Integer Age;


    @Override
    public Serializable pkVal() {
        return this.ID;
    }

}
