

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DanhsachHoaDonNhapHang {
    private static final String NULL = null;
    Scanner sc = new Scanner(System.in);
    private ArrayList<HoaDonNhapHang> danhSach;
    DecimalFormat formatter = new DecimalFormat("###,###,###");

    public DanhsachHoaDonNhapHang(ArrayList<HoaDonNhapHang> danhSach) {
        this.danhSach = danhSach;
    }

    public DanhsachHoaDonNhapHang() {
        this.danhSach = new ArrayList<HoaDonNhapHang>();
    }

    public ArrayList<HoaDonNhapHang> getList() {
        return this.danhSach;
    }

    // Them
    public void them(HoaDonNhapHang sp) {
        this.danhSach.add(sp);

    }

    // Xoa
    public void xoa(String mahd) {
        HoaDonNhapHang hdbh = new HoaDonNhapHang();
        for (HoaDonNhapHang hoaDonNhapHang : danhSach) {
            if (hoaDonNhapHang.getMahd().equals(mahd)) {
                hdbh = hoaDonNhapHang;
            }
        }
        this.danhSach.remove(hdbh);
    }

    // Sua
    public void sua(String mahd) {
        for (HoaDonNhapHang hoaDon : danhSach) {
            if (hoaDon.getMahd().equals(mahd)) {
                int luaChon = 0;
                do {
                    System.out.println("MENU ----------");
                    System.out.println("Lua chon: ");
                    System.out.println(
                            "1. Sua ma hoa don.\n"
                                    + "2. Sua ma tai khoan.\n"
                                    + "3. Sua ma doi tac.\n"
                                    + "4. Sua diem doi tac.\n"
                                    + "5. Sua danh sach san pham.\n"
                                    + "0. Thoat.\n");
                    luaChon = sc.nextInt();
                    sc.nextLine();
                    if (luaChon == 1) {
                        hoaDon.setMahd();
                    }
                    if (luaChon == 2) {
                        hoaDon.setmatk();
                    }
                    if (luaChon == 3) {
                        hoaDon.setMadt();
                    }
                    if (luaChon == 4) {
                        hoaDon.setDiemdt();
                    }
                    if (luaChon == 5) {
                        System.out.println("Nhap ma san pham c???n Sua: ");
                        String masp = sc.nextLine();
                        hoaDon.getdssp().sua(masp);
                    }
                } while (luaChon != 0);
            }
        }
    }

    // xu???t danh sach hoa don
    public void xuatDanhSach() {
        int i = 1;
        for (HoaDonNhapHang hoaDonNhapHang : danhSach) {
            System.out
                    .println("--------------------------------------------------");
            System.out.println("Hoa don " + i + ": ");
            i = i + 1;
            hoaDonNhapHang.xuatHoaDonNhapHang();
            System.out.println("--------------------------------------------------");
        }
    }
    // ghi v??o file
    public void ghiDuLieuVaoFile() throws IOException {
        File file = new File("DanhSachHoaDonNhapHang.txt");
        try {
            FileWriter fw = new FileWriter(file);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                for (HoaDonNhapHang hoaDonNhapHang : danhSach) {
                    bw.write(hoaDonNhapHang.dinhDangGhiVaoFile()
                            + "\n--------------------------------------------------------");
                    bw.newLine();
                }
                bw.flush();
                bw.close();
            }
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

    }
    // ?????c file
    public void docDuLieuTuFile() throws IOException {
        this.danhSach.clear();
        File file = new File("DanhSachHoaDonNhapHang.txt");
        try {

            FileReader fr = new FileReader(file);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = "";

                while (line != NULL) {

                    line = br.readLine();
                    if (line == NULL) {
                        break;
                    }
                    while (!line.equals("--------------------------------------------------------")) {
                        String mahd = line;
                        line = br.readLine();
                        String madt = line;
                        line = br.readLine();
                        int diemdt = Integer.parseInt(line);
                        line = br.readLine();
                        String matk = line;
                        line = br.readLine();
                        String txt[] = line.split("/");
                        int day = Integer.parseInt(txt[0]);
                        int month = Integer.parseInt(txt[1]);
                        int year = Integer.parseInt(txt[2]);
                        Ngay ngay = new Ngay(day, month, year);
                        QuanLiSanPham dssp = new QuanLiSanPham();
                        line = br.readLine();
                        line = br.readLine();
                        while (!line.equals("--------------------------------------------------------")) {
                            String txt1[] = line.split(",");
                            int gia = Integer.parseInt(txt1[3]);
                            int soLuong = Integer.parseInt(txt1[4]);
                            SanPham sp = new SanPham(txt1[0], txt1[1], txt1[2], gia, txt1[5],soLuong, null);
                            dssp.them(sp);
                            line = br.readLine();
                        }

                        HoaDonNhapHang hdbh = new HoaDonNhapHang(mahd, matk, ngay, dssp, madt, diemdt);
                        this.danhSach.add(hdbh);
                    }
                }
                br.close();
            } catch (FileNotFoundException e) {
                throw e;
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            fr.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    // Menu
    public void Menu() throws IOException {
        int luaChon0 = -1;
        do {
            System.out.println("MENU ----------");
            System.out.println("Lua chon: ");
            System.out.println(
                    "1. In danh sach hoa don ban hang.\n"
                            + "2. Them hoa don.\n"
                            + "3. Xoa hoa don.\n"
                            + "4. Sua hoa don.\n"
                            + "0. Thoat.\n");
            System.out.println("Vui long nhap lua chon cua ban: ");
            luaChon0 = sc.nextInt();
            sc.nextLine();
            if (luaChon0 == 1) {
                int i = 1;
                for (HoaDonNhapHang hoaDonNhapHang : danhSach) {
                    System.out.println(
                            "--------------------------------------------------");
                    System.out.println("Hoa don " + i + ": ");
                    i = i + 1;
                    hoaDonNhapHang.xuatHoaDonNhapHang();
                    System.out.println("--------------------------------------------------");
                }
            } else if (luaChon0 == 2) {
                System.out.println("Nhap ma hoa don: ");
                String Mahd = sc.nextLine();
                System.out.println("Nhap ma doi tac: ");
                String Madt = sc.nextLine();
                System.out.println("Nhap ma tai khoan: ");
                String Matk = sc.nextLine();
                System.out.println("Nhap diem doi tac: ");
                int Diemdt = sc.nextInt();
                sc.nextLine();
                System.out.println("Nhap ngay: ");
                int day = sc.nextInt();
                sc.nextLine();
                System.out.println("Nhap thang: ");
                int month = sc.nextInt();
                sc.nextLine();
                System.out.println("Nhap nam: ");
                int year = sc.nextInt();
                sc.nextLine();
                Ngay ngay = new Ngay(day, month, year);
                System.out.println("Nhap so luong san pham khac nhau: ");
                int sl = sc.nextInt();
                sc.nextLine();
                QuanLiSanPham dssp = new QuanLiSanPham();
                for (int i = 1; i <= sl; i++) {
                    System.out.println("Nhap ma san pham thu " + i + ": ");
                    String Masp = sc.nextLine();
                    System.out.println("Nhap ten san pham: ");
                    String Tensp = sc.nextLine();
                    System.out.println("Nhap hang san pham: ");
                    String Hangsp = sc.nextLine();
                    System.out.println("Nhap gia: ");
                    int gia = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhap thoi gian bao hanh: ");
                    String ThoiGianBaoHanh = sc.nextLine();
                    System.out.println("Nhap so luong: ");
                    int soLuong = sc.nextInt();
                    sc.nextLine();
                    SanPham sp = new SanPham(Masp, Tensp, Hangsp, gia,soLuong, ThoiGianBaoHanh);
                    dssp.them(sp);
                }
                HoaDonNhapHang hdbh = new HoaDonNhapHang(Mahd, Matk, ngay, dssp, Madt, Diemdt);
                this.danhSach.add(hdbh);

            } else if (luaChon0 == 3) {
                System.out.println("Nhap ma hoa don muon xoa: ");
                String Mahd = sc.nextLine();
                HoaDonNhapHang hdbh = new HoaDonNhapHang();
                for (HoaDonNhapHang hoaDonNhapHang : danhSach) {
                    if (hoaDonNhapHang.getMahd().equals(Mahd)) {
                        hdbh = hoaDonNhapHang;
                    }

                }
                this.danhSach.remove(hdbh);

            } else if (luaChon0 == 4) {
                System.out.println("Nhap ma hoa don muon sua: ");
                String Mahd = sc.nextLine();
                for (HoaDonNhapHang hoaDon : danhSach) {
                    if (hoaDon.getMahd().equals(Mahd)) {
                        int luaChon1 = 0;
                        do {
                            System.out.println("MENU ----------");
                            System.out.println("Lua chon: ");
                            System.out.println(
                                    "1. Sua ma hoa don.\n"
                                            + "2. Sua ma tai khoan.\n"
                                            + "3. Sua ma doi tac.\n"
                                            + "4. Sua diem doi tac.\n"
                                            + "5. Sua danh sach san pham.\n"
                                            + "0. Thoat.\n");
                            luaChon1 = sc.nextInt();
                            sc.nextLine();
                            if (luaChon1 == 1) {
                                hoaDon.setMahd();
                            }
                            if (luaChon1 == 2) {
                                hoaDon.setmatk();
                            }
                            if (luaChon1 == 3) {
                                hoaDon.setMadt();
                            }
                            if (luaChon1 == 4) {
                                hoaDon.setDiemdt();
                            }
                            if (luaChon1 == 5) {
                                System.out.println("Nhap ma san pham can Sua: ");
                                String masp = sc.nextLine();
                                hoaDon.getdssp().sua(masp);
                            }
                        } while (luaChon1 != 0);
                    }
                }

            } else if (luaChon0 == 0) {
                this.ghiDuLieuVaoFile();
                break;
            }
        } while (true);
    }

    public void thongKeNhapHang() throws IOException {
        kiemtra kt = new kiemtra();
        docDuLieuTuFile();
        System.out.print("Tu ngay: ");
        String dateform = kt.KiemTraNhapNgay();
        System.out.print("Den ngay: ");
        String dateto = kt.KiemTraNhapNgay();

        boolean existedFlag = false;
        Date date1 = null;
        Date date2 = null;
        Date date3 = null;
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date1 = format.parse(dateform);
            date3 = format.parse(dateto);
        } catch (java.text.ParseException e) {
            // TODO: handle exception
            System.out.println(e);
        }
        if(date1.compareTo(date3) > 0) {
            System.out.println("Nhap sai thu tu ngay!");
        }
        else {
            ArrayList<SanPham> thongKeSp = new ArrayList<SanPham>();
            for (HoaDonNhapHang hd : danhSach) {
                try {
                    date2 = format.parse(hd.getNgay().toString());
                    if (date1.before(date2) && date3.after(date2)) {
                        for (SanPham sp : hd.getdssp().getList()) {
                            for (SanPham spThongKe : thongKeSp) {
                                if (spThongKe.getMasp().equalsIgnoreCase(sp.getMasp())) {
                                    spThongKe.setSoluong_1(spThongKe.getSoluong() + sp.getSoluong());
                                    existedFlag = true;
                                    break;
                                }
                            }
                            if (existedFlag == false) {
                                thongKeSp.add(sp);
                            }
                            existedFlag = false;
                        }
                    }
                } catch (java.text.ParseException e) {
                    // TODO: handle exception
                    System.out.println(e);
                }
            }

            if (thongKeSp.size() <= 0) {
                System.out.println("Khong co san pham nao duoc ban ra trong khoang thoi gian da chon !");
            }
            QuanLiSanPham danhSachThongKe = new QuanLiSanPham(thongKeSp);
            danhSachThongKe.xuatDanhSach();
            System.out.println("Tong chi phi nhap hang: " + formatter.format(danhSachThongKe.tongGia())+" VND");
        }
    }
}
