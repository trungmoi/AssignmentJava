/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASMGD1;

/**
 *
 * @author mxtru
 */
public class Student {
    public String MaSV;
    public String HoTen;
    public double Tienganh;
    public double Tinhoc;
    public double Gdtc;

    public Student() {
    }

    public Student(String MaSV, String HoTen, double Tienganh, double Tinhoc, double Gdtc) {
        this.MaSV = MaSV;
        this.HoTen = HoTen;
        this.Tienganh = Tienganh;
        this.Tinhoc = Tinhoc;
        this.Gdtc = Gdtc;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public double getTienganh() {
        return Tienganh;
    }

    public void setTienganh(double tienganh) {
        this.Tienganh = tienganh;
    }

    public double getTinhoc() {
        return Tinhoc;
    }

    public void setTinhoc(double tinhoc) {
        this.Tinhoc = tinhoc;
    }

    public double getGdtc() {
        return Gdtc;
    }

    public void setGdtc(double Gdtc) {
        this.Gdtc = Gdtc;
    }
      public double getDiemTb(){
        
         return  (getTienganh()+ getTinhoc()+ getGdtc()) / 3;
        }      
       public Object[] toRow(){
        return new Object[]{this.getMaSV(),this.getHoTen(),this.getTienganh(),this.getTinhoc(),this.getGdtc(),this.getDiemTb()};
    }

}
