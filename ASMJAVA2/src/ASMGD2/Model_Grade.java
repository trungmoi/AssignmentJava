/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASMGD2;

/**
 *
 * @author mxtru
 */
public class Model_Grade {
      private int ID;
      private String MASV;
      private String HoTen;
      private float TiengAnh;
      private float TinHoc;
      private float GDTC;

    public Model_Grade() {
    }

    public Model_Grade(String MASV, String HoTen, float TiengAnh, float TinHoc, float GDTC) {
        this.MASV = MASV;
        this.HoTen = HoTen;
        this.TiengAnh = TiengAnh;
        this.TinHoc = TinHoc;
        this.GDTC = GDTC;
    }

    public Model_Grade(int ID, String MASV, String HoTen, float TiengAnh, float TinHoc, float GDTC) {
        this.ID = ID;
        this.MASV = MASV;
        this.HoTen = HoTen;
        this.TiengAnh = TiengAnh;
        this.TinHoc = TinHoc;
        this.GDTC = GDTC;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMASV() {
        return MASV;
    }

    public void setMASV(String MASV) {
        this.MASV = MASV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public float getTiengAnh() {
        return TiengAnh;
    }

    public void setTiengAnh(float TiengAnh) {
        this.TiengAnh = TiengAnh;
    }

    public float getTinHoc() {
        return TinHoc;
    }

    public void setTinHoc(float TinHoc) {
        this.TinHoc = TinHoc;
    }

    public float getGDTC() {
        return GDTC;
    }

    public void setGDTC(float GDTC) {
        this.GDTC = GDTC;
    }

   

    
      public float getDiemTB(){
          return(TiengAnh+TinHoc+GDTC)/3;
      }
      
      public Object[]toRowTable(){
      return new Object[]{
          MASV,HoTen,TiengAnh,TinHoc,GDTC,getDiemTB()   
     };
   }
}


