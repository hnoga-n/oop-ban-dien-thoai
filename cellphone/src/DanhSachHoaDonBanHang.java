
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachHoaDonBanHang {
    Scanner sc = new Scanner(System.in);
    private static final String NULL = null;
    private ArrayList<HoaDonBanHang> danhSach;

    public DanhSachHoaDonBanHang() {
        this.danhSach = new ArrayList<HoaDonBanHang>();
    }

    public DanhSachHoaDonBanHang(ArrayList<HoaDonBanHang> danhSach) {
        this.danhSach = danhSach;
    }

    // thêm
    public void them(HoaDonBanHang hd) {
        this.danhSach.add(hd);

    }

    // xóa
    public void xoa(String mahd) {
        HoaDonBanHang hdbh = new HoaDonBanHang();
        for (HoaDonBanHang hoaDonBanHang : danhSach) {
            if (hoaDonBanHang.getMahd().equals(mahd)) {
                hdbh = hoaDonBanHang;
            }

        }
        this.danhSach.remove(hdbh);
    }

    // sửa
    public void sua(String mahd) {
        for (HoaDonBanHang hoaDon : danhSach) {
            if (hoaDon.getMahd().equals(mahd)) {
                int luaChon = 0;
                do {
                    System.out.println("MENU ----------");
                    System.out.println("Lua chon: ");
                    System.out.println(
                            "1. Sua ma hoa don.\n"
                                    + "2. Sua ma tai khoan.\n"
                                    + "3. Sua ma khach hang.\n"
                                    + "4. Sua ma nhan vien.\n"
                                    + "5. Sua diem khach hang.\n"
                                    + "6. Sua danh sach san pham.\n"
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
                        System.out.println("Nhap ma khach hang moi: ");
                        String newMaKh = sc.nextLine();
                        hoaDon.setMakh(newMaKh);
                    }
                    if (luaChon == 4) {
                        System.out.println("Nhap ma nhan vien moi: ");
                        String newMaNv = sc.nextLine();
                        hoaDon.setmanv(newMaNv);
                    }
                    if (luaChon == 5) {
                        System.out.println("Nhap diem khach hang moi: ");
                        int newDiem = sc.nextInt();
                        hoaDon.setDiemkh(newDiem);
                    }
                    if (luaChon == 6) {
                        System.out.println("Nhap ma san pham can sua: ");
                        String masp = sc.nextLine();
                        hoaDon.getdssp().sua(masp);
                    }
                } while (luaChon != 0);

            }
        }
    }

    // xuất danh sách hóa đơn
    public void xuatDanhSach() {
        int i = 1;
        for (HoaDonBanHang hoaDonBanHang : danhSach) {
            System.out
                    .println("--------------------------------------------------------------------------------------");
            System.out.println("Hoa don " + i + ": ");
            i = i + 1;
            hoaDonBanHang.xuatHoaDonBanHang();
            System.out.println("--------------------------------------------------------------------------------------");
        }
    }

    // ghi vào file
    public void ghiDuLieuVaoFile() throws IOException {
        File file = new File("DanhSachHoaDonBanHang.txt");
        try {
            FileWriter fw = new FileWriter(file);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                for (HoaDonBanHang hoaDonBanHang : danhSach) {
                    bw.write(hoaDonBanHang.dinhDangGhiVaoFile()
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

    // đọc file
    public void docDuLieuTuFile() throws IOException {
        File file = new File("DanhSachHoaDonBanHang.txt");
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
                        String makh = line;
                        line = br.readLine();
                        int diemkh = Integer.parseInt(line);
                        line = br.readLine();
                        String matk = line;
                        line = br.readLine();
                        String manv = line;
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

                        HoaDonBanHang hdbh = new HoaDonBanHang(mahd, matk, ngay, dssp, makh, manv, diemkh);
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
        File file = new File("DanhSachHoaDonBanHang.txt");
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
                        String makh = line;
                        line = br.readLine();
                        int diemkh = Integer.parseInt(line);
                        line = br.readLine();
                        String matk = line;
                        line = br.readLine();
                        String manv = line;
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

                        HoaDonBanHang hdbh = new HoaDonBanHang(mahd, matk, ngay, dssp, makh, manv, diemkh);
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
                for (HoaDonBanHang hoaDonBanHang : danhSach) {
                    System.out.println(
                            "--------------------------------------------------------------------------------------");
                    System.out.println("Hoa don " + i + ": ");
                    i = i + 1;
                    hoaDonBanHang.xuatHoaDonBanHang();
                    System.out.println("--------------------------------------------------------------------------------------");
                }
            } else if (luaChon0 == 2) {
                System.out.println("Nhap ma hoa don: ");
                String Mahd = sc.nextLine();
                System.out.println("Nhap ma khach hang: ");
                String Makh = sc.nextLine();
                System.out.println("Nhap ma tai khoan: ");
                String Matk = sc.nextLine();
                System.out.println("Nhap ma nhan vien: ");
                String Manv = sc.nextLine();
                System.out.println("Nhap diem khach hang: ");
                int Diemkh = sc.nextInt();
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
                HoaDonBanHang hdbh = new HoaDonBanHang(Mahd, Matk, ngay, dssp, Makh, Manv, Diemkh);
                this.danhSach.add(hdbh);

            } else if (luaChon0 == 3) {
                System.out.println("Nhap ma hoa don muon xoa: ");
                String Mahd = sc.nextLine();
                HoaDonBanHang hdbh = new HoaDonBanHang();
                for (HoaDonBanHang hoaDonBanHang : danhSach) {
                    if (hoaDonBanHang.getMahd().equals(Mahd)) {
                        hdbh = hoaDonBanHang;
                    }

                }
                this.danhSach.remove(hdbh);

            } else if (luaChon0 == 4) {
                System.out.println("Nhap ma hoa don muon sua: ");
                String Mahd = sc.nextLine();
                for (HoaDonBanHang hoaDon : danhSach) {
                    if (hoaDon.getMahd().equals(Mahd)) {
                        int luaChon1 = 0;
                        do {
                            System.out.println("MENU ----------");
                            System.out.println("Lua chon: ");
                            System.out.println(
                                    "1. Sua ma hoa don.\n"
                                            + "2. Sua ma tai khoan.\n"
                                            + "3. Sua ma khach hang.\n"
                                            + "4. Sua ma nhan vien.\n"
                                            + "5. Sua diem khach hang.\n"
                                            + "6. Sua danh sach san pham.\n"
                                            + "0. Thoat.\n");
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
                                System.out.println("Nhap ma khach hang moi: ");
                                String newMaKh = sc.nextLine();
                                hoaDon.setMakh(newMaKh);
                            }
                            if (luaChon1 == 4) {
                                System.out.println("Nhap ma nhan vien moi: ");
                                String newMaNv = sc.nextLine();
                                hoaDon.setmanv(newMaNv);
                            }
                            if (luaChon1 == 5) {
                                System.out.println("Nhap diem khach hang moi: ");
                                int newDiem = sc.nextInt();
                                hoaDon.setDiemkh(newDiem);
                            }
                            if (luaChon1 == 6) {
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
                        for (HoaDonBanHang hoaDonBanHang : danhSach) {
                            bw.write(hoaDonBanHang.dinhDangGhiVaoFile()
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
