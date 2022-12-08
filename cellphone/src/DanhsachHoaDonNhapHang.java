
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
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

    // thĂªm
    public void them(HoaDonNhapHang sp) {
        this.danhSach.add(sp);

    }

    // xĂ³a
    public void xoa(String mahd) {
        HoaDonNhapHang hdbh = new HoaDonNhapHang();
        for (HoaDonNhapHang hoaDonNhapHang : danhSach) {
            if (hoaDonNhapHang.getMahd().equals(mahd)) {
                hdbh = hoaDonNhapHang;
            }
        }
        this.danhSach.remove(hdbh);
    }

    // sá»­a
    public void sua(String mahd) {
        for (HoaDonNhapHang hoaDon : danhSach) {
            if (hoaDon.getMahd().equals(mahd)) {
                int luaChon = 0;
                do {
                    System.out.println("MENU ----------");
                    System.out.println("Lá»±a chá»�n: ");
                    System.out.println(
                            "1. Sá»­a mĂ£ hĂ³a Ä‘Æ¡n.\n"
                                    + "2. Sá»­a mĂ£ tĂ i khoáº£n.\n"
                                    + "3. Sá»­a mĂ£ Ä‘á»‘i tĂ¡c.\n"
                                    + "4. Sá»­a Ä‘iá»ƒm Ä‘á»‘i tĂ¡c.\n"
                                    + "5. Sá»­a danh sĂ¡ch sáº£n pháº©m.\n"
                                    + "0. ThoĂ¡t.\n");
                    luaChon = sc.nextInt();
                    sc.nextLine();
                    if (luaChon == 1) {
                        System.out.println("Nháº­p mĂ£ hĂ³a Ä‘Æ¡n má»›i: ");
                        String newMaHd = sc.nextLine();
                        hoaDon.setMahd(newMaHd);
                    }
                    if (luaChon == 2) {
                        System.out.println("Nháº­p mĂ£ tĂ i khoáº£n má»›i: ");
                        String newMaTk = sc.nextLine();
                        hoaDon.setmatk(newMaTk);
                    }
                    if (luaChon == 3) {
                        System.out.println("Nháº­p mĂ£ Ä‘á»‘i tĂ¡c má»›i: ");
                        String newMaDt = sc.nextLine();
                        hoaDon.setMadt(newMaDt);
                    }
                    if (luaChon == 4) {
                        System.out.println("Nháº­p Ä‘iá»ƒm Ä‘á»‘i tĂ¡c má»›i: ");
                        int newDiem = sc.nextInt();
                        hoaDon.setDiemdt(newDiem);
                    }
                    if (luaChon == 5) {
                        System.out.println("Nháº­p mĂ£ sáº£n pháº©m cáº§n sá»­a: ");
                        String masp = sc.nextLine();
                        hoaDon.getdssp().sua(masp);
                    }
                } while (luaChon != 0);
            }
        }
    }

    // xuáº¥t danh sĂ¡ch hĂ³a Ä‘Æ¡n
    public void xuatDanhSach() {
        int i = 1;
        for (HoaDonNhapHang hoaDonNhapHang : danhSach) {
            System.out
                    .println(
                            "--------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("HĂ³a Ä‘Æ¡n " + i + ": ");
            i = i + 1;
            hoaDonNhapHang.xuatHoaDonNhapHang();
            System.out.println(
                    "--------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    public void xuatDanhSach_1(ArrayList<HoaDonNhapHang> listhd) {
        int i = 1;
        for (HoaDonNhapHang hoaDonNhapHang : listhd) {
            System.out
                    .println(
                            "--------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("HĂ³a Ä‘Æ¡n " + i + ": ");
            i = i + 1;
            hoaDonNhapHang.xuatHoaDonNhapHang();
            System.out.println(
                    "--------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    // ghi vĂ o file
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

    // Ä‘á»�c file
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
                            SanPham sp = new SanPham(txt1[0], txt1[1], txt1[2], gia, txt1[5], soLuong, null);
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
                            SanPham sp = new SanPham(txt1[0], txt1[1], txt1[2], gia, txt1[5], soLuong, null);
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
            System.out.println("Lá»±a chá»�n: ");
            System.out.println(
                    "1. In danh sĂ¡ch hĂ³a Ä‘Æ¡n bĂ¡n hĂ ng.\n"
                            + "2. ThĂªm hĂ³a Ä‘Æ¡n.\n"
                            + "3. XĂ³a hĂ³a Ä‘Æ¡n.\n"
                            + "4. Sá»­a hĂ³a Ä‘Æ¡n.\n"
                            + "0. ThoĂ¡t.\n");
            System.out.println("Vui lĂ²ng nháº­p lá»±a chá»�n cá»§a báº¡n: ");
            luaChon0 = sc.nextInt();
            sc.nextLine();
            if (luaChon0 == 1) {
                int i = 1;
                for (HoaDonNhapHang hoaDonNhapHang : danhSach) {
                    System.out.println(
                            "-----------------------------------------------------------------------");
                    System.out.println("HĂ³a Ä‘Æ¡n " + i + ": ");
                    i = i + 1;
                    hoaDonNhapHang.xuatHoaDonNhapHang();
                    System.out.println("-----------------------------------------------------------------------");
                }
            } else if (luaChon0 == 2) {
                System.out.println("Nháº­p mĂ£ hĂ³a Ä‘Æ¡n: ");
                String Mahd = sc.nextLine();
                System.out.println("Nháº­p mĂ£ Ä‘á»‘i tĂ¡c: ");
                String Madt = sc.nextLine();
                System.out.println("Nháº­p mĂ£ tĂ i khoáº£n: ");
                String Matk = sc.nextLine();
                System.out.println("Nháº­p Ä‘iá»ƒm Ä‘á»‘i tĂ¡c: ");
                int Diemdt = sc.nextInt();
                sc.nextLine();
                System.out.println("Nháº­p ngĂ y: ");
                int day = sc.nextInt();
                sc.nextLine();
                System.out.println("Nháº­p thĂ¡ng: ");
                int month = sc.nextInt();
                sc.nextLine();
                System.out.println("Nháº­p nÄƒm: ");
                int year = sc.nextInt();
                sc.nextLine();
                Ngay ngay = new Ngay(day, month, year);
                System.out.println("Nháº­p sá»‘ lÆ°á»£ng sáº£n pháº©m khĂ¡c nhau: ");
                int sl = sc.nextInt();
                sc.nextLine();
                QuanLiSanPham dssp = new QuanLiSanPham();
                for (int i = 1; i <= sl; i++) {
                    System.out.println("Nháº­p mĂ£ sáº£n pháº©m thá»© " + i + ": ");
                    String Masp = sc.nextLine();
                    System.out.println("Nháº­p tĂªn sáº£n pháº©m: ");
                    String Tensp = sc.nextLine();
                    System.out.println("Nháº­p hĂ£ng sáº£n pháº©m: ");
                    String Hangsp = sc.nextLine();
                    System.out.println("Nháº­p giĂ¡: ");
                    int gia = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nháº­p thá»�i gian báº£o hĂ nh: ");
                    String ThoiGianBaoHanh = sc.nextLine();
                    System.out.println("Nháº­p sá»‘ lÆ°á»£ng: ");
                    int soLuong = sc.nextInt();
                    sc.nextLine();
                    SanPham sp = new SanPham(Masp, Tensp, Hangsp, gia, soLuong, ThoiGianBaoHanh);
                    dssp.them(sp);
                }
                HoaDonNhapHang hdbh = new HoaDonNhapHang(Mahd, Matk, ngay, dssp, Madt, Diemdt);
                this.danhSach.add(hdbh);

            } else if (luaChon0 == 3) {
                System.out.println("Nháº­p mĂ£ hĂ³a Ä‘Æ¡n muá»‘n xĂ³a: ");
                String Mahd = sc.nextLine();
                HoaDonNhapHang hdbh = new HoaDonNhapHang();
                for (HoaDonNhapHang hoaDonNhapHang : danhSach) {
                    if (hoaDonNhapHang.getMahd().equals(Mahd)) {
                        hdbh = hoaDonNhapHang;
                    }

                }
                this.danhSach.remove(hdbh);

            } else if (luaChon0 == 4) {
                System.out.println("Nháº­p mĂ£ hĂ³a Ä‘Æ¡n muá»‘n sá»­a: ");
                String Mahd = sc.nextLine();
                for (HoaDonNhapHang hoaDon : danhSach) {
                    if (hoaDon.getMahd().equals(Mahd)) {
                        int luaChon1 = 0;
                        do {
                            System.out.println("MENU ----------");
                            System.out.println("Lá»±a chá»�n: ");
                            System.out.println(
                                    "1. Sá»­a mĂ£ hĂ³a Ä‘Æ¡n.\n"
                                            + "2. Sá»­a mĂ£ tĂ i khoáº£n.\n"
                                            + "3. Sá»­a mĂ£ Ä‘á»‘i tĂ¡c.\n"
                                            + "4. Sá»­a Ä‘iá»ƒm Ä‘á»‘i tĂ¡c.\n"
                                            + "5. Sá»­a danh sĂ¡ch sáº£n pháº©m.\n"
                                            + "0. ThoĂ¡t.\n");
                            luaChon1 = sc.nextInt();
                            sc.nextLine();
                            if (luaChon1 == 1) {
                                System.out.println("Nháº­p mĂ£ hĂ³a Ä‘Æ¡n má»›i: ");
                                String newMaHd = sc.nextLine();
                                hoaDon.setMahd(newMaHd);
                            }
                            if (luaChon1 == 2) {
                                System.out.println("Nháº­p mĂ£ tĂ i khoáº£n má»›i: ");
                                String newMaTk = sc.nextLine();
                                hoaDon.setmatk(newMaTk);
                            }
                            if (luaChon1 == 3) {
                                System.out.println("Nháº­p mĂ£ Ä‘á»‘i tĂ¡c má»›i: ");
                                String newMaDt = sc.nextLine();
                                hoaDon.setMadt(newMaDt);
                            }
                            if (luaChon1 == 4) {
                                System.out.println("Nháº­p Ä‘iá»ƒm khĂ¡ch hĂ ng má»›i: ");
                                int newDiem = sc.nextInt();
                                hoaDon.setDiemdt(newDiem);
                            }
                            if (luaChon1 == 5) {
                                System.out.println("Nháº­p mĂ£ sáº£n pháº©m cáº§n sá»­a: ");
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
        ArrayList<SanPham> thongKeSp = new ArrayList<SanPham>();
        for (HoaDonNhapHang hd : danhSach) {
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
        System.out.println("Tong chi phi nhap hang: " + danhSachThongKe.tongGia());
    }
}
