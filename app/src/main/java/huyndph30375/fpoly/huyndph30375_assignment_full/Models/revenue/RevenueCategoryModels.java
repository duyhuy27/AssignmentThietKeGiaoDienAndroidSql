package huyndph30375.fpoly.huyndph30375_assignment_full.Models.revenue;

public class RevenueCategoryModels {
    private int iDCategory;
    private String nameCategory;
    private int IconCategory;

    public RevenueCategoryModels() {
    }

    public RevenueCategoryModels(int iDCategory, String nameCategory, int iconCategory) {
        this.iDCategory = iDCategory;
        this.nameCategory = nameCategory;
        IconCategory = iconCategory;
    }

    public int getiDCategory() {
        return iDCategory;
    }

    public void setiDCategory(int iDCategory) {
        this.iDCategory = iDCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getIconCategory() {
        return IconCategory;
    }

    public void setIconCategory(int iconCategory) {
        IconCategory = iconCategory;
    }
}
