package huyndph30375.fpoly.huyndph30375_assignment_full.Models.revenue;

public class RevenueInforModels {
    private int idRevenueInfor;
    private String money;
    private String date, note, category, sumRevenue;

    public RevenueInforModels(int idRevenueInfor, String date, String note, String money, String category, String sumRevenue) {
        this.idRevenueInfor = idRevenueInfor;
        this.date = date;
        this.note = note;
        this.money = money;
        this.category = category;
        this.sumRevenue = sumRevenue;
    }

    public RevenueInforModels() {
    }



    public int getIdRevenueInfor() {
        return idRevenueInfor;
    }

    public void setIdRevenueInfor(int idRevenueInfor) {
        this.idRevenueInfor = idRevenueInfor;
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

    public String getSumRevenue() {
        return sumRevenue;
    }

    public void setSumRevenue(String sumRevenue) {
        this.sumRevenue = sumRevenue;
    }
}
