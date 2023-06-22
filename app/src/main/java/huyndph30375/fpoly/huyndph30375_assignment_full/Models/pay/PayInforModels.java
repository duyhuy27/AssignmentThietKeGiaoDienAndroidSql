package huyndph30375.fpoly.huyndph30375_assignment_full.Models.pay;

public class PayInforModels {
    private int idPayment;
    private String money;
    private String date, note,category, sumPay;

    public PayInforModels(int idPayment, String date, String note, String money, String category, String sumPay) {
        this.idPayment = idPayment;
        this.date = date;
        this.note = note;
        this.money = money;
        this.category = category;
        this.sumPay = sumPay;

    }

    public PayInforModels() {
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSumPay() {
        return sumPay;
    }

    public void setSumPay(String sumPay) {
        this.sumPay = sumPay;
    }
}
