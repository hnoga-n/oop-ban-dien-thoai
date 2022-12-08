
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public ArrayList<HoaDonBanHang> getArray() {
        return this.danhSach;
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
                    System.out.println("Lựa chọn: ");
                    System.out.println(
                            "1. Sửa mã hóa đơn.\n"
                                    + "2. Sửa mã tài khoản.\n"
                                    + "3. Sửa mã khách hàng.\n"
                                    + "4. Sửa mã nhân viên.\n"
                                    + "5. Sửa điểm khách hàng.\n"
                                    + "6. Sửa danh sách sản phẩm.\n"
                                    + "0. Thoát.\n");
                    luaChon = sc.nextInt();
                    sc.nextLine();
                    if (luaChon == 1) {
                        System.out.println("Nhập mã hóa đơn mới: ");
                        String newMaHd = sc.nextLine();
                        hoaDon.setMahd(newMaHd);
                    }
                    if (luaChon == 2) {
                        System.out.println("Nhập mã tài khoản mới: ");
                        String newMaTk = sc.nextLine();
                        hoaDon.setmatk(newMaTk);
                    }
                    if (luaChon == 3) {
                        System.out.println("Nhập mã khách hàng mới: ");
                        String newMaKh = sc.nextLine();
                        hoaDon.setMakh(newMaKh);
                    }
                    if (luaChon == 4) {
                        System.out.println("Nhập mã nhân viên mới: ");
                        String newMaNv = sc.nextLine();
                        hoaDon.setmanv(newMaNv);
                    }
                    if (luaChon == 5) {
                        System.out.println("Nhập điểm khách hàng mới: ");
                        int newDiem = sc.nextInt();
                        hoaDon.setDiemkh(newDiem);
                    }
                    if (luaChon == 6) {
                        System.out.println("Nhập mã sản phẩm cần sửa: ");
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
                    .println(
                            "-------------------------------------------------------------------------------");
            System.out.println("Hóa đơn " + i + ": ");
            i = i + 1;
            hoaDonBanHang.xuatHoaDonBanHang();
            System.out.println(
                    "--------------------------------------------------------------------------------------");
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
        this.danhSach.clear();
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
                            int soluong = Integer.parseInt(txt1[4]);
                            SanPham sp = new SanPham(txt1[0], txt1[1], txt1[2], gia, txt1[5], soluong, null);
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
        this.danhSach.clear();
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
                            int soLuong = Integer.parseInt(txt1[4]);
                            SanPham sp = new SanPham(txt1[0], txt1[1], txt1[2], gia, txt1[5], soLuong, null);
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
            System.out.println("Lựa chọn: ");
            System.out.println(
                    "1. In danh sách hóa đơn bán hàng.\n"
                            + "2. Thêm hóa đơn.\n"
                            + "3. Xóa hóa đơn.\n"
                            + "4. Sửa hóa đơn.\n"
                            + "0. Thoát.\n");
            System.out.println("Vui lòng nhập lựa chọn của bạn: ");
            luaChon0 = sc.nextInt();
            sc.nextLine();
            if (luaChon0 == 1) {
                int i = 1;
                for (HoaDonBanHang hoaDonBanHang : danhSach) {
                    System.out.println(
                            "--------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Hóa đơn " + i + ": ");
                    i = i + 1;
                    hoaDonBanHang.xuatHoaDonBanHang();
                    System.out.println(
                            "--------------------------------------------------------------------------------------------------------------------------------------------------");
                }
            } else if (luaChon0 == 2) {
                System.out.println("Nhập mã hóa đơn: ");
                String Mahd = sc.nextLine();
                System.out.println("Nhập mã khách hàng: ");
                String Makh = sc.nextLine();
                System.out.println("Nhập mã tài khoản: ");
                String Matk = sc.nextLine();
                System.out.println("Nhập mã nhân viên: ");
                String Manv = sc.nextLine();
                System.out.println("Nhập điểm khách hàng: ");
                int Diemkh = sc.nextInt();
                sc.nextLine();
                System.out.println("Nhập ngày: ");
                int day = sc.nextInt();
                sc.nextLine();
                System.out.println("Nhập tháng: ");
                int month = sc.nextInt();
                sc.nextLine();
                System.out.println("Nhập năm: ");
                int year = sc.nextInt();
                sc.nextLine();
                Ngay ngay = new Ngay(day, month, year);
                System.out.println("Nhập số lượng sản phẩm khác nhau: ");
                int sl = sc.nextInt();
                sc.nextLine();
                QuanLiSanPham dssp = new QuanLiSanPham();
                for (int i = 1; i <= sl; i++) {
                    System.out.println("Nhập mã sản phẩm thứ " + i + ": ");
                    String Masp = sc.nextLine();
                    System.out.println("Nhập tên sản phẩm: ");
                    String Tensp = sc.nextLine();
                    System.out.println("Nhập hãng sản phẩm: ");
                    String Hangsp = sc.nextLine();
                    System.out.println("Nhập giá: ");
                    int gia = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập thời gian bảo hành: ");
                    String ThoiGianBaoHanh = sc.nextLine();
                    System.out.println("Nhập số lượng: ");
                    int soLuong = sc.nextInt();
                    sc.nextLine();
                    SanPham sp = new SanPham(Masp, Tensp, Hangsp, gia, soLuong, ThoiGianBaoHanh);
                    dssp.them(sp);
                }
                HoaDonBanHang hdbh = new HoaDonBanHang(Mahd, Matk, ngay, dssp, Makh, Manv, Diemkh);
                this.danhSach.add(hdbh);

            } else if (luaChon0 == 3) {
                System.out.println("Nhập mã hóa đơn muốn xóa: ");
                String Mahd = sc.nextLine();
                HoaDonBanHang hdbh = new HoaDonBanHang();
                for (HoaDonBanHang hoaDonBanHang : danhSach) {
                    if (hoaDonBanHang.getMahd().equals(Mahd)) {
                        hdbh = hoaDonBanHang;
                    }

                }
                this.danhSach.remove(hdbh);

            } else if (luaChon0 == 4) {
                System.out.println("Nhập mã hóa đơn muốn sửa: ");
                String Mahd = sc.nextLine();
                for (HoaDonBanHang hoaDon : danhSach) {
                    if (hoaDon.getMahd().equals(Mahd)) {
                        int luaChon1 = 0;
                        do {
                            System.out.println("MENU ----------");
                            System.out.println("Lựa chọn: ");
                            System.out.println(
                                    "1. Sửa mã hóa đơn.\n"
                                            + "2. Sửa mã tài khoản.\n"
                                            + "3. Sửa mã khách hàng.\n"
                                            + "4. Sửa mã nhân viên.\n"
                                            + "5. Sửa điểm khách hàng.\n"
                                            + "6. Sửa danh sách sản phẩm.\n"
                                            + "0. Thoát.\n");
                            luaChon1 = sc.nextInt();
                            sc.nextLine();
                            if (luaChon1 == 1) {
                                System.out.println("Nhập mã hóa đơn mới: ");
                                String newMaHd = sc.nextLine();
                                hoaDon.setMahd(newMaHd);
                            }
                            if (luaChon1 == 2) {
                                System.out.println("Nhập mã tài khoản mới: ");
                                String newMaTk = sc.nextLine();
                                hoaDon.setmatk(newMaTk);
                            }
                            if (luaChon1 == 3) {
                                System.out.println("Nhập mã khách hàng mới: ");
                                String newMaKh = sc.nextLine();
                                hoaDon.setMakh(newMaKh);
                            }
                            if (luaChon1 == 4) {
                                System.out.println("Nhập mã nhân viên mới: ");
                                String newMaNv = sc.nextLine();
                                hoaDon.setmanv(newMaNv);
                            }
                            if (luaChon1 == 5) {
                                System.out.println("Nhập điểm khách hàng mới: ");
                                int newDiem = sc.nextInt();
                                hoaDon.setDiemkh(newDiem);
                            }
                            if (luaChon1 == 6) {
                                System.out.println("Nhập mã sản phẩm cần sửa: ");
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

    // thống kê
    public void thongKeBanHang() throws IOException {
        kiemtra kt = new kiemtra();
        this.docDuLieuTuFile();

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
        ArrayList<SanPham> thongKeSp = new ArrayList<SanPham>();
        for (HoaDonBanHang hd : this.danhSach) {
            try {
                date2 = format.parse(hd.getNgay().toString());
                if (date1.before(date2) && date3.after(date2)) {
                    for (SanPham sp : hd.getdssp().getList()) {
                        for (SanPham spThongKe : thongKeSp) {
                            if (spThongKe.getMasp().equalsIgnoreCase(sp.getMasp())) {
                                spThongKe.setSoluong(spThongKe.getSoluong() + sp.getSoluong());
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
        System.out.println("Tong doanh thu: " + danhSachThongKe.tongGia());
    }

    public static void main(String[] args) throws IOException {
        DanhSachHoaDonBanHang dsbh = new DanhSachHoaDonBanHang();
        dsbh.docDuLieuTuFile();
        dsbh.xuatDanhSach();
    }
}
