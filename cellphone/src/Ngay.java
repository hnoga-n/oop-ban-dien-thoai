import java.util.Scanner;

public class Ngay {

    private int day;
    private int month;
    private int year;
    Scanner sc = new Scanner(System.in);

    public Ngay() {
        day = 1;
        month = 1;
        year = 1;
    }

    public Ngay(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay() {
        System.out.println("Moi nhap ngay: ");
        this.day = sc.nextInt();
    }

    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth() {
        System.out.println("Moi nhap thang: ");
        this.month = sc.nextInt();
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear() {
        System.out.println("Moi nhap nam: ");
        this.year = sc.nextInt();
    }

    public void setYear(int year) {
        if (year >= 1) {
            this.year = year;
        }
    }

    public void nhapNgay() {
        this.setDay();
        this.setMonth();
        this.setYear();
    }

    public boolean thuocKhoangThoiGian(Ngay start, Ngay end) {
        if (start.year <= this.year && this.year <= end.year) {
            if (start.month < this.month && this.month < end.month) {
                return true;
            }

            if (start.month == this.month && this.month == end.month) {
                if (start.day <= this.day && this.day <= end.day) {
                    return true;
                }
            }
            if (start.month == this.month) {
                if (start.day <= this.day) {
                    return true;
                }
            }
            if (this.month == end.month) {
                if (this.day <= end.day) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    public static void main(String[] args) {
        Ngay a = new Ngay(12, 2, 2004);
        Ngay b = new Ngay(5, 12, 2005);
        Ngay c = new Ngay(4, 12, 2004);
        System.out.println(c.thuocKhoangThoiGian(a, b));

    }

}
