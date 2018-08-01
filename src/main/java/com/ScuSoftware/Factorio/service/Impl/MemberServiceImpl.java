package com.ScuSoftware.Factorio.service.Impl;

import com.ScuSoftware.Factorio.dao.MemberMapper;
import com.ScuSoftware.Factorio.model.Member;
import com.ScuSoftware.Factorio.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;
    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper){
        this.memberMapper = memberMapper;
    }
    @Override
    public int insertMember(Member member) {
            return memberMapper.insert(member);
    }
}
