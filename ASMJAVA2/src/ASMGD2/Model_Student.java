/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASMGD2;

/**
 *
 * @author mxtru
 */
public class Model_Student {
    	private String MASV; 
	private String Hoten; 
	private String Email;
	private String SoDT;
 	private boolean  Gioitinh;
	private String Diachi;
        private String Hinh;

    public Model_Student() {
    }

    public Model_Student(String MASV, String Hoten, String Email, String SoDT, boolean Gioitinh, String Diachi, String Hinh) {
        this.MASV = MASV;
        this.Hoten = Hoten;
        this.Email = Email;
        this.SoDT = SoDT;
        this.Gioitinh = Gioitinh;
        this.Diachi = Diachi;
        this.Hinh = Hinh;
    }

    public String getMASV() {
        return MASV;
    }

    public void setMASV(String MASV) {
        this.MASV = MASV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public boolean isGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(boolean Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

  
        
        
        public Object[] toRowTable(){
            return new Object[]{
                MASV,Hoten,Email,SoDT,isGioitinh() ?"Nam":"Nu",Diachi,Hinh
            };
        }
}
