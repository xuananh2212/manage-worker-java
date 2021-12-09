package QuanLyCongNhan;


import java.util.ArrayList;
import java.util.Scanner;

public class XuLy {
    public static void main(String[] args) {
        var scan =  new Scanner(System.in);
        DanhSachCongNhan d = new DanhSachCongNhan();
        d.readFile();
        doMenu(d,scan);

    }

    public static void menu() {
        System.out.println("1. them cong nhan vao danh sach cong nhan");
        System.out.println("2. tim kiem cong nhan theo id");
        System.out.println("3. xoa cong nhan khoi danh sach");
        System.out.println("4. sap xep theo ten cong nhan theo (a-z)");
        System.out.println("5. sap xep theo Luong ngay tang dan");
        System.out.println("6. hien thi danh sach cong nhan");
        System.out.println("7. ghi danh sach cong nhan vao file : DSCN.txt");
        System.out.println("0. thoat");
    }

    public static void doMenu(DanhSachCongNhan d, Scanner scan) {
        boolean flag = true;
        do {
            menu();
            System.out.println(">>>>>>>>>>>>>>moi chon: ");
            var chon = Integer.parseInt(scan.nextLine());
            switch (chon) {
                case 1:
                    Worker w = new Worker();
                    w.inPut(scan);
                    d.addWorker(w);
                    break;
                case 2:
                    System.out.println("nhap id ban muon tim: ");
                    var id = scan.nextLine();
                    d.searchWorker(id);
                    break;
                case 3:
                    System.out.println("nhap id ban muon xoa: ");
                    var id1 = scan.nextLine();
                    d.removeWorker(id1);
                    break;
                case 4:
                    d.softName();
                    break;
                case 5:
                    d.sortWage();
                    break;
                case 6:
                    d.outPut();
                    break;
                case 7:
                    d.writerFile();
                    break;
                case 0:
                    flag = false;
                    break;
            }
        } while (flag);
    }
}
