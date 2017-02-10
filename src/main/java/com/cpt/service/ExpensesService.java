package com.cpt.service;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.model.Expenses;
import com.cpt.req.ExpensesQuery;
import com.cpt.vo.EchartVo;

public interface ExpensesService {
	public Expenses get(Long id);
 	
	public PageResult<Expenses> pageList(PageParam pageParam, ExpensesQuery expensesQuery);
	
	public PageResult<Expenses> recordPageList(PageParam pageParam, ExpensesQuery expensesQuery);
	
	public Result<Integer> addOrEdit(Expenses expenses);
	
	public Result<Integer> delete(Long id);
	
	public EchartVo getDepartmentExpenses();
}
