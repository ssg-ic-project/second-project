package com.ssg.secondproject.mapper;


import com.ssg.secondproject.domain.WarehouseVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Log4j2
public class WarehouseMapperTest {
    @Autowired
    private WarehouseMapper warehouseMapper;

    @Test
    public void listTest() {
        // given

        // when
        List<WarehouseVO> warehouseVOList = warehouseMapper.selectAll();

        // then
        log.info(warehouseVOList);
    }
}
