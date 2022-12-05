import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLiSanPham {
    Scanner sc = new Scanner(System.in);
    private static final String NULL = null;

    private int tonggia;

    private ArrayList<SanPham> danhSach;

    // Constructor
    public QuanLiSanPham() {
        this.danhSach = new ArrayList<SanPham>();
    }

    public QuanLiSanPham(ArrayList<SanPham> danhSach) {
        this.danhSach = danhSach;
    }

    public ArrayList<SanPham> getList() {
        return this.danhSach;
    }

    // them
    public void them(SanPham sp) {
        this.danhSach.add(sp);

    }

    // xuất danh sach
    public void xuatDanhSach() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Danh sach san pham:");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        String header = String.format("%15s%15s%45s%15s%25s", "ma san pham", "hang", "ten san pham", "gia",
                "Thoi gian bao hanh");
        System.out.println(header);
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        for (SanPham product : danhSach) {
            String now = String.format("%15s%15s%45s%15s%25s", product.getMasp(), product.getHang(), product.getTensp(),
                    product.getGia(), product.getThoiGianBaoHanh());
            System.out.println(now);
            System.out.println("----------------------------------------------------------------------------------------------------------------------");

        }

    }

    // Tổng gia
    public int getTonggia() {
        return tonggia;
    }

    public void setTonggia(int tonggia) {
        this.tonggia = tonggia;
    }

    public int tongGia() {
        tonggia = 0;
        for (SanPham sanPham : danhSach) {
            tonggia = tonggia + sanPham.getGia();
        }
        return tonggia;
    }

    // xoa
    public void xoa(String masp) {
        SanPham sp = new SanPham();

        for (SanPham sanPham : danhSach) {
            if (sanPham.getMasp().equals(masp)) {
                sp = sanPham;
            }
        }
        this.danhSach.remove(sp);
    }

    // số lượng
    public void soLuong() {
        System.out.println(this.danhSach.size());
    }

    // tim kiem
    public void timKiem(String masp) {

        for (SanPham product : danhSach) {
            if (product.getMasp().equals(masp)) {
                System.out.println(product.XuatThongTin());
            }
        }
    }

    // Sua
    public void sua(String masp) {
        for (SanPham sanPham : danhSach) {
            if (sanPham.getMasp().equals(masp)) {
                int luaChon = 0;
                do {
                    System.out.println("MENU ----------");
                    System.out.println("Lua chon: ");
                    System.out.println(
                            "1. Sua ma san pham.\n"
                                    + "2. Sua ten san pham.\n"
                                    + "3. Sua ten hang.\n"
                                    + "4. Sua gia san pham\n"
                                    + "5. Sua thoi gian bao hanh.\n"
                                    + "0. Thoat.\n");
                    luaChon = sc.nextInt();
                    sc.nextLine();
                    if (luaChon == 1) {
                        System.out.println("Nhap ma san pham moi: ");
                        String newMasp = sc.nextLine();
                        sanPham.setMasp(newMasp);
                    }
                    if (luaChon == 2) {
                        System.out.println("Nhap ten san pham moi: ");
                        String newTensp = sc.nextLine();
                        sanPham.setTensp(newTensp);
                    }
                    if (luaChon == 3) {
                        System.out.println("Nhap hang san pham moi: ");
                        String newHang = sc.nextLine();
                        sanPham.setHang(newHang);
                    }
                    if (luaChon == 4) {
                        System.out.println("Nhap gia san pham moi: ");
                        int newGia = sc.nextInt();
                        sanPham.setGia(newGia);
                    }
                    if (luaChon == 5) {
                        System.out.println("Nhap thoi gian bao hanh moi: ");
                        String newThoiGianBaoHanh = sc.nextLine();
                        sanPham.setThoiGianBaoHanh(newThoiGianBaoHanh);
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
            System.out.println("Lua chon: ");
            System.out.println(
                    "1. Tim kiem hang.\n"
                            + "2. Tim kiem theo gia.\n"
                            +"3.Xuat chi tiet san pham\n"
                            + "0. Thoat.\n");
            luaChon = sc.nextInt();
            sc.nextLine();
            if (luaChon == 1) {
                System.out.println("Nhap hang muon tim: ");
                String Hangsp = sc.nextLine();
                String header = String.format("%15s%15s%45s%15s%25s", "ma san pham", "hang", "ten san pham", "gia",
                        "Thoi gian bao hanh");
                System.out.println(header);
                for (SanPham sanPham : danhSach) {
                    if (sanPham.getHang().equals(Hangsp)) {
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------");
                        String now = String.format("%15s%15s%45s%15s%25s", sanPham.getMasp(), sanPham.getHang(),
                                sanPham.getTensp(),
                                sanPham.getGia(), sanPham.getThoiGianBaoHanh());
                        System.out.println(now);
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------");
                    }
                }
            }
            if (luaChon == 2) {
                int luachon1 = 0;
                do {
                    System.out.println("MENU ----------");
                    System.out.println("Lua chon: ");
                    System.out.println(
                            "1. Gia duoi 5 trieu.\n"
                                    + "2. Gia tu 5 trieu đen 10 trieu.\n"
                                    + "3. Gia tu 10 trieu đen 15 trieu.\n"
                                    + "4. Gia tu 15 trieu đen 20 trieu.\n"
                                    + "5. Gia tren 20 trieu.\n"
                                    + "0. Thoat.\n");
                    luachon1 = sc.nextInt();
                    sc.nextLine();
                    if (luachon1 == 1) {
                        String header = String.format("%15s%15s%45s%15s%25s", "ma san pham", "hang", "ten san pham",
                                "gia",
                                "Thoi gian bao hanh");
                        System.out.println(header);
                        for (SanPham sanPham : danhSach) {
                            if (sanPham.getGia() <= 5000000) {
                                System.out.println(
                                        "----------------------------------------------------------------------------------------------------------------------");
                                String now = String.format("%15s%15s%45s%15s%25s", sanPham.getMasp(), sanPham.getHang(),
                                        sanPham.getTensp(),
                                        sanPham.getGia(), sanPham.getThoiGianBaoHanh());
                                System.out.println(now);
                                System.out.println(
                                        "----------------------------------------------------------------------------------------------------------------------");

                            }
                        }
                    }
                    if (luachon1 == 2) {
                        String header = String.format("%15s%15s%45s%15s%25s", "ma san pham", "hang", "ten san pham",
                                "gia",
                                "Thoi gian bao hanh");
                        System.out.println(header);
                        for (SanPham sanPham : danhSach) {
                            if ((sanPham.getGia() >= 5000000) && (sanPham.getGia() <= 10000000)) {
                                System.out.println(
                                        "----------------------------------------------------------------------------------------------------------------------");
                                String now = String.format("%15s%15s%45s%15s%25s", sanPham.getMasp(), sanPham.getHang(),
                                        sanPham.getTensp(),
                                        sanPham.getGia(), sanPham.getThoiGianBaoHanh());
                                System.out.println(now);
                                System.out.println(
                                        "----------------------------------------------------------------------------------------------------------------------");
                            }
                        }
                    }
                    if (luachon1 == 3) {
                        String header = String.format("%15s%15s%45s%15s%25s", "ma san pham", "hang", "ten san pham",
                                "gia",
                                "Thoi gian bao hanh");
                        System.out.println(header);
                        for (SanPham sanPham : danhSach) {
                            if ((sanPham.getGia() >= 10000000) && (sanPham.getGia() <= 15000000)) {
                                System.out.println(
                                        "----------------------------------------------------------------------------------------------------------------------");
                                String now = String.format("%15s%15s%45s%15s%25s", sanPham.getMasp(), sanPham.getHang(),
                                        sanPham.getTensp(),
                                        sanPham.getGia(), sanPham.getThoiGianBaoHanh());
                                System.out.println(now);
                                System.out.println(
                                        "----------------------------------------------------------------------------------------------------------------------");
                            }
                        }
                    }
                    if (luachon1 == 4) {
                        String header = String.format("%15s%15s%45s%15s%25s", "ma san pham", "hang", "ten san pham",
                                "gia",
                                "Thoi gian bao hanh");
                        System.out.println(header);
                        for (SanPham sanPham : danhSach) {
                            if ((sanPham.getGia() >= 15000000) && (sanPham.getGia() <= 20000000)) {
                                System.out.println(
                                        "----------------------------------------------------------------------------------------------------------------------");
                                String now = String.format("%15s%15s%45s%15s%25s", sanPham.getMasp(), sanPham.getHang(),
                                        sanPham.getTensp(),
                                        sanPham.getGia(), sanPham.getThoiGianBaoHanh());
                                System.out.println(now);
                                System.out.println(
                                        "----------------------------------------------------------------------------------------------------------------------");
                            }
                        }
                    }
                    if (luachon1 == 5) {
                        String header = String.format("%15s%15s%45s%15s%25s", "ma san pham", "hang", "ten san pham",
                                "gia",
                                "Thoi gian bao hanh");
                        System.out.println(header);
                        for (SanPham sanPham : danhSach) {
                            if (sanPham.getGia() >= 20000000) {
                                System.out.println(
                                        "----------------------------------------------------------------------------------------------------------------------");
                                String now = String.format("%15s%15s%45s%15s%25s", sanPham.getMasp(), sanPham.getHang(),
                                        sanPham.getTensp(),
                                        sanPham.getGia(), sanPham.getThoiGianBaoHanh());
                                System.out.println(now);
                                System.out.println(
                                        "----------------------------------------------------------------------------------------------------------------------");
                            }
                        }
                    }
                } while (luachon1 != 0);

            }
            if(luaChon==3){
                System.out.println("Nhap ma san pham: ");
                String maSp=sc.nextLine();
                for (SanPham sanPham : danhSach) {
                    if(sanPham.getMasp().equals(maSp)){
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
                for (SanPham sanPham : danhSach) {
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

    // đọc dữ liệu từ file
    public void docDuLieuTuFile() throws IOException {
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
                    ChiTietSanPham ctsp = new ChiTietSanPham(txt[5], txt[6], txt[7], txt[8], txt[9]);
                    SanPham sp = new SanPham(txt[0], txt[1], txt[2], gia, txt[4], ctsp);
                    this.danhSach.add(sp);

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
    public void chucNang() throws IOException {
        int luaChon0 = 0;
        do {
            System.out.println("MENU ----------");
            System.out.println("Lua chon: ");
            System.out.println(
                    "1. In danh sach san pham.\n"
                            + "2. Them san pham.\n"
                            + "3. Xoa san pham.\n"
                            + "4. Tim kiem san pham.\n"
                            + "5. So luong san pham\n"
                            + "6. Tong gia.\n"
                            + "7. Sua san pham.\n"
                            + "8. Ghi san pham vao file.\n"
                            + "9. Doc san pham tu file.\n"
                            + "0. Thoat.\n");
            System.out.println("Vui long nhap lua chon cua ban: ");
            luaChon0 = sc.nextInt();
            sc.nextLine();
            if (luaChon0 == 1) {
                System.out.println("Danh sach san pham:");
                String header = String.format("%15s%15s%45s%15s%25s", "ma san pham", "hang", "ten san pham", "gia",
                        "Thoi gian bao hanh");
                System.out.println(header);
                for (SanPham product : danhSach) {
                    String now = String.format("%15s%15s%45s%15s%25s", product.getMasp(), product.getHang(),
                            product.getTensp(), product.getGia(), product.getThoiGianBaoHanh());
                    System.out.println(now);
                }
            } else if (luaChon0 == 2) {
                System.out.println("Nhap ma san pham: ");
                String MaSp = sc.nextLine();
                System.out.println("Nhap ten hang: ");
                String HangSp = sc.nextLine();
                System.out.println("Nhap ten san pham: ");
                String TenSp = sc.nextLine();
                System.out.println("Nhap gia: ");
                int GiaSp = sc.nextInt();
                sc.nextLine();
                System.out.println("Nhap thoi gian bao hanh: ");
                String ThoiGianBaoHanhSp = sc.nextLine();
                System.out.println("Nhap thong so man hinh: ");
                String ManHinhSp = sc.nextLine();
                System.out.println("Nhap thong so vi xu li: ");
                String VxlSp = sc.nextLine();
                System.out.println("Nhap thong so camera: ");
                String CameraSp = sc.nextLine();
                System.out.println("Nhap thong so pin: ");
                String PinSp = sc.nextLine();
                System.out.println("Nhap thong so bo nho: ");
                String BoNhoSp = sc.nextLine();
                ChiTietSanPham ctsp = new ChiTietSanPham(ManHinhSp, VxlSp, CameraSp, PinSp, BoNhoSp);
                SanPham sp = new SanPham(MaSp, TenSp, HangSp, GiaSp, ThoiGianBaoHanhSp, ctsp);
                this.danhSach.add(sp);
                System.out.println(MaSp);
            } else if (luaChon0 == 3) {
                System.out.println("Nhap ma san pham muon xoa: ");
                String MaSp = sc.nextLine();
                SanPham sp = new SanPham(MaSp);
                this.danhSach.remove(sp);
            } else if (luaChon0 == 4) {
                System.out.println("Nhap ma san pham muon tim: ");
                String MaSp = sc.nextLine();
                for (SanPham product : danhSach) {
                    if (product.getMasp().equals(MaSp)) {
                        System.out.println(product.XuatThongTin());
                    }
                }

            } else if (luaChon0 == 5) {
                System.out.println(this.danhSach.size());
            } else if (luaChon0 == 6) {
                tonggia = 0;
                for (SanPham sanPham2 : danhSach) {
                    tonggia = tonggia + sanPham2.getGia();
                }
                System.out.println(tonggia);
            } else if (luaChon0 == 7) {
                System.out.println("Nhap ma san pham muon sua: ");
                String MaSp = sc.nextLine();
                for (SanPham sanPham3 : danhSach) {
                    if (sanPham3.getMasp().equals(MaSp)) {
                        int luaChon1 = 0;
                        do {
                            System.out.println("MENU ----------");
                            System.out.println("Lua chon: ");
                            System.out.println(
                                    "1. Sua ma san pham.\n"
                                            + "2. Sua ten san pham.\n"
                                            + "3. Sua ten hang.\n"
                                            + "4. Sua gia san pham\n"
                                            + "5. Sua thoi gian bao hanh.\n"
                                            + "6. Sua chi tiet san pham.\n"
                                            + "0. Thoat.\n");
                            luaChon1 = sc.nextInt();
                            sc.nextLine();
                            if (luaChon1 == 1) {
                                System.out.println("Nhap ma san pham moi: ");
                                String newMasp = sc.nextLine();
                                sanPham3.setMasp(newMasp);
                            }
                            if (luaChon1 == 2) {
                                System.out.println("Nhap ten san pham moi: ");
                                String newTensp = sc.nextLine();
                                sanPham3.setTensp(newTensp);
                            }
                            if (luaChon1 == 3) {
                                System.out.println("Nhap hang san pham moi: ");
                                String newHang = sc.nextLine();
                                sanPham3.setHang(newHang);
                            }
                            if (luaChon1 == 4) {
                                System.out.println("Nhap gia san pham moi: ");
                                int newGia = sc.nextInt();
                                sanPham3.setGia(newGia);
                            }
                            if (luaChon1 == 5) {
                                System.out.println("Nhap thoi gian bao hanh moi: ");
                                String newThoiGianBaoHanh = sc.nextLine();
                                sanPham3.setThoiGianBaoHanh(newThoiGianBaoHanh);
                            }
                            if (luaChon1 == 6) {
                                int luaChon = 0;
                                do {
                                    System.out.println("MENU ----------");
                                    System.out.println("Lua chon chi tiet san pham can sua: ");
                                    System.out.println(
                                            "1. Man hinh.\n"
                                                    + "2. Vi xu li.\n"
                                                    + "3. Camera.\n"
                                                    + "4. Pin\n"
                                                    + "5. Bo nho.\n"
                                                    + "0. Thoat.\n");
                                    luaChon = sc.nextInt();
                                    sc.nextLine();
                                    if (luaChon == 1) {
                                        System.out.println("Nhap thong so man hinh moi: ");
                                        String newManHinh = sc.nextLine();
                                        sanPham3.getChitietsp().setmanHinh(newManHinh);
                                    }
                                    if (luaChon == 2) {
                                        System.out.println("Nhap thong so vi xu li moi: ");
                                        String newVxl = sc.nextLine();
                                        sanPham3.getChitietsp().setvxl(newVxl);
                                    }
                                    if (luaChon == 3) {
                                        System.out.println("Nhap thong so camera moi: ");
                                        String newCamera = sc.nextLine();
                                        sanPham3.getChitietsp().setcamera(newCamera);
                                    }
                                    if (luaChon == 4) {
                                        System.out.println("Nhap thong so pin moi: ");
                                        String newPin = sc.nextLine();
                                        sanPham3.getChitietsp().setpin(newPin);
                                    }
                                    if (luaChon == 5) {
                                        System.out.println("Nhap thong so bo nho moi: ");
                                        String newBoNho = sc.nextLine();
                                        sanPham3.getChitietsp().setboNho(newBoNho);
                                    }
                                } while (luaChon != 0);
                            }
                        } while (luaChon1 != 0);
                    }
                }
            } else if (luaChon0 == 8) {
                File file = new File("SanPham.txt");
                try {
                    FileWriter fw = new FileWriter(file);
                    try (BufferedWriter bw = new BufferedWriter(fw)) {
                        for (SanPham sanPham : danhSach) {
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

            } else if (luaChon0 == 9) {
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
                            ChiTietSanPham ctsp = new ChiTietSanPham(txt[5], txt[6], txt[7], txt[8], txt[9]);
                            SanPham sp = new SanPham(txt[0], txt[1], txt[2], gia, txt[4], ctsp);
                            this.danhSach.add(sp);

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

        } while (luaChon0 != 0);
    }

    // Định dạng cho file hóa đơn.
    public String dinhDangFileHoaDon() {
        String s = "";
        for (SanPham sanPham : danhSach) {
            String s1 = "\n" + sanPham.getMasp() + "," + sanPham.getTensp() + "," + sanPham.getHang() + ","
                    + sanPham.getGia()
                    + "," + sanPham.getThoiGianBaoHanh();
            s = s + s1;
        }
        return s;
    }

}
