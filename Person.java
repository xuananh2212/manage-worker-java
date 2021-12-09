package QuanLyCongNhan;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class  Person implements Serializable{
    private FullName fullName;
    private String arrdess;
    private String numberIphone;
    private Date birday;


    public Person() {
        this.fullName = new FullName();
        this.birday = new Date();
    }

    public Person(FullName fullName) {
        this.fullName = fullName;
    }

    public Person(FullName fullName, String arrdess, String numberIphone) {
        this.fullName = fullName;
        this.arrdess = arrdess;
        this.numberIphone = numberIphone;
    }

    public Person(FullName fullName, String arrdess, String numberIphone, Date birday) {
        this.fullName = fullName;
        this.arrdess = arrdess;
        this.numberIphone = numberIphone;
        this.birday = birday;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public String getArrdess() {
        return arrdess;
    }

    public void setArrdess(String arrdess) {
        this.arrdess = arrdess;
    }

    public String getNumberIphone() {
        return numberIphone;
    }

    public void setNumberIphone(String numberIphone) {
        this.numberIphone = numberIphone;
    }

    public Date getBirday() {
        return birday;
    }

    public void setBirday(Date birday) {
        this.birday = birday;
    }

    public void inPut(Scanner scan) {
        boolean flag = true;
        System.out.println("vui long nhap ho va ten: ");
        var chuoiString = scan.nextLine().split("\\s+");
        this.fullName.setFirtName(chuoiString[chuoiString.length - 1]);
        this.fullName.setSurName(chuoiString[0]);
        var surName = "";
        for (int i = 1; i < chuoiString.length - 1; i++) {
            surName += chuoiString[i] + " ";
        }
        this.fullName.setSurName(surName);
        var regex = "^\\d{1,2}[/]\\d{1,2}[/]\\d{4}$";
        do {
            System.out.println("vui long nhap ngay Thang Sinh (vd : 22/11/2002):");
            var birday = scan.nextLine();
            Pattern pattern = Pattern.compile(regex);
            var format = "dd/MM/yyyy";
            Matcher matcher = pattern.matcher(birday);
            if (matcher.matches()) {
                SimpleDateFormat s = new SimpleDateFormat(format);
                flag =false;
                try {
                    this.birday = s.parse(birday);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("khong hop le vui long nhap dung dinh dang");

            }

        } while (flag);

        System.out.println("vui long nhap dia chi: ");
        this.arrdess = scan.nextLine();
        System.out.println("vui long nhap so dien thoai: ");
        this.numberIphone = scan.nextLine();
    }

    public void outPut() {
        var format = "dd/MM/yyyy";
        SimpleDateFormat s = new SimpleDateFormat(format);
        System.out.printf("%-10s\t%-10s\t%-12s\t%-10s", this.fullName.getFirtName(),
                s.format(this.birday), this.getArrdess(), this.getNumberIphone());
    }

    @Override
    public String toString() {
        return "Person{" +
                "FisrtName=" + fullName.getFirtName() +
                ", arrdess='" + arrdess + '\'' +
                ", numberIphone='" + numberIphone + '\'' +
                ", birday=" + birday +
                '}';
    }
}


class FullName implements Serializable {
    private String firtName;// ten
    private String midName;// dem
    private String surName;// ho

    public FullName() {
    }

    public FullName(String firtName, String midName, String surName) {
        this.firtName = firtName;
        this.midName = midName;
        this.surName = surName;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
