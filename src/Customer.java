import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    public List<PortfolioItemSaham> sahamDimiliki = new ArrayList<>();
    public List<PortfolioItemSBN> sbnDimiliki = new ArrayList<>();

    public Customer(String username, String password) {
        super(username, password);
    }
}
