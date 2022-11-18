
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DANHSACHNHANVIEN {
    private ArrayList<NHANVIEN> arrnv = new ArrayList<NHANVIEN>();
    Scanner sc = new Scanner(System.in);
    kiemtra kt = new kiemtra();


    public void XuatDanhSachNV() {
        System.out.println("============================================================================================");
        System.out.printf("%-20s%-25s%-15s%-20s%-20s\n","MA NHAN VIEN","HO TEN","NAM SINH","SO DIEN THOAI","CHUC VU");
        System.out.println("============================================================================================");
        for(NHANVIEN obj : arrnv) {
            System.out.println(obj.XuatNhanVien());
            System.out.println("--------------------------------------------------------------------------------------------");
        }      
    public ArrayList<NHANVIEN> getArray() {
        return arrnv;
    

    }

    public void ThemNhanVien() {
        NHANVIEN a = new NHANVIEN();
        a.NhapNhanVien();
        arrnv.add(a);

    }

    public NHANVIEN TimKiemNhanVienTheoMaNV(String manv) {
        NHANVIEN nv = null;
        for (NHANVIEN obj : arrnv) {
            if (obj.getManv().equalsIgnoreCase(manv)) {
                nv = obj;
                return nv;
            }
        }
        return null;
    }

    public void TimKiemNhanVien() {
        System.out.print("Nhap ma nhan vien can tim: ");
        String manv = kt.KiemTraNhapMa();
        NHANVIEN nv = null;
        nv = TimKiemNhanVienTheoMaNV(manv);
        if (nv != null)
            nv.XuatNhanVien_1();
        else
            System.out.println("Khong tim thay nhan vien !");
    }

    public void XoaNhanVien() {
        System.out.print("Nhap ma nhan vien can xoa: ");
        String manv = kt.KiemTraNhapMa();
        NHANVIEN nv = null;
        nv = TimKiemNhanVienTheoMaNV(manv);
        if (nv != null) {
            for (NHANVIEN obj : arrnv) {
                if (obj == nv) {
                    arrnv.remove(obj);
                    System.out.println("Xoa thanh cong nhan vien!");
                    break;
                }
            }
        } else
            System.out.println("Khong tim thay nhan vien !");
    }

    public void SuaNhanVien() {
        System.out.print("Nhap ma nhan vien can sua: ");
        String manv = kt.KiemTraNhapMa();
        NHANVIEN nv = null;
        nv = TimKiemNhanVienTheoMaNV(manv);
        if (nv != null) {
            for (NHANVIEN obj : arrnv) {
                if (obj == nv) {
                    while (true) {
                        System.out.println("\n");
                        System.out.println("--------------------------------");
                        System.out.println("======    SUA THONG TIN   ======");
                        System.out.println("--------------------------------");
                        System.out.println("1. Sua ma nhan vien");
                        System.out.println("2. Sua ho ten");
                        System.out.println("3. Sua nam sinh");
                        System.out.println("4. Sua so dien thoai");
                        System.out.println("5. Sua chuc vu");
                        System.out.println("6. Thoat");
                        System.out.println("--------------------------------");
                        ;
                        System.out.print("Chon: ");
                        String key = sc.nextLine();
                        if (Integer.parseInt(key) < 1 || Integer.parseInt(key) > 6)
                            System.out.println("Vui long chon so tu 1 den 6 !");
                        else {
                            switch (key) {
                                case "1":
                                    System.out.print("Nhap ma nhan vien moi: ");
                                    String ma = kt.KiemTraNhapMa();
                                    obj.setManv(ma);
                                    break;
                                case "2":
                                    System.out.print("Nhap ho ten nhan vien moi: ");
                                    String hoten = sc.nextLine();
                                    obj.setHoten(hoten);
                                    break;
                                case "3":
                                    System.out.print("Nhap nam sinh moi: ");
                                    String namsinh = kt.KiemTraNamSinh();
                                    obj.setNamsinh(namsinh);
                                    break;
                                case "4":
                                    System.out.print("Nhap so dien thoai moi: ");
                                    String sdt = kt.KiemTraNhapSDT();
                                    obj.setSdt(sdt);
                                    break;
                                case "5":
                                    System.out.print("Nhap chuc vu moi: ");
                                    String chucvu = kt.KiemTraNhapChucVu();
                                    obj.setChucvu(chucvu);
                                    break;
                            }
                        }
                        if (Integer.parseInt(key) == 6)
                            break;
                    }
                }
            }
        } else
            System.out.println("Khong tim thay nhan vien !");
    }

    public void MenuDanhSachNhanVien(DANHSACHNHANVIEN list) throws IOException {
        list.docfile();
        while(true) {

            System.out.println("\n");
            System.out.println("------------------------------------");
            System.out.println("==========    * MENU *    ==========");
            System.out.println("------------------------------------");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Xoa nhan vien");
            System.out.println("3. Tim kiem nhan vien");
            System.out.println("4. Sua thong tin nhan vien");
            System.out.println("5. Xuat danh sach nhan vien");
            System.out.println("6. Thoat");
            System.out.println("------------------------------------");
            System.out.print("Chon: ");
            String key = sc.nextLine();
            if(Integer.parseInt(key) <1 || Integer.parseInt(key) > 6)
                System.out.println("Vui long chon so tu 1 den 6 !");
            else {
                switch (key) {
                case "1":
                   list.ThemNhanVien();
                   break;
                case "2":
                   list.XoaNhanVien();;
                   break;
                case "3":
                   list.TimKiemNhanVien();
                   break;
                case "4":
                   list.SuaNhanVien();;
                   break;
                case "5":
                    list.XuatDanhSachNV();;
                    break;
                }
            }
            if(Integer.parseInt(key) == 6) {
                list.ghiFile();
                break;
            } 
        }
    }
    
    public void ghiFile() {
        FileOutputStream f = null;
        try {
            f = new FileOutputStream("danhsachnhanvien.txt",false);
            for(NHANVIEN obj : arrnv) {
                String line = obj.getFileLine();
                byte[] b = line.getBytes("utf8");
                f.write(b);
            }
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(DANHSACHNHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DANHSACHNHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(DANHSACHNHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if(f != null) {
                try {
                    f.close();
                } catch (Exception ex) {
                    Logger.getLogger(DANHSACHNHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void docfile() throws IOException{   
        FileInputStream f = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            f = new FileInputStream("danhsachnhanvien.txt");
            reader = new InputStreamReader(f,StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if(line.isEmpty()) 
                    continue;
                NHANVIEN nv = new NHANVIEN();
                nv.parseNhanVien(line);
                arrnv.add(nv);
            }
        }
        catch(FileNotFoundException ex) {
            Logger.getLogger(DANHSACHNHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if(f != null) {
                try {
                     f.close();
                } catch (IOException ex) {
                    Logger.getLogger(DANHSACHNHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(reader != null) {
                try {
                   reader.close();
               } catch (IOException ex) {
                   Logger.getLogger(DANHSACHNHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
               } catch (IOException ex) {
                   Logger.getLogger(DANHSACHNHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
        }
    }
    
    public static void main(String[] args) throws IOException{


        DANHSACHNHANVIEN list = new DANHSACHNHANVIEN();
        NHANVIEN a = new NHANVIEN("123", "hha", "1996", "096", "admin");
        NHANVIEN b = new NHANVIEN("124", "hha", "1996", "096", "admin");
        NHANVIEN c = new NHANVIEN("125", "hha", "1996", "096", "admin");
        list.arrnv.add(a);
        list.arrnv.add(b);
        list.arrnv.add(c);
        list.XuatDanhSachNV();
        list.XoaNhanVien();
        list.XuatDanhSachNV();

    }
}
