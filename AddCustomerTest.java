import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends BaseTest {
    @Test(dataProvider = "customerData")
    public void addCustomerTest(String name, String email, String phone) {
        LoginPage login = new LoginPage(driver);
        login.login("admin@test.com", "Admin@123");

        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.addCustomer(name, email, phone);
        Assert.assertTrue(customerPage.isCustomerAdded(name));
    }

    @DataProvider(name = "customerData")
    public Object[][] customerData() {
        return new Object[][] {
                {"John Doe", "john@example.com", "9876543210"},
                {"Jane Smith", "jane@example.com", "8765432109"}
        };
    }
}
