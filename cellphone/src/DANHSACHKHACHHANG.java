
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DANHSACHKHACHHANG {
    private ArrayList<KHACHHANG> arrkh = new ArrayList<KHACHHANG>();
    Scanner sc = new Scanner(System.in);
    kiemtra kt = new kiemtra();

    public ArrayList<KHACHHANG> getArray() {
        return arrkh;
    }

    public void XuatDanhSachKH() {
        if (arrkh != null) {
            System.out.println(
                    "===============================================================================================");
            System.out.printf("%-20s%-25s%-15s%-20s\n", "MA KHACH HANG", "HO TEN", "NAM SINH", "SO DIEN THOAI");
            System.out.println(
                    "===============================================================================================");

            for (KHACHHANG obj : arrkh) {
                System.out.println(obj.XuatKhachHang());
                System.out.println(
                        "-----------------------------------------------------------------------------------------------");
            }
        } else {
            System.out.println("Danh sach rong ,vui long nhap danh sach !");

        }
    }

    public void ThemKhachHang() {
        KHACHHANG a = new KHACHHANG();
        a.NhapKhachHang();
        arrkh.add(a);

    }

    public void ThemKhachHangDangKi(String makh) throws IOException {
        KHACHHANG a = new KHACHHANG();
        a.NhapKhachHang(makh);
        arrkh.add(a);
        this.ghiFile();
    }

    public KHACHHANG TimKiemKhachHangTheoMaKH(String makh) {
        KHACHHANG kh = null;
        for (KHACHHANG obj : arrkh) {
            if (obj.getMakh().equalsIgnoreCase(makh)) {
                kh = obj;
                break;
            }
        }
        return kh;
    }

    public void TimKiemKhachHang() {
        System.out.print("Nhap ma khach hang can tim: ");
        String makh = kt.KiemTraNhapMa();
        KHACHHANG kh = null;
        kh = TimKiemKhachHangTheoMaKH(makh);
        if (kh != null)
            kh.XuatKhachHang_1();
        else
            System.out.println("Khong tim thay khach hang !");
    }

    public void XoaKhachHang() {
        System.out.print("Nhap ma khach hang can xoa: ");
        String makh = kt.KiemTraNhapMa();
        KHACHHANG nv = null;
        nv = TimKiemKhachHangTheoMaKH(makh);
        if (nv != null) {
            for (KHACHHANG obj : arrkh) {
                if (obj == nv) {
                    arrkh.remove(obj);
                    System.out.println("Xoa thanh cong khach hang!");
                    break;
                }
            }
        } else
            System.out.println("Khong tim thay khach hang !");
    }

    public void SuaKhachHang() {
        System.out.print("Nhap ma khach hang can sua: ");
        String manv = sc.nextLine();
        KHACHHANG nv = null;
        nv = TimKiemKhachHangTheoMaKH(manv);
        if (nv != null) {
            for (KHACHHANG obj : arrkh) {
                if (obj == nv) {
                    while (true) {
                        System.out.println("\n");
                        System.out.println("--------------------------------");
                        System.out.println("======    SUA THONG TIN   ======");
                        System.out.println("--------------------------------");
                        System.out.println("1. Sua ma khach hang");
                        System.out.println("2. Sua ho ten");
                        System.out.println("3. Sua nam sinh");
                        System.out.println("4. Sua so dien thoai");
                        System.out.println("5. Thoat");
                        System.out.println("--------------------------------");
                        ;
                        System.out.print("Chon: ");
                        String key = sc.nextLine();
                        if (Integer.parseInt(key) < 1 || Integer.parseInt(key) > 5)
                            System.out.println("Vui long chon so tu 1 den 5 !");

                        else {
                            switch (key) {
                                case "1":
                                    System.out.print("Nhap ma khach hang moi: ");
                                    String ma = kt.KiemTraNhapMa();
                                    obj.setMakh(ma);
                                    break;
                                case "2":
                                    System.out.print("Nhap ho ten khach hang moi: ");
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
                                    break;
                            }
                        }
                        if (Integer.parseInt(key) == 5)
                            break;

                    }
                }
            }
        } else
            System.out.println("Khong tim thay khach hang !");
    }

    public void MenuDanhSachKhachHang() throws IOException {
        docfile();
        while (true) {
            System.out.println("\n");
            System.out.println("------------------------------------");
            System.out.println("==========    * MENU *    ==========");
            System.out.println("------------------------------------");
            System.out.println("1. Them khach hang");
            System.out.println("2. Xoa khach hang");
            System.out.println("3. Tim kiem khach hang");
            System.out.println("4. Sua thong tin khach hang");
            System.out.println("5. Xuat danh sach khach hang");
            System.out.println("6. Thoat");
            System.out.println("------------------------------------");
            System.out.print("Chon: ");
            String key = sc.nextLine();

            if (Integer.parseInt(key) < 1 || Integer.parseInt(key) > 6)
                System.out.println("Vui long chon so tu 1 den 6 !");
            else {
                switch (key) {
                    case "1":
                        ThemKhachHang();
                        break;
                    case "2":
                        XoaKhachHang();
                        break;
                    case "3":
                        TimKiemKhachHang();
                        break;
                    case "4":
                        SuaKhachHang();
                        break;
                    case "5":
                        XuatDanhSachKH();
                        break;
                }
            }
            if (Integer.parseInt(key) == 6) {
                ghiFile();
                break;
            }
        }
    }

    public void ghiFile() {
        FileOutputStream f = null;
        try {
            f = new FileOutputStream("danhsachkhachhang.txt", false);
            for (KHACHHANG obj : arrkh) {
                String line = obj.getFileLine();
                byte[] b = line.getBytes("utf8");
                f.write(b);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DANHSACHKHACHHANG.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DANHSACHKHACHHANG.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DANHSACHKHACHHANG.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (Exception ex) {
                    Logger.getLogger(DANHSACHKHACHHANG.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void docfile() throws IOException {
        FileInputStream f = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            f = new FileInputStream("danhsachkhachhang.txt");
            reader = new InputStreamReader(f, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty())
                    continue;
                KHACHHANG kh = new KHACHHANG();
                kh.parseKhachHang(line);
                arrkh.add(kh);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DANHSACHNHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException ex) {
                    Logger.getLogger(DANHSACHNHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(DANHSACHNHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(DANHSACHNHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        DANHSACHKHACHHANG list = new DANHSACHKHACHHANG();
        list.MenuDanhSachKhachHang();
    }
}
