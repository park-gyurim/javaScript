package com.yedam.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EmployeeFile {
   @SuppressWarnings("unused")
public static void main(String[] args) throws IOException {
         Connection conn = null;
         List<Employee> list = new ArrayList<>();
           try{
                  PreparedStatement pstmt = conn.prepareStatement("select first_name, salary from employees");
                  ResultSet rs = pstmt.executeQuery();
                  while (rs.next()) {
                     list.add(new Employee(rs.getString("first_name"), rs.getInt("salary")));
                  }
               }catch(
                     SQLException e)
               {
                  
                  e.printStackTrace();
               }
               
               Stream<Employee> stream = list.stream();
               stream.forEach( (s) -> System.out.println(s.getFirst_name()
                     + ", " + s.getSalary()));
         File file = new File("src/com/yedam/test/employee.txt");
         FileWriter fwt = new FileWriter(file,true);
         for(Employee i : list) {
         fwt.write();
         fwt.flush();
         fwt.close();
         System.out.println("파일에 저장 되었습니다");     
      }
}
}