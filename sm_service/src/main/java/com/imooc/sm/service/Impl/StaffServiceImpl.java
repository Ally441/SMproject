package com.imooc.sm.service.Impl;

import com.imooc.sm.dao.StaffDao;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;

    @Override
    public void add(Staff staff) {
        staff.setPassword("123456");
        staff.setWorkTime(new Date());
        staff.setStatus("正常");
        staffDao.insert(staff);
    }

    @Override
    public void delete(Integer id) {
        staffDao.delete(id);
    }

    @Override
    public void edit(Staff staff) {
        System.out.println(staff.getBornDate());
        staffDao.update(staff);
    }

    @Override
    public Staff get(Integer id) {
        return staffDao.selectById(id);
    }

    @Override
    public List<Staff> getAll() {
        return staffDao.selectAll();
    }
}
