package com.xiaoluo.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class SchemaExportTest
{
	public static void main(String[] args)
	{
		SchemaExport se = new SchemaExport(new Configuration().configure());
		
		se.create(true, false);
	}
}
