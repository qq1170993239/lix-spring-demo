package cn.lix.spring.demo.service.impl;

import cn.lix.spring.demo.dao.TestUserDao;
import cn.lix.spring.demo.entity.TestUser;
import cn.lix.spring.demo.service.TestUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TestUser)表服务实现类
 *
 * @author lix
 * @since 2020-07-18 10:03:56
 */
@Service("testUserService")
public class TestUserServiceImpl implements TestUserService {
    @Resource
    private TestUserDao testUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TestUser queryById(Integer id) {
        return this.testUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TestUser> queryAllByLimit(int offset, int limit) {
        return this.testUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param testUser 实例对象
     * @return 实例对象
     */
    @Override
    public TestUser insert(TestUser testUser) {
        this.testUserDao.insert(testUser);
        return testUser;
    }

    /**
     * 修改数据
     *
     * @param testUser 实例对象
     * @return 实例对象
     */
    @Override
    public TestUser update(TestUser testUser) {
        this.testUserDao.update(testUser);
        return this.queryById(testUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.testUserDao.deleteById(id) > 0;
    }
}