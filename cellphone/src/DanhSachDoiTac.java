import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.charset.StandardCharsets;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.io.FileNotFoundException;

public class DanhSachDoiTac {
    public ArrayList<DoiTac> arrDT = new ArrayList<DoiTac>();
    Scanner sc = new Scanner(System.in);

    public int soluongDT() {
        return arrDT.size();
    }

    public void them(DoiTac dt) {
        arrDT.add(dt);
    }

    public DoiTac tim(String Ma) {
        for (DoiTac dt : arrDT) {
            if (dt.getMADT().equals(Ma))
                return dt;
        }
        return null;
    }

    public void xoa(String Ma) {
        for (DoiTac dt : arrDT) {
            if (dt.getMADT().equals(Ma))
                arrDT.remove(dt);
            break;
        }
    }

    public void sua(String Ma) {
        int chon;
        System.out.println("1.Sua ma Doi Tac");
        System.out.println("2.Sua ten Doi Tac");
        System.out.println("3.Sua so dien thoai");
        System.out.println("4.Sua mail Doi Tac");
        System.out.println("0.Tro lai");
        for (DoiTac dt : arrDT) {

            if (dt.getMADT().equals(Ma)) {
                do {
                    System.out.print("Chon: ");
                    chon = Integer.parseInt(sc.nextLine());
                    switch (chon) {
                        case 1: {
                            System.out.print("Nhap ma Doi Tac moi: ");
                            String s = sc.nextLine();
                            dt.setMADT(s);
                            break;
                        }
                        case 2: {
                            System.out.print("Nhap ten Doi Tac moi: ");
                            String s = sc.nextLine();
                            dt.setTenDoiTac(s);
                            break;
                        }
                        case 3: {
                            System.out.print("Nhap so dien thoai moi: ");
                            String s = sc.nextLine();
                            dt.setTel(s);
                            break;
                        }
                        case 4: {
                            System.out.print("Nhap mail Doi Tac moi: ");
                            String s = sc.nextLine();
                            dt.setMail(s);
                            break;
                        }
                        case 0:
                            break;
                    }
                } while (chon != 0);
                break;
            }
        }
    }

    public void xuatDanhSach() {
        for (DoiTac dt : arrDT) {
            dt.xuatDoiTac();
            System.out.print("\n");
        }
    }

    // FILE
    public void ghiFile() {
        FileOutputStream f = null;
        try {
            f = new FileOutputStream("DSDT.txt", false);
            for (DoiTac dt : arrDT) {
                String line = dt.getFileLine();
                byte[] b = line.getBytes("utf8");
                f.write(b);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DanhSachDoiTac.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DanhSachDoiTac.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DanhSachDoiTac.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (Exception ex) {
                    Logger.getLogger(DanhSachDoiTac.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void docFile() throws IOException {
        FileInputStream f = null;
        InputStreamReader reader = null;
        BufferedReader bfReader = null;
        try {
            f = new FileInputStream("DSDT.txt");
            reader = new InputStreamReader(f, StandardCharsets.UTF_8);
            bfReader = new BufferedReader(reader);
            String line = null;
            while ((line = bfReader.readLine()) != null) {
                if (line.isEmpty())
                    continue;
                DoiTac dt = new DoiTac();
                dt.parseFile(line);
                arrDT.add(dt);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DanhSachDoiTac.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException ex) {
                    Logger.getLogger(DanhSachDoiTac.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(DanhSachDoiTac.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (bfReader != null) {
                try {
                    bfReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(DanhSachDoiTac.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        DanhSachDoiTac dsdt = new DanhSachDoiTac();
        DoiTac d = new DoiTac("DT4", "Huawei", "1111222233", "huawei@gmail.com");
        dsdt.docFile();
        dsdt.them(d);
        dsdt.xuatDanhSach();
        dsdt.ghiFile();
    }
}
