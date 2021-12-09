package QuanLyCongNhan;

import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Worker extends Person implements Serializable {
    private String id; // ma cong nhan
    private String caSX;// ca lam
    private float wage;// luong ngay

    public Worker() {
    }

    public Worker(FullName fullName, String arrdess, String numberIphone, Date birday, String id, String caSX, float wage) {
        super(fullName, arrdess, numberIphone, birday);
        this.id = id;
        this.caSX = caSX;
        this.wage = wage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaSX() {
        return caSX;
    }

    public void setCaSX(String caSX) {
        this.caSX = caSX;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }
    @Override
    public void inPut(Scanner scan){
        boolean flag = true;
        super.inPut(scan);
        var regex ="^\\d{2}(DCTT|dctt)$";
        Pattern pattern = Pattern.compile(regex);
        do {
            System.out.println("vui long nhap ma cong nhan(vd:71DCTT) : ");
            var idWorker = scan.nextLine();
            Matcher matcher = pattern.matcher(idWorker);
            if (matcher.matches()) {
                this.id = idWorker;
                flag =false;
            } else {
                System.out.println("khong hop le nhap sai dinh dang");
            }
        }while(flag);
        System.out.println("vui long nhap ca san xuat (sang , chieu, toi): ");
        this.caSX = scan.nextLine();
        System.out.println("luong theo ngay cua cong nhan: ");
        this.wage = Float.parseFloat(scan.nextLine());


    }
    @Override
     public void outPut(){
        super.outPut();
        System.out.printf("%-12s\t%-8s\t%-12f\n", this.id, this.caSX, this.wage);
    }


}
