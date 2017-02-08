package com.cpt.mapper;

import com.cpt.model.Expenses;
import com.cpt.model.ExpensesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpensesMapper {
    int countByExample(ExpensesExample example);

    int deleteByExample(ExpensesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Expenses record);

    int insertSelective(Expenses record);

    List<Expenses> selectByExample(ExpensesExample example);

    Expenses selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Expenses record, @Param("example") ExpensesExample example);

    int updateByExample(@Param("record") Expenses record, @Param("example") ExpensesExample example);

    int updateByPrimaryKeySelective(Expenses record);

    int updateByPrimaryKey(Expenses record);
}