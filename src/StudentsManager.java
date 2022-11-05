
import java.util.*;
class Student {
    private String hoTen;
    private String diaChi;
    private int tuoi;
    private double diemToan;
    private double diemLy;
    private double diemHoa;
    public Student() {
    }
    public Student(String hoTen, String diaChi, int tuoi, double diemToan, double diemLy, double diemHoa) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.tuoi = tuoi;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public double getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(double diemToan) {
        this.diemToan = diemToan;
    }

    public double getDiemLy() {
        return diemLy;
    }

    public void setDiemLy(double diemLy) {
        this.diemLy = diemLy;
    }

    public double getDiemHoa() {
        return diemHoa;
    }

    public void setDiemHoa(double diemHoa) {
        this.diemHoa = diemHoa;
    }
    
    public double tinhDiemTB() {
        return (diemToan + diemLy + diemHoa) / 3;
    }
    public void hienThi() {
        System.out.printf("Họ Tên:%15s | Địa chỉ: %15s | Toán: %4.1f | Lý: %4.1f | Hóa: %4.1f | Điểm TB: %4.1f |\n", hoTen, diaChi, diemToan, diemLy,
                diemHoa, tinhDiemTB());
    }
}
class ListStudent {
    private ArrayList<Student> arr;
    public ListStudent() {
        arr = new ArrayList<>();
    }
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        int n;
        do {            
            System.out.print("Nhập vào số sinh viên cần nhập: ");
            n = sc.nextInt();
            if(n < 0)
                System.out.printf("Số sinh viên phải lớn hơn hoặc bằng 0. Thừ lại.\n");
        } while (n < 0);
        sc.nextLine();
        for(int i = 1; i <= n; i++) {
            System.out.printf("\n------- Sinh viên thứ %d --------\n", i);
            System.out.print("Họ Tên: ");
            String hoTen = sc.nextLine();
            System.out.print("Địa Chỉ: ");
            String diaChi = sc.nextLine();
            System.out.print("Tuổi: ");
            int tuoi = Integer.parseInt(sc.nextLine());
            System.out.print("Điểm Toán: ");
            double diemToan = Double.parseDouble(sc.nextLine());
            System.out.print("Điểm Lý: ");
            double diemLy = Double.parseDouble(sc.nextLine());
            System.out.print("Điểm Hóa: ");
            double diemHoa = Double.parseDouble(sc.nextLine());
            arr.add(new Student(hoTen, diaChi, tuoi, diemToan, diemLy, diemHoa));
        }  
    }
    public void hienThiDanhSach() {
        System.out.println("Danh sách sinh viên: ");
        for (Student student : arr) {
            student.hienThi();
        }
    }
    public void sapXep(){
        arr.sort((Student a, Student b) ->(int)(a.tinhDiemTB() - b.tinhDiemTB()));
    }
    public Student diemToanCaoNhat() {
        double diemCaoNhat = arr.get(0).getDiemToan();
        int idx = 0;
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getDiemToan() > diemCaoNhat)
            {
                diemCaoNhat = arr.get(i).getDiemToan();
                idx = i;
            }
        }
        return arr.get(idx);
    }
    public void hienThiSinhVienTheoTuoi(int tuoiThapNhat) {
        System.out.printf("\n----- Sinh viên có tuổi lớn hơn %d -----\n", tuoiThapNhat);
        for (Student student : arr) {
            if(student.getTuoi() > tuoiThapNhat)
                student.hienThi();
        }
    }
    public void hienThiSinhVienTheoHo(String hoCanTim) {
        System.out.printf("------- Sinh viên có họ là \"%s\" ----------\n", hoCanTim);
        for (Student student : arr) {
            if(student.getHoTen().startsWith(hoCanTim)) {
                student.hienThi();
            }
        }
    }
    public void HienThiSinhVienTheoDiaChi(String diaChi) {
        System.out.printf("------- Sinh viên có địa chỉ \"%s\" ---------\n", diaChi);
        for (Student student : arr) {
            if(student.getDiaChi().startsWith(diaChi)) {
                student.hienThi();
            }
        }
    }
}
public class StudentsManager {

    public static void main(String[] args) {
        ListStudent list = new ListStudent();
        list.nhap();
        list.hienThiDanhSach();
        
        list.hienThiSinhVienTheoTuoi(15);
        list.hienThiSinhVienTheoHo("Phạm");
        list.HienThiSinhVienTheoDiaChi("Đà Nẵng");
    }
}

