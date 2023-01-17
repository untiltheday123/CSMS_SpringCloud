package com.chartservice.serviceImpl;


import com.chartservice.dao.ProfileDao;
import com.chartservice.domain.Profile;
import com.chartservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileDao profileDao;

    @Override
    public List<Profile> querySaleTotal() {
        return profileDao.querySaleTotal();
    }

    @Override
    public List<Profile> queryUserNum() {
        return profileDao.queryUserNum();
    }
}
