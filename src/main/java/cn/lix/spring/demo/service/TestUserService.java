package cn.lix.spring.demo.service;

import cn.lix.spring.demo.entity.TestUser;

import java.util.List;

/**
 * (TestUser)表服务接口
 *
 * @author lix
 * @since 2020-07-18 10:03:56
 */
public interface TestUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TestUser queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TestUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param testUser 实例对象
     * @return 实例对象
     */
    TestUser insert(TestUser testUser);

    /**
     * 修改数据
     *
     * @param testUser 实例对象
     * @return 实例对象
     */
    TestUser update(TestUser testUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}