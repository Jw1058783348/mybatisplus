package com.zving.mybatisplus.service.impl;

import com.zving.mybatisplus.entity.Member;
import com.zving.mybatisplus.mapper.MemberMapper;
import com.zving.mybatisplus.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JiangWei
 * @since 2021-10-09
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

}
