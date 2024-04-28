/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASMGD2;
import ASMGD1.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mxtru
 */
public class reposistories {
    public String getRole(String Username,String Password){
        String sql = "select Role from Users where Usernamme = ? And Password = ?";
        try {
            Connection conn = DB_Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Username);
            ps.setString(2, Password);
            ResultSet rs = ps.executeQuery();
            String Role = "No";
            while(rs.next()){
                Role = rs.getString("Role");
                
            }
            return Role;
        } catch (Exception e) {
        }
        return "No";
        
    }
    public static void main(String[] args) {
        reposistories repo = new reposistories(); 
        
    }
    
    // quản lý sv
    public List<Model_Student> getALLStudent(){
        String sql ="select MaSv, HoTen,Email,SoDT,GioiTinh,DiaChi,Hinh from Students";
        List<Model_Student> list = new ArrayList<>();
        try {
            Connection conn = DB_Connect.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Model_Student st = new Model_Student();
                st.setMASV(rs.getString("MaSV"));
                st.setHoten(rs.getString("HoTen"));
                st.setEmail(rs.getString("Email"));
                st.setSoDT(rs.getString("SoDT"));
                st.setGioitinh(rs.getBoolean("GioiTinh"));
                st.setDiachi(rs.getString("DiaChi"));
                st.setHinh(rs.getString("Hinh"));
                list.add(st);
               
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public int themStudent(Model_Student st){
        String sql = "insert into Students(MaSv, HoTen,Email,SoDT,GioiTinh,DiaChi,Hinh)values(?,?,?,?,?,?,?)";
        try {
            Connection conn = DB_Connect.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, st.getMASV());
            ps.setString(2, st.getHoten());
            ps.setString(3, st.getEmail());
            ps.setString(4, st.getSoDT());
            ps.setBoolean(5, st.isGioitinh());
            ps.setString(6, st.getDiachi());
            ps.setString(7, st.getHinh());
            int x = ps.executeUpdate();
            return x;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    
     public int xoaStudent(Model_Student st){
        String sql = "delete from Students where MaSV = ?";
                      
        try {
            Connection conn = DB_Connect.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, st.getMASV());
            int x = ps.executeUpdate();
            return x;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
     
       public int updateStudent(Model_Student st){
        String sql = "update Students set HoTen = ?,Email = ?,SoDT =?,GioiTinh=?,DiaChi=?,Hinh=? where MaSV = ? ";
        try {
            Connection conn = DB_Connect.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, st.getHoten());
            ps.setString(2, st.getEmail());
            ps.setString(3, st.getSoDT());
            ps.setBoolean(4, st.isGioitinh());
            ps.setString(5, st.getDiachi());
            ps.setString(6, st.getHinh());
            ps.setString(7, st.getMASV());
            int x = ps.executeUpdate();
            return x;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    
       
       //quan li diem
       public List<Model_Grade> getTop3(){
            List <Model_Grade > list = new ArrayList<>();
            String sql = "select  Grade.MaSv, HoTen, TiengAnh,TinHoc,GDTC from Grade join Students on Grade.MaSv = Students.MaSv ";
    
           try {
            Connection conn = DB_Connect.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String MaSv;
                String Hoten;
                float TiengAnh;
                float TinHoc;
                float GDTC;
                
                MaSv = rs.getString(1);
                Hoten = rs.getString(2);
                TiengAnh= rs.getFloat(3);
                TinHoc = rs.getFloat(4);
                GDTC = rs.getFloat(5);
                Model_Grade g = new Model_Grade(MaSv, Hoten, TiengAnh, TinHoc, GDTC);
                list.add(g);
                
            }
            return list;
           } catch (Exception e) {
                  System.out.println(e);
                  return null;
           }
        
           
      }
       
       public Model_Grade timBangMa(String Ma){
            Model_Grade g = new Model_Grade();
          String sql = "select Grade.MaSv, HoTen, TiengAnh,TinHoc,GDTC from Grade join Students on Grade.MaSv = Students.MaSv where Grade.MaSv = ?";
         
           try {
            Connection conn = DB_Connect.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 
                 String MASV = rs.getString("MaSv");
                 String HoTen = rs.getString("HoTen");
                 float TiengAnh = rs.getFloat("TiengAnh");
                 float TinHoc = rs.getFloat("TinHoc");
                 float GDTC = rs.getFloat("GDTC");              
            }
              return g;
           } catch (Exception e) {
                  System.out.println(e);
                  return null;
           }
           
       }
        public Model_Student diemA(String Ma){
             Model_Student g = null;
            String sql = "select MaSv, HoTen,Email,SoDT,GioiTinh,DiaChi,Hinh from Students where MaSv = ?";
         
           try {
            Connection conn = DB_Connect.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, Ma);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               String MASV = rs.getString("MaSv");
               String HoTen = rs.getString("HoTen");
               String Email = rs.getString("Email");
               int SoDT = rs.getInt("SoDT");
               boolean GioiTinh = rs.getBoolean("GioiTinh");
               String DiaChi = rs.getString("DiaChi");
               String Hinh = rs.getString("Hinh");
               g = new Model_Student(MASV, HoTen, Email, sql, GioiTinh, DiaChi, Hinh);
                
            }
            return g;
           } catch (Exception e) {
                  System.out.println(e);
                  return null;
           }
           
       }
       
       
      public int themDiem(Model_Grade g){
           String sql = "insert into Grade (MaSv,TiengAnh,TinHoc,GDTC) values(?,?,?,?)";
         
           try {
            Connection conn = DB_Connect.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            
            ps.setString(1, g.getMASV());
            ps.setFloat(2, g.getTiengAnh());
            ps.setFloat(3, g.getTinHoc());
            ps.setFloat(4, g.getGDTC());
            return ps.executeUpdate();
           
           } catch (Exception e) {
                  System.out.println(e);
                  return 0;
           }
      } 
       
       
      public int xoadiem(Model_Grade g){
          String sql = "delete from Grade where MaSv = ?";
           try {
            Connection conn = DB_Connect.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1,g.getMASV());
            return ps.executeUpdate();
           
           } catch (Exception e) {
                  System.out.println(e);
                  return 0;
           }
      }
      
      public int xoadiemtheoma(String Ma){
          String sql = "delete from Grade where MaSv = ?";
           try {
            Connection conn = DB_Connect.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1,Ma);
            return ps.executeUpdate();
           
           } catch (Exception e) {
                  System.out.println(e);
                  return 0;
           }
      }
      
      public int suadiem(Model_Grade g){
           String sql = "update Grade set TiengAnh = ?,TinHoc = ?,GDTC = ?";
         
           try {
            Connection conn = DB_Connect.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setFloat(1, g.getTiengAnh());
            ps.setFloat(2, g.getTinHoc());
            ps.setFloat(3, g.getGDTC());
            return ps.executeUpdate();
           
           } catch (Exception e) {
                  System.out.println(e);
                  return 0;
           }
      } 
}
