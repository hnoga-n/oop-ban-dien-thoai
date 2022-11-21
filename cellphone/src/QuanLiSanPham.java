
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class QuanLiSanPham {
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

    // thêm
    public void them(SanPham sp) {
        this.danhSach.add(sp);

    }

    // xuất danh sách
    public void xuatDanhSach() {
        System.out.println("Danh sách sản phẩm:");
        String header = String.format("%15s%15s%45s%15s%25s", "mã sản phẩm", "hãng", "tên sản phẩm", "giá",
                "Thời gian bảo hành");
        System.out.println(header);
        for (SanPham product : danhSach) {
            String now = String.format("%15s%15s%45s%15s%25s", product.getMasp(), product.getHang(), product.getTensp(),
                    product.getGia(), product.getThoiGianBaoHanh());
            System.out.println(now);

        }

    }

    // Tổng giá
    public int tongGia() {
        tonggia = 0;
        for (SanPham sanPham : danhSach) {
            tonggia = tonggia + sanPham.getGia();
        }
        return tonggia;
    }

    // xóa
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

    // tìm kiếm
    public void timKiem(String masp) {

        for (SanPham product : danhSach) {
            if (product.getMasp().equals(masp)) {
                System.out.println(product.XuatThongTin());
            }
        }
    }

    // sửa
    public void sua(String masp) {
        for (SanPham sanPham : danhSach) {
            if (sanPham.getMasp() == masp) {
                try (Scanner sc = new Scanner(System.in)) {
                    int luaChon = 0;
                    do {
                        System.out.println("MENU ----------");
                        System.out.println("Lựa chọn: ");
                        System.out.println(
                                "1. Sửa mã sản phẩm.\n"
                                        + "2. Sửa tên sản phẩm.\n"
                                        + "3. Sửa tên hãng.\n"
                                        + "4. Sửa giá sản phẩm\n"
                                        + "5. Sửa thời gian bảo hành.\n"
                                        + "0. Thoát.\n");
                        luaChon = sc.nextInt();
                        sc.nextLine();
                        if (luaChon == 1) {
                            System.out.println("Nhập mã sản phẩm mới: ");
                            String newMasp = sc.nextLine();
                            sanPham.setMasp(newMasp);
                        }
                        if (luaChon == 2) {
                            System.out.println("Nhập tên sản phẩm mới: ");
                            String newTensp = sc.nextLine();
                            sanPham.setTensp(newTensp);
                        }
                        if (luaChon == 3) {
                            System.out.println("Nhập hãng sản phẩm mới: ");
                            String newHang = sc.nextLine();
                            sanPham.setHang(newHang);
                        }
                        if (luaChon == 4) {
                            System.out.println("Nhập giá sản phẩm mới: ");
                            int newGia = sc.nextInt();
                            sanPham.setGia(newGia);
                        }
                        if (luaChon == 5) {
                            System.out.println("Nhập thời gian bảo hành mới: ");
                            String newThoiGianBaoHanh = sc.nextLine();
                            sanPham.setThoiGianBaoHanh(newThoiGianBaoHanh);
                        }
                    } while (luaChon != 0);
                }
            }
        }
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
                    String txt[] = line.split(", ");
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
        try (Scanner sc = new Scanner(System.in)) {
            int luaChon0 = 0;
            do {
                System.out.println("MENU ----------");
                System.out.println("Lựa chọn: ");
                System.out.println(
                        "1. In danh sách sản phẩm.\n"
                                + "2. Thêm sản phẩm.\n"
                                + "3. Xóa sản phẩm.\n"
                                + "4. Tìm kiếm sản phẩm.\n"
                                + "5. Số lượng sản phẩm\n"
                                + "6. Tổng giá.\n"
                                + "7. Sửa sản phẩm.\n"
                                + "8. Ghi sản phẩm vào file.\n"
                                + "9. Đọc sản phẩm từ file.\n"
                                + "0. Thoát.\n");
                System.out.println("Vui lòng nhập lựa chọn của bạn: ");
                luaChon0 = sc.nextInt();
                sc.nextLine();
                if (luaChon0 == 1) {
                    System.out.println("Danh sách sản phẩm:");
                    String header = String.format("%15s%15s%45s%15s%25s", "mã sản phẩm", "hãng", "tên sản phẩm", "giá",
                            "Thời gian bảo hành");
                    System.out.println(header);
                    for (SanPham product : danhSach) {
                        String now = String.format("%15s%15s%45s%15s%25s", product.getMasp(), product.getHang(),
                                product.getTensp(), product.getGia(), product.getThoiGianBaoHanh());
                        System.out.println(now);
                    }
                } else if (luaChon0 == 2) {
                    System.out.println("Nhập mã sản phẩm: ");
                    String MaSp = sc.nextLine();
                    System.out.println("Nhập tên hãng: ");
                    String HangSp = sc.nextLine();
                    System.out.println("Nhập tên sản phẩm: ");
                    String TenSp = sc.nextLine();
                    System.out.println("Nhập giá: ");
                    int GiaSp = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập thời gian bảo hành: ");
                    String ThoiGianBaoHanhSp = sc.nextLine();
                    System.out.println("Nhập thông số màn hình: ");
                    String ManHinhSp = sc.nextLine();
                    System.out.println("Nhập thông số vi xử lí: ");
                    String VxlSp = sc.nextLine();
                    System.out.println("Nhập thông số camera: ");
                    String CameraSp = sc.nextLine();
                    System.out.println("Nhập thông số pin: ");
                    String PinSp = sc.nextLine();
                    System.out.println("Nhập thông số bộ nhớ: ");
                    String BoNhoSp = sc.nextLine();
                    ChiTietSanPham ctsp = new ChiTietSanPham(ManHinhSp, VxlSp, CameraSp, PinSp, BoNhoSp);
                    SanPham sp = new SanPham(MaSp, TenSp, HangSp, GiaSp, ThoiGianBaoHanhSp, ctsp);
                    this.danhSach.add(sp);
                    System.out.println(MaSp);
                } else if (luaChon0 == 3) {
                    System.out.println("Nhập mã sản phẩm muốn xóa: ");
                    String MaSp = sc.nextLine();
                    SanPham sp = new SanPham(MaSp);
                    this.danhSach.remove(sp);
                } else if (luaChon0 == 4) {
                    System.out.println("Nhập mã sản phẩm muốn tìm: ");
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
                    System.out.println("Nhập mã sản phẩm muốn sửa: ");
                    String MaSp = sc.nextLine();
                    for (SanPham sanPham3 : danhSach) {
                        if (sanPham3.getMasp().equals(MaSp)) {
                            int luaChon1 = 0;
                            do {
                                System.out.println("MENU ----------");
                                System.out.println("Lựa chọn: ");
                                System.out.println(
                                        "1. Sửa mã sản phẩm.\n"
                                                + "2. Sửa tên sản phẩm.\n"
                                                + "3. Sửa tên hãng.\n"
                                                + "4. Sửa giá sản phẩm\n"
                                                + "5. Sửa thời gian bảo hành.\n"
                                                + "0. Thoát.\n");
                                luaChon1 = sc.nextInt();
                                sc.nextLine();
                                if (luaChon1 == 1) {
                                    System.out.println("Nhập mã sản phẩm mới: ");
                                    String newMasp = sc.nextLine();
                                    sanPham3.setMasp(newMasp);
                                }
                                if (luaChon1 == 2) {
                                    System.out.println("Nhập tên sản phẩm mới: ");
                                    String newTensp = sc.nextLine();
                                    sanPham3.setTensp(newTensp);
                                }
                                if (luaChon1 == 3) {
                                    System.out.println("Nhập hãng sản phẩm mới: ");
                                    String newHang = sc.nextLine();
                                    sanPham3.setHang(newHang);
                                }
                                if (luaChon1 == 4) {
                                    System.out.println("Nhập giá sản phẩm mới: ");
                                    int newGia = sc.nextInt();
                                    sanPham3.setGia(newGia);
                                }
                                if (luaChon1 == 5) {
                                    System.out.println("Nhập thời gian bảo hành mới: ");
                                    String newThoiGianBaoHanh = sc.nextLine();
                                    sanPham3.setThoiGianBaoHanh(newThoiGianBaoHanh);
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
                                StringTokenizer st = new StringTokenizer(line, ",");

                                String txt[] = line.split(", ");
                                int gia = Integer.parseInt(txt[3]);
                                ChiTietSanPham ctsp = new ChiTietSanPham(txt[5], txt[6], txt[7], txt[8], txt[9]);
                                this.danhSach.add(new SanPham(st.nextToken(), txt[1], txt[2], gia, txt[4], ctsp));

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
    }

}
