package com.sat.tmf.springboot.myexp.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sat.tmf.springboot.myexp.Expense;

public class MyExpensesDAO {
	
	public void saveExpense(Expense exp) {

		Session session = SessionFactoryProvider.getSessionFactory();
		Transaction t = session.beginTransaction();
		session.save(exp);
		t.commit();
		session.close();
	}
	
	public Expense getExpenseById(int id) {

		Session session = SessionFactoryProvider.getSessionFactory();
		Expense e = session.get(Expense.class,130);
//		If an object doesn’t exist in database, get() returns null whereas load() throws ObjectNotFoundexception.
//		Expense e = session.load(Expense.class,130);
		session.close();
		return e;
		
	}
	
	public List<Expense> getExpenseByCategory(int catId) {
		Session session = SessionFactoryProvider.getSessionFactory();

		String sqlQuery = "select * from expenses where expCatId = :catId"; 
		SQLQuery query = session.createSQLQuery(sqlQuery);
		query.setParameter("catId", catId);
		List<Expense> expensesList = query.list();
		session.close();
		return expensesList;
		
	}
	
	

}
