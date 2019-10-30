package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.StudentMapper;
import com.pojo.Student;

public class Demo1 {

	public static void main(String[] args) throws IOException {
		InputStream in = Resources.getResourceAsStream("Sqlconfig.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = fac.openSession();
		StudentMapper sm = session.getMapper(StudentMapper.class);
//		Student stu = sm.getStuByNo(101);
//		System.out.println(stu);
		Student stu = new Student("Mary", "Ů", new Date(), 0);
		System.out.println("����ǰ��"+stu);
		System.out.println(sm.addStudent2(stu));
		System.out.println("������"+stu);
		session.commit();
		session.close();

	}

}
