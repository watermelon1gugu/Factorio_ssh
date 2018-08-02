package com.ScuSoftware.Factorio.service.Impl;

import com.ScuSoftware.Factorio.dao.AnnounceMapper;
import com.ScuSoftware.Factorio.model.Announce;
import com.ScuSoftware.Factorio.model.AnnounceExample;
import com.ScuSoftware.Factorio.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@Transactional
public class AnnounceServiceImpl implements AnnounceService {

    private final AnnounceMapper announceMapper;
    @Autowired
    public AnnounceServiceImpl(AnnounceMapper announceMapper) {
        this.announceMapper = announceMapper;
    }

    @Override
    public List<Announce> getAllAnnounce() {
        return announceMapper.selectByExampleWithBLOBs(new AnnounceExample());
    }
}
