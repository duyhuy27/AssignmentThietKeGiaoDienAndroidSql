package huyndph30375.fpoly.huyndph30375_assignment_full.Models.pay;

public class PayModels {
    private int idPay;
    private String namePay;
    private int iconPay;

    public PayModels() {
    }

    public PayModels(int idPay, String namePay, int iconPay) {
        this.idPay = idPay;
        this.namePay = namePay;
        this.iconPay = iconPay;
    }

    public int getIdPay() {
        return idPay;
    }

    public void setIdPay(int idPay) {
        this.idPay = idPay;
    }

    public String getNamePay() {
        return namePay;
    }

    public void setNamePay(String namePay) {
        this.namePay = namePay;
    }

    public int getIconPay() {
        return iconPay;
    }

    public void setIconPay(int iconPay) {
        this.iconPay = iconPay;
    }
}
