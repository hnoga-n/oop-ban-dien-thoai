
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLiSanPham {
    Scanner sc = new Scanner(System.in);
    private static final String NULL = null;

    private long tonggia;

    private ArrayList<SanPham> danhSachSanPham;

    DecimalFormat formatter = new DecimalFormat("###,###,###");

    // Constructor
    public QuanLiSanPham() {
        this.danhSachSanPham = new ArrayList<SanPham>();
    }

    public QuanLiSanPham(ArrayList<SanPham> danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }

    public ArrayList<SanPham> getList() {
        return this.danhSachSanPham;
    }

    // thêm
    public void them(SanPham sp) {
        this.danhSachSanPham.add(sp);

    }

    // xuất danh sách
    public void xuatDanhSach() {
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Danh s�ch s?n ph?m:");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------");
        String header = String.format("%15s%15s%35s%15s%15s%25s", "M? s?n ph?m", "h?ng", "t�n s?n ph?m", "gi�",
                "s? l�?ng",
                "Th?i gian b?o h�nh");
        System.out.println(header);
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------------");
        for (SanPham product : danhSachSanPham) {
            String now = String.format("%15s%15s%35s%15s%15s%25s", product.getMasp(), product.getHang(),
                    product.getTensp(),
                    product.getGia(), product.getSoluong(), product.getThoiGianBaoHanh());
            System.out.println(now);
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------------------------");

        }

    }

    public void xuatDanhSach_1(ArrayList<SanPham> list) {
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Danh sách sản phẩm:");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------");
        String header = String.format("%15s%15s%35s%15s%15s%25s", "mã sản phẩm", "hãng", "tên sản phẩm", "giá",
                "số lượng",
                "ThỞi gian bảo hành");
        System.out.println(header);
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------------");
        for (SanPham product : list) {
            String now = String.format("%15s%15s%35s%15s%15s%25s", product.getMasp(), product.getHang(),
                    product.getTensp(),
                    product.getGia(), product.getSoluong(), product.getThoiGianBaoHanh());
            System.out.println(now);
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------------------------");

        }

    }

    // Tổng giá
    public long getTonggia() {
        return tonggia;
    }

    public void setTonggia(int tonggia) {
        this.tonggia = tonggia;
    }

    public long tongGia() {
        tonggia = 0;
        for (SanPham sanPham : danhSachSanPham) {
            tonggia = tonggia + sanPham.getGia() * sanPham.getSoluong();
        }
        return tonggia;
    }

    // xóa
    public void xoa(String masp) {
        SanPham sp = new SanPham();

        for (SanPham sanPham : danhSachSanPham) {
            if (sanPham.getMasp().equals(masp)) {
                sp = sanPham;
            }
        }
        this.danhSachSanPham.remove(sp);
    }

    // số lượng
    public void soLuong() {
        int soLuong = 0;
        for (SanPham sanPham : danhSachSanPham) {
            soLuong = soLuong + sanPham.getSoluong();
        }
        System.out.println(soLuong);
    }

    // tìm kiếm
    public void timKiem(String masp) {

        for (SanPham product : danhSachSanPham) {
            if (product.getMasp().equals(masp)) {
                product.XuatThongTinChiTiet();
            }
        }
    }

    // sửa
    public void sua(String masp) {
        for (SanPham sanPham : danhSachSanPham) {
            if (sanPham.getMasp().equals(masp)) {
                int luaChon;
                do {
                    System.out.println("MENU ----------");
                    System.out.println(
                            "1. Sua ma san pham.\n"
                                    + "2. Sua ten san pham.\n"
                                    + "3. Sua ten hang.\n"
                                    + "4. Sua gia san pham\n"
                                    + "5. Sua thoi gian bao hanh.\n"
                                    + "6. Sua so luong san pham.\n"
                                    + "7. Sua chi tiet san pham.\n"
                                    + "0. Thoat.\n");
                    System.out.print("Lua chon: ");
                    luaChon = sc.nextInt();
                    sc.nextLine();
                    if (luaChon == 1) {
                        System.out.println("Nhap ma san pham moi: ");
                        String newMasp = sc.nextLine();
                        sanPham.setMasp(newMasp);
                    } else if (luaChon == 2) {
                        System.out.println("Nhap ten san pham moi: ");
                        String newTensp = sc.nextLine();
                        sanPham.setTensp(newTensp);
                    } else if (luaChon == 3) {
                        System.out.println("Nhap hang san pham moi: ");
                        String newHang = sc.nextLine();
                        sanPham.setHang(newHang);
                    } else if (luaChon == 4) {
                        System.out.println("Nhap gia san pham: ");
                        int newGia = sc.nextInt();
                        sanPham.setGia(newGia);
                    } else if (luaChon == 5) {
                        System.out.println("Nhap thoi gian bao hanh moi: ");
                        String newThoiGianBaoHanh = sc.nextLine();
                        sanPham.setThoiGianBaoHanh(newThoiGianBaoHanh);
                    } else if (luaChon == 6) {
                        System.out.println("Nhap so luong moi: ");
                        int newSoLuong = sc.nextInt();
                        sanPham.setSoluong(newSoLuong);
                    } else if (luaChon == 7) {
                        sanPham.getChitietsp().suaChiTiet();
                    }
                } while (luaChon != 0);
            }
        }
    }

    // phân loại
    public void phanLoai() {
        int luaChon;
        do {
            System.out.println("MENU ----------");
            System.out.println("Lựa chỞn: ");
            System.out.println(
                    "1. Tìm kiếm hãng.\n"
                            + "2. Tìm kiếm theo giá.\n"
                            + "3.Xuất chi tiết sản phẩm\n"
                            + "0. Thoát.\n");
            luaChon = sc.nextInt();
            sc.nextLine();
            if (luaChon == 1) {
                System.out.println("Nhập hãng muốn tìm: ");
                String Hangsp = sc.nextLine();
                String header = String.format("%15s%15s%35s%15s%15s%25s", "mã sản phẩm", "hãng", "tên sản phẩm", "giá",
                        "số lượng",
                        "ThỞi gian bảo hành");
                System.out.println(header);
                for (SanPham sanPham : danhSachSanPham) {
                    if (sanPham.getHang().equals(Hangsp)) {
                        System.out.println(
                                "--------------------------------------------------------------------------------------------------------------------------------------------------");
                        String now = String.format("%15s%15s%35s%15s%15s%25s", sanPham.getMasp(), sanPham.getHang(),
                                sanPham.getTensp(),
                                sanPham.getGia(), sanPham.getSoluong(), sanPham.getThoiGianBaoHanh());
                        System.out.println(now);
                        System.out.println(
                                "--------------------------------------------------------------------------------------------------------------------------------------------------");
                    }
                }
            }
            if (luaChon == 2) {
                int luachon1 = 0;
                do {
                    System.out.println("MENU ----------");
                    System.out.println("Lựa chỞn: ");
                    System.out.println(
                            "1. Giá dưới 5 triệu.\n"
                                    + "2. Giá từ 5 triệu đến 10 triệu.\n"
                                    + "3. Giá từ 10 triệu đến 15 triệu.\n"
                                    + "4. Giá từ 15 triệu đến 20 triệu.\n"
                                    + "5. Giá trên 20 triệu.\n"
                                    + "0. Thoát.\n");
                    luachon1 = sc.nextInt();
                    sc.nextLine();
                    if (luachon1 == 1) {
                        String header = String.format("%15s%15s%35s%15s%15s%25s", "mã sản phẩm", "hãng", "tên sản phẩm",
                                "giá", "số lượng",
                                "ThỞi gian bảo hành");
                        System.out.println(header);
                        for (SanPham sanPham : danhSachSanPham) {
                            if (sanPham.getGia() <= 5000000) {
                                System.out.println(
                                        "--------------------------------------------------------------------------------------------------------------------------------------------------");
                                String now = String.format("%15s%15s%35s%15s%15s%25s", sanPham.getMasp(),
                                        sanPham.getHang(),
                                        sanPham.getTensp(),
                                        sanPham.getGia(), sanPham.getSoluong(), sanPham.getThoiGianBaoHanh());
                                System.out.println(now);
                                System.out.println(
                                        "--------------------------------------------------------------------------------------------------------------------------------------------------");

                            }
                        }
                    }
                    if (luachon1 == 2) {
                        String header = String.format("%15s%15s%35s%15s%15s%25s", "mã sản phẩm", "hãng", "tên sản phẩm",
                                "giá", "số lượng",
                                "ThỞi gian bảo hành");
                        System.out.println(header);
                        for (SanPham sanPham : danhSachSanPham) {
                            if ((sanPham.getGia() >= 5000000) && (sanPham.getGia() <= 10000000)) {
                                System.out.println(
                                        "--------------------------------------------------------------------------------------------------------------------------------------------------");
                                String now = String.format("%15s%15s%35s%15s%15s%25s", sanPham.getMasp(),
                                        sanPham.getHang(),
                                        sanPham.getTensp(),
                                        sanPham.getGia(), sanPham.getSoluong(), sanPham.getThoiGianBaoHanh());
                                System.out.println(now);
                                System.out.println(
                                        "--------------------------------------------------------------------------------------------------------------------------------------------------");
                            }
                        }
                    }
                    if (luachon1 == 3) {
                        String header = String.format("%15s%15s%35s%15s%15s%25s", "mã sản phẩm", "hãng", "tên sản phẩm",
                                "giá", "số lượng",
                                "ThỞi gian bảo hành");
                        System.out.println(header);
                        for (SanPham sanPham : danhSachSanPham) {
                            if ((sanPham.getGia() >= 10000000) && (sanPham.getGia() <= 15000000)) {
                                System.out.println(
                                        "--------------------------------------------------------------------------------------------------------------------------------------------------");
                                String now = String.format("%15s%15s%35s%15s%15s%25s", sanPham.getMasp(),
                                        sanPham.getHang(),
                                        sanPham.getTensp(),
                                        sanPham.getGia(), sanPham.getSoluong(), sanPham.getThoiGianBaoHanh());
                                System.out.println(now);
                                System.out.println(
                                        "--------------------------------------------------------------------------------------------------------------------------------------------------");
                            }
                        }
                    }
                    if (luachon1 == 4) {
                        String header = String.format("%15s%15s%35s%15s%15s%25s", "mã sản phẩm", "hãng", "tên sản phẩm",
                                "giá", "số lượng",
                                "ThỞi gian bảo hành");
                        System.out.println(header);
                        for (SanPham sanPham : danhSachSanPham) {
                            if ((sanPham.getGia() >= 15000000) && (sanPham.getGia() <= 20000000)) {
                                System.out.println(
                                        "--------------------------------------------------------------------------------------------------------------------------------------------------");
                                String now = String.format("%15s%15s%35s%15s%15s%25s", sanPham.getMasp(),
                                        sanPham.getHang(),
                                        sanPham.getTensp(),
                                        sanPham.getGia(), sanPham.getSoluong(), sanPham.getThoiGianBaoHanh());
                                System.out.println(now);
                                System.out.println(
                                        "--------------------------------------------------------------------------------------------------------------------------------------------------");
                            }
                        }
                    }
                    if (luachon1 == 5) {
                        String header = String.format("%15s%15s%35s%15s%15s%25s", "ma san pham", "hang", "ten san pham",
                                "gia", "so luong",
                                "Thoi gian bao hanh");
                        System.out.println(header);
                        for (SanPham sanPham : danhSachSanPham) {
                            if (sanPham.getGia() >= 20000000) {
                                System.out.println(
                                        "--------------------------------------------------------------------------------------------------------------------------------------------------");
                                String now = String.format("%15s%15s%35s%15s%15s%25s", sanPham.getMasp(),
                                        sanPham.getHang(),
                                        sanPham.getTensp(),
                                        sanPham.getGia(), sanPham.getSoluong(), sanPham.getThoiGianBaoHanh());
                                System.out.println(now);
                                System.out.println(
                                        "--------------------------------------------------------------------------------------------------------------------------------------------------");
                            }
                        }
                    }
                } while (luachon1 != 0);

            }
            if (luaChon == 3) {
                System.out.println("Nhap ma san pham: ");
                String maSp = sc.nextLine();
                for (SanPham sanPham : danhSachSanPham) {
                    if (sanPham.getMasp().equals(maSp)) {
                        sanPham.getChitietsp().XuatMoTaSanPham();
                    }
                }
            }
        } while (luaChon != 0);
    }

    // ghi dữ liệu vào file
    public void ghiDuLieuVaoFile() throws IOException {
        File file = new File("SanPham.txt");
        try {
            FileWriter fw = new FileWriter(file);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                for (SanPham sanPham : danhSachSanPham) {
                    bw.write(sanPham.toString());
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

    // đỞc dữ liệu từ file
    public void docDuLieuTuFile() throws IOException {
        this.danhSachSanPham.clear();
        File file = new File("SanPham.txt");
        try {

            FileReader fr = new FileReader(file);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = "";

                while (line != NULL) {

                    line = br.readLine();
                    if (line == NULL) {
                        break;
                    }
                    String txt[] = line.split(",");
                    int gia = Integer.parseInt(txt[3]);
                    int soLuong = Integer.parseInt(txt[4]);
                    ChiTietSanPham ctsp = new ChiTietSanPham(txt[6], txt[7], txt[8], txt[9], txt[10], txt[11]);
                    SanPham sp = new SanPham(txt[0], txt[1], txt[2], gia, txt[5], soLuong, ctsp);
                    them(sp);

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

    // chức năng tổng thể
    public void menuSanPham() throws IOException {
        this.docDuLieuTuFile();
        int luaChon0 = 0;
        do {
            System.out.println("MENU ----------");
            System.out.println(
                    "1. In danh sach san pham.\n"
                            + "2. Them san pham.\n"
                            + "3. Xoa san pham.\n"
                            + "4. Tim kiem san pham.\n"
                            + "5. So luong san pham\n"
                            + "6. Tong gia.\n"
                            + "7. Sua san pham.\n"
                            + "0. Thoat.\n");
            System.out.print("Nhap lua chon: ");
            luaChon0 = sc.nextInt();
            sc.nextLine();
            if (luaChon0 == 1) {
                System.out.println("Danh sach san pham:");
                String header = String.format("%15s%15s%35s%15s%15s%25s", "Ma san pham", "Hang", "Ten san pham", "Gia",
                        "So luong",
                        "Thoi gian bao hanh");
                System.out.println(header);
                for (SanPham product : danhSachSanPham) {
                    String now = String.format("%15s%15s%35s%15s%15s%25s", product.getMasp(), product.getHang(),
                            product.getTensp(), product.getGia(), product.getSoluong(), product.getThoiGianBaoHanh());
                    System.out.println(now);
                }
            } else if (luaChon0 == 2) {
                System.out.print("Nhap ma san pham: ");
                String MaSp = sc.nextLine();
                System.out.print("Nhap ten hang: ");
                String HangSp = sc.nextLine();
                System.out.print("Nhap ten san pham: ");
                String TenSp = sc.nextLine();
                System.out.print("Nhap gia: ");
                int GiaSp = sc.nextInt();
                sc.nextLine();
                System.out.print("Nhap thoi gian bao hanh: ");
                String ThoiGianBaoHanhSp = sc.nextLine();
                System.out.print("Nhap so luong: ");
                int soLuong = sc.nextInt();
                sc.nextLine();
                System.out.print("Nhap thong so man hinh: ");
                String ManHinhSp = sc.nextLine();
                System.out.print("Nhap thong so vi xu li: ");
                String VxlSp = sc.nextLine();
                System.out.print("Nhap thong so camera: ");
                String CameraSp = sc.nextLine();
                System.out.print("Nhap thong so pin: ");
                String PinSp = sc.nextLine();
                System.out.print("Nhap thong so ram: ");
                String RamSp = sc.nextLine();
                System.out.print("Nhap thong so bo nho: ");
                String BoNhoSp = sc.nextLine();
                ChiTietSanPham ctsp = new ChiTietSanPham(ManHinhSp, VxlSp, CameraSp, PinSp, RamSp, BoNhoSp);
                SanPham sp = new SanPham(MaSp, TenSp, HangSp, GiaSp, ThoiGianBaoHanhSp, soLuong, ctsp);
                them(sp);
                System.out.println(MaSp);
            } else if (luaChon0 == 3) {
                System.out.print("Nhap ma san pham muon xoa: ");
                String MaSp = sc.nextLine();
                SanPham sp = new SanPham(MaSp);
                this.danhSachSanPham.remove(sp);
            } else if (luaChon0 == 4) {
                System.out.print("Nhap ma san pham muon tim: ");
                String MaSp = sc.nextLine();
                for (SanPham product : danhSachSanPham) {
                    if (product.getMasp().equals(MaSp)) {
                        product.XuatThongTinChiTiet();
                    }
                }

            } else if (luaChon0 == 5) {
                this.docDuLieuTuFile();
                int sum = 0;
                for (SanPham sp : danhSachSanPham) {
                    sum += sp.getSoluong();
                }
                System.out.println("Tong so luong san pham co trong kho: " + sum);
            } else if (luaChon0 == 6) {
                tonggia = 0;
                for (SanPham sanPham2 : danhSachSanPham) {
                    tonggia += sanPham2.getGia() * sanPham2.getSoluong();
                }
                System.out.println("Tong gia tri san pham trong kho hang hien tai: " + tonggia);
            } else if (luaChon0 == 7) {
                System.out.print("Nhap ma san pham muon sua: ");
                String MaSp = sc.nextLine();
                this.sua(MaSp);
            } else if (luaChon0 == 0) {
                this.ghiDuLieuVaoFile();
                break;
            }

        } while (true);
    }

    // Ğịnh dạng cho file hóa đơn.
    public String dinhDangFileHoaDon() {
        String s = "";
        for (SanPham sanPham : danhSachSanPham) {
            String s1 = "\n" + sanPham.getMasp() + "," + sanPham.getTensp() + "," + sanPham.getHang() + ","
                    + sanPham.getGia() + "," + sanPham.getSoluong()
                    + "," + sanPham.getThoiGianBaoHanh();
            s = s + s1;
        }
        return s;
    }

    public void Menuchucnangnhaphang() throws IOException {
        // kiemtra kt = new kiemtra();
        System.out.println("Nhap ma doi tac: ");
        String madt;
        madt = sc.nextLine();
        ArrayList<SanPham> arrSp = new ArrayList<SanPham>(); // mảng sản phẩm tạm để lưu sản phẩm nhập hàng
        docDuLieuTuFile();
        while (true) {
            System.out.println("\n");
            System.out.println("----------------------------------------------");
            System.out.println("==========    * MENU NHAP HANG *    ==========");
            System.out.println("----------------------------------------------");
            System.out.println("1. Nhap san pham");
            System.out.println("2. Xem san pham da chon");
            System.out.println("3. Sua so luong san pham");
            System.out.println("4. Xoa san pham da chon");
            System.out.println("5. Xuat hoa don");
            System.out.println("6. Thoat");
            System.out.println("----------------------------------------------");
            System.out.print("Chon: ");
            String key = sc.nextLine();
            if (key.matches("[1-6]{1}") == false) {
                System.out.println("Vui long chon so tu 1 den 6 !");
                continue;
            } else {
                switch (key) {
                    case "1":
                        Boolean flag = null;
                        Boolean flag0 = true;
                        String masp;
                        int soluong;
                        SanPham sp = null;
                        System.out.println("Nhap ma san pham: ");
                        // masp = kt.KiemTraNhapMaSP();
                        masp = sc.nextLine();
                        for (SanPham obj : arrSp) {
                            if (obj.getMasp().equalsIgnoreCase(masp)) {
                                flag0 = false;
                                System.out.println("San pham da duoc chon!");
                                break;
                            }
                        }
                        if (flag0 == false) {
                            break;
                        }
                        for (SanPham obj : danhSachSanPham) {
                            if (obj.getMasp().equalsIgnoreCase(masp)) {
                                flag = true;
                                sp = obj;
                                break;
                            } else {
                                flag = false;
                            }
                        }
                        if (flag == false) {
                            System.out.println(
                                    "San pham khong co trong kho, vui long them san pham truoc khi nhap hang!");
                            break;
                        }

                        System.out.println("Nhap so luong: ");
                        soluong = sc.nextInt();
                        sc.nextLine();
                        sp.setSoluong(soluong);
                        arrSp.add(sp);
                        break;
                    case "2":
                        if (arrSp.isEmpty()) {
                            System.out.println("Khong co san pham nao duoc chon!");
                        } else {
                            xuatDanhSach_1(arrSp);
                        }
                        break;
                    case "3":
                        if (arrSp.isEmpty()) {
                            System.out.println("Danh sach san pham rong!");
                        } else {
                            Boolean flag1 = null;
                            String masp1;
                            int soluong1;
                            System.out.println("Nhap ma san pham can sua: ");
                            // masp1 = kt.KiemTraNhapMaSP();
                            masp1 = sc.nextLine();
                            System.out.println("Nhap so luong moi: ");
                            soluong1 = sc.nextInt();
                            sc.nextLine();
                            for (SanPham obj : arrSp) {
                                if (obj.getMasp().equalsIgnoreCase(masp1)) {
                                    flag1 = true;
                                    obj.setSoluong(soluong1);
                                    System.out.println("Cap nhat so luong thanh cong!");
                                    break;
                                } else {
                                    flag1 = false;
                                }
                            }
                            if (flag1 == false) {
                                System.out.println("San pham khong nam trong danh sach san pham duoc chon!");
                                break;
                            }
                        }
                        break;

                    case "4":
                        if (arrSp.isEmpty()) {
                            System.out.println("Danh sach san pham rong!");
                        } else {
                            Boolean flag2 = null;
                            String masp2;
                            System.out.println("Nhap ma san pham can xoa: ");
                            // masp2 = kt.KiemTraNhapMaSP();
                            masp2 = sc.nextLine();
                            for (SanPham obj : arrSp) {
                                if (obj.getMasp().equalsIgnoreCase(masp2)) {
                                    flag2 = true;
                                    arrSp.remove(obj);
                                    System.out.println("Xoa san pham thanh cong!");
                                    break;
                                } else {
                                    flag2 = false;
                                }
                            }
                            if (flag2 == false) {
                                System.out.println("San pham khong nam trong danh sach san pham duoc chon!");
                                break;
                            }
                        }
                        break;

                    case "5":
                        if (arrSp.isEmpty()) {
                            System.out.println("Danh sach san pham rong!");
                        } else {
                            /* XU LY HOA DON */
                            // xử lý ngày
                            LocalDate date = LocalDate.now();
                            String[] params = date.toString().split("-");
                            Ngay ngay = new Ngay(Integer.parseInt(params[2]), Integer.parseInt(params[1]),
                                    Integer.parseInt(params[0]));

                            // set mã hóa đơn
                            DanhsachHoaDonNhapHang listhd = new DanhsachHoaDonNhapHang();
                            listhd.docDuLieuTuFile();
                            String mahd = "hd" + (Integer.parseInt(
                                    listhd.getList().get(listhd.getList().size() - 1).getMahd().substring(2)) + 1);

                            // tạo quanlisanpham
                            QuanLiSanPham qlsp = new QuanLiSanPham(arrSp);

                            // tạo hóa đơn
                            HoaDonNhapHang hd = new HoaDonNhapHang(mahd, null, ngay, qlsp, madt, 0);
                            hd.xuatHoaDonNhapHang();

                            // lưu hóa đơn mới vào file
                            listhd.getList().add(hd);
                            listhd.ghiDuLieuVaoFile();

                            /* XU LY SAN PHAM */
                            QuanLiSanPham qlsp1 = new QuanLiSanPham();
                            qlsp1.docDuLieuTuFile();
                            for (SanPham sp1 : qlsp1.getList()) {
                                for (SanPham sp2 : arrSp) {
                                    if (sp1.getMasp().equalsIgnoreCase(sp2.getMasp())) {
                                        sp1.setSoluong(sp1.getSoluong() + sp2.getSoluong());
                                    }
                                }
                            }
                            qlsp1.ghiDuLieuVaoFile();
                            arrSp.clear();
                        }
                        break;
                }
            }
            if (Integer.parseInt(key) == 6) {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        QuanLiSanPham dssp = new QuanLiSanPham();
        dssp.menuSanPham();
    }
}
