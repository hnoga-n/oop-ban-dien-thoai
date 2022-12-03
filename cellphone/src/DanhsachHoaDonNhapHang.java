

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhsachHoaDonNhapHang {
    private static final String NULL = null;
    Scanner sc = new Scanner(System.in);
    private ArrayList<HoaDonNhapHang> danhSach;

    public DanhsachHoaDonNhapHang(ArrayList<HoaDonNhapHang> danhSach) {
        this.danhSach = danhSach;
    }

    public DanhsachHoaDonNhapHang() {
        this.danhSach = new ArrayList<HoaDonNhapHang>();
    }

    // thêm
    public void them(HoaDonNhapHang sp) {
        this.danhSach.add(sp);

    }

    // xóa
    public void xoa(String mahd) {
        HoaDonNhapHang hdbh = new HoaDonNhapHang();
        for (HoaDonNhapHang hoaDonNhapHang : danhSach) {
            if (hoaDonNhapHang.getMahd().equals(mahd)) {
                hdbh = hoaDonNhapHang;
            }
        }
        this.danhSach.remove(hdbh);
    }

    // sửa
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
                        System.out.println("Nhap ma hoa don moi: ");
                        String newMaHd = sc.nextLine();
                        hoaDon.setMahd(newMaHd);
                    }
                    if (luaChon == 2) {
                        System.out.println("Nhap ma tai khoan moi: ");
                        String newMaTk = sc.nextLine();
                        hoaDon.setmatk(newMaTk);
                    }
                    if (luaChon == 3) {
                        System.out.println("Nhap ma doi tac moi: ");
                        String newMaDt = sc.nextLine();
                        hoaDon.setMadt(newMaDt);
                    }
                    if (luaChon == 4) {
                        System.out.println("Nhap diem doi tac moi: ");
                        int newDiem = sc.nextInt();
                        hoaDon.setDiemdt(newDiem);
                    }
                    if (luaChon == 5) {
                        System.out.println("Nhap ma san pham can sua: ");
                        String masp = sc.nextLine();
                        hoaDon.getdssp().sua(masp);
                    }
                } while (luaChon != 0);
            }
        }
    }

    // xuất danh sách hóa dơn
    public void xuatDanhSach() {
        int i = 1;
        for (HoaDonNhapHang hoaDonNhapHang : danhSach) {
            System.out
                    .println("--------------------------------------------------------------------------------------");
            System.out.println("Hoa don " + i + ": ");
            i = i + 1;
            hoaDonNhapHang.xuatHoaDonNhapHang();
            System.out.println("--------------------------------------------------------------------------------------");
        }
    }
    // ghi vào file
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
    // dọc file
    public void docDuLieuTuFile() throws IOException {
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
                            SanPham sp = new SanPham(txt1[0], txt1[1], txt1[2], gia, txt1[4], null);
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
                            SanPham sp = new SanPham(txt1[0], txt1[1], txt1[2], gia, txt1[4], null);
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

        int luaChon0 = -1;
        do {
            System.out.println("MENU ----------");
            System.out.println("Lua chon: ");
            System.out.println(
                    "1. In danh sach hoa don nhap hang.\n"
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
                            "--------------------------------------------------------------------------------------");
                    System.out.println("Hoa don " + i + ": ");
                    i = i + 1;
                    hoaDonNhapHang.xuatHoaDonNhapHang();
                    System.out.println("--------------------------------------------------------------------------------------");
                }
            } else if (luaChon0 == 2) {
                System.out.println("Nhap ma hoa donn: ");
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
                System.out.println("Nhap so luong san pham: ");
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
                    SanPham sp = new SanPham(Masp, Tensp, Hangsp, gia, ThoiGianBaoHanh);
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
                                            + "0. Thoát.\n");
                            luaChon1 = sc.nextInt();
                            sc.nextLine();
                            if (luaChon1 == 1) {
                                System.out.println("Nhap ma hoa don moi: ");
                                String newMaHd = sc.nextLine();
                                hoaDon.setMahd(newMaHd);
                            }
                            if (luaChon1 == 2) {
                                System.out.println("Nhap ma tai khoan moi: ");
                                String newMaTk = sc.nextLine();
                                hoaDon.setmatk(newMaTk);
                            }
                            if (luaChon1 == 3) {
                                System.out.println("Nhap ma doi tac moi: ");
                                String newMaDt = sc.nextLine();
                                hoaDon.setMadt(newMaDt);
                            }
                            if (luaChon1 == 4) {
                                System.out.println("Nhap diem khach hang moi: ");
                                int newDiem = sc.nextInt();
                                hoaDon.setDiemdt(newDiem);
                            }
                            if (luaChon1 == 5) {
                                System.out.println("Nhap ma san pham can sua: ");
                                String masp = sc.nextLine();
                                hoaDon.getdssp().sua(masp);
                            }
                        } while (luaChon1 != 0);
                    }
                }

            } else if (luaChon0 == 0) {
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
                break;

            }
        } while (true);
    }
}
