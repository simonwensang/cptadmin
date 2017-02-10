package com.cpt.mapper.ext;

import java.util.List;

import com.cpt.model.Expenses;
import com.cpt.req.ExpensesQuery;
import com.cpt.vo.DepartmentExpenses;

public interface ExpensesExtMapper {
	 List<Expenses> pageList(ExpensesQuery expensesQuery);
	 
	 int logicalDelete(Long id);
	 
	 List<DepartmentExpenses> selectListDepartment(List<Long> list);
}
