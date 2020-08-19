package com.aem.aemtraining.core.service;

import java.util.List;


import com.aem.aemtraining.core.bean.Student;

public interface StudentIface {
	public boolean Stdregi( String name, String Address,String email,String Password, String Telephone);
	public boolean Stdupate( String name, String Address,String email,String Password, String Telephone);
	public boolean StuDelete( String name);
	public List<Student> getAllStudent();
}
