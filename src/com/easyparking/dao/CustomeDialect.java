package com.easyparking.dao;

import org.hibernate.dialect.MySQLDialect;
import java.sql.Types;
import org.hibernate.Hibernate;
import org.hibernate.dialect.function.StandardSQLFunction;


public class CustomeDialect extends MySQLDialect {
	public CustomeDialect(){
	    registerFunction("group_concat", new StandardSQLFunction("group_concat", Hibernate.STRING));
	    registerFunction("coalesce", new StandardSQLFunction("coalesce", Hibernate.STRING));
	    registerHibernateType(Types.LONGVARCHAR, Hibernate.TEXT.getName());

	}
}
