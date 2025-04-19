import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        LoginPage login = new LoginPage(driver);
        login.login(username, password);
        Assert.assertTrue(login.isDashboardVisible());
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"admin@test.com", "Admin@123"},
                {"wronguser", "wrongpass"}
        };
    }
}
