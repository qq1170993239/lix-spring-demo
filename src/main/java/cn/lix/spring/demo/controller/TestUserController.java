package cn.lix.spring.demo.controller;

import cn.lix.spring.demo.entity.TestUser;
import cn.lix.spring.demo.service.TestUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (TestUser)表控制层
 *
 * @author lix
 * @since 2020-07-18 10:03:56
 */
@RestController
@RequestMapping("testUser")
public class TestUserController {
    /**
     * 服务对象
     */
    @Resource
    private TestUserService testUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TestUser selectOne(Integer id) {
        return this.testUserService.queryById(id);
    }

}