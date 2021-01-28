import java.sql.Date;

public class Order {
    private User user;
    private Product product;
    private int amount;
    private float totalPay;
    private float actualPay;
    private Date orderDate;

    public Order() {
    }

    public Order(User user, Product product, int amount, float totalPay, float actualPay, Date orderDate) {
        this.user = user;
        this.product = product;
        this.amount = amount;
        this.totalPay = totalPay;
        this.actualPay = actualPay;
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(float totalPay) {
        this.totalPay = totalPay;
    }

    public float getActualPay() {
        return actualPay;
    }

    public void setActualPay(float actualPay) {
        this.actualPay = actualPay;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "user=" + user +
                ", product=" + product +
                ", amount=" + amount +
                ", totalPay=" + totalPay +
                ", actualPay=" + actualPay +
                ", orderDate=" + orderDate +
                '}';
    }
}
